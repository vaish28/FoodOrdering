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
	void acceptMenu(Scanner sc,Statement stmt)
	{
		sc.nextLine();
		days d[]=days.values();
		menuItems m[]=menuItems.values();
		for(int i=0;i<8;i++)
		{
			String fitem="";
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
							fitem=fitem+"'"+item+"',";
						}
						else
							fitem=fitem+"'"+item+"'";
						
						
						
					}
					System.out.println("String is"+fitem);
					stmt.executeUpdate("insert into menu values (1,'Monday',"+fitem+")");
				}
				catch(Exception e)
				{
					System.out.println("Exception"+e);
				}
		}
/*		catmenu=catm;
		do
		{

			System.out.println("Enter cost per tiffin: ");
			tcost=sc.nextDouble();
			if(tcost<0)
			{
				System.out.println("Please enter valid cost!");
			}
		}while(tcost<0);
		System.out.println("Enter monthly cost : ");
		moncost=sc.nextDouble();
		*/
	}
	/*
	void update(Scanner sc)
	{

		System.out.println("Enter which day to update menu");
		String day=sc.next();
		int i,j;
		for(i=1;i<=7;i++)
		{
			if(menu[i][0].compareToIgnoreCase(day)==0)
			{
				break;
			}
		}
		System.out.println("Which food category you want to update?");
		String cat=sc.next();
		for(j=1;j<=6;j++)
		{
			if(menu[0][j].compareToIgnoreCase(cat)==0)
			{
				break;
			}
		}
		System.out.println("Enter updated food item");
		menu[i][j]=sc.nextLine();
		System.out.println("Menu updated!!");

	}
	*/
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
					mm.acceptMenu(sc,st);
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
/*
	void updateMENU(Scanner sc)
	{
		if(category.equals("Vegetarian") || category.equals("Non-Vegeterian"))
		{
			promenu[0].update(sc);
		}
		else
		{
			int men=0;
			do
			{
				System.out.println("\tEnter the menu type you want to update. ");

				System.out.println("\n\t1.Vegetarian\n\t2.Non-Vegeterian");

				men  = sc.nextInt();
				if(men == 1)
				{
					promenu[0].update(sc);
				}
				else
				{
					if(men == 2 )
					{
						promenu[1].update(sc);
					}
					else
					{
						System.out.println("Please enter valid choice");
					}
				}

			}while(men<1 || men >2);

		}

	}*/
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
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		/*int n;
		System.out.println("Enter number of providers");
		n=sc.nextInt();
		Provider p= new  Provider();
		for(int i=0;i<n;i++)
		{
			p[i]=new Provider();
			p[i].acceptProDetails(sc);
		}
		 */
		int ch,ch1=0,ch2=0;
		//System.out.println(days.values());
		//System.out.println("Index of 0 is: "+days.valueOf(0).ordinal());  
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
				System.out.println("\t\tMenu");
				System.out.println("\t1.Add Provider\n\t2.Add Customer\n\t0.Exit\nEnter choice");
				ch=sc.nextInt();
				int flag=0;
				switch(ch)
				{
				case 1:
					flag=1;
					do{
						System.out.println("\n\t\tMenu\n\t1.Register/Login\n\t2.Update menu\n\t0.Exit");
						ch2=sc.nextInt();
						switch(ch2)
						{
						case 1:
							long tele;
							System.out.println("Enter mobile number");
							tele=sc.nextLong();
							String q="select name,business from provdetails where telno = "+tele+"";
							rs=stmt.executeQuery(q);
							if(rs.next()==false)
							{
								Provider p = new Provider();
								p.acceptProDetails(sc);
								String str1=p.getprovquery();
								stmt.executeUpdate("insert into provdetails "+"values("+str1+")");
								System.out.println("Registered successfully!");
								p.acceptmenu(sc,stmt);
							}
							else
							{
								System.out.print("Logged in successfully");
							}
							/*Calendar calendar = Calendar.getInstance();
							int day=calendar.get(Calendar.DAY_OF_WEEK);
							if(day==1)
							{
								System.out.println("Its Monday!!Do you want to change the Menu\n(1.YES 2.NO)");
								int cho;
								do
								{
									cho=sc.nextInt();
									if(cho==1)
									{
										//change;
									}
									else if(cho<1 || cho>2)
									{
										System.out.println("Invalid choice");
									}
								}while(cho<1 || cho>2);
							}*/
							break;

						case 2:
							if(flag!=1)
							{
								System.out.println("Register/Log in first");
							}
							else{

							}
							//stmt.modify()
							break;

						case 0:
							break;

						default:
							System.out.println("Please enter valid choice");
							break;

						}
					}while(ch2!=0);

					break;

				case 2:
					do{
						System.out.println("\n\t\tMenu\n\t1.Register\n\t2.Select provider\n\t0.Exit");
						ch1 = sc.nextInt();
						switch(ch1)
						{
						case 1:

							//need to change the acceptcust function
							Customer c=new Customer();
							c.acceptcust(sc,stmt);
							String str=c.sqlquery();
							stmt.executeUpdate("insert into custdetails "+"values("+str+")");

							break;
						case 2:

							//provider in acceptcust function

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
