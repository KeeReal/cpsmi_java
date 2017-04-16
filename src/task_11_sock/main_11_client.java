package task_11_sock;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class main_11_client {
    public static void main(String[] args) {
        Socket sock = null;
        try {
            sock = new Socket("127.0.0.1", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataInputStream input = null;
        try {
            input = new DataInputStream(sock.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


        PrintStream output = null;
        try {
            output = (PrintStream) sock.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }



        // close
        try {
            output.close();
            input.close();
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
