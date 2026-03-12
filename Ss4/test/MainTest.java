import org.junit.jupiter.api.*;

public class MainTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Chạy trước tất cả test");
    }

    @BeforeEach
    void setup(){
        System.out.println("Chạy trước mỗi test");
    }

    @AfterEach
    void tearDown(){
        System.out.println("Chạy sau mỗi test");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Chạy sau tất cả test");
    }

    @Test
    void sum1(){
        Main main = new Main();
        // Gia tri mong muon: a=1, b=2 (expected)
        Assertions.assertEquals(3, main.sum(1, 2));
        Assertions.assertEquals(5, main.sum(3, 2));
        Assertions.assertEquals(10, main.sum(5, 5));
        Assertions.assertEquals(0, main.sum(0, 0));

    }

    @Test
    void sum2(){
        System.out.println("test sum2");
    }

    @Disabled
    @Test
    void testBiTat(){
        System.out.println("Test này sẽ bị tắt");
    }
}