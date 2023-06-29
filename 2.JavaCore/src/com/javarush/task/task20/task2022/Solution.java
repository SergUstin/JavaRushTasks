package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("fileName2.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        Solution solution = new Solution("yourFileName1.txt");
        solution.writeObject("some_text");

        outputStream.writeObject(solution);
        outputStream.flush();

        FileInputStream fileInput = new FileInputStream("fileName2.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInput);

        Solution loadSol = (Solution) inputStream.readObject();
        loadSol.writeObject("some_text2");
    }
}
