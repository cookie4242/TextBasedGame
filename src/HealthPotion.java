
public class HealthPotion 
{
	private int duration = 1;
	private int effect = 30;
	
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
			player.health += effect;
			duration -= 1; 
			return true;
		}
	}

}
