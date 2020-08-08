package quoteapp.module.scrapper;

import quoteapp.module.quote.Quote;
import quoteapp.module.quote.QuoteRepository;
import quoteapp.module.quote.Source;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
@Slf4j
@RequiredArgsConstructor
public class DataLoaderService { //saves quotes to db during app startup

    private final QuoteRepository quoteRepository;

    @PostConstruct
    public void process() {

        List<Source> sourcesToProcess = new ArrayList<>(Arrays.asList(Source.values()));
        sourcesToProcess.removeAll(quoteRepository.findAllLoadedSources());

        for (Source source : sourcesToProcess) {
            try {
                WebScraper scraper = WebScraper.getInstance(source);
                if (scraper == null) {
                    log.warn("Scrapper not implemented for {}", source);
                    continue;
                }

                List<Quote> quotes = scraper.getQuotes();
                quoteRepository.saveAll(quotes);
                log.info("Saved {} quotes from {} ", quotes.size(), source);

            } catch (IOException e) {
                log.error("Failed to scrape: " + source, e);
            }
        }

    }
}
