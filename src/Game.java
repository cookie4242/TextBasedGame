public class Game 
{
	private InputManager Input;
	private OutputManager Output;
	private final int SwordAttack = 1;
	private final int BowAttack = 2;
	private final int Block = 3;
	private final int StrengthPotion = 4;
	private final int HealthPotion = 5;
	private final int PoisonPotion = 6;
	public String valaidInputString = ("123456");
	
	public Game()
	{
		Input = new InputManager();
		Output = new OutputManager(); 
		
		System.out.println("Welcome, here are the rules to the game.");
		System.out.println("	1- both players get to pick their name.");
		System.out.println("	2- both players chose their move and then the moves are done simultaneously.");
		System.out.println("	3- then the effects of each move are done to the players and then they chose another move.");
		System.out.println("	4- choices, the moves you can make.");
		System.out.println("		1- Potions: you have 3 of each potion: strength,health and poison.");
		System.out.println("				1- poison potion : lasts 5 rounds and does 10 damage a round.");
		System.out.println("				WARNING!  if you use one poison potion before the other is done you will lose the remaining rounds of effect");
		System.out.println("				2- Strength potion : adds 10 damage to every Physical attack for 5 rounds");		
		System.out.println("				WARNING!  if you use one Strength potion before the other is done you will lose the remaining rounds of effect");
		System.out.println("				3- health potion : adds 30 health");
		System.out.println("		2- Physical Attacks: bow and sword.");
		System.out.println("		3- Defense: sheild.");
		System.out.println("	5- if a player has won it will show the health and say who won.");
		System.out.println("	6- hint: if you set the same move over and over again it will be boring");
		System.out.println("");
		System.out.println("Let the games begin.");
		System.out.println("");

	}
	
	public void run()
	{
		Player playerOne = new Player();
		Player playerTwo = new Player();
		
		playerOne.name = Input.getPlayerOneName();
		playerTwo.name = Input.getPlayerTwoName(playerOne.name);
		
		boolean playingGame = true;
		while (playingGame)
		{
			GetAndPerformPlayerMove(playerOne, playerTwo);
			GetAndPerformPlayerMove(playerTwo, playerOne);
			
			playerOne.potionCheck();
			playerTwo.potionCheck();
			
			playingGame = !WinCheck(playerOne, playerTwo);
		}
	}
	
	public void GetAndPerformPlayerMove(Player attacker, Player defender)
	{
		attacker.move = getPlayerMove(attacker, defender);
		if (attacker.move == 5 && (attacker.healthPotionLeft() == false))
		{
			System.out.println("sorry you are out of health Potions");
		 	while(attacker.move == 5)
			{
		 		attacker.move = getPlayerMove(attacker, defender);
			}
		}
		
		performPlayerMove(attacker, defender);
	}
	
	public int getPlayerMove(Player attacker, Player defender)
	{
		Output.printPlayerOptions(attacker, defender);
		return Input.ValidOptions(valaidInputString);
	}
	
	private void performPlayerMove(Player attacker, Player defender)
	{
		int modifier = 0;
		
		if(attacker.activeStrengthPotion != null && attacker.activeStrengthPotion.getDuration() > 0)
		{
			 modifier = 10;
		}
		
		if(attacker.move == SwordAttack)
			defender.health -= 15 + modifier;
		else if(attacker.move == BowAttack)
			defender.health -= 20 + modifier;
		
		else if(attacker.move == Block)
		{
			if(defender.move == SwordAttack)
				attacker.health += 10;
			
			else if (defender.move == BowAttack)
					attacker.health += 20;
		}																																																																																
		else if (attacker.move == StrengthPotion && attacker.strengthPotionLeft())	
		{
			StrengthPotion Spotion = attacker.getNextStrengthPotion();
			attacker.activeStrengthPotion = Spotion;
		}
		else if (attacker.move == HealthPotion && attacker.healthPotionLeft())
		{
			HealthPotion potion = attacker.getNextHealthPotion();
			
			if(!potion.use(attacker))
			{
				System.out.print("you can not use this potion sorry ):"); 
			}
		
		}
		else if(attacker.move == PoisonPotion && attacker.poisonPotionsLeft())
		{
			defender.activePoisonPotion = attacker.getNextPoisonPotion();
		}
	}
	public boolean WinCheck(Player playerOne, Player playerTwo)
	{	
		System.out.print("you cant hide");
		if (playerOne.health <= 0 && playerOne.health > playerTwo.health || playerTwo.health <= 0 && playerOne.health > playerTwo.health)
		{
			Output.PrintWinner(playerOne, playerTwo);
			return true;
		}
		else if (playerOne.health <= 0 && playerTwo.health > playerOne.health || playerTwo.health <= 0 && playerTwo.health > playerOne.health)
		{
			Output.PrintWinner(playerTwo, playerOne);
			return true;
		}
		else if (playerOne.health <= 0 && playerTwo.health > playerOne.health || playerTwo.health <= 0 && playerTwo.health == playerOne.health)
		{
			System.out.println("");
			System.out.println(playerOne.name + "'s health was " + playerOne.health + " " + playerTwo.name + "'s health was " + playerTwo.health);
			System.out.println("it was a draw nobody won");
			return true;	
		}
		
		return false;
	}
}    
