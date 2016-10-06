package GroupFiles;

import java.util.Scanner;
public class JimmyCalculator implements Chatbot {

	private boolean inMathLoop;
	private String mathResponse;
	private Scanner input = new Scanner(System.in);
	
	public void talk() {
		inMathLoop = true;
		while (inMathLoop) {
			JimmyMain.print("(Type 'quit' to go back)");
			//static  call on promptInput method from JimmyMain class
			mathResponse = JimmyMain.promptInput();
			if (mathResponse.indexOf("quit") >= 0)  {
				inMathLoop = false;
				JimmyMain.promptForever();
			}
			else if (mathResponse.indexOf("yes") >= 0) {
				JimmyMain.print("Ok, please enter your first number.");
				int firstnum =  input.nextInt();
				System.out.println(firstnum);
			}
			else {
				JimmyMain.print("That answer was good too");				
			}

		}
		
	}


	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"school","class","teacher"};
		for(int i = 0; i< triggers.length; i++) {
			if (JimmyMain.findKeyword(userInput,triggers[i],0)
					>= 0) {
				return true;
			}
			return false;
		}
		///////////////////////////////////////////////////////////////////
		if (JimmyMain.findKeyword(userInput,"school",0)
				>= 0) {
			return true;
		}
		if (JimmyMain.findKeyword(userInput,"class",0) 
				>= 0) {
			return true;
		}
		return false;
	}
	
}