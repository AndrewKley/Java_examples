import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ChatClient{
    private JTextField _outgoing;
    private JTextArea _incoming;
    private BufferedReader _reader;
    private PrintWriter _writer;
    private Socket _socket;
    private String _address = "127.0.0.1";
    private int _port = 1111;

    public static void main(String[] args) {
        new ChatClient().start();
    }

    public void start() {
        JFrame frame = new JFrame("ChatClient client");
        JPanel mainPanel = new JPanel();
        _incoming = new JTextArea(15, 50);
        _incoming.setLineWrap(true);
        _incoming.setWrapStyleWord(true);
        _incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(_incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        _outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(_incoming);
        mainPanel.add(_outgoing);
        mainPanel.add(sendButton);
        setUpNetwork();

        Thread readThread = new Thread(new IncomingReader());
        readThread.start();

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void setUpNetwork() {
        try {
            _socket = new Socket(_address, _port);
            InputStreamReader streamSeader = new InputStreamReader(_socket.getInputStream());
            _reader = new BufferedReader(streamSeader);
            _writer = new PrintWriter(_socket.getOutputStream());
            System.out.println("networking established");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            try {
                _writer.println(_outgoing.getText());
                _writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
            _outgoing.setText("");
            _outgoing.requestFocus();
        }
    }

    public class IncomingReader implements Runnable {
        public void run() {
            String message;
            try {
                while ((message = _reader.readLine()) != null) {
                    System.out.println("read " + message);
                    _incoming.append(message + '\n');
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}