package homeWork6;


import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClientConsole {

    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8189;


    private static Socket socket;
    private static DataInputStream in;
    private static DataOutputStream out;

    private static Scanner localIn;
    private static String msgForServer;

    public EchoClientConsole() {

        new Thread(EchoClientConsole::getSendMsgFromConsole).start();

        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EchoClientConsole();
            }
        });
    }

    private static void openConnection() throws IOException {

        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) {
                            closeConnection();
                            break;
                        }

                        System.out.println("Server: " + strFromServer);


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }


    private static void closeConnection() {
        try {
            out.writeUTF("/end");
        } catch (IOException e) {
            e.printStackTrace();
        }
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


    static void getSendMsgFromConsole() {

        localIn = new Scanner(System.in);

        while (true) {
            msgForServer = localIn.nextLine();

            try {
                if (!msgForServer.trim().isEmpty()) {
                    out.writeUTF(msgForServer);
                    msgForServer = "";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
