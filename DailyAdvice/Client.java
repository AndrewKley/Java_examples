import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        Client Client = new Client();
        Client.go();
    }

    public void go() {
        String address = "127.0.0.1";
        int port = 5050;

        try {
            Socket socket = new Socket(address, port);
            InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputReader, port);

            String advice = reader.readLine();
            System.out.println(advice);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}