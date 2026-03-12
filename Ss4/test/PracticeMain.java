import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PracticeMain {

    @Test
    void kiemTraSoNguyenTo(){
        System.out.println("Test: kiem tra so 7 co phai so nguyen to");
        assertTrue(Practice.isPrime(7));
    }

    @Test
    void kiemTraKhongPhaiSoNguyenTo(){
        System.out.println("Test: kiem tra so 8 khong phai so nguyen to");
        assertFalse(Practice.isPrime(8));
    }

    @Test
    void kiemTraSoNhoHon2(){
        System.out.println("Test: kiem tra so nho hon 2");
        assertFalse(Practice.isPrime(1));
        assertFalse(Practice.isPrime(0));
        assertFalse(Practice.isPrime(-3));
    }

    @Test
    void tinhFibonacciBang0(){
        System.out.println("Test: fibonacci cua 0");
        assertEquals(0, Practice.fibonacci(0));
    }

    @Test
    void tinhFibonacciBang1(){
        System.out.println("Test: fibonacci cua 1");
        assertEquals(1, Practice.fibonacci(1));
    }

    @Test
    void tinhFibonacciBang5(){
        System.out.println("Test: fibonacci cua 5");
        assertEquals(5, Practice.fibonacci(5));
    }

    @Test
    void tinhFibonacciBang10(){
        System.out.println("Test: fibonacci cua 10");
        assertEquals(55, Practice.fibonacci(10));
    }

    @Test
    void fibonacciSoAm(){
        System.out.println("Test: fibonacci voi so am");
        assertThrows(IllegalArgumentException.class, () -> {
            Practice.fibonacci(-1);
        });
    }
}