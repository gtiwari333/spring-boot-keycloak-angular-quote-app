package quoteapp.module.quote;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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

    @ElementCollection
    public List<String> tags;

    public Quote(Source source, String content, String author, List<String> tags) {
        this.source = source;
        this.content = content;
        this.author = author;
        this.addedOn = Instant.now();
        this.tags = tags;
    }


}

