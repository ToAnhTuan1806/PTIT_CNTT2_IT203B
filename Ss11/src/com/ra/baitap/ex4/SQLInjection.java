package com.ra.baitap.ex4;

import java.sql.ResultSet;
import java.sql.Statement;
// Phan 2
public class SQLInjection {
    public void searchPatient(Statement stmt, String inputName) {
        try {
            String patientName = inputName;
            // loai bo ky tu dac biet de gay SQL Injection
            patientName = patientName.replace("--", "");
            patientName = patientName.replace(";", "");
            patientName = patientName.replace("'", "");

            String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Ma BN: " + rs.getString("patient_id"));
                System.out.println("Ho ten: " + rs.getString("full_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Phan 1: Phan tich
/*
do dư liệu được nhập từ người dùng được nối trực tiếp vào câu lệnh SQL nên hacker có thể chèn thêm điều kiện độc hại
vd nếu nhập : ' OR '1'='1
thì SQL sẽ thành: SELECT * FROM Patients WHERE full_name = '' OR '1'='1'
vì điều kiện '1'='1' luôn đúng. Vì OR chỉ cần một vế đúng nên mệnh đề WHERE sẽ luôn đúng với mọi bản ghi
vì vậy hệ thống sẽ trả về toàn bộ dữ liệu bệnh nhân thay vì chỉ một người, gây rò rỉ thông tin.
 */
