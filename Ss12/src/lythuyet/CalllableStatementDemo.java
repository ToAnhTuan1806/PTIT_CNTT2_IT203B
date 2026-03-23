package lythuyet;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CalllableStatementDemo {
    public static void main(String[] args) {
        try(
                Connection conn = DBConnection.openConnection();
                CallableStatement call= conn.prepareCall("{call deleteStudentById(?)}(?,?)}");
                ){
            // truyen tham so neu co
            call.setInt(1, 1); // xoa id=1
            // thuc thi
            int count = call.executeUpdate();
            System.out.println("da xoa " + count+ "ban ghi");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
