package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("data/even.txt")) {
            StringBuilder stringBuilder = new StringBuilder();
            int read;
            while ((read = fileInputStream.read()) != -1) {
                stringBuilder.append((char) read);
            }
            String[] split = stringBuilder.toString().split(System.lineSeparator());
            for (String readLine : split) {
                if (Integer.parseInt(readLine) % 2 == 0) {
                    System.out.println(readLine + " - even number");
                } else {
                    System.out.println(readLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
