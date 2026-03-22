package com.ra.baitap.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "123456$";

    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        try {
            // mo ket noi database
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Ket noi database thanh cong!");
            // tao statement
            stmt = connection.createStatement();
            // goi ham in danh muc thuoc
            PharmacyCatalogue pc = new PharmacyCatalogue();
            pc.printCatalogue(stmt);

        } catch (Exception e) {
            System.out.println("Loi ket noi hoac truy van DB");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
                System.out.println("Da dong ket noi.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
