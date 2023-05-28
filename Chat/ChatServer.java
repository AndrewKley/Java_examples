import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ChatServer {
    private ArrayList<Object> _clientOutputStreams;
    private int _port = 1111;

    public static void main(String[] args) {
        new ChatServer().start();
    }

    public void tellEveryone(String message) {
        Iterator<Object> iterator = _clientOutputStreams.iterator();
        while (iterator.hasNext()) {
            try {
                PrintWriter writer = (PrintWriter)iterator.next();
                writer.println(message);
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        _clientOutputStreams = new ArrayList<Object>();
        try {
            ServerSocket serverSocket = new ServerSocket(_port);

            while(true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                _clientOutputStreams.add(writer);

                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
                System.out.println("got a connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class ClientHandler implements Runnable {
        private BufferedReader _reader;
        private Socket _socket;

        public ClientHandler(Socket clientSocket) {
            try {
                _socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(_socket.getInputStream());
                _reader = new BufferedReader(isReader);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String message;
            try {
                while ((message = _reader.readLine()) != null) {
                    System.out.println("read " + message);
                    tellEveryone(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}