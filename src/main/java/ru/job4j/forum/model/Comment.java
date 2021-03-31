package ru.job4j.forum.model;

import lombok.Data;
import ru.job4j.forum.utils.DateUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Class Comment.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 26.03.2021
 */
@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;
    @ManyToOne
    @JoinColumn(name = "user_id")
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
