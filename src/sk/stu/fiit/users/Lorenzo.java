package sk.stu.fiit.users;

import sk.stu.fiit.storage.Chemicals;
import sk.stu.fiit.storage.Cocaine;
import sk.stu.fiit.storage.PlantsOfCoca;
import sk.stu.fiit.systemBase.Money;

import java.util.Calendar;
import java.util.Date;

// cocaine maker Lorenzo
public class Lorenzo extends Others { // packed private

    Chemicals chemicals;
    PlantsOfCoca plants;
    Cocaine cocaine;
    Money money;

    public Lorenzo(Chemicals chemicals, PlantsOfCoca plants, Cocaine cocaine, Money money){

        this.firstDay = new Date(2015, Calendar.SEPTEMBER, 24);
        this.haveKids = true;
        this.score = 1548;

        // objets from constructor parameters
        this.chemicals = chemicals;
        this.plants = plants;
        this.cocaine = cocaine;
        this.money = money;
    }

    // empty constructor for young Lorenzo;
    public Lorenzo(){

    }

    public boolean buyPlants(){

        final double costOfPlants = 2400; // USD
        final double newPlants = 54.6; // kg

        if(money.getMoney()>costOfPlants){
            money.setMoney(money.getMoney()-costOfPlants);
            plants.setQuantity(plants.getQuantity()+newPlants);
            return true;
        } else{
            System.out.println("You don't have enough money");
            return false;
        }
    }

    public boolean buyChemicals(){

        final double costOfChemicals = 1300; // USD
        final double newChemicals = 1.0; // kg

        if(money.getMoney()>costOfChemicals){
            money.setMoney(money.getMoney()-costOfChemicals);
            chemicals.setQuantity(chemicals.getQuantity()+newChemicals);
            return true;
        } else{
            System.out.println("You don't have enough money");
            return false;
        }
    }

    public boolean makeDrugs(){

        final double chemicalsNeed = 2.3;
        final double plantsNeed = 50.5;

        if(chemicalsNeed < chemicals.getQuantity()){

            if(plantsNeed < plants.getQuantity()){

                chemicals.setQuantity(chemicals.getQuantity()-chemicalsNeed);
                plants.setQuantity(plants.getQuantity()-plantsNeed);

                final double newCocaine = 9.5;
                cocaine.setQuantity(cocaine.getQuantity()+newCocaine);
                System.out.println("You make " + newCocaine + " kg of cocaine");

                this.score += 12.4;
                return true;
            }
        }

        System.out.println("Something gone wrong, check your storage values");
        this.score -= 2.4;

        return false;
    }

    @Override
    protected void work() {
        System.out.println("I am working hard! :/ ");
    }
}
