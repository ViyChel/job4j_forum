package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.service.CommentService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import javax.servlet.http.HttpServletRequest;

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
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "comment/edit";
    }

    @PostMapping("/create")
    public String create(@RequestParam("postId") long postId,
                         @RequestParam("text") String message, HttpServletRequest req) {
        Comment comment = Comment.of(message);
        String userName = req.getUserPrincipal().getName();
        comment.setAuthor(userService.findByName(userName));
        comment.setPost(postService.findById(postId));
        commentService.save(comment);
        return "redirect:/post/" + postId;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        commentService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("comment", commentService.findById(id));
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "comment/edit";
    }
}
