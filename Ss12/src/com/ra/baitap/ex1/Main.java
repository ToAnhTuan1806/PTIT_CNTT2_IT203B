package com.ra.baitap.ex1;

import com.ra.baitap.DBConnection;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma bac si: ");
        String code = sc.nextLine();
        System.out.print("Nhap mat khau: ");
        String pass = sc.nextLine();

        Connection conn = DBConnection.openConnection();

        if (conn == null) {
            System.out.println("Khong the ket noi CSDL");
            return;
        }
        DoctorLogin login = new DoctorLogin();
        boolean result = login.loginDoctor(conn, code, pass);
        if (result) {
            System.out.println("Cho phep truy cap benh an");
        } else {
            System.out.println("Tu choi truy cap");
        }

        sc.close();
    }
}
