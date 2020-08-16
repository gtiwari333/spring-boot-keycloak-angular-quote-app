package quoteapp.web;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import quoteapp.module.quote.Quote;

import java.util.List;

@Data
public class QuoteViewDto {

    private Long id;

    private String content;

    private String author;

    private long readCount;

    private long likeCount;

    private long dislikeCount;
    private List<String> tags;

    public static QuoteViewDto from(Quote q) {
        QuoteViewDto d = new QuoteViewDto();
        BeanUtils.copyProperties(q, d);
        return d;
    }
}
