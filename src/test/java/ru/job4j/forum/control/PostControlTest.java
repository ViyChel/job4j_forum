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
 * Class PostControlTest.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 29.03.2021
 */
@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class PostControlTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/post/new"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/edit"));
    }

    @Test
    @WithMockUser
    void shouldReturnPostView() throws Exception {
        this.mockMvc.perform(get("/post/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/post"));
    }

    @Test
    @WithMockUser
    void shouldReturnPostEdit() throws Exception {
        this.mockMvc.perform(get("/post/edit/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/edit"));
    }
}