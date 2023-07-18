package com.javarush.task.sql.task07.task0705;

import java.sql.*;

/* 
task0705
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                "root", "root");

        Statement statement = connection.createStatement();


        while (statement.executeQuery("select min(age) from employee").next()) {
            int num = statement.executeQuery("select min(age) from employee")
                    .getInt("age");

            System.out.println(num);
        }

        connection.close();
        statement.close();

    }
}
