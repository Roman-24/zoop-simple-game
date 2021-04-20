package sk.stu.fiit.systemBase;

import java.util.Scanner;

class SystemInput { // packed private

    SystemBase systemBase;

    protected SystemInput(SystemBase systemBase){
        this.systemBase = systemBase;
    }

    Scanner scInput = new Scanner(System.in);
    String input;

    /* scan inputs in loop but "end" is for stop*/
    protected void inputLoop(){

        while (true) {
            System.out.println("Now you can write your command");
            input = scInput.nextLine(); // read input commands
            System.out.println("input was: " + input);

            switch (input) {

                case "end":
                    systemBase.turnOffSystem();
                    break;
                case "money status":
                    systemBase.howRichWeAre();
                    break;
                case "police":
                    systemBase.whatPolice();
                    break;
                case "chem-status":
                    systemBase.chemicals.Status();
                    break;
                case "plants-status":
                    systemBase.plants.Status();
                    break;
                case "cocaine-status":
                    systemBase.cocaine.Status();

                case "lorenzo buy chem":
                    systemBase.lorenzo.buyChemicals();
                    break;

                case "lorenzo buy plants":
                    systemBase.lorenzo.buyPlants();
                    break;

                case "lorenzo make cocaine":
                    systemBase.lorenzo.makeDrugs();
                    break;

                case "mateo sell cocaine":
                    systemBase.mateo.sellCocaine();
                    break;

                case "mateo work":
                    systemBase.mateoWork();
                    break;

                default:
                    System.out.println("Incorrect input");

            }
        }
    }

}
