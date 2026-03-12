import baitap.PasswordService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordServiceTest {

    PasswordService service = new PasswordService();

    @Test
    void testDanhGiaMatKhau() {
        System.out.println("Kiem tra danh gia do manh mat khau: ");
        assertAll("Password strength tests",

                () -> assertEquals("Manh",
                        service.evaluatePasswordStrength("Abc123!@")),

                () -> assertEquals("Trung binh",
                        service.evaluatePasswordStrength("abc123!@")),

                () -> assertEquals("Trung binh",
                        service.evaluatePasswordStrength("ABC123!@")),

                () -> assertEquals("Trung binh",
                        service.evaluatePasswordStrength("Abcdef!@")),

                () -> assertEquals("Trung binh",
                        service.evaluatePasswordStrength("Abc12345")),

                () -> assertEquals("Yeu",
                        service.evaluatePasswordStrength("Ab1!")),

                () -> assertEquals("Yeu",
                        service.evaluatePasswordStrength("password")),

                () -> assertEquals("Yeu",
                        service.evaluatePasswordStrength("ABC12345"))
        );
    }
}