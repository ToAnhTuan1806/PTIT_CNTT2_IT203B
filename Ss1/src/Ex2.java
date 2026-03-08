import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhap tong so nguoi: ");
        int tongNg=sc.nextInt();

        System.out.print("Nhap so nhom: ");
        int soNhom=sc.nextInt();

        try {
            int moiNhom= tongNg/soNhom;
            System.out.println("Moi nhom co: "+moiNhom);
        }catch (ArithmeticException e){
            System.out.println("Khong the chia cho 0");
        }
        sc.close();
    }
}
