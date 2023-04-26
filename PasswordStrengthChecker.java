public class PasswordStrengthChecker {
    public enum Strength {
        WEAK,
        MEDIUM,
        STRONG
    }

    public static Strength checkStrength(String password) {
        // Check for weak passwords
        if (password.length() < 8 || password.toLowerCase().equals(password)) {
            return Strength.WEAK;
        }

        // Check for medium passwords
        if (password.length() < 12) {
            return Strength.MEDIUM;
        }

        // Check for strong passwords
        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
        }

        if (hasLowercase && hasUppercase && hasDigit && hasSpecialChar) {
            return Strength.STRONG;
        } else {
            return Strength.MEDIUM;
        }
    }
}

