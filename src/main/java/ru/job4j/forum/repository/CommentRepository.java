package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Comment;

import java.util.List;

/**
 * Interface CommentRepository.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 28.03.2021
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
//    List<Comment> findByPostId(long id);
//    void deleteByPostId(long id);
}
