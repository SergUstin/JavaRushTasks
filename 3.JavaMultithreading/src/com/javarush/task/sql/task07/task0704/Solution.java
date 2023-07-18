package com.javarush.task.sql.task07.task0704;

import java.sql.*;

/* 
task0704
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                "root", "root");

        Statement statement = connection.createStatement();

        while (statement.executeQuery("select * from employee").next()) {
            String name =
                    statement.executeQuery("select * from employee")
                            .getNString("name");
            System.out.println(name + System.lineSeparator());
        }

        connection.close();
        statement.close();
    }
}
