package baitap.ex6;

import baitap.ex4.User;

@FunctionalInterface
public interface UserProcessor {
    String process(User u);
}
