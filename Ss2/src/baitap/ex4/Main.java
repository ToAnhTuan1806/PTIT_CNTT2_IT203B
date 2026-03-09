package baitap.ex4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<User> users= Arrays.asList(
                new User("To"),
                new User("Anh"),
                new User("Tuan")
        );
        // (user) -> user.getUsername()
        List<String> usernames=users.stream().map(User::getUsername)
                .toList();

        // (s) -> System.out.println(s)
        usernames.forEach(System.out::println);

        // () -> new User()
        Supplier<User> supplier= User::new;
        User newUser = supplier.get();
        System.out.println(newUser.getUsername());
    }
}
