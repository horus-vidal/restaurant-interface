package project.manager;

import java.util.ArrayList;

/*
    This class should only really be created upon creation of the database.
    There should just be a large list of these where we add every item to the database.
 */
public class MenuItem {

    private double price; //cost of item
    private String itemDescription; //"juicy delicious prime angus burger with cheese"
    private String imageURL; //"hamburger.png"
    private String specialDay; //"N" if no special day, "Monday" is its a monday special
    private ArrayList<String> allergens; //list of allergens ["peanuts", "gluten"] for example

    //you dont want this
    MenuItem(){
        this(0.00,"not an item","", "N", new ArrayList<String>());
    }

    //you want this
    MenuItem(double prc, String itemDesc, String imgURL, String specDay, ArrayList<String> allgn) {
        setPrice(prc);
        setItemDescription(itemDesc);
        setImageURL(imgURL);
        setSpecialDay(specDay);
        setAllergens(allgn);
    }

    //Setters
    void setPrice(double prc){
        price = prc;
    }

    void setItemDescription(String itemDesc){
        itemDescription = itemDesc;
    }

    void setImageURL(String imgURL){
        imageURL = imgURL;
    }

    void setSpecialDay(String specDay){
        specialDay = specDay;
    }

    void setAllergens(ArrayList<String> allgn){
        allergens = allgn;
    }

    //Getters
    double getPrice(){
        return price;
    }

    String getItemDescription(){
        return itemDescription;
    }

    String getImageURL(){
        return imageURL;
    }

    String getSpecialDay(){
        return specialDay;
    }

    ArrayList<String> getAllergens(){
        return allergens;
    }
}