package sk.stu.fiit.users;

import java.util.Date;

// Pablo boss of boss
public final class Pablo extends Mateo  {

    public Pablo(){
        super();

        this.firstDay = new Date(2009, 1, 1);
        // this.haveKids // no information
        // this.score // no information
    }

    private void bribeTheCops(){
    }

    @Override
    final public void work(){
        System.out.println("I'm the boss, I don't have to work");
    }

}