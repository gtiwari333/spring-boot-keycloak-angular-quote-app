package g.t.quote.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Data
public class Quote implements Serializable {

    private static final long serialVersionUID = 744281458877843465L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Source source;

    private String author;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    private Instant addedOn;

    private long readCount;

    private long likeCount;

    private long dislikeCount;

    public Quote(Source source, String content, String author) {
        this.source = source;
        this.content = content;
        this.author = author;
        this.addedOn = Instant.now();
    }


}

