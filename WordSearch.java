package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordSearch {
	
	String name, word;
	String fileName = null;

	public void setFileName(String poemName) {
		name = poemName;
	}
	
	public String getFileName() {
		return name;
	}

	public void setWord(String inputWord) {
		word = inputWord;
	}
	
	public String getWord() {
		return word;
	}
	
	
	public String wordSearch() throws IOException {

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
	
	File f1 = new File(fileName); //Creation of File Descriptor for input file
    String[] words = null;  //Intialize the word Array
    FileReader fr = new FileReader(f1);  //Creation of File Reader object
    BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
    String s;     
    String input = word;   // Input word to be searched
    String result, displayResult = null;
    int count = 0;   //Intialize the word to zero
    while((s = br.readLine()) != null)   //Reading Content from the file
    {
        words=s.split(" ");  //Split the word using space
        for (String word : words) 
        {
               if (word.equals(input))   //Search for the given word
               {
                 count++;    //If Present increase the count by one
               }
               System.out.println(count);
               
       		if (count > 0) {
       			result = String.valueOf(count);
       			displayResult = "There were " + count + " occurences of the word of your word!";
       		}
       		else {
       			displayResult = "Your word was not found";
       		}
       				
        }
    }
       try {
		fr.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return displayResult;
	
 }
	
}

