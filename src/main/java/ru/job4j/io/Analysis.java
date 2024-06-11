package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
             PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(target)))) {
            String readLine;
            boolean flag = true;
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] split = readLine.split(" ");
                int status = Integer.parseInt(split[0]);
                String time = split[1];
                if ((status == 400 || status == 500) && flag) {
                    flag = false;
                    printWriter.print(String.format("%s;", time));
                } else if ((status == 200 || status == 300) && !flag) {
                    flag = true;
                    printWriter.print(String.format("%s;%s", time, System.lineSeparator()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}