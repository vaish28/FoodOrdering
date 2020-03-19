//package fooddelivery;
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
		for(int i=0;i<7;i++)
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
						fitem1=fitem1+m[j]+"='"+item+"', ";
					}
					else
					{
						fitem0=fitem0+"'"+item+"'";
						fitem1=fitem1+m[j]+"='"+item+"'";
					}
				}
				//System.out.println("String is"+fitem0);
				//System.out.println("String 2 is"+fitem1);
				if(flag == 0)
				{
					stmt.executeUpdate("insert into menu values (7,'"+d[i]+"',"+fitem0+")");
				}
				else if(flag == 1)
				{
					String s="update menu set "+fitem1+" where Day='"+d[i]+"'and pno=7";

					stmt.executeUpdate(s);
				}
			}
			catch(Exception e)
			{

				System.out.println("11Exception"+e);
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
		days s[]=days.values();
		for(int i=0;i<6;i++)
		{
			System.out.println((i+1)+". "+s[i]);
		}
		System.out.println("Enter which day number to update menu");
		int da=sc.nextInt();
		String day=s[da-1].toString();
		int j;
		menuItems m[]=menuItems.values();
		for(j=0;j<6;j++)
		{
			System.out.println((j+1)+". "+m[j]);
		}
		System.out.println("Enter which item number out of the above to update::");
		int n=sc.nextInt();
		String mi=m[n-1].toString();
		sc.nextLine();
		System.out.println("Enter older item :");
		String old=sc.nextLine();

		System.out.println("Enter updated food item");
		String it=sc.nextLine();
		//write query
		try{
			String str="update menu set "+mi+"='"+it+"' where Day='"+day+"' and pno=7";
			//System.out.println(str);
			st.executeUpdate(str);
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
	int rating=0;
	Menu mm=new Menu();
	//Add star rating in the table
	Provider()
	{		teleno=0;
	}

	void acceptProDetails(Scanner sc)
	{
		super.accept(sc,1);
		System.out.println("Enter the name of your business  :");
		service = sc.nextLine();

	}
	String getprovquery(long tele)
	{
		teleno=tele;
		String str=id+",'"+name+"','"+service+"',"+teleno+",'"+address+"','"+category+"',"+tcost+","+moncost;
		return str;
	}
	
	void acceptmenu(Scanner sc,Statement st)
	{
		int choice=0;
		try
		{
			do
			{
				System.out.println("Enter category of your food :\n\t1.Vegetarian\n\t2.Non-Vegetarian\n\t3.Both\n\t0.Exit");
				choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					category="Veg";
					mm.acceptMenu(sc,st,0,0);
					//st.executeUpdate("create table menuv1"+"(  Day varchar(10),Gravy varchar(30),Dry_veg varchar(30) , Chapati varchar(20), Sides varchar(30), Rice  varchar(30),Special varchar(30))");

					break;
				case 2:
					category="Non-Veg";
					//st.executeQuery("create table menunv" +providerno+"( Day varchar(10),Gravy varchar(30),Dry_veg varchar(30) , Chapati varchar(20), Sides varchar(30), Rice  varchar(30),Special varchar(30))");
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
			System.out.println("Exception2"+e);
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
	private int catg;
	private int providerno;
	private int tiffin;			//Single/Monthly tiffin
	private int quantity; 				//No of tiffins
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
	void acceptcust(Scanner sc)
	{ 
		super.accept(sc,1);
	}
	void selecprovider(Scanner sc,Statement stmt,PriorityQueue<Provider> p)
	{
		System.out.println("Enter category of your food :\n\t1.Vegetarian\n\t2.Non-Vegetarian\n\t3.Both\n\t0.Exit");
		catg=sc.nextInt();
		try
		{
			
			ResultSet rs=null;
			if(catg==1)
			{
				int flag=0;
				
				String q="select pno,name,business,ratings from provdetails where category = 'Veg' ";
				rs=stmt.executeQuery(q);
				while(rs.next())
				{
					Provider pro=new Provider();
					p.comparator();
					pro.id=rs.getInt(1);
					pro.name=rs.getString(2);
					pro.service=rs.getString(3);
					pro.rating=rs.getInt(4);
					p.add(pro);
					flag=1;
				}
				System.out.println("Provider_no\tName\tBusiness\tRating");
				while(!p.isEmpty())
				{
					Provider p1=new Provider();
					p1=p.remove();
					System.out.println(p1.providerno+"\t\t"+p1.name+"\t"+p1.service+"\t\t"+p1.rating);
				}
				if(flag==0)
				{
					System.out.println("We dont have any veg providers");
				}
			}
			else if(catg==2)
			{
				int flag=0;
				
				String q="select name,business from provdetails where category = 'Nonveg' ";
				rs=stmt.executeQuery(q);
				while(rs.next())
				{
					System.out.println(rs.getString(1));
					System.out.println(rs.getString(2));
					flag=1;
				}
				if(flag==0)
				{
					System.out.println("We dont have any Nonveg providers");
				}
			}
			else{
				rs=stmt.executeQuery("select name,business from provdetails");
				
				providerno=sc.nextInt();
				while(rs.next())
				{
					System.out.println("name "+rs.getString(1));
					System.out.println("business"+rs.getString(2));
				}
			}
			System.out.println("Above is the list of provider details ::Please Enter which providerno you want to select ");
			do
			{
				System.out.println("Enter quantity");
				quantity=sc.nextInt();
			}while(quantity<=0);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception");
		}
		//display respective providers menu
		System.out.println("\t Enter your choice  \n \t 1.Single tiffin \n \t 2.Monthly tiffin");
		sc.nextLine();
		tiffin=sc.nextInt();
		

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
			System.out.println("Bill no"+bno);
			bno++;
			Calendar calendar = Calendar.getInstance();
			System.out.println(calendar.getTime());
			System.out.println("-------------------------------------");
			System.out.println("Item name\t\t Qty\tPrice\tValue");
			String tiff;
			if(tiffin==1)
			{
				rs=stmt.executeQuery("select scost from provdetails where pno="+providerno);
				tiff="Single Tiffin";
			}
			else
			{
				rs=stmt.executeQuery("select mcost from provdetails where pno="+providerno);
				tiff="Monthly tiffin";
			}
			while(rs.next())
			{
				price=rs.getDouble(1);
			}
			
			
			System.out.println(tiff+"\t\t"+quantity+"\t"+price+"\t"+(quantity*price));
			System.out.println("Delivery charges:");
			System.out.println("Total amount Incl of All taxes:");
			System.out.println("-------------------------------------");
			System.out.println("\tThank you for your purchase");
			System.out.println("\tHave a nice day!");
		}
		catch(Exception e)
		{
			System.out.println("Exception");
		}
	}
	 void rating(Scanner sc,Statement stmt)
	 {
		 System.out.println("Please enter your star ratings for the provider");
		 System.out.println("Enter 1 , 2, 3, 4, or 5 for respective star rating");
		 int rating=sc.nextInt();
		 String str2=Integer.toString(rating);
		 try
		 {
			 stmt.executeUpdate("insert into provdetails "+"values("+str2+")");
		 }
		 catch(Exception e)
		 {
			 System.out.println("e");
		 }
		 System.out.println("Thank for your reviews");
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
class RatingComparator implements Comparator<Provider>
{
	public int compare(Provider p1,Provider p2)
	{
		if(p1.rating<p2.rating)
		{
			return 1;
		}
		else if(p1.rating>p2.rating)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}
public class FoodDelivery {

	public static void main(String[] args) 
	{

		Scanner sc=new Scanner(System.in);
		int ch,ch1=0,ch2=0;


		long tele = 0;

		try {
			ResultSet rs=null;
			//			System.out.println("1");
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("2sfgv");

			String url=("jdbc:mysql://localhost/dabewala");

			System.out.println("3sfgv");

			Connection con=DriverManager.getConnection(url,"root","Archanasanjeev@99");

			Statement stmt=con.createStatement();

			System.out.println("driver loaded");

			do{

				System.out.println("\tAre you a ....");
				System.out.println("\t1.Provider\n\t2.Customer\n\t0.Exit : \nEnter choice");
				ch=sc.nextInt();
				int flag=0;
				switch(ch)
				{
				case 1:

					Provider p = new Provider();
					System.out.println(" \t\tRegister / Login");

					do
					{
						try{
							System.out.println("Enter mobile number  :");
							tele=sc.nextLong();
							if(Long.toString(tele).length() != 10)
							{
								System.out.println("Please enter valid phone number");
							}
						}
						catch(InputMismatchException e){
							System.out.println("Please enter valid phone number ");
							flag=1;
							sc.next();
						}

					}while(Long.toString(tele).length() != 10 || flag==1 || tele<0);
					String q="select pno from provdetails where telno = "+tele+"";
					rs=stmt.executeQuery(q);
					if(rs.next()==false)
					{

						p.acceptProDetails(sc);

						System.out.println("Registered successfully!");
						p.acceptmenu(sc,stmt);
						String str1=p.getprovquery(tele);
						stmt.executeUpdate("insert into provdetails "+"values("+str1+")");
					}
					else
					{
						System.out.print("Logged in successfully");
					}

					do{
						do {
							System.out.println("\n\t\1.Update entire menu\n\t2. Update an item from the menu\n\t0.Exit");

							ch2=sc.nextInt();
							if(ch2 > 3 || ch2 < 0)
							{
								System.out.println("Please enter valid option");
							}

						}while(ch2 > 3 || ch2 < 0);

						switch(ch2)
						{

						case 1:
							//updating entire menu
							p.upmenentire(sc, stmt,3);
							break;

						case 2:

							p.upmen(sc, stmt,1);
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
					Customer c=new Customer();
					System.out.println("Register / Login");
					RatingComparator r=new RatingComparator();
					PriorityQueue<Provider> pr=new PriorityQueue<Provider>(2,r);
					do
					{
						flag=0;
						try{
							System.out.println("Enter mobile number  :");
							tele=sc.nextLong();
							if(Long.toString(tele).length() != 10)
							{
								System.out.println("Please enter valid phone number");
							}
						}
						catch(InputMismatchException e){
							System.out.println("Please enter valid phone number ");
							flag=1;
							sc.next();
						}

					}while(Long.toString(tele).length() != 10 || flag==1 || tele<0);

					q="select regno from custdetails where telno = "+tele+"";
					rs=stmt.executeQuery(q);
					
					if(rs.next()==false)
					{
						
						c.acceptcust(sc);
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

							System.out.println("\n\t\tMenu\n\t1.Select provider and place order\n\t2.Bill\n\t 0.Exit");

							ch1 = sc.nextInt();

						}while(ch1>2 || ch1<0);

						switch(ch1)
						{
						case 1:
							c.selecprovider(sc, stmt, pr);
							//need to change the acceptcust function

							break;
						case 2:
							c.bill(stmt);
							//provider in acceptcust function

							break;

						case 0:
							System.out.println("Thank you!!");
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
			System.out.println("exception"+e);
		}

	}

}
