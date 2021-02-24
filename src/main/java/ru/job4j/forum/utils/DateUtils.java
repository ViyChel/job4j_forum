package ru.job4j.forum.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class DateUtils.
 *
 * @author Vitaly Yagufarov (for.viy@gmail.com)
 * @version 1.0
 * @since 25.03.2021
 */
public class DateUtils {
    private DateUtils() {
    }

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(
            "dd.MM.yyyy HH:mm"
    );

    public static String dateFormat(LocalDateTime localDateTime) {
        return localDateTime.format(FORMATTER);
    }

}
