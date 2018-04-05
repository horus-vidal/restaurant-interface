The purpose of this document is to introduce you guys to the db helper and how to implement it. 
I'll make search-able sections since this might get long

1. DB helper organization
2. Linking/Using the DB helper
3. Using Logcat
4. Using Cursor
5. Method Index

1. DB helper organization

  //db name
    public static final String database_name = "electronic_rest.db";

    //complete order table
    public static final String orders_table = "full_order";
	
	//columns in the full order table
    public static final String fo_col1 = "transaction_id"; //primary key for full orders table
    public static final String fo_col2 = "customer_id"; //placeholder for a customer id, if we want to use one
    public static final String fo_col3 = "date"; //date the order took place
    public static final String fo_col4 = "order_total"; //total revenue from the order
    public static final String fo_col5 = "order_status"; //order status
    public static final String fo_col6 = "payment_status"; //payment status, i.e. have they paid
    public static final String fo_col7 = "server_name";     //name of server
	
	
	//order items table
    public static final String oi_table = "order_items";
	
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
   

   //menu items table
   public static final String mi_table = "menu_items";
   
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
   
   
   //allergens table
    public static final String al_table = "allergens_table";
	
	//columns in the allergens table
    public static final String al_col1 = "allergen";    //allergen type
    public static final String al_col2 = "item_name";   //item name, from menu items
    public static final String al_col3 = "item_type";   //item type, from menu items
	
	
