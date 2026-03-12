import baitap.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    UserService service = new UserService();

    @Test
    @DisplayName("Tuoi 18 du dieu kien dang ky")
    void testAge18() {
        int age = 18;
        boolean result = service.checkRegistrationAge(age);
        System.out.println("Kiem tra tuoi = 18");
        assertEquals(true, result);
    }

    @Test
    @DisplayName("Tuoi 17 khong du dieu kien")
    void testAge17() {
        int age = 17;
        boolean result = service.checkRegistrationAge(age);
        System.out.println("Kiem tra tuoi = 17");
        assertEquals(false, result);
    }

    @Test
    @DisplayName("Tuoi am phai nem ngoai le")
    void testAgeNegative() {
        int age = -1;
        System.out.println("Kiem tra tuoi = -1");
        assertThrows(IllegalArgumentException.class, () -> {
            service.checkRegistrationAge(age);
        });
    }
}