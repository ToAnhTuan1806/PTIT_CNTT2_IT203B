import java.sql.*;

public class DBConnection {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "123456$";

    public static Connection openConnection(){
        //b1 khai bao Driver
        try {
            Class.forName(DRIVER);
            // mo ket noi
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Chua cai dat mysql driver");
        } catch (SQLException e) {
            System.err.println("Loi sql: ket noi that bai");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        try (
                // B1: Mo ket noi
                Connection conn = openConnection();
                // B2: Tao cau lenh Statement
                Statement stmt = conn.createStatement();
        ) {
            // Tao bang:
            String createDatabaseSql = """
                    CREATE DATABASE IF NOT EXISTS student
                    """;

            String useDatabaseSql = """
                    USE student
                    """;

            String createTableSql = """
                    CREATE TABLE IF NOT EXISTS Student(
                        id int auto_increment primary key,
                        name varchar(255) not null,
                        gpa decimal(10, 2) check(gpa > 0)
                    )
                    """;

            String selectSql = """
                    SELECT name, gpa, id FROM Student
                    """;

            // B3: Truyen tham so neu co

            // B4: Thuc thi cau lenh
            stmt.executeUpdate(createDatabaseSql);
            stmt.execute(useDatabaseSql);
            stmt.executeUpdate(createTableSql);

            boolean isResultSet = stmt.execute(selectSql); // true: co ban ghi tra ve(ResultSet - SELECT) - false: ko co

            // B5: Xu ly ket qua tra ve neu co
            if (isResultSet) {
                ResultSet rs = stmt.getResultSet();
                System.out.println("Kết nối thành công: Tô Anh Tuấn");
                while (rs.next()) {
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("GPA: " + rs.getString("gpa"));
                    System.out.println("ID: " + rs.getString("id"));
                    System.out.println("---------------------------------------");
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        // B6: Dong ket noi
    }
}