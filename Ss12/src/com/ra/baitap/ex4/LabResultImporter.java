package com.ra.baitap.ex4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class LabResultImporter {
    public void importResults(Connection conn, List<LabResult> results) {
        String sql = "INSERT INTO LabResults(patient_id, test_name, result_value) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (LabResult result : results) {
                ps.setString(1, result.getPatientId());
                ps.setString(2, result.getTestName());
                ps.setDouble(3, result.getResultValue());
                ps.executeUpdate();
            }

            System.out.println("Nap du lieu xet nghiem thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*
PreparedStatement giúp chương trình chạy nhanh hơn vì câu lệnh SQL chỉ cần chuẩn bị một lần ở đầu.
Sau đó trong vòng lặp chỉ việc thay dữ liệu rồi chạy tiếp, không cần database phải phân tích lại câu lệnh nhiều lần.
Nhờ vậy giảm tải cho server và tốc độ nạp dữ liệu sẽ nhanh hơn rõ rệt.
 */

// Phần 1: Phân tích
/*
Khi chương trình sử dụng Statement và thực hiện lệnh SQL trong vòng lặp nhiều lần
    ví dụ như nạp 1.000 kết quả xét nghiệm, thì mỗi lần thực hiện database đều phải làm lại
        các bước như phân tích câu lệnh (parse), kiểm tra cú pháp và tạo kế hoạch thực thi (execution plan)
Trong khi đó cấu trúc câu lệnh SQL thực tế không thay đổi, chỉ khác dữ liệu đầu vào.
    Việc database phải lặp lại các bước này 1.000 lần là không cần thiết và gây lãng phí tài nguyên như CPU và bộ nhớ.
        Điều này làm tăng tải cho server và khiến chương trình chạy chậm hơn.

có thể hiểu database giống như phải “đọc lại đề bài từ đầu” mỗi lần thực hiện câu lệnh, dù nội dung gần như giống nhau.
    Vì vậy khi số lượng dữ liệu lớn, hiệu năng hệ thống sẽ giảm rõ rệt.
 */