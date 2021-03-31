package ru.job4j.forum.control;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.Role;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

import java.util.EnumSet;

/**
 * Class RegControl.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 27.02.2021
 */
@Controller
public class RegControl {

    private final PasswordEncoder encoder;
    private final UserService userService;

    public RegControl(PasswordEncoder encoder, UserService userService) {
        this.encoder = encoder;
        this.userService = userService;
    }

    @PostMapping("/reg")
    public String save(User user, Model model) {
        User userFromDbByName = userService.findByName(user.getUsername());
        User userFromDbByEmail = userService.findByEmail(user.getEmail());
        if (userFromDbByName != null || userFromDbByEmail != null) {
            if (userFromDbByName != null) {
                model.addAttribute("nameError", "Имя занято");
            }
            if (userFromDbByEmail != null) {
                model.addAttribute("emailError", "Email занят");
            }
            return "auth/reg";
        }
        user.setPassword(encoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setRoles(EnumSet.of(Role.USER));
        userService.save(user);
        return "auth/login";
    }

    @GetMapping("/reg")
    public String reg() {
        return "auth/reg";
    }
}