package com.ra.baitap.ex5;

import java.math.BigDecimal;
import java.sql.*;

public class PatientService {
    public void displayPatients(Connection conn) {
        String sql = "SELECT id, patient_code, patient_name, age, department, disease, admission_days, status FROM patient_ra";
        try (
                // Su dung PreparedStatement de tranh SQL Injection
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            System.out.println("\n===== DANH SACH BENH NHAN =====");
            System.out.printf("%-5s %-10s %-20s %-5s %-20s %-20s %-10s %-10s%n", "ID", "Ma BN", "Ten", "Tuoi", "Khoa", "Benh ly", "So ngay", "Trang thai");
            while (rs.next()) {
                System.out.printf("%-5d %-10s %-20s %-5d %-20s %-20s %-10d %-10s%n",
                        rs.getInt("id"),
                        rs.getString("patient_code"),
                        rs.getString("patient_name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getString("disease"),
                        rs.getInt("admission_days"),
                        rs.getString("status"));
            }
        } catch (Exception e) {
            System.out.println("Loi khi hien thi danh sach benh nhan");
            e.printStackTrace();
        }
    }

    //ham tiep nhan benh nhan moi
    public void addPatient(Connection conn, Patient patient) {
        //lenh insert co su dung dau ? de truyen tham so
        String sql = "INSERT INTO patient_ra(patient_code, patient_name, age, department, disease, admission_days, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            //gan gia tri cho tung tham so
            ps.setString(1, patient.getPatientCode());
            ps.setString(2, patient.getPatientName());
            ps.setInt(3, patient.getAge());
            ps.setString(4, patient.getDepartment());
            ps.setString(5, patient.getDisease());
            ps.setInt(6, patient.getAdmissionDays());
            ps.setString(7, patient.getStatus());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Tiep nhan benh nhan moi thanh cong");
            } else {
                System.out.println("Tiep nhan benh nhan that bai");
            }
        } catch (Exception e) {
            System.out.println("Loi khi them benh nhan");
            e.printStackTrace();
        }
    }

    //ham cap nhat thong tin benh ly cua benh nhan theo ID
    public void updateDisease(Connection conn, int patientId, String newDisease) {
        String sql = "UPDATE patient_ra SET disease = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newDisease);
            ps.setInt(2, patientId);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Cap nhat benh an thanh cong");
            } else {
                System.out.println("Khong tim thay benh nhan");
            }

        } catch (Exception e) {
            System.out.println("Loi khi cap nhat benh an");
            e.printStackTrace();
        }
    }

    //ham xuat vien benh nhan va tinh tong vien phi
    public void dischargePatient(Connection conn, int patientId) {
        //goi stored procedure tinh phi
        String callSql = "{CALL CALCULATE_DISCHARGE_FEE(?, ?)}";
        //sau khi tinh phi se cap nhat trang thai xuat vien
        String updateSql = "UPDATE patient_ra SET status = 'Xuat vien' WHERE id = ?";

        try (CallableStatement cs = conn.prepareCall(callSql)) {
            cs.setInt(1, patientId);
            // Dang ky tham so dau ra total_fee kieu DECIMAL
            cs.registerOutParameter(2, Types.DECIMAL);
            cs.execute();
            //lay tong vien phi tra ve
            BigDecimal totalFee = cs.getBigDecimal(2);
            //cap nhat trang thai xuat vien
            try (PreparedStatement ps = conn.prepareStatement(updateSql)) {

                ps.setInt(1, patientId);

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    System.out.println("Xuat vien thanh cong");
                    System.out.println("Tong vien phi: " + totalFee + " VND");
                } else {
                    System.out.println("Khong tim thay benh nhan");
                }
            }

        } catch (Exception e) {
            System.out.println("Loi khi xuat vien va tinh phi");
            e.printStackTrace();
        }
    }
}
