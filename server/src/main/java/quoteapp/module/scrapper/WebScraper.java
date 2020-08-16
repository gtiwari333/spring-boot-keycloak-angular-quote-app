package quoteapp.module.scrapper;

import quoteapp.module.quote.Quote;
import quoteapp.module.quote.Source;

import java.io.IOException;
import java.util.List;

public interface WebScraper {

    List<Quote> getQuotes() throws IOException;

    static WebScraper getInstance(Source source) {
        switch (source) {
            case GOOD_READS:
                return new GoodReadsScrapper(source);
        }

        return null;
    }
}
