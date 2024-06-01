package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        List<String> lineEntries = new ArrayList<>();
        List<String> timePeriods = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            String readLine;
            while ((readLine = bufferedReader.readLine()) != null) {
                lineEntries.add(readLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String start = null;
        String end;
        for (String line : lineEntries) {
            String[] split = line.split(" ");
            int status = Integer.parseInt(split[0]);
            String time = split[1];
            if ((status == 400 || status == 500) && start == null) {
                start = time;
            } else if ((status == 200 || status == 300) && start != null) {
                end = time;
                timePeriods.add(start + ";" + end + ";");
                start = null;
            }
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(target))) {
            for (String strings : timePeriods) {
                bufferedWriter.write(strings);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}