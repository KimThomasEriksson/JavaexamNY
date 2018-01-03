package Client.Model;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server implements Runnable {
    Socket clientSocket;
    String email;
    String password;
    Boolean teacher;
    Boolean student;
    Boolean admin;
    Boolean loggedIn;
    School school;

    Server(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.loggedIn=false;
        this.teacher=false;
        this.student=false;
        this.admin=false;
    }


    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5555);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while(true) {
                System.out.println("waiting for conn");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected");
                new Thread(new Server(clientSocket)).start();
            }

        } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        boolean value=true;
        try{
            DataInputStream in =new DataInputStream(clientSocket.getInputStream());
            //DataInputStreamReader in = new InputStreamReader(clientSocket.getInputStream());

            while(value) {
                //String rec=in.
                String recived=in.readUTF();
                String[] parts = recived.split(",");
                this.password = parts[0];
                this.email = parts[1];




            }
            clientSocket.close();

    } catch (SocketTimeoutException s) {
        System.out.println("Socket timed out!");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    }

