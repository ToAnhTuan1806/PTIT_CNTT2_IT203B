package com.btth;

import java.sql.*;

public class TransferMoney {
    public static void transfer(String fromId, String toId, double amount){
        Connection conn;

        try {
            conn=DBConnection.openConnection();

            conn.setAutoCommit(false);

            String checkSql= "Select Balance from Accounts where AccountId= ?";
            PreparedStatement pstmt = conn.prepareStatement(checkSql);
            pstmt.setString(1, fromId);
            ResultSet rs = pstmt.executeQuery();

            if(!rs.next()){
                throw new Exception("Tai khoan gui khong ton tai");
            }
            double balance = rs.getDouble("Balance");
            if (balance<amount){
                throw new Exception("Khong du tien");
            }

            pstmt.setString(1, toId);
            rs= pstmt.executeQuery();

            if(!rs.next()){
                throw new Exception("Tai khoan nhan khong ton tai");
            }

            CallableStatement call=conn.prepareCall("{call sp_UpdateBlance(?,?)}");

            // tru tien
            call.setString(1, fromId);
            call.setDouble(2, -amount);
            call.execute();

            // cong tien
            call.setString(1,  toId);
            call.setDouble(2, +amount);
            call.execute();

            conn.commit();
            System.out.println("Chuyen tien thanh cong");

            String selectSql= "Select * from Accounts";
            PreparedStatement ps=conn.prepareStatement(selectSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
