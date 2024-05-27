package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class MultiplicationTable {
    public static void main(String[] args) {
        try (FileOutputStream outputStream = new FileOutputStream("data/multiplicationtable.txt")) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    outputStream.write((i + " * " + j + " = " + (i * j)).getBytes());
                    outputStream.write(System.lineSeparator().getBytes());
                }
                outputStream.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
