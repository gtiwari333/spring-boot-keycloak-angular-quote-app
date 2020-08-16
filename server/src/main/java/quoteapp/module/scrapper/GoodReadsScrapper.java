package quoteapp.module.scrapper;

import quoteapp.module.quote.Quote;
import quoteapp.module.quote.Source;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import quoteapp.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class GoodReadsScrapper implements WebScraper { //standalone app to read quotes
    private final Source source;

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
            String quoteText = Utils.clean(parts[0].replaceAll("“", "").replaceAll("”", ""));
            String author = Utils.clean(parts[1].trim());

            quotes.add(new Quote(source, quoteText, author));
        }

        return quotes;
    }


    public static void main(String[] args) throws Exception {
        WebScraper sc = WebScraper.getInstance(Source.GOOD_READS);
        System.out.println(sc.getQuotes());

    }
}
