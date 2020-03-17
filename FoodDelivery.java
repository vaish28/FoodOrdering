
import java.util.*;
import java.sql.*;

enum days
{
	Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday
}
enum menuItems
{
	Gravy ,Dry_veg , Chapati , Sides , Rice ,Special 
	
}
class Menu
{
	void acceptMenu(Scanner sc,Statement stmt , int flag,int provno )
	{
		sc.nextLine();
		days d[]=days.values();
		menuItems m[]=menuItems.values();
		for(int i=0;i<8;i++)
		{
			String fitem0="";
			String fitem1="";
			System.out.println("For "+d[i]);
			try
				{
					for(int j=0;j<6;j++)
					{
						
						System.out.println("Enter "+m[j]);
						String item;
						item=sc.nextLine();
						if(j<5)
						{
							fitem0=fitem0+"'"+item+"',";
							fitem1=fitem1+m[j]+"='"+item+"',";
						}
						else
							fitem0=fitem0+"'"+item+"'";
							fitem1=fitem1+m[j]+"='"+item+"'";
					}
					//System.out.println("String is"+fitem0)
					if(flag == 0)
					{
					stmt.executeUpdate("insert into menu values (1,'Monday',"+fitem0+")");
					}
					else if(flag == 1)
					{
						stmt.executeUpdate("update menu set"+fitem1+"where pno="+provno);
					}
				}
				catch(Exception e)
				{
					System.out.println("Exception"+e);
				}
		}
	}
	
	void updateEntire(Scanner sc , Statement st, int provno)
	{
		acceptMenu(sc,st,1,provno);
		System.out.println("Entire menu updated!!");
		
	}
	void updatespecific(Scanner sc,Statement st,int provno)
	{
		System.out.println("Enter which day to update menu");
		String day=sc.next();
		int j;
		menuItems m[]=menuItems.values();
		for(j=1;j<=6;j++)
		{
			System.out.println(j+". "+m[j]);
		}
		System.out.println("Enter which item number out of the above to update::");
		int n=sc.nextInt();
		String mi=m[n].toString();
		System.out.println("Enter older item :");
		String old=sc.nextLine();
		
		System.out.println("Enter updated food item");
		String it=sc.nextLine();
		//write query
		try{
		
		st.executeUpdate("update menu set "+mi+"="+it+" where "+mi+"="+old+" and Day="+day+" and pno="+provno);
		System.out.println("Menu updated!!");
		}
		catch(Exception e)
		{
			System.out.println("Exception!");
		}
		

	}
}
class Details
{
	protected int id ;
	protected String name;
	protected long teleno;
	protected String address;

	protected void accept(Scanner sc,int d)
	{
		sc.nextLine();
		System.out.println("Enter your name");
		name=sc.nextLine();			
		int flag=0;
		if(d!=1)
		{
		do
		{
			try{
				System.out.println("Enter contact number  :");
				teleno = sc.nextLong();
				if(Long.toString(teleno).length() != 10)
				{
					System.out.println("Please enter valid phone number");
				}
			}
			catch(InputMismatchException e){
				System.out.println("Please enter valid phone number ");
				flag=1;
				sc.next();
			}

		}while(Long.toString(teleno).length() != 10 && flag==1 && teleno<0);
		sc.nextLine();
		}

		System.out.println("Enter your address");
		address=sc.nextLine();

		System.out.println("Your registration number is:"+id);
		id++;

	}
}
class Provider extends Details 
{
	String category;
	String service;   //name of the business
	double tcost;
	double moncost;
	int providerno=0;
	Menu mm=new Menu();
	//Add star rating in the table
	Provider()
	{		teleno=0;
	}

	void acceptProDetails(Scanner sc)
	{
		super.accept(sc,1);
		System.out.println("Enter the name of your business  :");
		sc.nextLine();
		service = sc.nextLine();
		
	}
	String getprovquery()
	{
		String str=id+",'"+name+"','"+service+"',"+teleno+",'"+address+"','"+category+"',"+tcost+","+moncost;
		return str;
	}

