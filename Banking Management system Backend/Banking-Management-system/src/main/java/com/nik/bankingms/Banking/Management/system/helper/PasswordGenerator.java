package com.nik.bankingms.Banking.Management.system.helper;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;
@Component
public class PasswordGenerator {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%&*";
    private static final String ALL = UPPER + LOWER + DIGITS + SPECIAL;

    private static final SecureRandom random = new SecureRandom();

    public static String generatePassword(int length) {
        if (length < 6) {
            throw new IllegalArgumentException("Password length should be at least 6 characters");
        }

        StringBuilder password = new StringBuilder();

        // Ensure at least one character from each category
        password.append(UPPER.charAt(random.nextInt(UPPER.length())));
        password.append(LOWER.charAt(random.nextInt(LOWER.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));

        // Fill remaining characters randomly
        for (int i = 4; i < length; i++) {
            password.append(ALL.charAt(random.nextInt(ALL.length())));
        }

        // Shuffle the characters
        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        char[] chars = input.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
