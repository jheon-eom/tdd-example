package com.study.tdd;

public class PasswordMeter {

    public PasswordStrength meter(String pw) {
        if (pw == null || pw.isEmpty()) {
            throw new IllegalArgumentException();
        }
        boolean lengthRule = pw.length() >= 8;
        boolean containsUpperCase = isContainsUppercase(pw);
        boolean containsDigit = containsDigit(pw);
        if (lengthRule && !containsUpperCase && !containsDigit) {
            return PasswordStrength.WEAK;
        }
        if (!lengthRule) {
            return PasswordStrength.NORMAL;
        }
        if (!containsUpperCase) {
            return PasswordStrength.NORMAL;
        }
        if (!containsDigit) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private boolean isContainsUppercase(String pw) {
        for (char ch : pw.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                return true;
            }
        }
        return false;
    }

    private boolean containsDigit(String pw) {
        for (char ch : pw.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }
}
