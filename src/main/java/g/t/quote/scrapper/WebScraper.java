package g.t.quote.scrapper;

import g.t.quote.entity.Quote;
import g.t.quote.entity.Source;

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
