package g.t.quote.web;

import g.t.quote.entity.Quote;
import g.t.quote.entity.QuoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping(value = "/quotes")
public class QuoteController {

    private final QuoteRepository quoteRepository;

    public QuoteController(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @GetMapping(value = {"", "/{countOpt}"})
    public List<Quote> findRandomQuotes(@PathVariable Optional<Integer> countOpt) {

        log.info("Got request to read {} quotes", (countOpt.isPresent() ? countOpt.get() : "DEFAULT"));

        int count = 2;
        if (countOpt.isPresent()) {
            count = countOpt.get();
            if (count > 10) {
                count = 10;
            }
        }

        Long maxId = quoteRepository.count();

        int tryCount = 0; // don't stuck in loop searching for enough quote...
        List<Quote> quotes = new ArrayList<>();
        do {
            tryCount++;

            count = count - quotes.size();
            quotes.addAll(readRandomQuotes(maxId, count));

            if (tryCount > 10) {
                log.warn("Ohh already tried 10 times... let's not stuck in loop");
                break;
            }
        } while (quotes.size() != count);

        return quotes;
    }

    private List<Quote> readRandomQuotes(Long maxId, int count) {
        List<Long> randomIds = new Random().longs(1, maxId).boxed().distinct().limit(count).collect(Collectors.toList());
        return quoteRepository.findAllById(randomIds);
    }
}