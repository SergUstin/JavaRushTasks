package com.javarush.task.sql.task07.task0707;

import java.sql.*;

/* 
Метод wasNull
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select name, weight from employee")) {

            while (resultSet.next()) {
                String nameValue = resultSet.getString("name");
                Float weightValue = resultSet.getFloat("weight");
                if (resultSet.wasNull()) {
                    weightValue = null;
                }
                System.out.println(nameValue + " " + weightValue);
            }

        }


    }
}
