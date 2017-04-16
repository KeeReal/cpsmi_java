package task_11_sock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class main_11_server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            String question = "srv: What does the fox say?";
            out.println(question);
            while ((inputLine = in.readLine()) != null) {
                System.out.println("info: received=" + inputLine);
                out.println(inputLine);
                out.println(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
