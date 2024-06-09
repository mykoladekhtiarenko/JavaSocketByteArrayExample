package org.example.soket;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectServer {
    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Ми запустили сервер " + s);

        try {
            Socket socket = s.accept();
            try {
                System.out.println("Встановили з'єднання: " + socket);
                InputStream inputStream = socket.getInputStream();
                byte[] message = IOUtils.toByteArray(inputStream);
                System.out.println(Message.fromBytes(message));
                inputStream.close();
            } finally {
                System.out.println("Сервер закрив сокет ...");
                socket.close();
            }
        } finally {
            s.close();
        }
    }
}
