package Ex5;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        try {
            user.setAge(-10);
        } catch (InvalidAgeException e) {
            System.out.println("Loi: " + e.getMessage());
        }

    }
}
