package com.ra.bt.ex1;

import com.ra.bt.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PrescriptionService {
    public void capPhatThuoc(int medicineId, int patientId) {
        Connection conn = null;
        try {
            conn = DBConnection.openConnection();
            conn.setAutoCommit(false);

            // tru thuoc trong kho
            String sql1 = "UPDATE Medicine_Inventory " + "SET quantity = quantity - 1 " + "WHERE medicine_id = ? AND quantity > 0";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, medicineId);

            int row = ps1.executeUpdate();
            if (row == 0) {
                throw new RuntimeException("Thuoc khong ton tai hoac het hang");
            }

            // lich su cap phat
            String sql2 = "INSERT INTO Prescription_History(patient_id, medicine_id, date) " +
                    "VALUES (?, ?, NOW())";

            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, patientId);
            ps2.setInt(2, medicineId);
            ps2.executeUpdate();
            conn.commit();
            System.out.println("Cap phat thuoc thanh cong");

        } catch (Exception e) {
            System.out.println("Giao dich that bai -> rollback");
            try {
                conn.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (Exception e) {
            }
        }
    }
}

// Phần 1: Phân tích:
/*
Trong jdbc khi mở kết nối thì chế độ Auto-Commit mặc định được bật
    vì vậy mỗi câu lệnh SQL chạy thành công sẽ được commit ngay vào database
Trong chương trình, câu lệnh trừ thuốc trong kho thực hiện trước, nên dữ liệu đã bị lưu lại
    sau đó chương trình xảy ra lỗi nên câu lệnh ghi lịch sử cấp phát không được thực hiện
Do hai thao tác không nằm trong cùng một Transaction, nên database không tự hủy thao tác trước đó
   kết quả là thuốc đã bị trừ nhưng không có lịch sử cấp phát, gây sai lệch dữ liệu nên điều này vi phạm tính nguyên tử (Atomicity) của
        Transaction: nghiệp vụ đúng phải “hoặc thực hiện hết, hoặc hủy hết”.
 */