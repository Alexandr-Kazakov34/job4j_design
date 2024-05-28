package ru.job4j.io;

import java.io.*;


public class ReadFile {
    public static void main(String[] args) {
        try (BufferedReader input = new BufferedReader(new FileReader("data/input.txt"))) {
            String line = input.readLine();
            while (line != null) {
                System.out.println(line);
                line = input.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}