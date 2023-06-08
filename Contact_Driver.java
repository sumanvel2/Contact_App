package Contact;
import java.util.Scanner;
public class Contact_Driver {
	static Scanner s=new Scanner(System.in);
   public static void main(String[] args) {
	   int x;
	System.out.println("\t\"Welcome To Contact List");
	System.out.println();
	do{System.out.println("Select which Activity u want:");
	Contact_back.main(args);
	System.out.println();
	System.out.println("Final Notification:");
	System.out.println("If you want use again the Contact page press \"1\"");
	System.out.println("If you don't  want use again the Contact page press \"2\"");
	x = s.nextInt();
	 }while(x==1);
	 System.out.println();  
	 System.out.println("\t\t\3\3Thank you!\3\3");
}
}

