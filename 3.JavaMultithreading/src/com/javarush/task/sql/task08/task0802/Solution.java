package com.javarush.task.sql.task08.task0802;

import java.sql.*;

/* 
Откат транзакции
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "root");

        connection.setAutoCommit(false);

        try (connection;
             Statement statement = connection.createStatement()) {

            int update = statement.executeUpdate("UPDATE employee set salary = salary + 2000 where name = 'Diego'");
            int update1 = statement.executeUpdate("UPDATE employee set salary = salary + 500 where name = 'Amigo'");

            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
        }
    }
}
