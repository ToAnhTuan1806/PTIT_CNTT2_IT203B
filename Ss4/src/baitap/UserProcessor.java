package baitap;

public class UserProcessor {
    public String processEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email khong hop le");
        }
        String[] parts = email.split("@");

        if (parts.length != 2 || parts[1].isEmpty()) {
            throw new IllegalArgumentException("Email khong co ten mien");
        }
        return email.toLowerCase();
    }
}
