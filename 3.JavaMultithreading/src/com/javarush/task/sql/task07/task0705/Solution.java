package com.javarush.task.sql.task07.task0705;

import java.sql.*;

/* 
task0705
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select min(distinct age) from employee")) {

            while (resultSet.next()) {
                int num = resultSet.getInt(1);
                System.out.println(num);
            }
        }
    }
}
