import java.util.*;
import java.sql.*;

public class FoodDelivery {

	public static void main(String[] args) 
	{

		Scanner sc=new Scanner(System.in);
		int ch,ch1=0,ch2=0;
int regno=0;	

		long tele = 0;

		try {
			ResultSet rs=null;
		
			Class.forName("com.mysql.jdbc.Driver");

			String url=("jdbc:mysql://localhost/dabewala");

			Connection con=DriverManager.getConnection(url,"root","abcd1234");

			Statement stmt=con.createStatement();

			do{

				System.out.println("\tAre you a ....");
				System.out.println("\t1.Provider\n\t2.Customer\n\t0.Exit : \nEnter choice");
				ch=sc.nextInt();
				int flag=0;
				int pno=0;
				switch(ch)
				{
				case 1:

					Provider p = new Provider();
					System.out.println(" \t\tRegister / Login");

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
					rs=stmt.executeQuery(q);
					while(rs.next())
					{
						pno=rs.getInt(1);
					}
					p.setprovno(pno);
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
							p.upmenentire(sc, stmt);
							p.displayMENUcall(stmt);
							break;

						case 2:
							//updating a specific menu item
							p.upmen(sc, stmt);
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
								System.out.println("\nPlease enter valid phone number");
							}
						}
						catch(InputMismatchException e){
							System.out.println("\nPlease enter valid phone number ");
							flag=1;
							sc.next();
						}

					}while(Long.toString(tele).length() != 10 || flag==1 || tele<0);

					q="select regno from custdetails where telno = "+tele+"";
					rs=stmt.executeQuery(q);

					if(rs.next()==false)
					{
						c.acceptcust(sc);
						String str=c.sqlquery(int tele);
						stmt.executeUpdate("insert into custdetails "+"values("+str+")");
						System.out.println("\nRegistered successfully!\n");

					}
					else
					{
						System.out.print("\nLogged in successfully\n");
					}
					rs=stmt.executeQuery(q);
					
					if(rs.next())
					{
						regno=rs.getInt(1);
					}
					c.setregno(regno);
					do{

						c.selecprovider(sc, stmt, pr);

						do
						{

							System.out.println("\tDo you want to place another order?\n\t1.Yes \n\t2.No");

							ch1 = sc.nextInt();

						}while(ch1>2 || ch1<1);


					}while(ch1!=2);


					break;

				default:
					System.out.println("\nPlease enter valid choice\n");
					break;

				case 0:
					System.out.println("\n\tThank you!\n");
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
