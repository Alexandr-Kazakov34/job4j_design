package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AbuseTest {
    @Test
    void drop(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter printWriter = new PrintWriter(source)) {
            printWriter.println("hello foolish dude");
            printWriter.println("java job4j php");
        }
        File target = tempDir.resolve("target.txt").toFile();
        Abuse.drop(source.getAbsolutePath(), target.getAbsolutePath(), List.of("foolish", "php"));

        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(target))) {
            bufferedReader.lines().forEach(result::append);
        }
        assertThat("hello dude java job4j ").hasToString(result.toString());
    }
}