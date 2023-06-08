package Contact;

import java.util.*;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;
import java.sql.*;
public class Contact_back {
	static Scanner s = new Scanner(System.in);
	static int x;
public static void main(String[] args) {

		// 1.load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2get the connection
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact?user=root&password=root");
			// 3.create statement
			Statement sc = c.createStatement();

			System.out.println("1.if you want to store new contact  press\"1\"");
			System.out.println();
			System.out.println("2.if you want search the contact  please \"2\" ");
			System.out.println();
			System.out.println("3.if you want to Delete contact  press\"3\"");
			System.out.println();
			System.out.println("4.if you don't want any activity  press 4 ");

			int inp = s.nextInt();
			switch (inp) {
			case 1:
				do {
					{
						try {
							System.out.println("enter the Mobile_number");
							Long l = s.nextLong();
							System.out.println("enter the contact name");
							String n = s.next();
							if (n != null) {
								sc.executeUpdate("insert into contact values('" + n + "'," + l + ")");
								System.out.println("the contact saved successfully...!");
							} else {
								System.out.println("invalid data->check your Number (or) Name");
							}
						} catch (Exception e) {
							System.out.println("This Contact is  already Exist ");
						}
						System.out.println();
						System.out.println("notification:");
						System.out.println("if you want store again press 1");
						System.out.println("if you don't want store again press 2");
						x = s.nextInt();
					}
				} while (x == 1);
				break;
			case 3:
				do {
					
					{
						try {
							System.out.println("type to which contact you deleted enter the name or ph_no");
							System.out.println();
							System.out.println("1.Deleted by name means press 1\n2.Delete by number means press 2\n3.Delete all contact please press 3");
							int in = s.nextInt();
							if (in == 1) {
								System.out.println("enter the name");
								String n = s.next();
								if (n != null) {
									sc.executeUpdate("DELETE FROM CONTACT WHERE NAME='" + n + "'");
									System.out.println("contact deleted");
								} else {
									System.out.println("enter the valid name");
								}

							} else if(in==2) {
								System.out.println("enter the number");
								Long num = s.nextLong();
								if (num != 0) {
									sc.executeUpdate("DELETE FROM CONTACT WHERE ph_no=" + num + "");
									System.out.println("contact deleted");
								} else {
									System.out.println("enter the valid number");
								}

							}else {
								System.out.println("!!!!important note: "
								+ "Your Records permanently deleted from your storage!!!");
								System.out.println("If you Confirm Means press 1");
								System.out.println("If you want Exit press 2");
								int d= s.nextInt();
								 if (d==1) {
									sc.executeUpdate("truncate table contact.contact");
									System.out.println("contact delted successfully..");
								       // sc.executeQuery("truncate table contact.contact");
								}else {
									System.out.println("Your data is saved...\2");
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("Invalid data");
						}
						System.out.println();
						System.out.println("notification:");
						System.out.println("if you want delete more contacts press 1");
						System.out.println("if you don't want delete more contacts press 2");
						x = s.nextInt();
					}
				} while (x == 1);
				break;
			case 2:
				do {
					{
						try {
							System.out.println(
									"1.you want all Contact Details press 1\n2.search by name means press 2\n3.search by number means press 3");
							int in = s.nextInt();
							if (in == 1) {
								ResultSet res = sc.executeQuery("select * from contact order by name");

								System.out.println("name\t\tph_no");
								while (res.next()) {
									Long ph_no = res.getLong("ph_no");
									String name = res.getString("name");
									
									System.out.println(name + "\t\t" + ph_no);
								}
							} else if (in == 2) {
								System.out.println("enter the name");
								String na = s.next();
								ResultSet res = sc.executeQuery("Select * from contact where name like'%" + na + "%'");

								if (!res.next()) {
									System.out.println("result not matched");
								} else {
									System.out.println("name\tph_no");
									do {
										Long ph_no = res.getLong("ph_no");
										String name = res.getString("name");
										System.out.println(name + "\t" + ph_no);
									} while (res.next());
								}
							} else {
								System.out.println("enter the number");
								Long nu = s.nextLong();
								ResultSet res = sc.executeQuery("Select * from contact where ph_no='" + nu + "'");
								if (!res.next()) {
									System.out.println("result not matched");
								} else {
									System.out.println("name\tph_no");
									do {
										Long ph_no = res.getLong("ph_no");
										String name = res.getString("name");
										System.out.println(name + "\t" + ph_no);
									} while (res.next());
								}
							}
						} catch (Exception e) {
							System.out.println("The Invalid data");
						}
						System.out.println();
						System.out.println("notification:");
						System.out.println("if you want get another contacts details press 1");
						System.out.println("if you don't get another contacts details press 2");
						x = s.nextInt();
					}
				} while (x == 1);
				break;
			default: {
				   System.out.println("\"Thank you for using the Contacts page\"");
				   }
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
