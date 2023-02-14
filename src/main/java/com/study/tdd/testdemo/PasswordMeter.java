package com.study.tdd.testdemo;

public class PasswordMeter {

    public PasswordStrength meter(String pw) {
        if (pw == null || pw.isEmpty()) {
            throw new IllegalArgumentException();
        }
        int metCount = 0;
        metCount = calculateMetCount(pw, metCount);
        if (metCount <= 1) {
            return PasswordStrength.WEAK;
        }
        if (metCount == 2) {
            return PasswordStrength.NORMAL;
        }
        return PasswordStrength.STRONG;
    }

    private int calculateMetCount(String pw, int metCount) {
        if (meetLength(pw)) {
            metCount++;
        }
        if (containsUppercase(pw)) {
            metCount++;
        }
        if (containsDigit(pw)) {
            metCount++;
        }
        return metCount;
    }

    private boolean meetLength(String pw) {
        return pw.length() >= 8;
    }

    private boolean containsUppercase(String pw) {
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
