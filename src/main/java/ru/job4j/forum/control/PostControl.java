package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

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
    private final UserService userService;

    public PostControl(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model) {
        String path = "post/post";
        Post post = postService.findById(id);
        if (post.getId() == 0) {
            path = "error/404";
        }
        model.addAttribute("post", post);
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return path;
    }

    @GetMapping("/new")
    public String newPost(Model model) {
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "post/edit";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("post") Post post) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
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
        String path = "post/edit";
        Post post = postService.findById(id);
        if (post.getId() == 0) {
            path = "error/404";
        }
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("post", post);
        return path;
    }
}
