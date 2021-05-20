package ru.job4j.forum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Class PasswordConfig.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 25.05.2021
 */
@Configuration
public class PasswordConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
