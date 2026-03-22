package com.ra.baitap.ex3;

import java.sql.Statement;
// Phan 2
public class BedManagement {
    public void updateBedStatus(Statement stmt, String inputId) {
        try {
            String sql = "UPDATE Beds SET bed_status = 'Dang su dung' WHERE bed_id = '" + inputId + "'";
            // chay lenh update
            int rowsAffected = stmt.executeUpdate(sql);
            // ktra so dong bi tac dong
            if (rowsAffected > 0) {
                System.out.println("Cap nhat trang thai giuong benh thanh cong!");
            } else {
                System.out.println("Loi: Ma giuong nay khong ton tai");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Phan 1: Phan tich
/*
executeUpdate() trả về số dòng dữ liệu bị ảnh hưởng bởi câu lệnh UPDATE
Nếu kết quả lớn hơn 0, nghĩa là có dữ liệu được cập nhật thành công
Nếu kết quả bằng 0, nghĩa là không có dòng nào khớp với điều kiện, tức là mã giường không tồn tại
Vì vậy cần kiểm tra giá trị trả về của executeUpdate() để thông báo chính xác
    cho y tá rằng cập nhật thành công hay mã giường không tồn tại
 */
