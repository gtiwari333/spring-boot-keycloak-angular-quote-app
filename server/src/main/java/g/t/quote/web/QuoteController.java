package g.t.quote.web;

import g.t.quote.entity.Quote;
import g.t.quote.service.RandomQuoteFetchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/quotes")
@RequiredArgsConstructor
public class QuoteController {

    private final RandomQuoteFetchService quoteFetchService;

    @GetMapping(value = "")
    @CrossOrigin
    public List<Quote> findRandomQuotes() {

        log.info("Got request to read DEFAULT quotes");

        return quoteFetchService.findRandomQuotes();
    }

    @GetMapping(value = "/{requestedSize}")
    @CrossOrigin
    public List<Quote> findRandomQuotes(@PathVariable int requestedSize) {

        log.info("Got request to read {} quotes", (requestedSize));

        return quoteFetchService.findRandomQuotes(requestedSize);
    }

}