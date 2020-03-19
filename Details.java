import java.util.*;
import java.sql.*;

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
