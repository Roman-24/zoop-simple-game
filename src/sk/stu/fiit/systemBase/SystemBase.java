package sk.stu.fiit.systemBase;

import sk.stu.fiit.storage.Chemicals;
import sk.stu.fiit.storage.Cocaine;
import sk.stu.fiit.storage.PlantsOfCoca;
import sk.stu.fiit.users.Lorenzo;
import sk.stu.fiit.users.Mateo;
import sk.stu.fiit.users.Others;
import sk.stu.fiit.users.Pablo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SystemBase implements Sys {

    // final variable
    final static int password = 1234;

    // display double in 2 decimal places
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    // defining initial states
    Money money;
    private int policeRespect = 10;

    // defining storage items
    Chemicals chemicals;
    PlantsOfCoca plants;
    Cocaine cocaine;

    // defining users
    Pablo boss;
    Lorenzo lorenzo;
    Mateo mateo;
    Others youngLorenzo; // Parent for UPCASTING

    //ArrayList ... UPCASTING
    ArrayList<Others> users;

    public SystemBase() {
        chemicals = new Chemicals();
        plants = new PlantsOfCoca();
        cocaine = new Cocaine();
        boss = new Pablo();
        // money = new Money();
        money = Money.getInstance();
        lorenzo = new Lorenzo(this.chemicals, this.plants, this.cocaine, this.money);
        mateo = new Mateo(this.cocaine, this.money);
        users = new ArrayList<>();

        // UPCASTING ... Parent caster = new child Lorenzo
        youngLorenzo = new Lorenzo();
    }

    void makeUserList(){ //ArrayList ... UPCASTING
        users.add(boss);
        users.add(lorenzo);
        users.add(mateo);
        users.add(youngLorenzo);
        System.out.println("Users:");
        System.out.println(users);
        System.out.println("....");
    }

    // starting system and user verification
    @Override // from sys.java
    final public void start() {
        System.out.println("Hellow!");
        System.out.print("User name: ");

        // scan user name
        Scanner scWho = new Scanner(System.in);
        String userName = scWho.nextLine(); // read user name like input

        if (verifyUser(userName)) { // if good user name

            System.out.print("Password: ");
            Scanner scPwd = new Scanner(System.in);
            int pwd = scPwd.nextInt(); // read user pwd

            if(verifyUser(pwd)){
                System.out.println("Dear " + userName + " welcome to Narcos!"); // Say hi to user
                this.makeUserList();
            } else{
                System.out.println("Wrong name or password");
                turnOffSystem();
            }

        } else {
            System.out.println("Wrong name or password");
            turnOffSystem();
        }
    }

    /*
    basic functions for start and shut down system
    */

    // compare user String name
    @Override
    final public boolean verifyUser(String name) {
        return name.equals("Pablo");
    }

    // compare user int pwd
    @Override
    final public boolean verifyUser(int pwd) {
        return pwd == password;
    }

    // shut down system
    @Override // from sys.java
    final public void turnOffSystem() { // packed private
        System.out.println("The system is shutting down...");
        System.exit(0);
    }

    /*
    other functionality
    */

    // print money status
    protected void howRichWeAre() {
        System.out.println("You have " + df2.format(money.getMoney()) + " $");
    }

    // printf how much police respect us
    protected void whatPolice() {
        System.out.println("You have " + df2.format(policeRespect) + " police respect");
    }

    // Mateo working
    protected void mateoWork(){
        mateo.work();
    }

    // *************  work in progress
    protected boolean operationSuccess(int score){
        int min = 0;
        int max = 2000;
        int random = getRandomNumberInRange(min, max);

        return random > score;
    }

    private int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public int getPoliceRespect() {
        return policeRespect;
    }
    public void setPoliceRespect(int policeRespect) {
        this.policeRespect = policeRespect;
    }

}