package com.ra.baitap.ex5.business;

import com.ra.baitap.ex5.dao.DoctorDAO;
import com.ra.baitap.ex5.model.Doctor;

import java.util.List;

public class DoctorBusiness {
    private final DoctorDAO doctorDAO = new DoctorDAO();
    // lay danh sach bac si de hien thi
    public List<Doctor> getAllDoctors() {
        return doctorDAO.findAll();
    }
    // kiem tra du lieu truoc khi them bac si moi
    public boolean addDoctor(Doctor doctor) {
        // kiem tra ma bac si co rong hay khong
        if (doctor.getDoctorId() == null || doctor.getDoctorId().trim().isEmpty()) {
            System.out.println("Ma bac si khong duoc de trong.");
            return false;
        }
        // kiem tra ho ten co rong hay khong
        if (doctor.getFullName() == null || doctor.getFullName().trim().isEmpty()) {
            System.out.println("Ho ten khong duoc de trong.");
            return false;
        }
        // kiem tra chuyen khoa co rong hay khong
        if (doctor.getSpecialization() == null || doctor.getSpecialization().trim().isEmpty()) {
            System.out.println("Chuyen khoa khong duoc de trong.");
            return false;
        }
        // kiem tra do dai chuyen khoa
        if (doctor.getSpecialization().length() > 50) {
            System.out.println("Chuyen khoa qua dai.");
            return false;
        }
        // goi DAO de them vao database
        return doctorDAO.insertDoctor(doctor);
    }
    // goi chuc nang thong ke chuyen khoa
    public void statisticDoctorsBySpecialization() {
        doctorDAO.statisticBySpecialization();
    }
}
