import baitap.UserProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserProcessorTest {

    UserProcessor processor;

    @BeforeEach
    void khoiTaoDuLieu() {
        processor = new UserProcessor();
        System.out.println("Khoi tao doi tuong UserProcessor truoc moi test");
    }

    @Test
    @DisplayName("Kiem tra email hop le")
    void testEmailHopLe() {
        String email = "user@gmail.com";
        String result = processor.processEmail(email);
        System.out.println("Test email hop le");
        assertEquals("user@gmail.com", result);
    }

    @Test
    void testEmailThieuKyTuAt() {
        String email = "usergmail.com";
        System.out.println("Test email thieu @");
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail(email);
        });
    }

    @Test
    void testEmailKhongCoTenMien() {
        String email = "user@";
        System.out.println("Test email khong co ten mien");

        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail(email);
        });
    }

    @Test
    void testChuanHoaEmail() {
        String email = "Example@Gmail.com";
        String result = processor.processEmail(email);
        System.out.println("Test chuan hoa email");
        assertEquals("example@gmail.com", result);
    }
}