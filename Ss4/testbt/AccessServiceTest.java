import baitap.ex5.AccessService;
import baitap.ex5.Action;
import baitap.ex5.Role;
import baitap.ex5.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccessServiceTest {
    AccessService service = new AccessService();
    User user;

    @AfterEach
    void donDep() {
        user = null;
        System.out.println("Don dep doi tuong test");
    }


    // admin test
    @Test
    void adminCoTheXoaUser() {
        user = new User("admin", Role.ADMIN);
        boolean result = service.canPerformAction(user, Action.DELETE_USER);
        System.out.println("ADMIN xoa user");
        assertTrue(result);
    }

    @Test
    void adminCoTheKhoaUser() {
        user = new User("admin", Role.ADMIN);
        boolean result = service.canPerformAction(user, Action.LOCK_USER);
        System.out.println("ADMIN khoa user");
        assertTrue(result);
    }

    @Test
    void adminCoTheXemThongTin() {
        user = new User("admin", Role.ADMIN);
        boolean result = service.canPerformAction(user, Action.VIEW_PROFILE);
        System.out.println("ADMIN xem profile");
        assertTrue(result);
    }


   //moderate test
    @Test
    void moderatorKhongDuocXoaUser() {
        user = new User("mod", Role.MODERATOR);
        boolean result = service.canPerformAction(user, Action.DELETE_USER);
        System.out.println("MODERATOR khong duoc xoa");
        assertFalse(result);
    }

    @Test
    void moderatorDuocKhoaUser() {
        user = new User("mod", Role.MODERATOR);
        boolean result = service.canPerformAction(user, Action.LOCK_USER);
        System.out.println("MODERATOR khoa user");
        assertTrue(result);
    }

    @Test
    void moderatorDuocXemThongTin() {
        user = new User("mod", Role.MODERATOR);
        boolean result = service.canPerformAction(user, Action.VIEW_PROFILE);
        System.out.println("MODERATOR xem profile");
        assertTrue(result);
    }

    // user test
    @Test
    void userKhongDuocXoa() {
        user = new User("user", Role.USER);
        boolean result = service.canPerformAction(user, Action.DELETE_USER);
        System.out.println("USER khong duoc xoa");
        assertFalse(result);
    }

    @Test
    void userKhongDuocKhoa() {
        user = new User("user", Role.USER);
        boolean result = service.canPerformAction(user, Action.LOCK_USER);
        System.out.println("USER khong duoc khoa");
        assertFalse(result);
    }

    @Test
    void userDuocXemThongTin() {
        user = new User("user", Role.USER);
        boolean result = service.canPerformAction(user, Action.VIEW_PROFILE);
        System.out.println("USER xem profile");
        assertTrue(result);
    }
}