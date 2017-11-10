import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager 
{
	public String getStringInput(String consolePrompt)
	{
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
	    try {
			System.out.print(consolePrompt);
			return in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    return "";
	}
	
	public static int getIntInput(String consolePrompt)
	{
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		try {
			System.out.print(consolePrompt);
			return Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public String getPlayerOneName()
	{
		return getNameInput("Player One Name:");
	}
	
	
	public String getPlayerTwoName(String name)
	{

		String PlayerName = "";
		boolean validname = false;
		
		while(!validname)
		{
			PlayerName = getNameInput("Player Two Name:");
			
			if (PlayerName.equals(name))
				System.out.println("sorry that name was the same as the other name ");
			else
				break;
		}
		
		return PlayerName;
	}

	private String getNameInput(String prompt)
	{
		String PlayerName = "";
		boolean validname = false;
		
		
		while(!validname)
		{
			PlayerName = getStringInput(prompt);
			
			if (PlayerName.length() < 1)
			{
				System.out.println("sorry that name was to short ");
			}
			else
			{
				validname = true;
			}
		}
		
		return PlayerName;
		
	}
	
	
	public int ValidOptions(String Options)
	{
		String keystroke = "";
		Boolean goodAnswer = false;
		
		while (!goodAnswer)
		{
			keystroke = getStringInput("Enter a valid option:");
		
			
			if(Options.contains(keystroke) && keystroke.length() == 1)
				{
					goodAnswer = true;
			
				}
			else
		        System.out.println(keystroke +" was not a valid choice. \n");
		}
		
		return Integer.parseInt(keystroke);
	}
	
}