	void acceptmenu(Scanner sc,Statement st)
	{
		int choice=0;
		try
		{
			st.executeQuery("Use dabewala");
			do
			{
				System.out.println("Enter category of your food :\n\t1.Vegetarian\n\t2.Non-Vegetarian\n\t3.Both\n\t0.Exit");
				choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					category="Vegetarian";
					mm.acceptMenu(sc,st,0,0);
					//st.executeUpdate("create table menuv1"+"(  Day varchar(10),Gravy varchar(30),Dry_veg varchar(30) , Chapati varchar(20), Sides varchar(30), Rice  varchar(30),Special varchar(30))");
				
					break;
				case 2:
					category="Non-Vegetarian";
					st.executeQuery("create table menunv" +providerno+"( Day varchar(10),Gravy varchar(30),Dry_veg varchar(30) , Chapati varchar(20), Sides varchar(30), Rice  varchar(30),Special varchar(30))");
					break;
				case 3:
					category="Both";
					st.executeQuery("create table menuv" +providerno+"( Day varchar(10),Gravy varchar(30),Dry_veg varchar(30) , Chapati varchar(20), Sides varchar(30), Rice  varchar(30),Special varchar(30))");
					st.executeQuery("create table menunv" +providerno+"( Day varchar(10),Gravy varchar(30),Dry_veg varchar(30) , Chapati varchar(20), Sides varchar(30), Rice  varchar(30),Special varchar(30))");
					break;
				case 0:
					break;
				default:
					System.out.println("Invalid choice! Please enter again");
					break;
				}
			}while(choice<0 || choice>3);

		}
		catch(Exception e)
		{
			System.out.println("Exception");
		}
		do
		{

			System.out.println("Enter cost of single tiffin");
			tcost=sc.nextDouble();
			if(tcost<0)
			{
				System.out.println("Please enter valid cost!");
			}
		}while(tcost<0);
		do
		{

			System.out.println("Enter cost of monthly tiffin");
			moncost=sc.nextDouble();
			if(moncost<0)
			{
				System.out.println("Please enter valid cost!");
			}
		}while(moncost<0);

	}
	void upmen(Scanner sc,Statement stmt,int provno)
	{
		mm.updatespecific(sc,stmt,provno);
	}
	void upmenentire(Scanner sc,Statement stmt,int provno)
	{
		mm.updateEntire(sc, stmt, provno);
	}
}

class Customer extends Details
{
	private String catg;
	private int providerno;
	private String tiffin;			//Single/Monthly tiffin
	private int quantity;			//No of tiffins
	//Add location and time
	Customer()
	{
		providerno=0;
	}

