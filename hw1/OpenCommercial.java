
// java.io include the InputStreamReader and BufferedReader classes
// java.net gets URL
import java.net.*;
import java.io.*;

// prompts the user for the name X of company

class OpenCommercial{
	public static void main(String[]args) throws Exception{
		BufferedReader keyboard;
		String inputLine;

		// system.out print to screen 
		// system.in read from the keyboard 
		// readline is in bufferedreader
		keyboard = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Please enter the name of a company(without spaces):");
		// System.out.flush(); // the line is printed immediately
		inputLine = keyboard.readLine();


		// inputStream objects read raw data, but don't format the data
		// inputStreamReader compose raw data into characters
		URL u = new URL("http://" + inputLine + ".com/");
		// url.openStream() initiates a new TCP connection.Need to connect first in order to read.
		InputStream ins = u.openStream();
		// after connected, now can read the file.
		// An InputStreamReader is a bridge from byte streams to 
		// character streams: It reads bytes and decodes them into characters using a specified charset.
		InputStreamReader isr = new InputStreamReader(ins);
		// compose the character into entire line of text
		BufferedReader web = new BufferedReader(isr);



		String web1 = web.readLine();
		String web2 = web.readLine();
		String web3 = web.readLine();
		String web4 = web.readLine();
		String web5 = web.readLine();

		System.out.println(web5);
		System.out.println(web4);
		System.out.println(web3);
		System.out.println(web2);
		System.out.println(web1);


	}

}
