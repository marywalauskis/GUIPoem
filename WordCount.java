package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class WordCount {

	String name;
	public void setFileName(String poemName) {
		name = poemName;
	}
	
	public String getFileName() {
		return name;
	}

	public String wordCount() {

		
		String fileName = null;
		String displayNameAndCount = null;
		String charCountToString;
		String wordCountToString;
		String lineCountToString;
		int charCount = 0; 
        int wordCount = 0;
        int lineCount = 0;
		
		if( getFileName().equals("raven")) {
			fileName = "theRaven.txt";
		}
		else if(getFileName().equals("bells")) {
			fileName = "theBells.txt";
		}
		else if(getFileName().equals("dream")) {
			fileName = "aDreamWithinADream.txt";
		}
		else {
			fileName = "annabelLee.txt";
		}
		
		
		 HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();

	     BufferedReader reader = null;
	        try{
	            //Creating BufferedReader object
	        	reader = new BufferedReader(new FileReader(fileName));

	            //Reading the first line into currentLine
	            String currentLine = reader.readLine();
	            while (currentLine != null) {   
	            	 //Updating the lineCount
	                lineCount++;
	                 
	                //Getting number of words in currentLine
	                String[] words = currentLine.split("\\W+");
	                 
	                //Updating the wordCount
	                wordCount = wordCount + words.length;
	                 
	                //Iterating each word
	                for (String word : words)
	                {
	                    //Updating the charCount   
	                    charCount = charCount + word.length();
	                }
	                 
	                //Reading next line into currentLine
	                currentLine = reader.readLine();
	            }
	             
	            //Printing charCount, wordCount and lineCount
	            charCountToString = String.valueOf(charCount);
	            wordCountToString = String.valueOf(wordCount);
	         // minus two because the first two line are the author and title
	            lineCountToString = String.valueOf(lineCount - 2); 
	            
	            displayNameAndCount = "There are \n" + charCountToString + "\n characters in the poem.\n\n"
	            		+ "There are \n" + wordCountToString + "\n words in the poem.\n\n" + "There are \n"
	            		+ lineCountToString + "\n lines in the poem.";
	            
	        } catch (IOException e) 
	        {
	            e.printStackTrace();
	        }finally
	        {
	            try
	            {
	                reader.close();           //Closing the reader
	            } catch (IOException e) 
	            {
	                e.printStackTrace();
	            }
	        }
			return displayNameAndCount;
	}}