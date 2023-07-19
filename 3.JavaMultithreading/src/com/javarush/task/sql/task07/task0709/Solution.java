package com.javarush.task.sql.task07.task0709;

import java.sql.*;
import java.util.Date;

/* 
Метод getObject
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select name, weight, birthday, inn from employee")) {

            while (resultSet.next()) {
                String name = resultSet.getObject("name", String.class);
                Float weight = resultSet.getObject("weight", Float.class);
                Date date = resultSet.getObject("birthday", Date.class);
                Long inn = resultSet.getObject("inn", Long.class);

                System.out.println(name + " " + weight + " " + date + " " + inn);
            }
        }
    }
}
