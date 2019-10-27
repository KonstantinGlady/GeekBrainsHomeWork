package homeWork6;

import javax.swing.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServerConsole {

    private static Scanner scanner;
    private static String msgFromConsole;

    private static DataInputStream in;
    private static DataOutputStream out;

    private static Socket socket;

    public EchoServerConsole() {

        new Thread(EchoServerConsole::getSendMsg).start();
        try {
            openConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void getSendMsg() {
        scanner = new Scanner(System.in);
        while (true) {
            msgFromConsole = scanner.nextLine();
            if (!msgFromConsole.trim().isEmpty()) {
                try {
                    out.writeUTF(msgFromConsole);
                    msgFromConsole = "";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EchoServerConsole();
            }
        });
    }

    public void openConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                socket = null;

                try (ServerSocket serverSocket = new ServerSocket(8189)) {
                    System.out.println("Server is waiting.");

                    socket = serverSocket.accept();
                    System.out.println("Client get access.");


                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());

                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            closeConnection();
                            break;
                        }
                        System.out.println("Client: " + str);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    private static void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

