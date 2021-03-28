package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.CommentService;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Class PostControl.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 23.03.2021
 */
@Controller
@RequestMapping("/post")
public class PostControl {
    private final PostService postService;
    private final CommentService commentService;
    private final UserService userService;

    public PostControl(PostService postService, CommentService commentService, UserService userService) {
        this.postService = postService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("comments", commentService.findAll());
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "post/post";
    }

    @GetMapping("/new")
    public String newPost(@ModelAttribute("post") Post post, Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "post/edit";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("post") Post post, HttpServletRequest req) {
        String userName = req.getUserPrincipal().getName();
        post.setAuthor(userService.findByName(userName));
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        postService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "post/edit";
    }
}
