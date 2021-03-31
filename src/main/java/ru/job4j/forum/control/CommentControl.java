package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.CommentService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

/**
 * Class CommentControl.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 26.03.2021
 */
@Controller
@RequestMapping("/comment")
public class CommentControl {
    private final CommentService commentService;
    private final PostService postService;
    private final UserService userService;

    public CommentControl(CommentService commentService, PostService postService, UserService userService) {
        this.commentService = commentService;
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/new/{id}")
    public String newComment(@PathVariable("id") long id, Model model) {
        String path = "comment/edit";
        Post post = postService.findById(id);
        if (post.getId() == 0) {
            path = "error/404";
        }
        model.addAttribute("post", post);
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return path;
    }

    @PostMapping("/create")
    public String create(@RequestParam("postId") int postId,
                         @RequestParam("text") String message) {
        Comment comment = Comment.of(message);
        Post post = postService.findById(postId);
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        comment.setAuthor(userService.findByName(userName));
        post.addComment(comment);
        commentService.save(comment);
        return "redirect:/post/" + postId;
    }
}
