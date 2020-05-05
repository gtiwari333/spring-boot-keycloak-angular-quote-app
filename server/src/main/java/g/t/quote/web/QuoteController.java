package g.t.quote.web;

import g.t.quote.service.QuoteCreateDto;
import g.t.quote.service.QuoteDBService;
import g.t.quote.service.RandomQuoteFetchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping(value = "/quotes")
@RequiredArgsConstructor
public class QuoteController { //TODO:fix cross-origin by proxy

    private final RandomQuoteFetchService quoteFetchService;
    private final QuoteDBService quoteDBService;

    @GetMapping(value = "")
    @CrossOrigin
    public List<QuoteViewDto> findRandomQuotes() {

        log.info("Got request to read DEFAULT quotes");

        return quoteFetchService.findRandomQuotes().stream().map(QuoteViewDto::from).collect(Collectors.toList());
    }

    @GetMapping(value = "/{requestedSize}")
    @CrossOrigin
    public List<QuoteViewDto> findRandomQuotes(@PathVariable int requestedSize) {

        log.info("Got request to read {} quotes", (requestedSize));

        return quoteFetchService.findRandomQuotes(requestedSize).stream().map(QuoteViewDto::from).collect(Collectors.toList());
    }


    @PostMapping
    @CrossOrigin
    public Long save(@RequestBody QuoteCreateDto d) {

        log.info("Got request to save new");

        return quoteDBService.save(d).getId();
    }

}