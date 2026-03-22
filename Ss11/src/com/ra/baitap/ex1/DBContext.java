package com.ra.baitap.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Phan 2
public class DBContext {
    // cau hinh
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "123456$";

    // lay connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // dong connection
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

// Phan 1: Phan tích
/*
Nếu chương trình liên tục mở kết nối đến cơ sở dữ liệu nhưng không đóng lại,
    số lượng kết nối sẽ tăng dần theo thời gian và chiếm hết tài nguyên của database.
Điều này giống như trong bệnh viện, nhiều người cùng lấy thiết bị làm việc nhưng dùng xong không trả.
Ban đầu chưa thấy vấn đề, nhưng sau một thời gian sẽ không còn đủ tài nguyên cho người đến sau.
Khi đó, phần mềm có thể chạy chậm, bị treo hoặc mất kết nối với cơ sở dữ liệu, dẫn đến lỗi Communications link failure.
Với hệ thống y tế phải hoạt động 24/7, đây là vấn đề rất nguy hiểm vì có thể làm gián đoạn việc tra cứu bệnh án,
    nhập thông tin bệnh nhân và xử lý cấp cứu.
Ngoài ra, việc viết cứng URL, username và password trong mã nguồn cũng khiến chương trình khó bảo trì và kém an toàn.
Vì vậy, cần tạo lớp DBContext để quản lý kết nối tập trung và đảm bảo mọi truy vấn đều đóng kết nối trong khối finally.
 */
