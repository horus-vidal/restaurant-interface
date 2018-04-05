package com.example.my.testapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


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
    public static final String mi_col10 = "image_name"; //image for the menu item

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
    public static final String oi_col7 = "oi_price"; //price of the actual order item, is = quantity * price
                                                     //from the menu items table





    //columns in the allergens table
    public static final String al_col1 = "allergen";    //allergen type
    public static final String al_col2 = "item_name";   //item name, from menu items
    public static final String al_col3 = "item_type";   //item type, from menu items


    public DBhelper(Context context) {
        super(context, database_name, null, 1);
        // SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //creates the full orders table
        db.execSQL("create table " + orders_table +
                "( " + fo_col1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + fo_col2 + " TEXT, "
                + fo_col3 + " DATETIME, "
                + fo_col4 + " REAL, "
                + fo_col5 + " TEXT, "
                + fo_col6 + " INTEGER, "
                + fo_col7 + " TEXT)");

        //creates the menu items table
        db.execSQL("create table " + mi_table +
                "( " + mi_col1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + mi_col2 + " TEXT, "
                + mi_col3 + " TEXT, "
                + mi_col4 + " REAL, "
                + mi_col5 + " TEXT, "
                + mi_col6 + " INTEGER, "
                + mi_col7 + " INTEGER, "
                + mi_col8 + " INTEGER, "
                + mi_col9 + " INTEGER, "
                + mi_col10 + " TEXT)");


        //creates the order items table (updated to add order item id
        db.execSQL("create table " + oi_table +
                "( " +  oi_col0 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + oi_col1 + " INTEGER, "
                +oi_col2 + " TEXT, "
                + oi_col3 + " TEXT, "
                + oi_col4 + " INTEGER, "
                + oi_col5 + " INTEGER, "
                + oi_col6 + " TEXT, "
                + oi_col7 + " REAL, "
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

        //gets date and time from getdatetime function
        String date = getDateTime();

        //adds initial values to order
        contentvalues.put(fo_col2, customerID);
        contentvalues.put(fo_col3, date);
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

    //method to get all data from the order table
    //added for debugging, can stay if necessary
    public Cursor getOrderData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + orders_table, null);
        return res;
    }


    //The add order item class adds an individual order item to an existing order
    public boolean addOrderItem(int transactionId, String itemName, String itemType, int quantity)
    {
        //create a database object
        SQLiteDatabase db = this.getWritableDatabase();
        //create values for a new order item
        ContentValues contentvalues = new ContentValues();


        //get total order item cost
       double cost = getOrderItemPrice(itemName, quantity);

        //add values to db
        contentvalues.put(oi_col1, transactionId);
        contentvalues.put(oi_col2, itemName);
        contentvalues.put(oi_col3, itemType);
        contentvalues.put(oi_col4, quantity);
        contentvalues.put(oi_col5, 0);  //originally not comped, so flags are set to 0 and
        contentvalues.put(oi_col6, " "); //reasons are left blank
        contentvalues.put(oi_col7, cost);

        boolean upcost = updateOrderTotal("+", cost, transactionId );
        if(upcost)
            Log.d("updated? ", "yes");
        else
            Log.d("updated? ", "no");

        long result = db.insert(oi_table, null, contentvalues);
        if(result == -1)
            return false;
        else return true;
    }

    //a method to get total order item price, searches for menu item by name
    //multiplies the found price by quantity and returns total cost
    public double getOrderItemPrice(String name, int quantity)
    {
        //create price containers
        double itemTotal = 0.0;
        double miprice = 0.0;

        //create a database object
        SQLiteDatabase db = this.getWritableDatabase();



        //query the database
        //SQL reads as:
        //select price from menu_items where item_name = 'name'
        Cursor c = db.rawQuery("select " + mi_col4 + " from " + mi_table
                + " where " + mi_col2 + " = " + " '" +  name + "' ", null);

        c.moveToFirst();

        //convert result to double and multiply by quantity.
       miprice = c.getDouble(0);
       itemTotal = miprice * quantity;

        return itemTotal;


    }

    //test method to add a menu item
    //returns true if successfull
    public boolean addMenuItem(String itemName, String itemType, double price)
    {
        //create a database object
        SQLiteDatabase db = this.getWritableDatabase();
        //create values for a new order item
        ContentValues contentvalues = new ContentValues();

        //add values to db
        contentvalues.put(mi_col2, itemName);
        contentvalues.put(mi_col3, itemType);
        contentvalues.put(mi_col4, price);

        long result = db.insert(mi_table, null, contentvalues);
        if(result == -1)
            return false;
        else return true;
    }

    //test method to add an allergen
    //returns true if successfull
    public boolean addAllergen(String allergen, String name, String type)
    {
        //create a database object
        SQLiteDatabase db = this.getWritableDatabase();
        //create values for a new order item
        ContentValues contentvalues = new ContentValues();

        //add values to db
        contentvalues.put(al_col1, allergen);
        contentvalues.put(al_col2, name);
        contentvalues.put(al_col3, type);

        long result = db.insert(al_table, null, contentvalues);
        if(result == -1)
            return false;
        else return true;
    }

    //method to update order total in case of comping or adding an order item
    //paramaters are an operator (+/-), the ammount to be changed, and
    //the tid (transaction id)
    //returns true if updated appropriately
    public boolean updateOrderTotal(String operator, double amount, int tid)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        double newAmount = 0.0; //placeholder for new amount

        //get the old amount
        String SQL_sel = "select " + fo_col4 + " from " + orders_table
                + " where " + fo_col1 + " = " + tid;

        Cursor c1 = db.rawQuery(SQL_sel, null);
        c1.moveToFirst();
        double oldAmount = c1.getDouble(0);

        //add/subtract new amount
        if(operator == "+")
            newAmount = oldAmount + amount;
        else
            newAmount = oldAmount - amount;

        //update row using content values
        ContentValues values = new ContentValues();
        values.put(fo_col4, newAmount);

        db.update(orders_table, values, fo_col1 + " = " + tid, null);
        return true;

    }

    //goes through the menu items table, looking for items by type
    //returns all items that match
    public Cursor getItemsByType(String type)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //SQL reads as:
        //select * from menu_items where item_type = 'type'
        Cursor res = db.rawQuery("select * from " + mi_table
                        + " where " + mi_col3 + " = '" + type + "' ", null);
        return res;
    }

    //sets the comp flag to 1, signalling the item was comped, and
    //adds a short string for comment to the order items table
    //returns true after updating successfully
    public boolean compItems(int orderid, String comment)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        int flag = 1;

        //get the old amount and transaction id
        String SQL_sel = "select " + oi_col7 + ", " + oi_col1 + " from " + oi_table
                + " where " + oi_col0 + " = " + orderid;

        Cursor c1 = db.rawQuery(SQL_sel, null);
        c1.moveToFirst();
        double oldAmount = c1.getDouble(0);
        int transactionId = c1.getInt(1);

        //update total in order
        boolean upcost = updateOrderTotal("-", oldAmount, transactionId );
        if(upcost)
            Log.d("updated? ", "yes");
        else
            Log.d("updated? ", "no");


        //update row using content values
        ContentValues values = new ContentValues();
        values.put(oi_col5, flag);
        values.put(oi_col6, comment);
        values.put(oi_col7, 0.0);

        db.update(oi_table, values, oi_col0 + " = " + orderid, null);
        return true;

    }

    //retrieves individual comped items from db
    //and returns them
    public Cursor getCompedItems()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + oi_table
                + " where " + oi_col5 + " = 1", null);
        return res;
    }

    //deletes full row from order items table (by id)
    //returns true if appropriately deleted
    public boolean deleteOrderItem(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(oi_table, oi_col0 + " = " + id, null) > 0;
    }

    //finds the menu item for special of the day using the special tag (day)
    //and returns full menu item
    public Cursor getSpecial(String day)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //SQL reads as:
        //select * from menu_items where special_tag = 'day'
        Cursor res = db.rawQuery("select * from " + mi_table
                + " where " + mi_col5 + " = '" + day + "' ", null);
        return res;

    }

    //looks for all items in the order items table with the same transaction
    //id and returns them
    public Cursor getAllItems(int transid)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + oi_table
                + " where " + oi_col1 + " = " + transid, null);
        return res;
    }


    //a function to filter an allergen, returns
    //all the (whole) menu items that match by joining
    //the allergens table and the menu items table
    public Cursor filterAllergens(ArrayList<String> allergens)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String extraQuery = "";


        //should read as:
        //SELECT menu_items.*, allergens_table.allergen
        //FROM menu_items JOIN allergens_table
        //ON menu_items.item_name = allergens_table.item_name
        //WHERE allergens_table.allergen != '(first item in the allergens ArrayList)'
        String SQL_join = "select " + mi_table + ".*, "
                    + al_table + "." + al_col1
                    + " from " + mi_table + " join "
                    + al_table + " on " + mi_table + "."
                    + mi_col2 +  " = " + al_table + "."
                    + al_col2 +" where " + al_table + "."
                    + al_col1 + " != '" + allergens.get(0) + "' ";

        //if the size of the allergens arraylist is bigger than 1,
        //loop through the array and add an additional and statement
        //to the end of the query and return all menu items that match that criteria
        if(allergens.size() > 1)
        {
            for(String allergen : allergens)
            {
                //this excludes the first element of the array since it's
                //already included in the variable declaration
                if(allergen != allergens.get(0))
                {
                    String extraAnd = " and " + al_table + "."
                            + al_col1 + " != '" + allergen + "' ";

                    extraQuery = extraQuery + extraAnd;
                }
            }


            SQL_join = SQL_join + extraQuery;



            Cursor res2 = db.rawQuery(SQL_join, null);
            return res2;
        }


        //if there is only one allergen, the function drops to this statement and prints
        //out the results for only one
        Cursor res = db.rawQuery(SQL_join, null);
        return res;
    }


    //function updated to get only the date
    //returns this as a string
    public String getDateTime()
    {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c1 = db.rawQuery("select date('now')", null);
        c1.moveToFirst();
        String nowDate = c1.getString(0);
        return nowDate;

    }


    //gets weekly server report by joining the information in the order items table
    //with the server name from the full orders table
    public Cursor getServerWeekly(String serverName)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //get current date and convert to string
        Cursor c1 = db.rawQuery("select date('now')", null);
        c1.moveToFirst();
        String nowDate = c1.getString(0);

        //get date from a week ago and convert to string
        Cursor c2 = db.rawQuery("select date('now', '-7 day')", null);
        c2.moveToFirst();
        String oldDate = c2.getString(0);

        //SQL reads:
        //SELECT order_items.*, full_order.server_name
        //FROM order_items JOIN full_order
        //WHERE full_order.server_name = 'serverName'
        //AND full_order.date BETWEEN oldDate AND nowDate

        String SQL_join = "select " + oi_table+ ".*, "
                + orders_table + "." + fo_col7 + ", "
                + orders_table + "." + fo_col3
                + " from " + oi_table + " join "
                + orders_table + " where " + fo_col7
                + " = '" + serverName + "' " + " and "
                + orders_table + "." + fo_col3 + " between '"
                + oldDate + "' and '" + nowDate + "' ";


            Cursor c = db.rawQuery(SQL_join, null);
            return c;
    }


    //gets day-of server report by joining the information in the order items table
    //with the server name from the full orders table
    public Cursor getServerDaily(String serverName)
    {
        SQLiteDatabase db = this.getWritableDatabase();


        //get current date and convert to string
        Cursor c1 = db.rawQuery("select date('now')", null);
        c1.moveToFirst();
        String nowDate = c1.getString(0);



        //SQL reads:
        //SELECT order_items.*, full_order.server_name
        //FROM order_items JOIN full_order
        //WHERE full_order.server_name = 'serverName'
        //AND full_order.date = 'nowDate'

        String SQL_join = "select " + oi_table+ ".*, "
                + orders_table + "." + fo_col7 + ", "
                + orders_table + "." + fo_col3
                + " from " + oi_table + " join "
                + orders_table + " where " + fo_col7
                + " = '" + serverName + "' " + " and "
                + orders_table + "." + fo_col3 + " = '"
                + nowDate + "' ";




        Cursor c = db.rawQuery(SQL_join, null);
        return c;

    }

    //a method to get a specific order's status
    //by inputting transaction id
    //returns that order's status in the form of a string
    public String getOrderStatus(int transactionId)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //SQL reads as:
        //select full_order.order_status from full_order where transaction_id = transactionId
        Cursor c = db.rawQuery("select " + orders_table + "." + fo_col5
                + " from " + orders_table + " where "
                + fo_col1 + " = " + transactionId, null);
        c.moveToFirst();
        String status = c.getString(0);

        return status;
    }

    //method to update status of a specific order
    // parameters are transactionId, newStatus
    //returns true if updated appropriately
    public boolean updateOrderStatus(int transactionId, String newStatus)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //update row using content values
        ContentValues values = new ContentValues();
        values.put(fo_col5, newStatus);

        db.update(orders_table, values, fo_col1 + " = " + transactionId, null);
        return true;

    }

    //finds all orders that match the inputted status
    //returns a list of all the order items under orders with
    //that status
    public Cursor filterOrderStatus(String status)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //SQL reads as:
        //select full_order.transaction_id, full_order.order_status,
        //order_items.* from full_order join order_items
        //where order_status = 'status'

        String SQL_join = "select " + orders_table + "." + fo_col1
                + ", " + orders_table + "." + fo_col5
                + ", " + oi_table + ".* from "
                + orders_table + " join " + oi_table
                + " where " + fo_col5 + " = '" + status + "' ";


        Cursor res = db.rawQuery(SQL_join, null);
        return res;

    }

    //method to add a special item to the menu using the specialtag/day
    //returns true if added appropriately
    public boolean addSpecialItem(String itemName, String itemType, double price, String specialTag)
    {
        //create a database object
        SQLiteDatabase db = this.getWritableDatabase();
        //create values for a new order item
        ContentValues contentvalues = new ContentValues();

        //add values to db
        contentvalues.put(mi_col2, itemName);
        contentvalues.put(mi_col3, itemType);
        contentvalues.put(mi_col4, price);
        contentvalues.put(mi_col5, specialTag);

        long result = db.insert(mi_table, null, contentvalues);
        if(result == -1)
            return false;
        else return true;
    }


}

