package com.ra.baitap.ex4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "123456$";
    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        Scanner scanner = new Scanner(System.in);
        try {
            // mo ket noi database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Ket noi database thanh cong!");

            // tao statement
            stmt = connection.createStatement();

            // nhap ten benh nhan can tim
            System.out.print("Nhap ten benh nhan can tim: ");
            String name = scanner.nextLine();

            // goi ham tim kiem
            SQLInjection si = new SQLInjection();
            si.searchPatient(stmt, name);

        } catch (Exception e) {
            System.out.println("Loi ket noi hoac truy van database!");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if ( connection!= null) {
                    connection.close();
                }
                System.out.println("Da dong ket noi.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
