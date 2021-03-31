package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.service.CommentService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Class CommentControlTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 29.03.2021
 */
@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class CommentControlTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService commentService;

    @Test
    @WithMockUser
    void shouldReturnCreateView() throws Exception {
        this.mockMvc.perform(get("/comment/new/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("comment/edit"));
    }

    @Test
    @WithMockUser
    void shouldReturnEditView() throws Exception {
        this.mockMvc.perform(get("/comment/edit/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("comment/edit"));
    }

    @Test
    @WithMockUser
    void whenCreateNewComment() throws Exception {
        this.mockMvc.perform(post("/comment/create")
                .param("postId", "1")
                .param("text", "Хорошая машина. Буду брать."))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/post/1"));
        ArgumentCaptor<Comment> argument = ArgumentCaptor.forClass(Comment.class);
        verify(commentService).save(argument.capture());
        assertThat(argument.getValue().getMessage(), is("Хорошая машина. Буду брать."));
    }
}