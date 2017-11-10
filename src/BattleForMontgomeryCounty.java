import java.io.IOException;

public class BattleForMontgomeryCounty 
{
	
	
	/**
	 * Description:
	 * 
	 * Goals:
	 * - Get Player 1 and Player 2 names for the game
	 * - Create Player objects to store player information
	 * - Choose which player goes first randomly
	 * - Start the game loop
	 *     - Allow first player to have a turn
	 *         - Show player their options (create UI through text for health, items and options)
	 *         - Take user input to select option
	 *         - End turn and move to next player
	 *     - Allow second player to have a turn
	 *         - All requirements are the same as the first player above
	 *     - When both player turns are over perform both actions at the same time
	 *         - Determine damage done or effects to players
	 *         - Determine who wins if there is a tie
	 *         - If there is a victor, show win screen
	 * @throws IOException 
	 */
	public static void main(String[] args)
	{
		Game game = new Game();
		game.run();
	}
	
	/**
	 * OFFICIAL RULES OF THE GAME
	 * Players
	 *  - Players starts with 100 health
	 *  - Both players get a sword and bow
	 *  - Players start with 3 of every potion
	 *  - Players start with a shield
	 * Moves
	 *  - Attack with sword
	 *  - Attack with bow
	 *  - Block/Defend
	 *  - Use potion
	 * Global Rules for moves
	 *  - All moves made by players are performed at the same time and the win conditions are checked after both players have gone each round
	 *  - Health can go above 100
	 *  - If you use two poison potions next to eachother, the number of turns it effects the enemy resets to 5 and the user loses the potion from their inventory
	 *  - Both players can not see what the other players move is. They cannot see if they take potions. All they can see is enemy moves that effect them. (Attacks, poison potions)
	 * Attacks
	 * - Sword
	 *   - If both players use sword, nobody takes damage (they clash)
	 *   - If one player uses shield and the other uses a sword, the defending character takes 5 damage
	 *   - If you strike somebody with a sword that is not blocking they take 15 damage (or is attacking with bow)
	 * - Bow
	 *   - Bows do no damage against somebody that is blocking with a shield
	 *   - If you strike somebody with a bow that is not blocking they take 20 damage (or is attacking with bow/sword)
	 * Potions
	 *   - Health Potion
	 *     * Gives player 30 health
	 *   - Strength Potion
	 *     * Adds 10 damage to each attack for the next 5 rounds
	 *   - Poison Potion
	 *     * Deals 10 damage to the opponent for the next 5 round
	 * Win Conditions
	 *  - If either player gets to 0 health, they lose the game.
	 *  - If both players get to 0 health at the same time, it is a draw
	 */
	

}
