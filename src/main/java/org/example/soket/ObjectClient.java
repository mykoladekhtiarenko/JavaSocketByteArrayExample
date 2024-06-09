package org.example.soket;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ObjectClient {
    public static void main(String[] args) throws IOException {
        InetAddress addr = InetAddress.getByName(null);
        System.out.println("адреса =" + addr);
        Socket socket = new Socket(addr, ObjectServer.PORT);
        try {
            Message message = new Message(1, 1, "Hello World");
            DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
            oos.write(message.toBytes());
            oos.flush();
            oos.close();
        } finally {
            System.out.println("закриваємо клієнт");
            socket.close();
        }
    }
}