2. Linking/Using the DB helper
		2.1 under the class declaration, create a variable of the db class
				public class MainActivity extends AppCompatActivity {
							Dbhelper mydb;
							
		2.2 inside your onCreate function, create a new instance of the db helper 
				protected void onCreate(Bundle savedInstanceState) {
					super.onCreate(savedInstanceState);
					setContentView(R.layout.activity_main);
					mydb = new Dbhelper(this);
					
		2.3 Also inside the onCreate function, create something (button/edit text etc) 
			to link to your corresponding activity
				addAl = (Button)findViewById(R.id.[BUTTON ID]);
					
		2.4 Use like you would any other object : mydb.[method from db helper]
			More than likely, it will be inside the listener
				
				    public void addAllergen()
					{
						[addAl].setOnClickListener(
							new View.OnClickListener() 
							{
								@Override
									public void onClick(View view) 
									{
										boolean isinserted = mydb.addAllergen("milk","krabby patte w cheeze", "entree" );									
										if(isinserted == true) {
											Log.d("Is inserted? ", " Yes");
										}
										else
										{
											Log.d("Is inserted? ", " No");
										}
									}
							}
						);
					}	
	
		2.5 The last step is to add a function call into your onCreate method,
			below all of your variable/instance declarations
			
			   protected void onCreate(Bundle savedInstanceState) {
					super.onCreate(savedInstanceState);
					setContentView(R.layout.activity_main);
					mydb = new Dbhelper(this);

					addAl = (Button)findViewById(R.id.[BUTTON ID]) ;
					addAllergen();
					
3. Using Logcat
		Several of the methods return as boolean once they attempt an update or an insertion.
		In order to see if they were successful, I've been using Logcat, which runs in the background
		Each time you run your app. It's also quite helpful for debugging in general, as it can tell you
		why your app is crashing.

		3.1 You need to add at least one log call before you can use it. 
			A log call is set up with a (user defined) searchable tag and
			a message: Log.d("tag", "message);
				   
				   public void setOrder() {
						boolean isinserted = mydb.addOrder("Bob", 0.0, "ordered", "sandy");
						if (isinserted == true) {
							Log.d("is done?", "yes, order set ");
            

						} else {
							Log.d("is done?", "no, order not set ");
            
						}
					}
		3.2 To view Logcat's output, open Logcat and search for your tag to see what
			your message says. It should look something like this:
			04-05 12:06:38.536 16953-16953/com.example.my.testapp D/is done?: yes, order set 
			
			
4. Using Cursor
		Several methods return as cursor, which grabs all the rows that match
		Cursor returns rows in order of how they were inserted into the database.
		If two tables were joined together, the cursor reads from the first column(s) 
		after the select statement to the last one(s);
		
		4.1 To print out what you want you'll need to find what row will equal the cursor
			index and add it to a buffer. If cursor finds no rows, it returns 0.
			
			    public void viewOrderitem()
				{
					Cursor res = mydb.getOrderItemData();
					if(res.getCount()== 0)
					{
						showMessage("Error", "No data");
						return;
					}

					StringBuffer buffer = new StringBuffer();
					while(res.moveToNext())
					{
						buffer.append("order id : " + res.getString(0) +"\n");
						buffer.append("transaction id: " + res.getString(1) +"\n");
						buffer.append("item name: " + res.getString(2) +"\n");
						buffer.append("item type : " + res.getString(3) +"\n");
						buffer.append("quantity: " + res.getString(4) +"\n");
						buffer.append("comped flag: " + res.getString(5) +"\n");
						buffer.append("reasons comped: " + res.getString(6) +"\n");
						buffer.append("oi price: " + res.getString(7) +"\n\n");
					}
					//show all data
					showMessage("Data", buffer.toString());
				}
				
		4.2 index example: 
			Sql: select * from allergens 
			allergens table has 3 rows, allergen, item name, item type
				declared in that order, so the cursor index 0 = allergen, 1 = item name, 2 = item type
			retrieved in java file using:
					Cursor res = mydb.getAltable();
					while(res.moveToNext())
					{
						buffer.append("allergen: " + res.getString(0) +"\n");
						buffer.append("item name: " + res.getString(1) +"\n");
						buffer.append("item item type: " + res.getString(2) +"\n\n");
					}
			this prints every allergen, item name and item type to a buffer to 
			be displayed
			
5. Method Index

	//the addOrder class creates the first instance of an order.
    //the order items will be added to this whole order and will
    //have a separate method to do so
    public boolean addOrder(String customerID, double orderTotal, 
						String orderStatus, String serverName )

	    //method to get all data from the order table
    //added for debugging, can stay if necessary
    public Cursor getOrderData()
	
	 //The add order item class adds an individual order item to an existing order
    public boolean addOrderItem(int transactionId, String itemName, 
						String itemType, int quantity)
		
	    //a method to get total order item price, searches for menu item by name
    //multiplies the found price by quantity and returns total cost
    public double getOrderItemPrice(String name, int quantity)
	
	   //test method to add a menu item
    //returns true if successful
    public boolean addMenuItem(String itemName, String itemType, double price)
	
	    //test method to add an allergen
    //returns true if successful
    public boolean addAllergen(String allergen, String name, String type)
	
	    //method to update order total in case of comping or adding an order item
    //paramaters are an operator (+/-), the ammount to be changed, and
    //the tid (transaction id)
    //returns true if updated appropriately
    public boolean updateOrderTotal(String operator, double amount, int tid)
	
	    //goes through the menu items table, looking for items by type
    //returns all items that match
    public Cursor getItemsByType(String type)
	
	
	    //sets the comp flag to 1, signalling the item was comped, and
    //adds a short string for comment to the order items table
    //returns true after updating successfully
    public boolean compItems(int orderid, String comment)
	
	    //retrieves individual comped items from db
    //and returns them
    public Cursor getCompedItems()
	
	    //deletes full row from order items table (by id)
    //returns true if appropriately deleted
    public boolean deleteOrderItem(int id)
	
	    //finds the menu item for special of the day using the special tag (day)
    //and returns full menu item
    public Cursor getSpecial(String day)
	
	    //looks for all items in the order items table with the same transaction
    //id and returns them
    public Cursor getAllItems(int transid)
	
	    //a function to filter an allergen, returns
    //all the (whole) menu items that match by joining
    //the allergens table and the menu items table
    public Cursor filterAllergens(ArrayList<String> allergens)
	
	//a function to get date
    //returns this as a string
    public String getDateTime()
	
	   //gets weekly server report by joining the information in the order items table
    //with the server name from the full orders table
    public Cursor getServerWeekly(String serverName)
	
	    //gets day-of server report by joining the information in the order items table
    //with the server name from the full orders table
    public Cursor getServerDaily(String serverName)
	
	    //a method to get a specific order's status
    //by inputting transaction id
    //returns that order's status in the form of a string
    public String getOrderStatus(int transactionId)
	
	    //method to update status of a specific order
    // parameters are transactionId, newStatus
    //returns true if updated appropriately
    public boolean updateOrderStatus(int transactionId, String newStatus)
	
	    //finds all orders that match the inputted status
    //returns a list of all the order items under orders with
    //that status
    public Cursor filterOrderStatus(String status)
	
	    //method to add a special item to the menu using the specialtag/day
    //returns true if added appropriately
    public boolean addSpecialItem(String itemName, String itemType, 
						double price, String specialTag)
	
	
	
	
	
					
					
					
					