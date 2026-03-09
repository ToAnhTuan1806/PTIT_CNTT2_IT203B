package baitap;
@FunctionalInterface
public interface PasswordValidator {
    boolean isValid(String password);
}

