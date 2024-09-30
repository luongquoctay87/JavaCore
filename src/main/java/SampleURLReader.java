package src.main.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class SampleURLReader {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8082/user/list");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
