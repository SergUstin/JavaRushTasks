package com.javarush.task.sql.task07.task0708;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Date;

/* 
Получение даты
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                "root", "root");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select name, created from employee");

        while (resultSet.next()) {
            String name = resultSet.getNString("name");
            LocalDateTime date = resultSet.getObject("created", LocalDateTime.class);
            System.out.println(name + " " + date);
        }

        resultSet.close();
        statement.close();
        connection.close();


    }
}
