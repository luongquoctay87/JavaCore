package src.main.java;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SampleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4953);  // Kết nối đến server ở cổng 1234

        // Gửi dữ liệu đến server
        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        writer.println("Xin chào từ Client!");

        // Nhận phản hồi từ server
        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String response = reader.readLine();
        System.out.println("Phản hồi từ server: " + response);

        socket.close();
    }
}
