package com.ra.baitap.ex2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VitalSignUpdate {
    public void updateVitalSigns(Connection conn, String patientId, double temperature, int heartRate) {
        String sql= """
                Update Patients set temperature = ?, heart_rate = ? where patient_id = ?;
                """;
        try(PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setDouble(1, temperature);
            pstmt.setInt(2, heartRate);
            pstmt.setString(3, patientId);
            int rows = pstmt.executeUpdate();
            if(rows>0){
                System.out.println("cap nhat chi so sinh ton thanh cong");
            }else {
                System.out.println("khong tim thays benh nhan");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

// Phần 1: Phân tích
/*
Trong jdbc khi ta dùng Statement và nỗi chuỗi để tạo lệnh SQL, giá trị số thực như nhiệt độ (double) có thể bị ảnh hưởng
    bởi thiết lập vùng miền (Locale) của máy tính
vd trên một số máy tính, số thập phân được nhập là 37,5 thay vì 37.5. Nếu ta nối trực tiếp giá trị này vào
    câu lệnh SQL thì database sẽ không hiểu và báo lỗi cú pháp, vì database chỉ chấp nhận dấu chấm cho số thực
Khi dùng PreparedStatement ta không cần phải nối chuỗi nữa mà truyền giá trị thông qua các phương thức như setDouble() hoặc setInt()
    các phương thức này sẽ tự động chuyển đổi dữ liệu sang định dạng chuẩn mà database có thể hiểu được, không phụ thuộc vào cách hiển thị số trên hệ điều hành
việc sử dụng setDouble() và setInt() trong PreparedStatement giúp chương trình:
    Không bị lỗi do khác nhau về dấu thập phân giữa các hệ điều hành
    Truyền dữ liệu đúng kiểu số cho cơ sở dữ liệu
    Giúp code an toàn và dễ viết hơn

 */
