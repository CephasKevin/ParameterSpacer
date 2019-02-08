package paramSpacer;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class paramSpacer {

	private static ArrayList<Character> arrayOfChars = new ArrayList<Character>();
	
	private static void paramSpacingOff()
	{
		  for(int x = 0; x < arrayOfChars.size(); x++)
			 {
		    	if(arrayOfChars.get(x).compareTo(')') == 0 && arrayOfChars.get(x - 1).compareTo(' ') == 0)//find all the occurrences of ')'
		    	{
		    		//If there is a space behind the closing bracket then remove it
		    		arrayOfChars.remove(x -1);
		    	}
		    	else if(arrayOfChars.get(x).compareTo('(') == 0 && arrayOfChars.get(x + 1).compareTo(' ') == 0)//find all the occurrences of ')'
		    	{
		    		
		    		//If there is a space after the opening bracket then remove it
		    		arrayOfChars.remove(x + 1);
		    	}
			 }
	}
	
	private static void paramSpacingOn()
	{
		for(int x = 0; x < arrayOfChars.size(); x++)
		{
			if(arrayOfChars.get(x).compareTo(')') == 0 && arrayOfChars.get(x - 1).compareTo(' ') != 0 && arrayOfChars.get(x - 1).compareTo('(') != 0)//find all the occurrences of ')'
	    	{
	    		//If there isn't a space behind the closing bracket then add one
	    		arrayOfChars.add(x, ' ');
	    	}
	    	else if(arrayOfChars.get(x).compareTo('(') == 0 && arrayOfChars.get(x + 1).compareTo(' ') != 0 && arrayOfChars.get(x + 1).compareTo(')') != 0)//find all the occurrences of ')'
	    	{
	    		//If there isn't a space after the opening bracket then add one
	    		arrayOfChars.add(x + 1, ' ');
	    	}
		}
	}
		
	
	public static void main(String[] args) throws IOException
	{
		
	    FileReader fr = 
	      new FileReader("randomCsharpCode2.txt"); 
	  
	    int i; 
	    while ((i=fr.read()) != -1)
	    {		      	    
	      arrayOfChars.add((char) i);
	    }
	    
	    fr.close();
	    
	    System.out.print("File has been read in successfully\nWould you like parameter spacing in your code?\n");
	    
	    String paramChoice = "";
	    
	    Scanner inputScanner = new Scanner(System.in);
	    
	    paramChoice = inputScanner.nextLine();//Take user input and pass it into a string
	    
	    inputScanner.close();
	    
	    
	    if(paramChoice.equals("yes"))
	    {
	    	paramSpacingOn();
	    }
	    else if(paramChoice.equals("no"))
	    {
	    	paramSpacingOff();	    	
	    }
	    
	    //After formatting print out the final array
	    for(int x = 0; x < arrayOfChars.size(); x++)
		{
	    	System.out.print(arrayOfChars.get(x));
		}
	    	     
	}

}