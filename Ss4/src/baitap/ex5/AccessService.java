package baitap.ex5;

public class AccessService {
    public boolean canPerformAction(User user, Action action) {

        if (user.getRole() == Role.ADMIN) {
            return true;
        }

        if (user.getRole() == Role.MODERATOR) {
            return action == Action.LOCK_USER || action == Action.VIEW_PROFILE;
        }

        if (user.getRole() == Role.USER) {
            return action == Action.VIEW_PROFILE;
        }
        return false;
    }
}
