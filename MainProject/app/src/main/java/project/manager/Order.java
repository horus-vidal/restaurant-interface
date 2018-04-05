package project.manager;

import java.util.ArrayList;

/*
    Contains an ID, and a list of Menu Item objects. Each customer would get one of these.
 */
public class Order {
    private int orderId; //"Order 210"
    //private int customerId; ???
    private ArrayList<MenuItem> items; //["Burger", "Taco", "Dr. Pepper", "Harlem Shake"]

    //default constructor. dont do this
    Order() {
        this(-1, new ArrayList<MenuItem>());
    }

    //proper constructor. do this
    Order(int orderId, ArrayList<MenuItem> items) {
        setOrderId(orderId);
        setItems(items);
    }

    //addMenuItem() ???

    //setters
    void setOrderId(int orID) {
        orderId = orID;
    }

    void setItems(ArrayList<MenuItem> itms) {
        items = itms;
    }

    //getters
    int getOrderId() {
        return orderId;
    }

    ArrayList<MenuItem> getItems() {
        return items;
    }
}
