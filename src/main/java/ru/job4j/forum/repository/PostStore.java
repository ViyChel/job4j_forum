package ru.job4j.forum.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class MemStore.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 26.02.2021
 */
@Data
@Repository
public class PostStore {
    private final Map<Integer, Post> posts = new HashMap<>();
    private AtomicInteger id = new AtomicInteger();

    public PostStore() {
        Post post1 = Post.of("Продаю машину ладу 01.", "Пробег 135000 км. На металлолом :)",
                User.of("Oleg", "123", "oleg@email.com"));
        post1.setId(id.incrementAndGet());
        posts.put(post1.getId(), post1);
        Post post2 = Post.of("Продаю мотоцикл Yamaha XT1200ZE.", "В отличном состоянии. Стоял в гараже. Пробег 1500 "
                        + "км.",
                User.of("Max", "123", "max@email.com"));
        post2.setId(id.incrementAndGet());
        posts.put(post2.getId(), post2);
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(id.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public void delete(int id) {
        posts.remove(id);
    }

    public Post getByIndex(int id) {
        return posts.get(id);
    }
}
