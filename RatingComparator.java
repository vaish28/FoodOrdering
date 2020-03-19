import java.util.*;
import java.sql.*;
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
