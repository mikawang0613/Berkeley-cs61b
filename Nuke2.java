import java.io.*;

class Nuke2{
	// read a string from the keyboard and print the same string 

	public static void main(String[]args) throws Exception{
		

		// read from the keyboard
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Please type a word in:");
		System.out.flush();
		String word = keyboard.readLine();

		
		String newWord;
		newWord = word.substring(0,1) + word.substring(2);
		System.out.println("Print the word with 2 letter removed:" + newWord);


	}

}