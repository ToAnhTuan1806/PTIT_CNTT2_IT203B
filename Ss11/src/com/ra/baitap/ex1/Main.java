package com.ra.baitap.ex1;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Connection connection = null;

        try {
            // mo ket noi database
            connection = DBContext.getConnection();
            System.out.println("Ket noi database thanh cong!");

        } catch (Exception e) {
            System.out.println("Ket noi database that bai!");
            e.printStackTrace();
        } finally {
            // dong ket noi sau khi su dung
            DBContext.closeConnection(connection);
            System.out.println("Da dong ket noi.");
        }
    }
}
