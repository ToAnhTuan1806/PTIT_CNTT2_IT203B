package baitap.ex5;

public class Main {
    public static void main(String[] args) {
        SuperAdmin superAdmin = new SuperAdmin();
        superAdmin.logActivity("Delete user");
    }
}

// lop superadmin thuc thi ca 2 interface nay thi Java se khong biet dung method nao
// Giai quyet bang cach: Class superadmin phai override lai phuong thuc logActivity()