	String sqlquery()
	{
		String str=id+",'"+name+"',"+teleno+",'"+address+"'";
		return str;
	}
	void acceptcust(Scanner sc,Statement stmt)
	{ 
		super.accept(sc,0);
		System.out.println("\t Enter your choice  \n \t Single tiffin \n \t Monthly tiffin");
		tiffin=sc.nextLine();
		ResultSet rs=null;
		do
		{
			System.out.println("Enter quantity");
			quantity=sc.nextInt();
		}while(quantity<=0);
		try
		{
			System.out.println("Enter category of your food :\n\t1.Vegetarian\n\t2.Non-Vegetarian\n\t3.Both\n\t0.Exit");
			int choice=sc.nextInt();

			if(choice==1)
			{
				int flag=0;
				String q="select name,business from provdetails where category = 'Veg' ";
				rs=stmt.executeQuery(q);
				while(rs.next())
				{
					rs.getString(1);
					rs.getString(2);
					flag=1;
				}
				if(flag==0)
				{
					System.out.println("We dont have any veg providers");
				}
			}
			else if(choice==2)
			{
				int flag=0;
				String q="select name,business from provdetails where category = 'Nonveg' ";
				rs=stmt.executeQuery(q);
				while(rs.next())
				{
					rs.getString(1);
					rs.getString(2);
					flag=1;
				}
				if(flag==0)
				{
					System.out.println("We dont have any Nonveg providers");
				}
			}
			else{
				rs=stmt.executeQuery("select name,business from provdetails");
				while(rs.next())
				{
					rs.getString(1);
					rs.getString(2);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception");
		}

		System.out.println("Above is the list of provider details ::Please Enter which providerno you want to select ");
		providerno=sc.nextInt();
		//display respective providers menu


	}

	void bill(Statement stmt)
	{
		double price=0;
		int bno=0;
		ResultSet rs=null;
		String q="select business address from provdetails where pno = "+providerno+"";
		try
		{
			rs=stmt.executeQuery(q);
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
			System.out.println("-------------------------------------");
			System.out.println();
			System.out.println("Bill no"+bno);
			bno++;
			Calendar calendar = Calendar.getInstance();
			System.out.println(calendar.getTime());
			System.out.println("-------------------------------------");
			System.out.println("Item name\t\t Qty\tPrices\tValue");
			rs=stmt.executeQuery("select sprice from provdetails where pno="+providerno);
			while(rs.next())
			{
				price=rs.getDouble(1);
			}
			System.out.println(tiffin+"\t\t"+quantity+"\t"+price+"\t"+(quantity*price));
			System.out.println("Delivery charges:");
			System.out.println("Total amount Incl of All taxes:");
			System.out.println("-------------------------------------");
			System.out.println("\t\tThank you for your purchase");
			System.out.println("\t\tHave a nice day!");
		}
		catch(Exception e)
		{
			System.out.println("Exception");
		}
	}
	
}
class DeliveryGuy extends Details
{
	String area;

	DeliveryGuy()
	{
		area="";
	}
	void acceptd(Scanner sc)
	{
		super.accept(sc,0);

	}
	void assignarea()
	{

	}
}

public class FoodDelivery {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		int ch,ch1=0,ch2=0;


		long tele;

		try {
			ResultSet rs=null;
			//			System.out.println("1");
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("2sfgv");

			String url=("jdbc:mysql://localhost/dabewala");

			System.out.println("3sfgv");

			Connection con=DriverManager.getConnection(url,"root","abcd1234");

			Statement stmt=con.createStatement();

			System.out.println("driver loaded");

			do{

				System.out.println("\tAre you a ....");
				System.out.println("\t1.Provider\n\t2.Customer\n\t0.Exit :( \nEnter choice");
				ch=sc.nextInt();
				int flag=0;
				switch(ch)
				{
				case 1:
					
					Provider p = new Provider();
					System.out.println(" \t\tRegister / Login");

					System.out.println("Enter mobile number");
					tele=sc.nextLong();
					String q="select pno from provdetails where telno = "+tele+"";
					rs=stmt.executeQuery(q);
					if(rs.next()==false)
					{
						
						p.acceptProDetails(sc);
						String str1=p.getprovquery();
						stmt.executeUpdate("insert into provdetails "+"values("+str1+")");
						System.out.println("Registered successfully!");

					}
					else
					{
						System.out.print("Logged in successfully");
					}

					do{
						do {
							System.out.println("\n\t\1.Accept menu\n\t2.Update entire menu\n\t3. Update an item from the menu\n\t0.Exit");

							ch2=sc.nextInt();
							if(ch2 > 3 || ch2 < 0)
							{
								System.out.println("Please enter valid option");
							}

						}while(ch2 > 3 || ch2 < 0);

						switch(ch2)
						{
						case 1:
							//accepting entire menu
							p.acceptmenu(sc,stmt);
							System.out.println();

							break;

						case 2:
							//updating entire menu
							p.upmenentire(sc, stmt, rs.getInt(1));
							break;

						case 3:
							p.upmen(sc, stmt,rs.getInt(1));
							break;

						case 0:
							break;

						default:
							System.out.println("Please enter valid choice");
							break;

						}
					}while(ch2!=0);

					break;

				case 2: // customer




					System.out.println("Register / Login");
					System.out.println("Enter mobile number");
					tele=sc.nextLong();
					q="select id from custdetails where teleno = "+tele+"";
					rs=stmt.executeQuery(q);
					if(rs.next()==false)
					{
						Customer c=new Customer();
						c.acceptcust(sc,stmt);
						String str=c.sqlquery();
						stmt.executeUpdate("insert into custdetails "+"values("+str+")");
						System.out.println("Registered successfully!");

					}
					else
					{
						System.out.print("Logged in successfully");
					}


					do{
						
						do {
							
							System.out.println("\n\t\tMenu\n\t1.Select provider\n\t2.Post ratings\n\t 0.Exit");
							
							ch1 = sc.nextInt();
						
						}while(ch1>2 || ch1<0);

						switch(ch1)
						{
						case 1:

							//need to change the acceptcust function

							break;
						case 2:

							//provider in acceptcust function

							break;

						case 3:
							//ratings
							break;

						default:
							System.out.println("Please enter valid choice");
							break;
						}
					}while(ch1!=0);


					break;
				default:
					System.out.println("Please enter valid choice");
					break;

				case 0:
					System.out.println("Thank you!");
					break;
				}
			}while(ch!=0);


		}
		catch(Exception e)
		{
			System.out.println("e");
		}

	}

}
