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
    static School school;

    public ClientGetSchool(ObjectOutputStream out, ObjectInputStream in) {
        this.out = out;
        this.in = in;
        this.admin=false;
        this.teacher=false;
        this.student=false;
    }

    //Testing login in to server and if succeed it will check what accsess you have and make return the object for you
    public static School loadSchool() {
        Client.Model.School newschool=null;
        boolean answer = false;
        String accses;
        try {
            Socket clientSocket = new Socket("127.0.0.1", 5555);

            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());

            out.writeUTF("start");
            newschool = (Client.Model.School) ois.readObject();
            school=newschool;



            System.out.println(newschool.getName());



        }

        catch (IOException e) {e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return newschool;
    }

    public static School exitSchool() {
        Client.Model.School newschool=null;
        boolean answer = false;
        String accses;
        try {
            Socket clientSocket = new Socket("127.0.0.1", 5555);

            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());

            out.writeUTF("exit");

            oos.writeObject(school);





        }

        catch (IOException e) {e.printStackTrace();
        }
        return newschool;
    }




}

