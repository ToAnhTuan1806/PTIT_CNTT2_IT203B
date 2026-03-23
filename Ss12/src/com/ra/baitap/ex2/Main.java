package com.ra.baitap.ex2;

import com.ra.baitap.DBConnection;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma benh nhan: ");
        String patientId = sc.nextLine();
        System.out.print("Nhap nhiet do: ");
        double temperature = sc.nextDouble();
        System.out.print("Nhap nhip tim: ");
        int heartRate = sc.nextInt();
        Connection conn = DBConnection.openConnection();
        if (conn == null) {
            System.out.println("Khong ket noi duoc CSDL");
            return;
        }
        VitalSignUpdate vs = new VitalSignUpdate();
        vs.updateVitalSigns(conn, patientId, temperature, heartRate);
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
