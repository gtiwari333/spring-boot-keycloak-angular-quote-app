package g.t.quote.scrapper;

import g.t.quote.entity.Quote;
import g.t.quote.entity.QuoteRepository;
import g.t.quote.entity.Source;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
@Slf4j
public class ScrapperService {

    private final QuoteRepository quoteRepository;

    public ScrapperService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

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
