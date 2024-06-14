package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zip.putNextEntry(new ZipEntry(path.toAbsolutePath().toString()));
                try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(path.toFile()))) {
                    zip.write(output.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean check(String[] args) {
        ArgsName keyValue = ArgsName.of(args);
        if (keyValue.get("d").isBlank() || keyValue.get("e").isBlank() || keyValue.get("o").isBlank()) {
            throw new IllegalArgumentException("Missing some arguments");
        }
        if (!Files.isDirectory(Paths.get(keyValue.get("d")))) {
            throw new IllegalArgumentException("Do not correct path");
        }
        if (!keyValue.get("e").startsWith(".")) {
            throw new IllegalArgumentException("Do not correct format extensions");
        }
        if (!keyValue.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("Do not correct extensions");
        }
        return true;
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (check(args)) {
            String sourceDirectory = ArgsName.of(args).get("d");
            String targetZipFile = ArgsName.of(args).get("o");
            Path sourcePath = Paths.get(sourceDirectory);
            List<Path> searchFiles = Search.search(sourcePath, path -> true);
            Zip zip = new Zip();
            zip.packFiles(searchFiles, new File(targetZipFile));
            zip.packSingleFile(
                    new File("./pom.xml"),
                    new File("./pom.zip")
            );
        }
    }
}