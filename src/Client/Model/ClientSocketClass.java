package Client.Model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientSocketClass {
    Boolean admin;
    Boolean teacher;
    Boolean student;
    DataOutputStream out;
    DataInputStream in;

    public ClientSocketClass(DataOutputStream out, DataInputStream in) {
        this.out = out;
        this.in = in;
        this.admin=false;
        this.teacher=false;
        this.student=false;
    }

//Testing loggin in to server and if suceed it will check what accses you have and make return the objekt for you
    public static ClientSocketClass clientLogin(String password, String email) {
        boolean answer=false;
        ClientSocketClass objectToReturn =null;
        String accses;
        try {
            Socket clientSocket = new Socket("127.0.0.1", 5555);

            OutputStream outToServer = clientSocket.getOutputStream();

            DataOutputStream out = new DataOutputStream(outToServer);
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            out.writeUTF(email+","+password);
            answer=in.readBoolean();
            if(answer==false){
                out.close();
                in.close();
                throw new ArithmeticException("Password or Email is wrong");
                }
            else{
                ClientSocketClass login =new ClientSocketClass(out,in);
                //need to get the accses of the account
                out.writeUTF("access");

                accses=in.readUTF();
                if(accses.equals("admin")) {
                    login.admin = true;
                }
                if(accses.equals("teacher")){
                    login.teacher=true;

                }
                if(accses.equals("student")){
                    login.student=true;
                }

                objectToReturn=login;
            }

        }
        catch (IOException e) {e.printStackTrace();
        }
        return objectToReturn;
    }


}

