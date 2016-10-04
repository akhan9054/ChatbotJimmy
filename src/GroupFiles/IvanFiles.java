package GroupFiles;

	
public class IvanFiles implements Chatbot{
	private int response;
	private boolean inBookLoop;
	public String Novel;
	public String[] Yes = {" What is your favorite genre?"+ "..."
			
	};
	public String[] No = { " Why? " };

	public void talk(){
		
	}
	public boolean isTriggered(String userInput) {
		if(JimmyMain.findKeyword(userInput, "Book", 0)>=0){
			return true;
		}
		return false;
	}

}
