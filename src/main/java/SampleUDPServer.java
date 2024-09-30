package src.main.java;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SampleUDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(7749);
        byte[] receiveData = new byte[1024];
        System.out.println("Server UDP đang chờ nhận dữ liệu...");

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        socket.receive(receivePacket);
        String message = new String(receivePacket.getData());
        System.out.println("Nhận từ client: " + message.trim());

    }
}
