package ru.job4j.io;

import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;


public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String requestLine = input.readLine();
                    boolean shouldCloseServer = false;
                    String response = "";

                    if (requestLine != null && !requestLine.isEmpty()) {
                        if (requestLine.contains("msg=Hello")) {
                            response = "Hello, dear friend.";
                        } else if (requestLine.contains("msg=Exit")) {
                            shouldCloseServer = true;
                        } else if (requestLine.contains("msg=")) {
                            int startIndex = requestLine.indexOf("msg=") + 4;
                            int endIndex = requestLine.indexOf(" ", startIndex);
                            response = requestLine.substring(startIndex, endIndex);
                        }
                    }

                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    output.write(response.getBytes());
                    output.flush();

                    for (String line = requestLine; line != null && !line.isEmpty(); line = input.readLine()) {
                        System.out.println(line);
                    }
                    if (shouldCloseServer) {
                        server.close();
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("Exception in log example", e);
        }
    }
}