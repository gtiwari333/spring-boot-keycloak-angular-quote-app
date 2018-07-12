package g.t.quote.scrapper;

import g.t.quote.entity.Quote;
import g.t.quote.entity.Source;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static g.t.quote.Utils.clean;

@Slf4j
public class GoodReadsScrapper implements WebScraper {
    private final Source source;

    public GoodReadsScrapper(Source source) {
        this.source = source;
    }

    @Override
    public List<Quote> getQuotes() throws IOException {
        Document doc = Jsoup.connect("https://www.goodreads.com/quotes?page=1").get();
        log.debug(doc.title());
        Elements quoteElements = doc.select(".quoteText");

        List<Quote> quotes = new ArrayList<>();
        for (Element q : quoteElements) {
            String qStr = q.text();

            log.trace(qStr);

            String[] parts = qStr.split("―");
            String quoteText = clean(parts[0].replaceAll("“", ""));
            String author = clean(parts[1].trim());

            quotes.add(new Quote(source, quoteText, author));
        }

        return quotes;
    }


    public static void main(String[] args) throws Exception {
        WebScraper sc = WebScraper.getInstance(Source.GOOD_READS);
        System.out.println(sc.getQuotes());

    }
}
