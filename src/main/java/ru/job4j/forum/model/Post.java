package ru.job4j.forum.model;

import lombok.Data;
import ru.job4j.forum.utils.DateUtils;

import java.time.LocalDateTime;

/**
 * Class Post.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 24.02.2021
 */
@Data
public class Post {
    private int id;
    private String name;
    private String description;
    private User author;
    private LocalDateTime created = LocalDateTime.now();

    public static Post of(String name, String description, User user) {
        Post post = new Post();
        post.name = name;
        post.description = description;
        post.author = user;
        return post;
    }

    public String formattedDateTime() {
        return DateUtils.dateFormat(created);
    }
}