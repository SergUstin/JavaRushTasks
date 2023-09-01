package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {

    public static void main(String[] args) throws Exception {
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                System.out.println("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                System.out.println("Произошла ошибка. Проверьте введенные данные.");
            }
        } while (operation != Operation.EXIT);

    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("");
        ConsoleHelper.writeMessage("Выберете опирацию: ");
        ConsoleHelper.writeMessage(String.format("\t %d - упаковать файл в архив", Operation.CREATE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - добавить файл в архив", Operation.ADD.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - удалить файл из архива", Operation.REMOVE.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - распоковать архив", Operation.EXTRACT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - просмтреть содержимие архива", Operation.CONTENT.ordinal()));
        ConsoleHelper.writeMessage(String.format("\t %d - выход", Operation.EXIT.ordinal()));

        return Operation.values()[ConsoleHelper.readInt()];
    }
}
