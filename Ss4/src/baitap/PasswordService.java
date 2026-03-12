package baitap;

public class PasswordService {

    public String evaluatePasswordStrength(String password) {

        if (password == null || password.length() < 8) {
            return "Yeu";
        }

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        if (hasUpper && hasLower && hasDigit && hasSpecial) {
            return "Manh";
        }

        int count = 0;
        if (hasUpper) {
            count++;
        }
        if (hasLower) {
            count++;
        }
        if (hasDigit) {
            count++;
        }
        if (hasSpecial) {
            count++;
        }

        if (count == 3) {
            return "Trung binh";
        }

        return "Yeu";
    }
}