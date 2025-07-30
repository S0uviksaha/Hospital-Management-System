package Classes;

import java.sql.*;

public class ConnectSql {
    Connection connection;
    Statement statement;

    public ConnectSql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hospital_management_system", 
                "root", "Souvik#736@01"
            );
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}