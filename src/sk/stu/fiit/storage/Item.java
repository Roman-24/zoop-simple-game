package sk.stu.fiit.storage;

import java.text.DecimalFormat;

abstract class Item { // packed private

    protected double quantity;
    protected String name;

    private static DecimalFormat df2 = new DecimalFormat("#.##");

    public void Status() { /* for print quantity */
        System.out.println("You have " + df2.format(quantity) + " " + this.name + " on storage");
    }

    // get and set quantity methods
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

}
