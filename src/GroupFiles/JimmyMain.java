package GroupFiles;

import java.util.Scanner;

public class JimmyMain {
		
		static String response;
		static boolean inMainLoop;
		static Scanner input;
		static String user;
		//list all chatbots available under this class
//		static chatbot school;
		static Chatbot ivan;
		static Chatbot joseph;
		
				
		public static void main(String[] args) {
			//demonstrateStringMethods();
			createField(); 
			promptName();
			//promptInput();
			promptForever();
		}
		
		public static void promptName(){
			print("Hello! I am a chatbot. What is your name?");
			user = input.nextLine();
		}

		public static void promptForever() {
			inMainLoop = true;
			while (inMainLoop){
				print("Hello, " + user + "! May i know what your hobby is?");
				response = promptInput();
				if(findKeyword(response, "good", 0) >= 0){
					print("ayy nice but i dont care.");
				}
				//response to liking school
//				else if(response.indexOf("school") >= 0){
//					print("School is wack. Tell me why you like it.");
//					//exit while loop
//					inMainLoop = false;
//					//go to school's talk method
//					school.talk();
//				}
				else{
					print("Whatchu sayin boi?");
				}
			}
		}

		public static int findKeyword(String searchString, String keyword, int startPos) {
			//deletes white space
			searchString = searchString.trim();
			searchString = searchString.toLowerCase();
			keyword = keyword.toLowerCase();  
			System.out.println("The phrase is " + searchString);
			System.out.println("The keyword is " + keyword);
			//find first position of keyword
			int pos = searchString.indexOf(keyword);
			System.out.println("The keyword was found at " + pos);
			
			//keep searching until keyword found
			while(pos >= 0){
				//assume preceded and followed by space
				String before = "";
				String after = "";
				//check char in front if it exists
				if(pos > 0){
					before = searchString.substring(pos-1, pos);
					System.out.println("The character before is " + before);
					
				}
				//check if there is a char after keyword
				if(pos + keyword.length() < searchString.length()){
					after = searchString.substring(pos + keyword.length(), pos + keyword.length());
					System.out.println("The character after is " + after);
				}
				if(before.compareTo("a") < 0 && after.compareTo("a") < 0 && noNegations(searchString, pos)){
					System.out.println("Found " + keyword + " at " + pos);
					return pos;
				}else{
					//pos+1 is one space after after our current pos, so this finds NEXT word
					pos = searchString.indexOf(keyword, pos+1);
					System.out.println("Did not find " + keyword + ", checking position " + pos);
				}
			}
			
			return -1;
		}

		//"Helper method" - helps larger method. Thus, they are private b/c 
		//they are used only the methods they help. Helps readability.
		//returns true is there are no negation words in front of pos
		private static boolean noNegations(String searchString, int pos) {
			//check to see if no is in front of pos
			//check to see if there are spaces in front
			//then check to see if "no" is there
			if(pos-3 >= 0 && searchString.substring(pos-3,pos).equals("no ")){
				return false;
			}
			//check for not
			if(pos-4 >= 0 && searchString.substring(pos-4,pos).equals("not ")){
				return false;
			}
			//check for never
			if(pos-6 >= 0 && searchString.substring(pos-6,pos).equals("never ")){
				return false;
			}
			//check for n't
			if(pos-4 >= 0 && searchString.substring(pos-4,pos).equals("n't ")){
				return false;
			}
			return true;
		}

		public static String promptInput() {
			String userInput = input.nextLine();
			return userInput;
		}

		public static void createField() {
			input = new Scanner(System.in);
			user = "";
			//initialize group chatbots below
		//	school = new JimmySchool();
		}

		public static void demonstrateStringMethods(){
			String text1 = new String("What's poppin world!"); 
			String text2 = "What's poppin world!"; 			//same as above string var
			
			if(text1.equals(text2)){
				print("These strings are equal:");
			}
			print(text1);
			print(text2);
			
			String word1 = "aardvark";
			String word2 = "NotAardvark";
			
			if(word1.compareTo(word2) < 0){
				print("word1 comes before word2.");
			}
		}
		
		public static void print(String text){
			String printString = "";
			int cutoff = 35;
			//check for words to add
			//IOW text has a length > 0
			while(text.length() > 0){
				String cut = "";
				String nextWord = "";
				//check to see if next word will fit on the line AND
				//there must still be words to add
				while(cut.length() + nextWord.length() < cutoff && text.length() > 0){
					//add the next word to line
					cut += nextWord;
					
					text = text.substring(nextWord.length());
					
					//identify following word w/o space
					int endOfWord = text.indexOf(" ");
					//if there are no more spaces, this is the last word
					if(endOfWord == -1){
						endOfWord = text.length()-1; // -1 is for index
					}
					nextWord = text.substring(0,endOfWord+1);
					
				}
				printString += cut + "\n";
			}
			
			
			/*if (printString.length() > cutoff){
				for(int i = 0; i*cutoff < text.length(); i++){
					printString += getCut(text, cutoff, i+1) + "\n";
				}
			}*/
			System.out.println(printString);
		}
		
		private static String getCut(String text, int cutoff, int cut){
			int cutIndex = cut * cutoff;
			if(cutIndex > text.length()){
				cutIndex = text.length();
			}
			String currentCut = text.substring(0, cutIndex);
			
			int indexOfLastSpace = currentCut.length()-1;
			//start at last index, go backwards
			for(int i = currentCut.length()-1; i >= 0; i--){
				String letter = currentCut.substring(i, i+1);
				if(letter.equals(" ")){
					indexOfLastSpace = i;
					break;
				}
			}
			//shorten cut to end on space
			currentCut = currentCut.substring(0, indexOfLastSpace);
			
			return currentCut;
		}
}
