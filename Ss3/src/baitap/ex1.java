package baitap;

import java.util.List;

public class ex1 {
    public static void main(String[] args) {
        List<User> users=List.of(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@gmail.com", "INACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE")
        );
        users.forEach(u ->
                System.out.println("Username: " + u.username() +
                        ", Email: " + u.email() +
                        ", Status: " + u.status())
        );
    }
}
