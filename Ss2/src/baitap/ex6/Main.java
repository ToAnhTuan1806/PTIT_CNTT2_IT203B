package baitap.ex6;

import baitap.ex4.User;

public class Main {
    public static void main(String[] args) {
        UserProcessor processor= UserUtils::convertToUpperCase;
        User user = new User("Tuan");
        String result = processor.process(user);
        System.out.println(result);
    }
}
