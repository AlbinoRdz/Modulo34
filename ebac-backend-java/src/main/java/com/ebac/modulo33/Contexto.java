package com.ebac.modulo33;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Contexto {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/modulo33";
        String user = "root";
        String password = "root";

        MysqlConnection mysqlConnection = new MysqlConnection();
        Connection connection = mysqlConnection.getConnection(url, user, password);

        // Select
        String sql = "select * from usuarios";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("id de usuario: " + resultSet.getInt("idUsuario"));
            System.out.println("nombre de usuario: " + resultSet.getString("nombre"));
            System.out.println("edad del usuario: " + resultSet.getInt("edad"));
            System.out.println("-------------------------------------------------------------");
        }
    }
}
