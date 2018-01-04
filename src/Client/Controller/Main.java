package Client.Controller;

import Client.Model.ClientGetSchool;

import java.io.Serializable;
import java.util.ArrayList;

public class Main implements Serializable {


    public static void main(String[] args) throws InterruptedException {
        Client.Model.School diceSchool= ClientGetSchool.loadSchool();
       ClientGUI client = new ClientGUI();
       client.main(args, diceSchool);



    }
}
