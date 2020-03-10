
import java.util.*;
import java.sql.*;
import javax.sql.*;
class Menu
{
	String menu[][]=new String[8][7];
	double tcost;
	double moncost;
	String catmenu;
	Menu()
	{
		tcost = 0.0;

		menu[1][0]="Monday";
		menu[2][0]="Tuesday";
		menu[3][0]="Wednesday";
		menu[4][0]="Thursday";
		menu[5][0]="Friday";
		menu[6][0]="Saturday";
		menu[7][0]="Sunday";
		menu[0][1]="Gravy";
		menu[0][2]="Dry veg";
		menu[0][3]="Chapati";
		menu[0][4]="Sides";
		menu[0][5]="Rice";
		menu[0][6]="Special";

	}
	void acceptMenu(Scanner sc,String catm)
	{
		sc.nextLine();
		for(int i=1;i<8;i++)
		{

			System.out.println("For "+menu[i][0]);

			for(int j=1;j<7;j++)
			{

				System.out.println(menu[0][j]+" = ");
				menu[i][j]=sc.nextLine();
			}
		}
		catmenu=catm;
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
	}
	void update(Scanner sc,String catm)
	{
		if(catm.compareToIgnoreCase("Both")!=0)
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
	}
	void display()
	{
		menu[0][0]="";
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<7;j++)
			{
				System.out.print(menu[i][j]+"\t\t");
			}
			System.out.println();
		}
	}
}
class Provider
{
	String category;
	String Owner;
	String service;   //name of the business
	long teleno;
	String Address;
	Menu promenu[];


	Provider()
	{		teleno=0;
	}

	void acceptProDetails(Scanner sc)
	{
		System.out.println("Enter the name of your business  :");
		service = sc.nextLine();

		System.out.println("Enter the name of the Owner  :");
		Owner = sc.nextLine();
		int flag=0;
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
		System.out.println("Enter address of your outlet :");
		Address = sc.nextLine();

		int choice=0;

		do
		{
			System.out.println("Enter category of your food :\n\t1.Vegetarian\n\t2.Non-Vegetarian\n\t3.Both\n\t0.Exit");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				category="Vegetarian";
				promenu=new Menu[1];
				promenu[0]=new Menu();
				promenu[0].acceptMenu(sc,category);
				promenu[0].display();
				break;
			case 2:
				category="Non-Vegetarian";
				promenu=new Menu[1];
				promenu[0]=new Menu();
				promenu[0].acceptMenu(sc,category);
				promenu[1].display();
				break;
			case 3:
				category="Both";
				promenu=new Menu[2];
				promenu[0]=new Menu();
				System.out.println("For Vegeterian");
				promenu[0].acceptMenu(sc, category);
				promenu[0].display();
				promenu[1]=new Menu();
				System.out.println("For Non-Vegeterian");
				promenu[1].acceptMenu(sc, category);
				promenu[1].display();
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid choice! Please enter again");
				break;
			}
		}while(choice<0 || choice>3);

	}
	
}
class Customer
{
	private:
	String name;
	long teleno;
	String address;
	long regno;
	String catg;
	int providerno;
	String day;
	Customer()
	{
		teleno=0;
		regno=0;
	}
	void acceptcust(Scanner sc,Provider p[],int n)
	{
		Calendar calendar = Calendar.getInstance();
		int day=calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(day);
		
		for(int i=0;i<n;i++)
		{
			System.out.println(p[i].service);
		}
		System.out.println("Enter which provider you want to select:");
		String prov=sc.next();
		for(int j=0;j<n;j++)
		{
			if(p[j].service.compareToIgnoreCase(prov)==0)
			{
				providerno=j;
			}
		}
	}	
}
public class FoodDelivery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int n;
		System.out.println("Enter number of providers");
		n=sc.nextInt();
		Provider p[]= new  Provider[n];
		for(int i=0;i<n;i++)
		{
			p[i]=new Provider();
			p[i].acceptProDetails(sc);
		}
		Customer c=new Customer();
		c.acceptcust(sc,p,n);
		try {
				  ResultSet rs=null;
				   Class.forName("com.mysql.jdbc.Driver");
				   String url=("jdbc:mysql://localhost/dabewala");
				   Connection con=DriverManager.getConnection(url,"root","abcd1234");
				   Statement stmt=con.createStatement();
				   System.out.println("driver loaded");
				   
				   stmt.executeUpdate("insert into provdetails "+"values(3,'Ana','tif',123,'bbb')");
				   System.out.println("added");
			}
			catch(Exception e)
			{
				System.out.println("e");
			}
			
	}

}
