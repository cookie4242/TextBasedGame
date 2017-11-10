
public class PoisonPotion
{

	private int duration = 5;
	private int effect = -10;
	
	public int getDuration()
	{
		return duration;
	}

	public boolean use(Player player)
	{
		System.out.println("poison.use");
		if (duration <= 0)
		{
			return false;
		}
		else
		{
			player.health += effect;
			duration -= 1; 
			return true;
		}
	}

}


