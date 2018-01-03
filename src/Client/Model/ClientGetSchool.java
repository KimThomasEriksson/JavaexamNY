package Client.Model;
import Client.Model.School;
import java.io.*;
import java.net.Socket;

public class ClientGetSchool implements Serializable {
    Boolean admin;
    Boolean teacher;
    Boolean student;
    ObjectOutputStream out;
    ObjectInputStream in;

    public ClientGetSchool(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
        this.admin=false;
        this.teacher=false;
        this.student=false;
    }

    //Testing loggin in to server and if suceed it will check what accses you have and make return the objekt for you
    public static School connect() {
        Client.Model.School newschool=null;
        boolean answer = false;
        String accses;
        try {
            Socket clientSocket = new Socket("127.0.0.1", 5555);


            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            newschool = (Client.Model.School) in.readObject();

            System.out.println(newschool.getName());



        }

        catch (IOException e) {e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return newschool;
    }


}

