package baitap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ex4 {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@gmail.com", "ACTIVE"),
                new User("alice", "alice@yahoo.com", "INACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE")
        );

        Map<String, User> map = users.stream()
                .collect(Collectors.toMap(
                        User::username,
                        u -> u,
                        (u1, u2) -> u1
                ));

        List<User> uniqueUsers = new ArrayList<>(map.values());

        uniqueUsers.forEach(System.out::println);
    }
}
