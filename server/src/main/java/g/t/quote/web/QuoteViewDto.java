package g.t.quote.web;

import g.t.quote.entity.Quote;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class QuoteViewDto {

    private Long id;

    private String content;

    private String author;

    private long readCount;

    private long likeCount;

    private long dislikeCount;

    public static QuoteViewDto from(Quote q) {
        QuoteViewDto d = new QuoteViewDto();
        BeanUtils.copyProperties(q, d);
        return d;
    }
}
