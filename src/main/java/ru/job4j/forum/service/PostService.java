package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostStore;

import java.util.Collection;

/**
 * Class PostService.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 24.02.2021
 */
@Service
public class PostService {
    private final PostStore postStore;
    private final CommentService commentService;

    public PostService(PostStore postStore, CommentService commentService) {
        this.postStore = postStore;
        this.commentService = commentService;
    }

    public Collection<Post> getAll() {
        return postStore.getPosts().values();
    }

    public void save(Post post) {
        postStore.save(post);
    }

    public void deleteById(int id) {
        postStore.delete(id);
        commentService.deleteByPostId(id);
    }

    public Post findById(int id) {
        return postStore.getByIndex(id);
    }
}
