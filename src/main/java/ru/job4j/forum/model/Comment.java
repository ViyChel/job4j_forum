package ru.job4j.forum.model;

import lombok.Data;
import ru.job4j.forum.utils.DateUtils;

import java.time.LocalDateTime;

/**
 * Class Comment.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 26.03.2021
 */
@Data
public class Comment {
    private int id;
    private String message;
    private Post post;
    private User author;
    private LocalDateTime created = LocalDateTime.now();

    public static Comment of(String message) {
        Comment comment = new Comment();
        comment.setMessage(message);
        return comment;
    }

    public String formattedDateTime() {
        return DateUtils.dateFormat(created);
    }

}
