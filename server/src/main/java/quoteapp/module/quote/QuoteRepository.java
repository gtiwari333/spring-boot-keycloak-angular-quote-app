package quoteapp.module.quote;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query("select distinct q.source from Quote q")
    List<Source> findAllLoadedSources();

    @EntityGraph(attributePaths = {"tags"})
    List<Quote> findAllById(Iterable<Long> var1);

    @EntityGraph(attributePaths = {"tags"})
    Optional<Quote> findById(Long var1);

    @Modifying
    @Transactional
    @Query("update Quote q set q.readCount = q.readCount + 1 where id in (:ids)")
    void updateReadCounts(@Param("ids") Iterable<Long> ids);

    @Query("select max(id) from Quote q  ")
    Long findMaxId();
}
