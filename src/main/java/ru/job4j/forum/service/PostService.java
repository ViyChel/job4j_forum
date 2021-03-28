package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

/**
 * Class PostService.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 24.02.2021
 */
@Service
public class PostService {
    private final PostRepository postRepository;
    private final CommentService commentService;

    public PostService(PostRepository postRepository, CommentService commentService) {
        this.postRepository = postRepository;
        this.commentService = commentService;
    }

    public Iterable<Post> getAll() {
        return postRepository.findAll();
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public void deleteById(long id) {
        postRepository.deleteById(id);
        commentService.deleteByPostId(id);
    }

    public Post findById(long id) {
        return postRepository.findById(id).orElse(new Post());
    }
}
