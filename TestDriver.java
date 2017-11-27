//Test Driver program for Database.java

import java.util.*;
import java.sql.*;

public class TestDriver
{
	public static void main(String args[]) throws SQLException
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your Oracle username:");
		String username = scan.nextLine();
		System.out.println("Enter your Oracle password:");
		String password = scan.nextLine();
		Database db = null;
		try
		{
			db = new Database(username, password);
		}
		catch(SQLException e1)
		{
			System.out.println("Error when logging in");
			System.exit(0);
		}

		//Test user creation
		db.createUser("695", "John", "slfslj", "5-May-1987", "yy220@pitt.edu");
		System.out.println("Successfully created new user");

		//Test login
		if(db.loginUser("695", "slfslj"))
			System.out.println("Logged in");
		else
			System.out.println("Not logged in");

		//Test friend request generation
		db.initiateFriendship("1", "695");

		db.closeDB();
	}
}