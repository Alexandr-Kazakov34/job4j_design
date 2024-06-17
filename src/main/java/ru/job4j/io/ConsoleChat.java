package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        boolean isRunning = true;
        boolean isMute = true;
        ArrayList<String> log = new ArrayList<>();
        Random random = new Random();
        try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
            while (isRunning) {
                String userInput = input.readLine();
                log.add(userInput);
                if (userInput.equalsIgnoreCase(OUT)) {
                    isRunning = false;
                }
                if (userInput.equalsIgnoreCase(STOP)) {
                    isMute = false;
                }
                if (userInput.equalsIgnoreCase(CONTINUE)) {
                    isMute = true;
                }
                if (isMute) {
                    int intRandom2 = random.nextInt(readPhrases().size());
                    System.out.println(readPhrases().get(intRandom2));
                }
                saveLog(log);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> readPhrases() {
        ArrayList<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            String read;
            while ((read = reader.readLine()) != null) {
                phrases.add(read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(path, true))) {
            for (String phrase : log) {
                writer.write(phrase.getBytes());
                writer.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("data/dialog.txt", "data/botAnswers.txt");
        consoleChat.run();
    }
}