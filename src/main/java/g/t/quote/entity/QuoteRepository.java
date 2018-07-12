package g.t.quote.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query("select distinct q.source from Quote q")
    List<Source> findAllLoadedSources();
}
