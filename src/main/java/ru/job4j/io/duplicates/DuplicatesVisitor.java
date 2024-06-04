package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, Path> filePropertyPathMap = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        FileProperty fileProperty = new FileProperty(Files.size(file), file.getFileName().toString());
        if (filePropertyPathMap.containsKey(fileProperty)) {
            System.out.println(file.toAbsolutePath() + " and " + filePropertyPathMap.get(fileProperty).toAbsolutePath());
        } else {
            filePropertyPathMap.put(fileProperty, file);
        }
        return super.visitFile(file, attributes);
    }
}