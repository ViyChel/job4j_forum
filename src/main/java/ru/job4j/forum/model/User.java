package ru.job4j.forum.model;

import lombok.Data;

/**
 * Class User.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 24.02.2021
 */
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String email;

    public static User of(String name, String password, String email) {
        User user = new User();
        user.username = name;
        user.password = password;
        user.email = email;
        return user;
    }
}
