
public class OutputManager 
{
	public void printPlayerOptions(Player attacker, Player enemy)
	{
		System.out.println(" ");
		System.out.println("#######################################\n");
		System.out.println("it is " + attacker.name + "'s turn");
		System.out.println( attacker.name + "'s health = " + attacker.health);
		System.out.println( enemy.name + "'s health = " + enemy.health + "\n");
		System.out.println("press 1 to attack with sword ");
		System.out.println("press 2 to attack with bow ");
		System.out.println("press 3 to  block ");
		
		if (attacker.strengthPotionLeft())
			System.out.println("press 4 to use strength potion " + ",you have " + attacker.numberOfStrengthPotionLeft + "x left");
		else
			System.out.println("sorry you don't have any more strength potions left"); 
		
		if (attacker.healthPotionLeft())
			System.out.println("press 5 to use healing potion " + ",you have " + attacker.numberOfHealthPotionsLeft + "x left");
		else
			System.out.println("sorry you don't have any more health potions left");
		
		if(attacker.poisonPotionsLeft())
			System.out.println("press 6 to use poison potion "+ ",you have " + attacker.numberOfPoisonPotionsLeft + "x left");
		else
			System.out.println("sorry you don't have any more Poison potions left");
	}
	
	
	public void  attackOptions()
	{
		System.out.println("\npress 1 to attack with sword ");
		System.out.println("press 2 to attack with bow \n");
	}
	
	public void  blockOptions()
	{
		System.out.println("\npress 1 to block \n");
	}
	
	public void  potionOptions(int[] potions)
	{
		System.out.println("");
		System.out.println("you have x3 of each \n");
		System.out.println("press 1 to use a posion potion you have " + potions[0] + "x  left");
		System.out.println("press 2 to use a strength potion you have " + potions[1] + "x left");
		System.out.println("press 3 to use a healing potion you have " + potions[2] + "x left\n");
	}

	public void PrintWinner(Player playerWinner, Player playerLoser)
	{
		System.out.println("");
		System.out.println(playerWinner.name + "'s health was " + playerWinner.health + " " + playerLoser.name + "'s health was " + playerLoser.health);
		System.out.println(playerWinner.name + " won the fight");
	}
}
