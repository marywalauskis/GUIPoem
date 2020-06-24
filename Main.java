package application;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	
	HBox poemChoice;
	TitledPane titlePane;
	RadioButton theRaven, annabelLee, aDreamWithinADream, theBells;
	ToggleGroup poemGroup;
	TextField choice;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		//Variables for landing window
		Label name = new Label("Edgar Allan Poe - Poem Analyzer");
		HBox titleHBox = new HBox();
		titleHBox.setAlignment(Pos.CENTER);
		name.setFont(Font.font("Comic Sans", FontWeight.BOLD, 20));
		
		///instructional text for each section
		Label words = new Label("Learn about each poem! See how many characters, lines and words each poem has.");
		words.setFont(Font.font("Comic Sans", 17));
		Label display = new Label("Select the poem you would like to read.");
		display.setFont(Font.font("Comic Sans", 17));
		Label search = new Label("Search for a word.");
		search.setFont(Font.font("Comic Sans", 17));
		
		//Creating poem section for selection
		poemGroup = new ToggleGroup();
		theRaven = new RadioButton("The Raven");
		theRaven.setToggleGroup(poemGroup);
		annabelLee = new RadioButton("Annabel Lee");
		annabelLee.setToggleGroup(poemGroup);
		aDreamWithinADream = new RadioButton("A Dream Within a Dream");
		aDreamWithinADream.setToggleGroup(poemGroup);
		theBells = new RadioButton("The Bells");
		theBells.setToggleGroup(poemGroup);
		
		poemChoice = new HBox(50);
		poemChoice.getChildren().addAll(theRaven, annabelLee, aDreamWithinADream, theBells);
		
		//Adding Radio Buttons to the pane
		titlePane = new TitledPane("Poems", poemChoice);
		titlePane.setCollapsible(false);
		titlePane.setPrefHeight(75);
		
		//Variables for poem display from buttons
		HBox bottomButtonHBox;
		Label buttonTitleHBox;
		Button theRaven, annabelLee, aDreamWithinADream, theBells;
		TextArea poemDisplay;
		
		//initalize 
		poemDisplay = new TextArea();
		
		theRaven = new Button("The Raven");
		annabelLee = new Button("Annabel Lee");
		aDreamWithinADream = new Button("A Dream Within A Dream");
		theBells = new Button("The Bells");
		
		//initalize bottomButtonHBox and add children
		bottomButtonHBox = new HBox(50);
		bottomButtonHBox.setPadding(new Insets(10, 10, 10, 10));
		bottomButtonHBox.setSpacing(10);
		bottomButtonHBox.getChildren().addAll(theRaven, annabelLee, aDreamWithinADream, theBells);
		
		
		//initalize bottom HBox for word search and add children
		HBox wordSearch = new HBox();
		wordSearch.setPadding(new Insets(10, 10, 10, 10));
		wordSearch.setSpacing(10);
		
		TextField wordSearchEntry;
		Button wsRaven, wsBells, wsAnnabel, wsDream;
		
		wordSearchEntry = new TextField();
		wsRaven = new Button("The Raven");
		wsBells = new Button("The Bells");
		wsAnnabel = new Button("Annabel Lee");
		wsDream = new Button("A Dream Within A Dream");
		
		wordSearch.getChildren().addAll(wordSearchEntry, wsRaven, wsAnnabel, wsDream, wsBells);
		
		
		//////Button actions to display each poem
		theRaven.setOnAction(e -> {
			poemDisplay.clear(); //clear text area from other button clicks
			
			File file = new File("theRaven.txt");
			Scanner scan;
			try {
				scan = new Scanner(file);
				
				while(scan.hasNext()) {
					String line = scan.nextLine();
					poemDisplay.appendText(line + "\n ");
				}
				
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
		});
		
		annabelLee.setOnAction(e -> {
			poemDisplay.clear(); //clear text area from other button clicks
			
			File file = new File("annabelLee.txt");
			Scanner scan;
			try {
				scan = new Scanner(file);
				
				while(scan.hasNext()) {
					String line = scan.nextLine();
					poemDisplay.appendText(line + "\n ");
				}
				
			} catch (FileNotFoundException e3) {
				e3.printStackTrace();
			}
		});
		
		theBells.setOnAction(e -> {
			poemDisplay.clear(); //clear text area from other button clicks
			
			File file = new File("theBells.txt");
			Scanner scan;
			try {
				scan = new Scanner(file);
				while(scan.hasNext()) {
					String line = scan.nextLine();
					poemDisplay.appendText(line + "\n ");
				}
				
			} catch (FileNotFoundException e4) {
				e4.printStackTrace();
			}
		});
		
		aDreamWithinADream.setOnAction(e -> {
			poemDisplay.clear(); //clear text area from other button clicks
			
			File file = new File("aDreamWithinADream.txt");
			Scanner scan;
			try {
				scan = new Scanner(file);
				
				while(scan.hasNext()) {
					String line = scan.nextLine();
					poemDisplay.appendText(line + "\n ");
				}
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		
		
		//Variables for new window
		TextArea wordCountDisplay = new TextArea();
		HBox buttonHBox;
		//Label output;
		
		//Window to display WordCount results
		HBox layoutTwo = new HBox(200);
		layoutTwo.setPrefSize(500, 500);
		
		wordCountDisplay.setPrefSize(200, 200);
		Scene newScene = new Scene(layoutTwo);
		
		//Button to go back to original window
		Button homeButton = new Button("Return");
		homeButton.setPrefHeight(45);
		homeButton.setPrefWidth(90);
		
		layoutTwo.getChildren().addAll(wordCountDisplay, homeButton);
		/////////End of second window
		
		
		
		//Window to display WordSearch results
		//Variables for new window
		Label wordSearchDisplay = new Label();
		HBox layoutWordSearch = new HBox(400);
		layoutWordSearch.setPrefSize(500, 500);
		
		layoutWordSearch.setPrefSize(200, 200);
		Scene wordSearchScene = new Scene(layoutWordSearch);
		
		// need to make new home button
		layoutWordSearch.getChildren().add(wordSearchDisplay);
		
	
		//Button to open new window with selected poem choice
		Button selectNewWindowButton;
		
		selectNewWindowButton = new Button("Select");
		selectNewWindowButton.setPrefHeight(45);
		selectNewWindowButton.setPrefWidth(95);
		
		selectNewWindowButton.setOnAction(e -> {
			try {
				wordCountDisplay.setText(SubmitChoice());
				//wordCountDisplay.setWrapText(SubmitChoiceAnalyzer()); //add textanalyzer
				primaryStage.setScene(newScene);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		buttonHBox = new HBox(50);
		buttonHBox.setPadding(new Insets(10, 10, 10, 10));
		buttonHBox.setSpacing(10);
		
		
		buttonHBox.getChildren().addAll(selectNewWindowButton);
		
		
		///process word in text field on button click
		wsRaven.setOnAction(e -> {
			String r = "raven";
			
			wordSearchDisplay.setText(getSearchResults(r, wordSearchEntry.getText()));
			primaryStage.setScene(wordSearchScene);
		});
				
		wsBells.setOnAction(e -> {
			String r = "bells";
			
			wordSearchDisplay.setText(getSearchResults(r, wordSearchEntry.getText()));
			primaryStage.setScene(wordSearchScene);
		});
		
		wsAnnabel.setOnAction(e -> {
			String r = "annabel";
			
			wordSearchDisplay.setText(getSearchResults(r, wordSearchEntry.getText()));
			primaryStage.setScene(wordSearchScene);
		});
		
		wsDream.setOnAction(e -> {
			String r = "dream";
			
			wordSearchDisplay.setText(getSearchResults(r, wordSearchEntry.getText()));
			primaryStage.setScene(wordSearchScene);
		});
				
		//Varibales for Main display scene
		VBox main;
		Scene scene;
		
		///////Original Display Scene
		main = new VBox(10);
		main.setPadding(new Insets(20));
		main.getChildren().addAll(name, words, titlePane, buttonHBox, display, bottomButtonHBox, poemDisplay, search, wordSearch);
		
		scene = new Scene(main);
		primaryStage.setTitle("Poem Analyzer");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		////Return button to go back to original window
		homeButton.setOnAction(e -> primaryStage.setScene(scene));
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

	public String SubmitChoice() throws IOException {
		String holder;
		String raven = "raven";
		String annabel = "annabel";
		String bells = "bells";
		String dream = "dream";
		
		WordCount wc = new WordCount();
		
		if(theRaven.isSelected()) {
			wc.setFileName(raven);
			holder = wc.wordCount();
			System.out.println(holder);
			return holder;
		}
		if(annabelLee.isSelected()) {
			wc.setFileName(annabel);
			holder = wc.wordCount();
			System.out.println(holder);
			return holder;
		}
		if(theBells.isSelected()) {
			wc.setFileName(bells);
			holder = wc.wordCount();
			System.out.println(holder);
			return holder;
		}
		if(aDreamWithinADream.isSelected()) {
			wc.setFileName(dream);
			holder = wc.wordCount();
			System.out.println(holder);
			return holder;
		}
		return "";
	}
	
	public String getSearchResults(String n, String w) {
		String holder = null;
		
		WordSearch search = new WordSearch();
		search.setFileName(n);
		search.setWord(w);
		try {
			holder = search.wordSearch();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(holder);
		return holder;
	}
	/*
	public String SubmitChoiceAnalyzer() {
		TextAnalyzer ta = new TextAnalyzer();
		String array = null;
		 Map<String, Integer> wordMap = ta.getWordCount("theRaven.txt");

	        List<Entry<String, Integer>> list = ta.sortByValue(wordMap);

	        for(Map.Entry<String, Integer> entry:list){

	        String[] arr = new String[20]; //needs to only output top 20 elements
	        
	        	if(entry.getValue() >= 8) {
	        	
	            System.out.println(entry.getKey()+" : "+entry.getValue());
	        	}
	        }
		return wordMap.keySet().toArray();
		
	}*/
	
}
