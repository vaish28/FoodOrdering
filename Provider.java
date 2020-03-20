package fooddelivery;
import java.util.*;
import java.sql.*;

class Provider extends Details 
{
	String category;
	String service;   //name of the business
	double tcost;
	double moncost;
	//int providerno=0;
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
		String str="pno,'"+name+"','"+service+"',"+teleno+",'"+address+"','"+category+"',"+tcost+","+moncost+","+rating;
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
					//st.executeQuery("create table menuv" +providerno+"( Day varchar(10),Gravy varchar(30),Dry_veg varchar(30) , Chapati varchar(20), Sides varchar(30), Rice  varchar(30),Special varchar(30))");
					//st.executeQuery("create table menunv" +providerno+"( Day varchar(10),Gravy varchar(30),Dry_veg varchar(30) , Chapati varchar(20), Sides varchar(30), Rice  varchar(30),Special varchar(30))");
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
		
		System.out.println("Enter the updated total cost :");
		double totalcost = sc.nextDouble();
		
		
		System.out.println("Enter the updated monthly cost :");
		double monthlycost = sc.nextDouble();
		try
		{
		stmt.executeUpdate("update provdetails set scost = "+totalcost+ ", mcost = "+monthlycost+" where pno = "+provno);
		System.out.println("Cost updated successfuly!!");
		}
		catch(Exception e)
		{
			System.out.println("Exception in upentire cost updation");
		}
		
		
	}
	
	
	void displayMENUcall(Statement stmt,int provno)
	{
		mm.displayMenu(stmt, provno);
		
	}


}
