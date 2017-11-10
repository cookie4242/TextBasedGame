
public class StrengthPotion 
{


	private int duration = 5;
	private int effect = 10;
	
	public int getDuration()
	{
		return duration;
	}

	public boolean use(Player player)
	{
		if (duration <= 0)
		{
			return false;
		}
		else
		{
			duration -= 1; 
			return true;
		}
	}


}
