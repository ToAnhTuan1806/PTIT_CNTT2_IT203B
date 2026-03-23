package com.ra.baitap.ex5;

public class Patient {
    private int id;
    private String patientCode;
    private String patientName;
    private int age;
    private String department;
    private String disease;
    private int admissionDays;
    private String status;

    public Patient() {
    }

    public Patient(int id, String patientCode, String patientName, int age,
                   String department, String disease, int admissionDays, String status) {
        this.id = id;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.age = age;
        this.department = department;
        this.disease = disease;
        this.admissionDays = admissionDays;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String getDisease() {
        return disease;
    }

    public int getAdmissionDays() {
        return admissionDays;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setAdmissionDays(int admissionDays) {
        this.admissionDays = admissionDays;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
