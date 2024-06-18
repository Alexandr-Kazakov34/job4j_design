package ru.job4j.io;

import java.io.*;
import java.util.*;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String pathCSV = argsName.get("path");
        if (!pathCSV.endsWith(".csv")) {
            throw new IllegalArgumentException("the path parameter must have the extension .csv");
        }
        String delimiter = argsName.get("delimiter");
        if (!delimiter.equals(";") && !delimiter.equals(",")) {
            throw new IllegalArgumentException("as delimiter use \";\" or \",\"");
        }
        List<String> filters = Arrays.asList(argsName.get("filter").split(","));
        String out = argsName.get("out");
        if (out.equals("stdout")) {
            write(System.out, filters, pathCSV, delimiter);
        } else {
            try (PrintStream ps = new PrintStream(new File(out))) {
                write(ps, filters, pathCSV, delimiter);
            }
        }
    }

    private static void write(PrintStream ps, List<String> filters, String path, String delimiter)
            throws FileNotFoundException {
        boolean firstLine = true;
        List<Integer> indexes = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String[] columns = scanner.nextLine().split(delimiter);
                List<String> selectedColumns = new ArrayList<>();
                if (firstLine) {
                    for (String filter : filters) {
                        for (int i = 0; i < columns.length; i++) {
                            String columnWithoutSpace = columns[i].trim();
                            if (filter.equals(columnWithoutSpace)) {
                                indexes.add(i);
                                selectedColumns.add(columnWithoutSpace);
                                break;
                            }
                        }
                    }
                    firstLine = false;
                } else {
                    for (int index : indexes) {
                        selectedColumns.add(columns[index].trim());
                    }
                }
                ps.println(String.join(delimiter, selectedColumns));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}