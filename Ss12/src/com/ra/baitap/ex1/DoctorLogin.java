package com.ra.baitap.ex1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorLogin {
    public boolean loginDoctor(Connection conn, String doctorCode, String password) {

        String sql = "SELECT * FROM Doctors WHERE doctor_code = ? AND password = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, doctorCode);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Dang nhap thanh cong");
                System.out.println("Ma bac si: " + rs.getString("doctor_code"));
                System.out.println("Ten bac si: " + rs.getString("doctor_name"));
                return true;
            } else {
                System.out.println("Sai ma bac si hoac mat khau");
            }
        } catch (Exception e) {
            System.out.println("Loi he thong khi dang nhap");
            e.printStackTrace();
        }
        return false;
    }
}

// Phan 1: Phaan tích
/*
PreparedStatement giúp trống lại SQL Ịnection vì nó khôg cho dư liệu ng dùng nhập trực tiếp tham gia vaò việc tạo câu lệnh SQL
Khi dùng Stament ta thường nối chuối để tạo câu Sql
    khi nhập ký tự đặc biệt kiểu ' OR '1'='1 thì ctruc lệnh SQL sẽ bị thay đổi và có thể làm dkien đăng nhập luôn đúng
        từ đó hacker có thể truy cập trái phép
Còn khi dùng PreparedStatement câu lệnh SQl đc viết sẵn với các dấu (?) làm tham số
    sau đó giá trị ng dùng nhập vào đc gán bằng các pthuc như séttring(), setInt(), ...
        lúc này dữ liệu đầu vào chỉ được coi là giá trị dữ liệu thuần túy, không được hiểu là một phần của câu lệnh SQL
Do đó, các ký tự nguy hiểm như OR, --, ;… sẽ không thể làm thay đổi logic của câu lệnh

 */