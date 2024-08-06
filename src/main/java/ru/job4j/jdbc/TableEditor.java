package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        try (InputStream inputStream = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(inputStream);
        }
        Class.forName(properties.getProperty("driver_class"));
        connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password"));
    }

    public void createTable(String tableName) throws Exception {
        sqlRequest(String.format("CREATE TABLE %s(id SERIAL PRIMARY KEY, name TEXT)", tableName));
    }

    public void dropTable(String tableName) throws Exception {
        sqlRequest(String.format("DROP TABLE %s", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        sqlRequest(String.format("ALTER TABLE %s add %s %s", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        sqlRequest(String.format("ALTER TABLE %s drop column %s", tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        sqlRequest(String.format("ALTER TABLE %s rename column %s to %s", tableName, columnName, newColumnName));
    }

    public void sqlRequest(String sql) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (InputStream inputStream = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(inputStream);
        }
        try (TableEditor tableEditor = new TableEditor(properties)) {
            tableEditor.createTable("test_table");
            System.out.println(tableEditor.getTableScheme("test_table"));
            tableEditor.addColumn("test_table", "address", "text");
            System.out.println(tableEditor.getTableScheme("test_table"));
            tableEditor.renameColumn("test_table", "address", "full_address");
            System.out.println(tableEditor.getTableScheme("test_table"));
            tableEditor.dropColumn("test_table", "full_address");
            System.out.println(tableEditor.getTableScheme("test_table"));
            tableEditor.dropTable("test_table");
            System.out.println(tableEditor.getTableScheme("test_table"));
        }
    }

    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}