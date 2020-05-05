package g.t.quote.service;

import g.t.quote.entity.Quote;
import g.t.quote.entity.QuoteRepository;
import g.t.quote.entity.Source;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuoteDBService {

    private final QuoteRepository quoteRepository;

    public Quote save(QuoteCreateDto d) {
        Quote q = new Quote();
        BeanUtils.copyProperties(d, q);
        q.setSource(Source.MANUAL_ENTRY);

        return quoteRepository.save(q);
    }

    public Optional<Quote> getById(Long id){
        return quoteRepository.findById(id);
    }
}
