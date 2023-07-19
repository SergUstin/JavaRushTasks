package com.javarush.task.sql.task08.task0804;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;

/* 
task0804
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        String sql = "insert into employee (name, age, smth) values (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "root");
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            for (int i = 0; i < 5; i++) {
                preparedStatement.setString(1, "employee_" + i);
                preparedStatement.setInt(2, 30 + i);
                preparedStatement.setString(3, "i = " + i);

                preparedStatement.addBatch();
            }

            int[] ints = preparedStatement.executeBatch();
            System.out.println(Arrays.toString(ints));
        }


    }
}
