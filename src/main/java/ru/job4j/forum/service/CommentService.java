package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.repository.CommentStore;

import java.util.Collection;

/**
 * Class CommentService.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 26.03.2021
 */
@Service
public class CommentService {
    private final CommentStore store;

    public CommentService(CommentStore store) {
        this.store = store;
    }

    public Comment save(Comment model) {
        return store.save(model);
    }

    public Comment findById(int id) {
        return store.findById(id);
    }

    public Collection<Comment> findAll() {
        return store.findAll();
    }

    public void deleteById(int id) {
        store.deleteById(id);
    }

    public void deleteByPostId(int id) {
        store.deleteCommentsByPostId(id);
    }

}
