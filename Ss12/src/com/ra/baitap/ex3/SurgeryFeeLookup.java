package com.ra.baitap.ex3;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class SurgeryFeeLookup {
    public void getSurgeryFee(Connection conn, int surgeryId) {
        String sql = "{CALL GET_SURGERY_FEE(?, ?)}";

        try (CallableStatement cs = conn.prepareCall(sql)) {

            // truyen tham so dau vao
            cs.setInt(1, surgeryId);
            // dang ky tham so dau ra
            cs.registerOutParameter(2, Types.DECIMAL);

            cs.execute();

            // lay gia tri tu tham so OUT
            BigDecimal totalCost = cs.getBigDecimal(2);

            if (totalCost != null) {
                System.out.println("Chi phi phau thuat la: " + totalCost);
            } else {
                System.out.println("Khong lay duoc chi phi phau thuat");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Phần 1: Phân tích
/*
khi gọi Stored Procedure trong JDBC mà có tham số đầu ra (OUT), ta bắt buộc phải sử dụng phương thức registerOutParameter() trước khi thực thi câu lệnh
    vì JDBC cần biết trước tham số nào sẽ nhận giá trị trả về từ database và kiểu dữ liệu của tham số đó là gì.
        Nếu không đăng ký trước sau khi thủ tục chạy xong chương trình sẽ không biết đọc dữ liệu ở vị trí nào,
            từ đó dễ dẫn đến lỗi như “The column index is out of range” hoặc không lấy được giá trị tiền tệ trả về.
có thể hiểu đơn giản rằng registerOutParameter() giống như bước khai báo cho JDBC biết rằng:
    tham số này sẽ chứa kết quả trả về, hãy chuẩn bị để nhận dữ liệu.
khi tham số đầu ra trong cơ sở dữ liệu có kiểu DECIMAL, thì trong Java phải đăng ký bằng hằng số Types.DECIMAL thuộc lớp java.sql.Types.
    việc chọn đúng kiểu dữ liệu giúp JDBC đọc giá trị từ database chính xác và tránh lỗi sai kiểu dữ liệu

 */
