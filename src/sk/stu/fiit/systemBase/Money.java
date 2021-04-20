package sk.stu.fiit.systemBase;

// Implementing Singleton class with getInstance() method
public class Money {

    // static variable single_instance of type Singleton
    private static Money single_instance = null;

    // variable of type String
    public double quantity;

    // private constructor restricted to this class itself
    private Money() {
        quantity = 109000; // USD
    }

    // static method to create instance of Singleton class
    public static Money getInstance() {
        if (single_instance == null)
            single_instance = new Money();

        return single_instance;
    }

    public double getMoney() {
        return quantity;
    }
    public void setMoney(double quantity) {
        this.quantity = quantity;
    }



    // old version of this Class
/*public class Money {

    private double quantity = 69000; // USD

    public double getMoney() {
        return quantity;
    }
    public void setMoney(double quantity) {
        this.quantity = quantity;
    }
}*/

}