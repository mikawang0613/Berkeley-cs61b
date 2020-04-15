import java.io.*;

public class Names{
	public static void main(String[]args){
		String first = "John";
		String middle = "Fitzgerald";
		String last = "Kennedy";
		String initials;
		String firstInit,middleInit,lastInit;

		firstInit = first.substring(0,1);
		middleInit = middle.substring(0,1);
		lastInit = last.substring(0,1);
		initials = firstInit.concat(middleInit);
		initials = initials.concat(lastInit);

		System.out.println();
		System.out.println(first + " " + middle + " "+ last);
		System.out.println(initials);
		System.out.println(first.toUpperCase() + " " + last.toUpperCase());

		// Perform various string operations on the name John Fitzgerald Kennedy.
		System.out.println(first + "equals john is " + first.equals("john"));
		System.out.println(first + "equals john (ignoring case) is" + first.equalsIgnoreCase("john"));
		System.out.println("The Character at index 3 in " + middle + "is" + middle.substring(3,4));
		System.out.println("The index of \"gerald\" within" + middle + "is " + middle.indexOf("gerald"));
		System.out.println("The index of \"gerald\" within " + last + "is " + last.indexOf("gerald"));

		System.out.println();


	}
}