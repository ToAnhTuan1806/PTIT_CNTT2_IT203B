package lythuyet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class PrepardStatement {
    // ke thua Statement
    // Cho phep truyen tham so vao sql thong qua setter

    public static void main(String[] args) {
        // mo ket noi
        try (Connection conn = DBConnection.openConnection()) {
            //SELECT
            // chuan bi cau lenh
            PreparedStatement preSelect = conn.prepareStatement("SELECT * FROM student where id = ?");
            // truyen tham soneu co
            preSelect.setInt(1, 2); // tim theo ma student id =2
            // thuc thi cau lenh: excuteQuerry(new la Select), excuteUpdate(INSERT, UPDATE, DELETE)
            ResultSet resultSet = preSelect.executeQuery();
            // xu ly ket qua tra ve neu co
            if (resultSet.next()) {
                // lay thong tin qua get
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("SELECT: " + id + " - " + name);
            }

            //INSERT
            // chuan bi cau lenh
            PreparedStatement preInsert = conn.prepareStatement("INSERT INTO student(name) VALUES(?)");
            // truyen tham so
            preInsert.setString(1, "Nguyen Van A");
            // thuc thi
            int rowInsert = preInsert.executeUpdate();
            System.out.println("INSERT thanh cong: " + rowInsert + " dong");

            // UPDATE
            // chuan bi cau lenh
            PreparedStatement preUpdate = conn.prepareStatement("UPDATE student SET name = ? WHERE id = ?");
            // truyen tham so
            preUpdate.setString(1, "Tran Van B");
            preUpdate.setInt(2, 2);
            // thuc thi
            int rowUpdate = preUpdate.executeUpdate();
            System.out.println("UPDATE thanh cong: " + rowUpdate + " dong");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}