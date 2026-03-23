package com.ra.baitap.ex5;

import com.ra.baitap.DBConnection;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection conn = DBConnection.openConnection();
        if (conn == null) {
            System.out.println("Khong the ket noi den CSDL");
            return;
        }

        PatientService service = new PatientService();
        int choice;
        do {
            System.out.println("\n===== HE THONG QUAN LY NOI TRU RIKKEI-HOSPITAL =====");
            System.out.println("1. Danh sach benh nhan");
            System.out.println("2. Tiep nhan benh nhan moi");
            System.out.println("3. Cap nhat benh an");
            System.out.println("4. Xuat vien va tinh phi");
            System.out.println("5. Thoat");
            System.out.print("Nhap lua chon: ");
            while (!sc.hasNextInt()) {
                System.out.print("Vui long nhap so: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    service.displayPatients(conn);
                    break;
                case 2:
                    Patient patient = new Patient();
                    System.out.print("Nhap ma benh nhan: ");
                    patient.setPatientCode(sc.nextLine());
                    System.out.print("Nhap ten benh nhan: ");
                    patient.setPatientName(sc.nextLine());
                    System.out.print("Nhap tuoi: ");
                    patient.setAge(Integer.parseInt(sc.nextLine()));
                    System.out.print("Nhap khoa dieu tri: ");
                    patient.setDepartment(sc.nextLine());
                    System.out.print("Nhap benh ly: ");
                    patient.setDisease(sc.nextLine());
                    System.out.print("Nhap so ngay nam vien: ");
                    patient.setAdmissionDays(Integer.parseInt(sc.nextLine()));
                    patient.setStatus("Noi tru");

                    service.addPatient(conn, patient);
                    break;
                case 3:
                    System.out.print("Nhap ID benh nhan can cap nhat: ");
                    int updateId = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhap benh ly moi: ");
                    String newDisease = sc.nextLine();

                    service.updateDisease(conn, updateId, newDisease);
                    break;
                case 4:
                    System.out.print("Nhap ID benh nhan can xuat vien: ");
                    int dischargeId = Integer.parseInt(sc.nextLine());
                    service.dischargePatient(conn, dischargeId);
                    break;
                case 5:
                    System.out.println("Da thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }

        } while (choice != 5);

        try {
            conn.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
