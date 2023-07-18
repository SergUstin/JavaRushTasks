package com.javarush.task.sql.task07.task0709;

import java.sql.*;
import java.util.Date;

/* 
Метод getObject
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                "root", "root");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select name, weight, birthday, inn from employee");

        while (resultSet.next()) {
            String name = resultSet.getNString("name");
            float weight = resultSet.getFloat("weight");
            Date date = resultSet.getDate("birthday");
            long inn = resultSet.getLong("inn");

            System.out.println(name + " " + weight + " " + date + " " + inn);
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
