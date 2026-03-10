package baitap.ex3;

import baitap.User;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();
        Optional<User> user = repo.findUserByUsername("alice");
        user.ifPresentOrElse(
                u-> System.out.println("Welcome "+u.username()),
                ()-> System.out.println("Guest login")
        );
    }
}
