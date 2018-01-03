package Server.Controller;

import Client.Model.School;
import Server.Model.Server;


import java.io.*;
import java.util.ArrayList;


public class Main implements Serializable {

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
/*
       School diceSchool = new School("Dice School", "Kungsgatan 15");

        diceSchool.addCource("Math A", "Mathematics", 100, 25);
        diceSchool.addCource("Math B", "Mathematics", 100, 25);
        diceSchool.addCource("Math C", "Mathematics", 100, 25);
        diceSchool.addCource("Spanish A", "Spanish", 100, 25);
        diceSchool.addCource("French","French", 100, 25);
        diceSchool.addCource("Physics A", "Physics", 100, 25);

        diceSchool.addTeacher("Kim", "Svensson", "kim@diceschool.se", "1234", 1994, 26000, "Mathematics");
        diceSchool.addTeacher("Peter", "Brymer", "peter@diceschool.se", "1234", 1994, 26000, "Spanish");
        diceSchool.addTeacher("Dan", "Berg", "dan@diceschool.se", "1234", 1994, 26000, "French");
        ArrayList<String> teacherList = new ArrayList<>();
        teacherList.add("Mathematics");
        teacherList.add("Physics");
        diceSchool.addTeacher("Johanna", "Olsson", "johanna@diceschool.se", "1234", 1994, 26000, teacherList);

        diceSchool.addStudent("Sven", "Larsson", "sven@diceschool.se", "1234", 1994);
        diceSchool.addStudent("Håkan", "Svensson", "hakan@diceschool.se", "1234", 1994);
        diceSchool.addStudent("Loke", "Svalbardsson", "loke@diceschool.se", "1234", 1994);
        diceSchool.addStudent("Björn", "Dankelan", "bjorn@diceschool.se", "1234", 1994);

        diceSchool.addCurriclum(diceSchool.getCourses().get(0), diceSchool.getTeachers().get(0));
        diceSchool.addCurriclum(diceSchool.getCourses().get(1), diceSchool.getTeachers().get(1));
        diceSchool.addCurriclum(diceSchool.getCourses().get(3), diceSchool.getTeachers().get(2));
        diceSchool.addCurriclum(diceSchool.getCourses().get(5), diceSchool.getTeachers().get(3));

        diceSchool.getCurriculum().get(0).addStudent(diceSchool.getStudents().get(0));
        diceSchool.getCurriculum().get(0).addStudent(diceSchool.getStudents().get(1));
        diceSchool.getCurriculum().get(1).addStudent(diceSchool.getStudents().get(2));
        functoSaveSchool(diceSchool);
*/


      School school=functoLoadSchool("Dice School");
      Thread.sleep(2000);
      System.out.println(school.getName());
      Server.main(args);


    }



    public static void functoSaveSchool(School school) {
       String nameOfSchool=school.getName();


        try {
            FileOutputStream fileOut =
                    new FileOutputStream(nameOfSchool+".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(school);
            out.close();
            fileOut.close();
        } catch (IOException i) {

        }
    }

    public static School functoLoadSchool(String schoolToLoad) throws IOException, ClassNotFoundException {

        School newSchool=null;
        FileInputStream fileIn = new FileInputStream(schoolToLoad+".ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        newSchool = (School) in.readObject();
        Server.setSchool(newSchool);
        System.out.println(newSchool.getName());


        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();


        }

/*
        //nu är det dags att ta upp object från hårdisk
        try {
            FileInputStream fileIn = new FileInputStream(schoolToLoad+".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            newSchool = (School) in.readObject();
            Server.setSchool(newSchool);
            System.out.println(newSchool.getName());

            in.close();
            fileIn.close();
            return newSchool;




        } catch (IOException i) {

        } catch (ClassNotFoundException c) {}
        return newSchool;
*/
        return newSchool;
    }








}
