package com.example.kirsten.testapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBhelper extends SQLiteOpenHelper {

    //db name
    public static final String database_name = "electronic_rest.db";

    //Table names
    public static final String orders_table = "full_order";
    public static final String oi_table = "order_items";
    public static final String mi_table = "menu_items";
   // public static final String ds_table = "daily_specials";
    //public static final String ci_table = "comped_items";
    public static final String al_table = "allergens_table";



    //columns in the full order table
    public static final String fo_col1 = "transaction_id"; //primary key for full orders table
    public static final String fo_col2 = "customer_id"; //placeholder for a customer id, if we want to use one
    public static final String fo_col3 = "date"; //date the order took place
    public static final String fo_col4 = "order_total"; //total revenue from the order
    public static final String fo_col5 = "order_status"; //order status
    public static final String fo_col6 = "payment_status"; //payment status, i.e. have they paid
    public static final String fo_col7 = "server_name";     //name of server

    //columns in the menu items table
    public static final String mi_col1 = "item_id"; //primary key for menu items
    public static final String mi_col2 = "item_name"; // menu item name
    public static final String mi_col3 = "item_type"; //appetizer, entree, etc
    public static final String mi_col4 = "price";   //item price
    public static final String mi_col5 = "special_tag"; //if the menu item is a special, the special
                                                        //tag is set with a day
    public static final String mi_col6 = "calories"; //the rest are nutrition facts
    public static final String mi_col7 = "protein";
    public static final String mi_col8 = "sodium";
    public static final String mi_col9 = "sugar";

    //columns in the order items table, the bridge table between
    //full order and individual menu items - composed mostly of primary keys
    //from both tables
    public static final String oi_col0 = "oi_id"; //primary key for order items, added for easier check splitting
    public static final String oi_col1 = "transaction_id"; //primary key from full order table
    public static final String oi_col2 = "item_name"; //primary key from menu items table
    public static final String oi_col3 = "item_type"; //type of item, also from menu items table
    public static final String oi_col4 = "quantity";    //quantity of items ordered
    public static final String oi_col5 = "comped_flag"; //if the order item is comped, set flag to comped
    public static final String oi_col6 = "reasons_comped"; //enter reasons why it was comped




    //columns in the allergens table
    public static final String al_col1 = "allergen";    //allergen type
    public static final String al_col2 = "item_name";   //item name, from menu items
    public static final String al_col3 = "item_type";   //item type, from menu items



    /*below is what i was originally going to do for specials, which we can go back to
    *but i think just adding a special flag to a menu item is a better method
    *
    * columns in the daily specials table
    *public static final String ds_col1 = "day"; //primary key for special of the day
    *public static final String ds_col2 = "sp_name"; //special name
    *public static final String ds_col3 = "sp_type"; //special type
    *public static final String ds_col4 = "sp_price"; //special price
    *public static final String ds_col5 = "sp_calories"; //special nutritional facts
    *public static final String ds_col6 = "sp_protein";
    *public static final String ds_col7 = "sp_sodium";
    *public static final String ds_col8 = "sp_sugar"; */

    public DBhelper(Context context) {
        super(context, database_name, null, 1);
        // SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //creates the full orders table
        db.execSQL("create table " + orders_table +
                "( " + fo_col1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + fo_col2 + " INTEGER, "
                + fo_col3 + " DATETIME, "
                + fo_col4 + " REAL, "
                + fo_col5 + " TEXT, "
                + fo_col6 + " INTEGER, "
                + fo_col7 + " TEXT)");

        //creates the menu items table
        db.execSQL("create table " + mi_table +
                "( " + mi_col1 + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + mi_col2 + " TEXT, "
                + mi_col3 + " TEXT, "
                + mi_col4 + " REAL, "
                + mi_col5 + " TEXT, "
                + mi_col6 + " INTEGER, "
                + mi_col7 + " INTEGER, "
                + mi_col8 + " INTEGER, "
                + mi_col9 + " INTEGER)");


        //creates the order items table (updated to add order item id
        db.execSQL("create table " + oi_table +
                "( " +  oi_col0 + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + oi_col1 + " INTEGER, "
                +oi_col2 + " TEXT, "
                + oi_col3 + " TEXT, "
                + oi_col4 + " INTEGER, "
                + oi_col5 + " INTEGER, "
                + oi_col6 + " TEXT, "
                + "FOREIGN KEY( " + oi_col1 + " ) REFERENCES "
                + orders_table + "( " + fo_col1 + " ), "
                + "FOREIGN KEY( " + oi_col2 + " ) REFERENCES "
                + mi_table + "( "  + mi_col2 + " ), "
                + "FOREIGN KEY( " + oi_col3 + " ) REFERENCES "
                + mi_table + "( "  + mi_col3 + " )) ");

        //creates the allergens table (linked to menu items)
        db.execSQL("create table " + al_table +
                "( " + al_col1 + " TEXT, "
                + al_col2 + " TEXT, "
                + al_col3 + " TEXT, "
                + "FOREIGN KEY( " + al_col2 + " ) REFERENCES "
                + mi_table + "( "  + mi_col2 + " ), "
                + "FOREIGN KEY( " + al_col3 + " ) REFERENCES "
                + mi_table + "( "  + mi_col3 + " )) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        //drops all tables
        db.execSQL("drop table if exists " + orders_table);
        db.execSQL("drop table if exists " + mi_table);
        db.execSQL("drop table if exists " + oi_table);
        db.execSQL("drop table if exists " + al_table);

        onCreate(db);

    }

    //the addOrder class creates the first instance of an order.
    //the order items will be added to this whole order and will
    //have a separate method to do so
    public boolean addOrder(String customerID, double orderTotal, String orderStatus, String serverName )
    {
        //create a database object
        SQLiteDatabase db = this.getWritableDatabase();
        //create values for the first instance of an order
        ContentValues contentvalues = new ContentValues();

        //adds initial values to order
        contentvalues.put(fo_col2, customerID);

        //eventually add the date to the content values using a get date method
        contentvalues.put(fo_col4, orderTotal);
        contentvalues.put(fo_col5, orderStatus);
        contentvalues.put(fo_col6, "not_paid");     //set to not paid as default
        contentvalues.put(fo_col7, serverName );

        //checks to make sure the table was inserted successfully
        long result = db.insert(orders_table, null, contentvalues);
        if(result == -1)
            return false;
        else return true;

    }

    //The add order item class adds an individual order item to an existing order
    public boolean addOrderItem(int transactionId, String itemName, String itemType, int quantity)
    {
        //create a database object
        SQLiteDatabase db = this.getWritableDatabase();
        //create values for a new order item
        ContentValues contentvalues = new ContentValues();

        //add values to db
        contentvalues.put(oi_col1, transactionId);
        contentvalues.put(oi_col2, itemName);
        contentvalues.put(oi_col3, itemType);
        contentvalues.put(oi_col4, quantity);
        contentvalues.put(oi_col5, 0);  //originally not comped, so flags are set to 0 and
        contentvalues.put(oi_col6, " "); //reasons are left blank

        long result = db.insert(oi_table, null, contentvalues);
        if(result == -1)
            return false;
        else return true;
    }

    //goes through the menu items table, looking for items by type
    public Cursor getItemsByType(String type)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + mi_table
                        + " where " + mi_col3 + " = " + type, null);
        return res;
    }

    //sets the comp flag to 1, signalling the item was comped, and
    //adds a short string for comment to the order items table
    //returns true after updating
    public boolean compItems(int orderid, String comment)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int flag = 1;

        db.rawQuery("UPDATE " + oi_table
                + " SET " + oi_col5 + " = " + flag
                + oi_col6 + " = " + comment
                + " WHERE " + oi_col0 + " = " + orderid, null);
        return true;
    }

    //deletes full row from order items table (by id)
    //returns number of rows deleted (returns 0 if nothing was deleted)
    public Integer deleteOrderItem(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(oi_table, "id = ?",
                new String[]{id});
    }

    //finds the menu item for special of the day using the special tag (day)
    //and returns full menu item
    public Cursor getSpecial(String day)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + mi_table
                + " where " + mi_col5 + " = " + day, null);
        return res;

    }

    //eventually, a filter allergens method will be added that uses the
    //filter allergens table and loops through, excluding the allergens
    //sent in

    //a method to add allergens since they are their own separate table will also
    //be needed

    //placeholder for a get date class, needed for recording into the order table
}

