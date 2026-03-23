package com.ra.baitap.ex3;

import com.ra.baitap.DBConnection;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap id ca phau thuat: ");
        int surgeryId = sc.nextInt();

        Connection conn = DBConnection.openConnection();

        if (conn == null) {
            System.out.println("Khong ket noi duoc CSDL");
            return;
        }
        SurgeryFeeLookup lookup = new SurgeryFeeLookup();
        lookup.getSurgeryFee(conn, surgeryId);

        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
