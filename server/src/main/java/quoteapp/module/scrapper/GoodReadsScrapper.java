package quoteapp.module.scrapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import quoteapp.module.quote.Quote;
import quoteapp.module.quote.Source;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class GoodReadsScrapper implements WebScraper { //standalone app to read quotes
    private static final Source source = Source.GOOD_READS;

    @Override
    public List<Quote> getQuotes() throws IOException {
        Document doc = Jsoup.connect("https://www.goodreads.com/quotes?page=1").get();
        log.debug(doc.title());
        Elements quoteElements = doc.select(".quoteText");

        List<Quote> quotes = new ArrayList<>();
        for (Element q : quoteElements) {
            //read quote text and the author from the body of quoteText css
            //e.text() returns all the visible text inside this element which also includes the author... use ownText to not look at child elements
            String qStr = q.ownText().replaceAll("―", "").trim();
            String quoteText = qStr.replaceAll("“", "").replaceAll("”", "");

            //author is inside span inside authorOrTitle class within the current element
            String author = q.select(".authorOrTitle").text();

            //Tags: read sibling element of div with class 'quoteText', choose the one with class 'quoteFooter' and read the  a tags
            Elements tagElements = q.nextElementSiblings()
                    .select(".quoteFooter").select(".greyText").select("a");
            List<String> tags = tagElements.stream().map(Element::text).collect(Collectors.toList());

            quotes.add(new Quote(source, quoteText, author, tags));
        }

        return quotes;
    }


    public static void main(String[] args) throws Exception {
        WebScraper sc = WebScraper.getInstance(source);
        System.out.println(sc.getQuotes());

    }
}
