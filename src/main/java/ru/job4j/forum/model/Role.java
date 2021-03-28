package ru.job4j.forum.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Class Role.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 28.03.2021
 */
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
