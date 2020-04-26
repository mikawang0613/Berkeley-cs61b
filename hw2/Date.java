import java.io.*;

class Date{
	private int month, day, year;
	private static int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

	public Date(int month, int day, int year ){

		if(!isValidDate(month,day,year)){
			System.out.println("Invalid date");
			System.exit(0);
		}else{
			this.month = month; 
			this.day = day;
			this.year = year;
		}
	}

	// construct a Date object corresponding to the given string
	// should be a string of the form "month/day/year"
	//month must be one or two digits, year between 1 and 4 digits
	public Date(String s){
		String [] dateString = s.split("/");
		int month, day, year;

		month = Integer.parseInt(dateString[0]);
		day = Integer.parseInt(dateString[1]);
		year = Integer.parseInt(dateString[2]);

		if (isValidDate(month, day, year) && dateString.length == 3 && year < 10000){
			this.month = month;
			this.day = day ; 
			this.year = year;
		}else{
			System.out.println("Invalid Date");
			System.exit(0);
		}

	}
	public static boolean isLeapYear(int year){
		if (year%4 == 0 && year%100 != 0){
			return true;
		}else if (year%400 == 0){
			return true;
		}else{
			return false;
		}
	}
	// return the number of days in a given month.
	public static int dayInMonth(int month, int year){
		if (isLeapYear(year) && month == 2){
			return daysInMonth[month - 1] + 1;
		}else{
			return daysInMonth[month - 1];
		}
	}

	//Check whether the given date is valid.
	//return true if and only if month/day/year/ constitute a valid date
	public static boolean isValidDate(int month, int day, int year ){
		if (month < 1 || day > 31 || year < 1){
			return false;
		}else if (day > daysInMonth[month-1]){
			return false;
		}else{
			return true;
		}

	}
	//return a string representation of this date in the form month/day/year
	//The month, day, and year are expressed in full as integers;for example, 
	// 12/7/2006 or 3/21/407
	public String toString(){
		return this.month + "/" + this.day + "/" + this.year;
	}

	//determine whether this Date is before the Date d.
	//return true if and only if this Date is before d. 


	public boolean isBefore(Date d){
		if(this.year < d.year){
			return true;
		}else if (this.year == d.year && this.month > d.month){
			return true;
		}else if (this.year == d.year && this.month == d.month && this.day > d.day){
			return true;
		}else{
			return false; 
		}
	}



	//determine whether this Date is after the Date d.
	// return true if and only if this Date is after d

	public boolean isAfter(Date d){
		if (this.year > d.year){
			return true;
		}else if (this.year == d.year && this.month > d.month){
			return true;
		}else if (this.year == d.year && this.month == d.month && this.day > d.day){
			return true;
		}
		return false;
	}

	//Return the number of this Date in the year
	public int dayInYear(){
		int daysUntilMonth = 0;
		for (int i = 0; i < month; i++) {
			daysUntilMonth += daysInMonth[i];
		}
		if(isLeapYear(this.year) && this.month > 2){
			return daysUntilMonth + this.day + 1;
		}else{
			return daysUntilMonth + this.day;
		}
	}

	//Determine the difference in days between d and this Date. For example, 
	// if this Date is 12/15/2012 and d is 12/14/2012, the difference is 1. 
	// if this Date occurs before d , the result is negative 

	public int difference(Date d){
		int diff = 0 ;
		if(isBefore(d)){
			return -d.difference(this);
		}else{
		 for(int i = d.year; i < year ; i++){
		 	if(isLeapYear(i)){
		 		diff +=366;
		 	}else{
		 		diff += 365;
		 	}
		 }
		 if (this.year == d.year){
		 	diff += (d.dayInYear() - this.dayInYear());
		 }else{
		 	diff += (this.dayInYear() - d.dayInYear());
		 }
		}
		return diff;

	}
	public static void main(String[] argv){
		System.out.println("\nTesting constructors.");
		Date d1 = new Date(1,1,1);
		System.out.println("Date should be 1/1/1: " + d1);
		d1 = new Date("2/4/2");
		System.out.println("Date should be 2/4/2: " + d1);
		// d1 = new Date("2/29/2000");
		// System.out.println("Date shoud be 2/29/2000: " + d1);
		// d1 = new Date("2/29/1904");
		// System.out.println("Date should be 2/29/1904: " + d1);

		d1 = new Date(12, 31, 1975);
    	System.out.println("Date should be 12/31/1975: " + d1);
		Date d2 = new Date("1/1/1976");
		System.out.println("Date should be 1/1/1976: " + d2);
		Date d3 = new Date("1/2/1976");
		System.out.println("Date should be 1/2/1976: " + d3);

		Date d4 = new Date("2/27/1977");
		Date d5 = new Date("8/31/2110");

		System.out.println("\nTesting before and after.");
	    System.out.println(d2 + " after " + d1 + " should be true: " + d2.isAfter(d1));
	    System.out.println(d3 + " after " + d2 + " should be true: " + d3.isAfter(d2));
	    System.out.println(d1 + " after " + d1 + " should be false: " + d1.isAfter(d1));
	    System.out.println(d1 + " after " + d2 + " should be false: " + d1.isAfter(d2));
	    System.out.println(d2 + " after " + d3 + " should be false: " + d2.isAfter(d3));

	    System.out.println(d1 + " before " + d2 + " should be true: " + d1.isBefore(d2));
	    System.out.println(d2 + " before " + d3 + " should be true: " + d2.isBefore(d3));
	    System.out.println(d1 + " before " + d1 + " should be false: " + d1.isBefore(d1));
	    System.out.println(d2 + " before " + d1 + " should be false: " + d2.isBefore(d1));
	    System.out.println(d3 + " before " + d2 + " should be false: " + d3.isBefore(d2));

	    System.out.println("\nTesting difference.");
	    System.out.println(d1 + " - " + d1  + " should be 0: " + d1.difference(d1));
	    System.out.println(d2 + " - " + d1  + " should be 1: " + d2.difference(d1));
	    System.out.println(d3 + " - " + d1  + " should be 2: " + d3.difference(d1));
	    System.out.println(d3 + " - " + d4  + " should be -422: " + d3.difference(d4));
	    System.out.println(d5 + " - " + d4  + " should be 48762: " + d5.difference(d4));

	}
}