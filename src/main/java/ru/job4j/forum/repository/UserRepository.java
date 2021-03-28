package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.User;

/**
 * Interface UserRepository.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 28.03.2021
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String name);
}
