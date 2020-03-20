package fooddelivery;
import java.util.*;
import java.sql.*;

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
				
				String q="select pno,name,business,rating from provdetails where category = 'Veg' ";
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
					System.out.println(p1.id+"\t\t"+p1.name+"\t"+p1.service+"\t\t"+p1.rating);
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
