package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, Path> filePropertyPathMap = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        FileProperty fileProperty = new FileProperty(attributes.size(), file.getFileName().toString());
        if (!filePropertyPathMap.containsKey(fileProperty)) {
            filePropertyPathMap.put(fileProperty, file);
        }
        return super.visitFile(file, attributes);
    }

    public void printFilePropertyPathMap() {
        for (Map.Entry<FileProperty, Path> entry : filePropertyPathMap.entrySet()) {
                for (Path file : entry.getValue()) {
                    System.out.println(file);
            }
        }
    }
}