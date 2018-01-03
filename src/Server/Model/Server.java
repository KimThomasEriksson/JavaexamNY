package Server.Model;
import Client.Model.Admin;
import Client.Model.School;
import Client.Model.Student;
import Client.Model.Teacher;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

import static Server.Controller.Main.functoLoadSchool;
import static Server.Controller.Main.functoSaveSchool;

public class Server implements Runnable {
    Socket clientSocket;
    String email;
    String password;
    Boolean boolteacher;
    Boolean boolstudent;
    Boolean booladmin;
    Boolean loggedIn;
    public static School school;
    Student student;
    Teacher teacher;
    Admin admin;

    public Server(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.loggedIn=false;
        this.boolteacher=false;
        this.boolstudent=false;
        this.booladmin=false;
        this.student=null;
        this.teacher=null;
        this.admin=null;

    }

    public static void setSchool(School school) {
        Server.school = school;
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
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            ObjectOutputStream oos= new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream ois= new ObjectInputStream(clientSocket.getInputStream());
            //DataInputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
            boolean mustBeDead = false;
            String msg=in.readUTF();
            System.out.println(msg);
            if(msg.equals("start")){
                System.out.println("sending school");
                oos.writeObject(school);

            }
            if(msg.equals("exit")){
                School newschool= (School) ois.readObject();
                functoSaveSchool(newschool);
                functoLoadSchool(newschool.getName());
            }

            System.out.println("We jumped passsed it");


                /*
                String recived=in.readUTF();
                String[] parts = recived.split(",");
                this.password = parts[0];
                this.email = parts[1];


                boolean tryloggin=tryToLogin();
                if(tryloggin){
                    out.writeBoolean(true);
                    if(this.boolstudent==true){
                        out.writeUTF("student");
                    }
                    if(this.boolteacher==true){
                        out.writeUTF("teacher");
                    }
                    if(this.booladmin==true){
                        out.writeUTF("admin");
                    }

                    break;

                }

                out.writeBoolean(false);
                mustBeDead = true;
                break;

            }




            if(mustBeDead==false) {
                while (true) {
                   String lastmessage=in.readUTF();

                    if(lastmessage=="allInfo") {

                        if (this.boolstudent == true) {
                            out.writeUTF(getAllStudentInfo());
                            oos.writeObject(this.student);



                        }

                        if(this.boolteacher==true){
                            oos.writeObject(getObjectTeacher());
                            //Teacherinfo här
                        }

                        if(this.booladmin==true){
                            oos.writeObject(school);

                        }




                    }

                }
            }
            clientSocket.close();
*/

    } catch (SocketTimeoutException s) {
        System.out.println("Socket timed out!");
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Object getObjectTeacher(){
        return this.teacher;
    }

    public boolean tryToLogin(){

        ArrayList<Student> studentlist= school.getStudents();
        for (int i = 0; i < studentlist.size(); i++) {
            if(studentlist.get(i).getEmail().equals(this.email)){
                if(studentlist.get(i).getPassword().equals(this.password)){
                    this.student=studentlist.get(i);
                    this.boolstudent=true;
                    this.loggedIn=true;
                    return true;
                }else return false;
            }
        }

        ArrayList<Teacher> teacherlist=school.getTeachers();
        for (int i = 0; i < teacherlist.size(); i++) {
            if (teacherlist.get(i).getEmail().equals(this.email)){
                if(teacherlist.get(i).getPassword().equals(this.password)){
                    this.teacher=teacherlist.get(i);
                    this.boolstudent=true;
                    this.loggedIn=true;
                    return true;
                }else return false;
            }
        }

        ArrayList<Admin> adminlist=school.getAdmins();
        for (int i = 0; i < adminlist.size(); i++) {
            if (adminlist.get(i).getEmail().equals(this.email)){
                if(adminlist.get(i).getPassword().equals(this.password)){
                    this.admin=adminlist.get(i);
                    this.booladmin=true;
                    this.loggedIn=true;
                    return true;
                }else return false;
            }
        }


        return false;
    }

    public String getAllStudentInfo(){

        String stringToSend="";
        String firstName,lastName,email;
        int id,totalPoints;
        firstName=this.student.getFirstName();
        lastName=this.student.getLastName();
        email=this.student.getEmail();
        totalPoints=this.student.getTotalPoints();
        id=this.student.getStudentId();


        stringToSend=firstName+","+lastName+","+email+","+totalPoints+","+id;
        System.out.println(stringToSend);
        return stringToSend;

    }

    public String getCurrentStudentCources(){
        //NamnKurs,Äämne,Poäng,LärarensNamn

        String stringToReturn="";




        return stringToReturn;
    }
    }

