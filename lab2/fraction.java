import java.io.*;

class Fraction{
	private int numberOfFraction = 0;

	private int numerator; //must be nonnegative n < 0
	private int denominator; // must be positive n < 1


	// Check to see if n is nonnegative and d is positive
	//After checking and the condition is true, set n to numerator, set d to denominator
	public Fraction(int n, int d){
		if (n < 0){
			System.out.println("Fatal error: Negative numerator.");
			System.exit(0);

		}

		if (d < 1){
			System.out.println("Fatal error: Nonpositive denominator.");
			System.exit(0);
		}
		numberOfFraction++;
		numerator = n ; 
		denominator = d;
	}
	//constructs a Fraction n/1
	public Fraction(int n){
		this(n,1);
	}

	//constructs a Fraction 0/1

	public Fraction(){
		numberOfFraction++;
		numerator = 0; 
		denominator = 1; 
	}
	//copies the fraction "original"
	public Fraction(Fraction original){
		numberOfFraction++;
		numerator = 0;
		denominator = 1;
	}

	//convert this Fraction to a string format: "numerator/denominator"
	//Fraction should be printed in reduced form
	//*************************//

	public String toString(){
		int thisGcd = gcd(numerator, denominator);

		return (numerator/thisGcd + "/" + denominator / thisGcd);
	}
	//return the sum of two fractions

	public Fraction add(Fraction f2){
		Fraction r = new Fraction((numerator * f2.denominator) + (f2.numerator * denominator),(denominator * f2.denominator));

		return r; 
	}
	// Replace this Fraction's numerator with a new value
	//numerator is a new numerator. 

	public void changeNumerator(int numerator){
		if(numerator < 0){
			System.out.println("Fatal error: Negative numerator");
			System.exit(0);
		}
		this.numerator = numerator;
	}
	//return the number of Fraction objects in existence.

	public int fracs(){
		return numberOfFraction;
	}
	//Compute the greatest common divisor of the two input 

	static private int gcd(int x, int y){
		if (y == 0){
			return x;
		}

		return gcd(y, x % y);
	}
	//put the Fraction class through some tests.

	public static void main(String[]argv){
		Fraction f0 = new Fraction();
		Fraction f1 = new Fraction(3);
		Fraction f2 = new Fraction(12, 20);
		Fraction f3 = f2;

		System.out.println("\n Testing constructors and toString():");
		System.out.println("The fraction f0 is: " + f0.toString());
		System.out.println("The fraction f1 is: " + f1);
		System.out.println("The fraction f2 is: " + f2);
		System.out.println("The fraction f3 is: " + f3 + ",which should equals to f2");

		//Test the add method
		System.out.println("\n Testing add:");


		Fraction sumOfTwo = f1.add(f2);
		Fraction sumOfThree = sumOfTwo.add(f0);


		System.out.println("The sum of  " + f1 + "and " + f2 + " is: " + sumOfTwo);
		System.out.println("The sum of " + f0 + ", " + f1 + " and " + f2 + " is " + sumOfThree);

		//Test the methods used in part 3
		System.out.println("\nTesting changeNumerator and fracs:");

		f3.changeNumerator(7);
		System.out.println("Now f3 is " + f3 + ", which should be 7/20");
    	System.out.println("The total number of Fraction objects is " + f3.fracs());

    	//Test gcd function 
    	System.out.println("\nTesting gcd:");
	    System.out.println("The gcd of 2 and 10 is: " + gcd(2, 10));
	    System.out.println("The gcd of 15 and 5 is: " + gcd(15, 5));
	    System.out.println("The gcd of 24 and 18 is: " + gcd(24, 18));
	    System.out.println("The gcd of 10 and 10 is: " + gcd(10, 10));
	    System.out.println("The gcd of 21 and 400 is: " + gcd(21, 400));

	}

}