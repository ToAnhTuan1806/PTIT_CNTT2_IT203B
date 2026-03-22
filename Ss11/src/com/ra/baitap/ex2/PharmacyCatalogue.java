package com.ra.baitap.ex2;

import java.sql.ResultSet;
import java.sql.Statement;
// Phan 2:
public class PharmacyCatalogue {
    public void printCatalogue(Statement stmt) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy");
            boolean hasData = false;
            System.out.println("===== DANH MUC THUOC =====");
            System.out.printf("%-30s %-15s%n", "ten thuoc", "So luong toon kho");

            // while de duyet toan bo cac dong
            while (rs.next()) {
                hasData = true;
                String medicineName = rs.getString("medicine_name"); //ten thuoc
                int stock = rs.getInt("stock"); //sl ton kho
                System.out.printf("%-30s %-15d%n", medicineName, stock);
            }

            // neu bang trong thi tbao
            if (!hasData) {
                System.out.println("Kho thuốc hiện đang trống.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Phan 1: Phan tich
/*
Lệnh if (rs.next()) chỉ kiểm tra dữ liệu một lần duy nhất, nên nếu bảng có nhiều thuốc thì chương trình cũng chỉ lấy được dòng đầu tiên rồi dừng
Vì vậy, if không đủ để xử lý yêu cầu in danh sách toàn bộ thuốc
Ban đầu, con trỏ của ResultSet nằm trước dòng dữ liệu đầu tiên. Mỗi lần gọi next(), con trỏ sẽ di chuyển xuống một dòng tiếp theo:
    -nếu còn dữ liệu thì next() trả về true
    -nếu đã hết dữ liệu thì next() trả về false
Do đó:
    -dùng if (rs.next()) thì chỉ đọc được 1 dòng
    -dùng while (rs.next()) thì có thể duyệt toàn bộ các dòng
Nếu bảng thuốc trống thì rs.next() sẽ trả về false ngay từ đầu. Khi đó chương trình nên có thông báo phù hợp thay vì chỉ kết thúc mà không in gì
Vì vậy, để in đầy đủ danh mục thuốc gồm Tên thuốc và Số lượng tồn kho, cần thay if bằng vòng lặp while
 */
