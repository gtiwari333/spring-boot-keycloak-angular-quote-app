package g.t.quote.web;

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
public class QuoteController {

    private final RandomQuoteFetchService quoteFetchService;

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

}