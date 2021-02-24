package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.UserStore;

import java.util.Collection;

/**
 * Class UserService.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 22.03.2021
 */
@Service
public class UserService {
    private final UserStore userStore;

    public UserService(UserStore userStore) {
        this.userStore = userStore;
    }

    public Collection<User> getAll() {
        return userStore.getUsers().values();
    }

    public void save(User user) {
        userStore.save(user);
    }

    public User findById(int id) {
        return userStore.getByIndex(id);
    }

    public User findByName(String name) {
        return userStore.findByName(name);
    }
}
