package com.ra.baitap.ex5.dao;

import com.ra.baitap.ex5.db.DBConnection;
import com.ra.baitap.ex5.model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {
    // lay toan bo danh sach bac si tu database
    public List<Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT doctor_id, full_name, specialization, duty_date FROM Doctors";

        try (
                Connection conn = DBConnection.openConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            // duyet tung dong du lieu trong bang Doctors
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setDoctorId(rs.getString("doctor_id"));
                doctor.setFullName(rs.getString("full_name"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setDutyDate(rs.getDate("duty_date"));
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            System.out.println("Loi khi lay danh sach bac si: " + e.getMessage());
        }
        return doctors;
    }

    // them mot bac si moi vao database
    public boolean insertDoctor(Doctor doctor) {
        String sql = "INSERT INTO Doctors(doctor_id, full_name, specialization, duty_date) VALUES (?, ?, ?, ?)";

        try (
                Connection conn = DBConnection.openConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            // gan gia tri cho cau lenh SQL
            ps.setString(1, doctor.getDoctorId());
            ps.setString(2, doctor.getFullName());
            ps.setString(3, doctor.getSpecialization());
            ps.setDate(4, doctor.getDutyDate());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Loi khi them bac si: " + e.getMessage());
            return false;
        }
    }

    // thong ke so luong bac si theo tung chuyen khoa
    public void statisticBySpecialization() {
        String sql = "SELECT specialization, COUNT(*) AS total FROM Doctors GROUP BY specialization";
        try (
                Connection conn = DBConnection.openConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {
            System.out.println("===== THONG KE CHUYEN KHOA =====");
            System.out.printf("%-25s %-10s%n", "Chuyen khoa", "So luong");

            // in ra tung chuyen khoa va so luong bac si
            while (rs.next()) {
                String specialization = rs.getString("specialization");
                int total = rs.getInt("total");
                System.out.printf("%-25s %-10d%n", specialization, total);
            }
        } catch (SQLException e) {
            System.out.println("Loi khi thong ke chuyen khoa: " + e.getMessage());
        }
    }
}
