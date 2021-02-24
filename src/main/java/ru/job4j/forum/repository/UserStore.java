package ru.job4j.forum.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class UserRepository.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 22.03.2021
 */
@Data
@Repository
public class UserStore {
    private final Map<Integer, User> users = new HashMap<>();
    private AtomicInteger id = new AtomicInteger();

    public void save(User user) {
        if (user.getId() == 0) {
            user.setId(id.incrementAndGet());
        }
        users.put(user.getId(), user);
    }

    public User getByIndex(int id) {
        return users.get(id);
    }

    public User findByName(String name) {
        return users.entrySet().stream()
                .filter(user -> name.equals(user.getValue().getUsername()))
                .findFirst().map(Map.Entry::getValue).orElse(new User());

    }
}
