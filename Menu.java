package fooddelivery;
import java.util.*;
import java.sql.*;

enum days
{
	Mon,Tues,Wed,Thur,Fri,Sat,Sun
}
enum menuItems
{
	Gravy ,Dry_veg , Chapati , Sides , Rice ,Special 
}
class Menu
{
	void acceptMenu(Scanner sc,Statement stmt , int flag,int provno)
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
					stmt.executeUpdate("insert into menu values ("+provno+",'"+d[i]+"',"+fitem0+")");
				}
				else if(flag == 1)
				{
					String s="update menu set "+fitem1+" where Day='"+d[i]+"'and pno="+provno;

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
			String str="update menu set "+mi+"='"+it+"' where Day='"+day+"' and pno="+provno;
			//System.out.println(str);
			st.executeUpdate(str);
			System.out.println("Menu updated!!");
		}
		catch(Exception e)
		{
			System.out.println("Exception!");
		}
	}	
	void displayMenu(Statement stmt,int provno)
	{
		
		days d[]=days.values();
		menuItems m[]=menuItems.values();
		System.out.print("\t");
		for(int i=0;i<m.length;i++)
		{
			System.out.print(m[i]);
			System.out.print("    ");
		}
		System.out.println();
		try
		{
		ResultSet rs = stmt.executeQuery("select * from menu where pno = "+provno);
		int cnt =0;
		while(rs.next())
		{
			System.out.print(d[cnt]+"\t");
			cnt++;
			for(int i=0;i<m.length;i++)
			{
				String key = m[i].toString();
				String val = rs.getString(key);
				System.out.print(val);
				System.out.print("\t");
			}
			System.out.println();
		}
		
		}
		catch(SQLException e)
		{
			System.out.println("Exception in display menu");
		}
		
	}
}
