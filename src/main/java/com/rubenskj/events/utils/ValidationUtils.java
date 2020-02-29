package com.rubenskj.events.utils;

import org.springframework.util.StringUtils;

public class ValidationUtils {
    public static void isEmptyString(String textContent) {
        if (StringUtils.isEmpty(textContent)) {
            throw new IllegalArgumentException("Text content cannot be null.");
        }
    }
}
