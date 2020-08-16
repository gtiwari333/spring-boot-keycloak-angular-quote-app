package quoteapp.module.quote;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RandomQuoteFetchService {

    private final QuoteRepository quoteRepository;

    public List<Quote> findRandomQuotes() {
        return findRandomQuotes(2);
    }

    public List<Quote> findRandomQuotes(int requestedSize) {

        if (requestedSize > 10) {
            requestedSize = 10;
        }

        Long dbRecordCount = quoteRepository.findMaxId();

        int tryCount = 0; // don't stuck in loop searching for enough quote...
        List<Quote> quotes = new ArrayList<>();
        do {
            tryCount++;

            requestedSize = requestedSize - quotes.size();
            quotes.addAll(readRandomQuotes(dbRecordCount, requestedSize));

            if (tryCount > 10) {
                log.warn("Ohh already tried 10 times... let's not stuck in loop");
                break;
            }
        } while (quotes.size() != requestedSize);

        updateReadCounts(quotes);

        return quotes;
    }

    private void updateReadCounts(List<Quote> quotes) {
        quoteRepository.updateReadCounts(quotes.stream().map(Quote::getId).collect(Collectors.toList()));
    }

    private List<Quote> readRandomQuotes(Long dbRecordCount, int count) {
        List<Long> randomIds = new Random().longs(1, dbRecordCount).boxed().distinct().limit(count).collect(Collectors.toList());
        return quoteRepository.findAllById(randomIds);
    }
}
