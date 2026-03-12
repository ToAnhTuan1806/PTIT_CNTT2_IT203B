import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ProductManager manager=new ProductManager();

        while (true){
            System.out.println("----- Product Management System -----");
            System.out.println("1. Them san pham moi");
            System.out.println("2. Hien thi danh sach san pham");
            System.out.println("3. Cap nhat so luong theo id");
            System.out.println("4. Xoa san pham da het hang");
            System.out.println("5. Thoat chuong trinh");
            System.out.print("Lua chon cua ban: ");
            int choice=sc.nextInt();

            switch (choice){
                case 1:
                    try{
                        System.out.print("Nhap ID: ");
                        int id=sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nhap ten: ");
                        String name=sc.nextLine();

                        System.out.print("Nhap gia: ");
                        double price=sc.nextDouble();

                        System.out.print("Nhap so luong: ");
                        int quantity=sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nhap danh muc: ");
                        String category=sc.nextLine();

                        Product product=new Product(id,name,price,quantity,category);
                        manager.addProduct(product);
                        System.out.println("Them sp thanh cong");
                    }catch (InvalidProductException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    manager.displayProducts();
                    break;
                case 3:
                    try{
                        System.out.print("Nhap id: ");
                        int id=sc.nextInt();

                        System.out.print("Nhap so luong moi: ");
                        int quantity=sc.nextInt();

                        manager.updateQuantity(id, quantity);
                        System.out.println("Cap nhat so luong thanh cong");
                    } catch (InvalidProductException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    manager.deleteOutOfStock();
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
