package ru.job4j.forum.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Comment;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class CommentStore.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 26.03.2021
 */
@Data
@Repository
public class CommentStore {
    private final Map<Integer, Comment> comments = new HashMap<>();
    private AtomicInteger id = new AtomicInteger();

    public Comment save(Comment model) {
        if (model.getId() == 0) {
            model.setId(id.incrementAndGet());
        }
        comments.put(model.getId(), model);
        return model;
    }

    public Comment findById(int id) {
        return comments.get(id);
    }

    public Collection<Comment> findAll() {
        return comments.values();
    }

    public void deleteById(int id) {
        comments.remove(id);
    }

    public void deleteCommentsByPostId(int id) {
        comments.entrySet().removeIf(comment -> comment.getValue().getPost().getId() == id);
    }
}
