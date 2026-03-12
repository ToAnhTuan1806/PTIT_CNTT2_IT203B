import baitap.UserValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserValidatorTest {
    UserValidator validator=new UserValidator();

    @Test
    @DisplayName("Username hop le")
    void testUsernameHopLe() {

        // Arrange
        String username = "tuan1806";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        System.out.println("username hop le");
        assertTrue(result);
    }

    @Test
    @DisplayName("Username qua ngan")
    void testUsernameQuaNgan() {
        // Arrange
        String username = "tuan";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        System.out.println("username qua ngan");
        assertFalse(result);
    }

    @Test
    @DisplayName("Username chua khoang trang")
    void testUsernameChuaKhoangTrang() {

        // Arrange
        String username = "to tuan";

        // Act
        boolean result = validator.isValidUsername(username);

        // Assert
        System.out.println("username chua khoang trang");
        assertFalse(result);
    }
}
