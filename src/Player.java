
public class Player
{	
	public String name;
	public int health;
	public int move;
	public int[] healthPotionsOLD = new int [3] ;
	public HealthPotion[] healthPotions;
	public PoisonPotion[] poisonPotions;
	public StrengthPotion[] StrengthPotions;
	public int numberOfStrengthPotion;
	public int numberOfPoisonPotion;
	public int numberOfHealthPotion;
	public int numberOfHealthPotionsLeft;
	public int numberOfPoisonPotionsLeft;
	public int numberOfStrengthPotionLeft;
	public PoisonPotion activePoisonPotion;
	public StrengthPotion activeStrengthPotion;
	
	public Player()
	{
		health = 100;
		numberOfStrengthPotion = 3; 
		numberOfPoisonPotion = 3; 
		numberOfHealthPotion = 3;
		numberOfHealthPotionsLeft = 3;
		numberOfPoisonPotionsLeft = 3;
		numberOfStrengthPotionLeft = 3;
	
		healthPotions = new HealthPotion[numberOfHealthPotion];
		for (int i = 0; i < numberOfHealthPotion; i++)	
			healthPotions[i] = new HealthPotion();
		
		poisonPotions = new PoisonPotion[numberOfPoisonPotion];
		for (int i = 0; i < numberOfPoisonPotion; i++)	
			poisonPotions[i] = new PoisonPotion();
		
		StrengthPotions = new StrengthPotion[numberOfStrengthPotion];
		for (int i = 0; i < numberOfStrengthPotion; i++)	
			StrengthPotions[i] = new StrengthPotion();
	}
	
	public boolean healthPotionLeft()
	{	
		for(int i = 0 ;i < numberOfHealthPotion ; i++)
		{
			if (healthPotions[i] != null)
				return true;
		}
		
		return false;
	}
	
	
	public HealthPotion getNextHealthPotion()
	{
		
		for(int i = 0 ;i < numberOfHealthPotion ; i++)
		{
			if (healthPotions[i] != null)
			{
				HealthPotion potion = healthPotions[i];
				healthPotions[i] = null;
				numberOfHealthPotionsLeft --;
				return potion;
			}
			
		}
		
		return null;
	}
	
	public boolean poisonPotionsLeft()
	{	
		for(int i = 0 ;i < numberOfPoisonPotion ; i++)
		{
			if (poisonPotions[i] != null)
				return true;
		}
		
		return false;
	}
	
	public PoisonPotion getNextPoisonPotion()
	{
		
		for(int i = 0 ;i < numberOfPoisonPotion ; i++)
		{
			if (poisonPotions[i] != null)
			{
				System.out.println("the " + i + "slot of posion potion being used");
		
				PoisonPotion Ppotion = poisonPotions[i];
				poisonPotions[i] = null;
				numberOfPoisonPotionsLeft --;
				return Ppotion;
			}
			
		}
		
		return null;
	}
	
	public boolean strengthPotionLeft()
	{	
		for(int i = 0 ;i < numberOfStrengthPotion ; i++)
		{
			if (StrengthPotions[i] != null)
				return true;
		}
		
		return false;
	}
	
	public StrengthPotion getNextStrengthPotion()
	{
		
		for(int i = 0 ;i < numberOfStrengthPotion ; i++)
		{
			if (StrengthPotions[i] != null)
			{
				System.out.println("the " + i + "slot of Strengthposion potion being used");
		
				StrengthPotion spotion = StrengthPotions[i];
				StrengthPotions[i] = null;
				numberOfStrengthPotionLeft --;
				return spotion;
			}
			
		}
		
		return null;
	}
	
	public void potionCheck()
	{
		if (activePoisonPotion != null)
		{
			activePoisonPotion.use(this);
		}
		
		if (activeStrengthPotion != null)
		{
			activeStrengthPotion.use(this);
		}
	}
	
	public String toString()
	{
		String divider = "#######################################\n";
		String playerInfo = "Name: " + name + "\n";
		return divider + playerInfo + divider;
	}
}
