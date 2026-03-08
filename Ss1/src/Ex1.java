import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhap nam sinh cua ban: ");
        String date= sc.nextLine();

        try {
            int namSinh= Integer.parseInt(date);
            int tuoi= 2026-namSinh;
            System.out.println("Tuoi cua ban la: "+ tuoi);
        } catch (NumberFormatException e) {
            System.out.println("Phai nhai so hop le!");
        }finally {
            sc.close();
        }
    }
}
