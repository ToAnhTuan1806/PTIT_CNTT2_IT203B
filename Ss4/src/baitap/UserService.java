package baitap;

public class UserService {
    public boolean checkRegistrationAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Tuoi khong hop le");
        }
        if (age >= 18) {
            return true;
        }
        return false;
    }
}
