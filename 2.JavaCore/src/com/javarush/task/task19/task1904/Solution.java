package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        String file = "C:\\MyProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1904\\test";
        PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(new File(file)));
        Person person = adapter.read();
        System.out.println(person);


    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;


        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String string = fileScanner.nextLine();
//            String[] strings = string.split(" ");
//            int day = Integer.parseInt(strings[3]);
//            int month = Integer.parseInt(strings[4]);
//            int year = Integer.parseInt(strings[5]);
//            Calendar calendar = new GregorianCalendar(year, month - 1, day);
//            Date date = calendar.getTime();
//            return new Person(strings[1], strings[2], strings[0], date);

            try {
                String[] strings = string.replaceAll("\\d", "").trim().split(" ");
                SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
                Date date = format.parse(string.replaceAll("\\D", ""));
                return new Person(strings[1], strings[2], strings[0], date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
