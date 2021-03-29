package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
}