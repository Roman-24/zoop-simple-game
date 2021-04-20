package sk.stu.fiit.users;

import sk.stu.fiit.storage.Cocaine;
import sk.stu.fiit.systemBase.Money;

import java.util.Date;

public class Mateo extends Others { // packed private

    Cocaine cocaine;
    Money money;

    public Mateo(Cocaine cocaine, Money money){

        this.firstDay = new Date(2016, 3, 4);
        this.haveKids = true;
        this.score = 1935;

        // objets from constructor parameters
        this.cocaine = cocaine;
        this.money = money;
    }

    public Mateo() {

    }

    static public boolean hideCocaine(){
        System.out.println("All Cocaine is safe");
        return true;
    }

    static public boolean hideMoney(){
        System.out.println("Your many are safe");
        return true;
    }

    static public boolean transport(){
        return true;
    }

    public void sellCocaine(){

        final double sellCocaine = 10; // kg
        final double newMoney = 10000; // USD

        if(cocaine.getQuantity()>sellCocaine){
            cocaine.setQuantity(cocaine.getQuantity()-sellCocaine);
            money.setMoney(money.getMoney()+newMoney);
            System.out.println("You make " + newMoney + " USD");
        } else{
            System.out.println("You don't have enough cocaine");
        }
    }

    @Override
    public void work() {
        transport();
        hideCocaine();
        hideMoney();
    }
}