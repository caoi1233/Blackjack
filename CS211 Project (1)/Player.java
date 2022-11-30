
public class Player {

	//Hand held class and has associated values for each player.
	// Class attributes
	private Hand 	hand;		// Current hand
	private int 	handValue;	// Current hand value
	private int 	wallet;		// Will hold your winnings?
	private String 	name;		// ID
	
	public Player(String name) {
		this.name 	= name;
		hand 		= new Hand();
		handValue 	= 0;
		wallet 		= 100;
	}
	
	
	//Add a card to the hand.
	public void addCard(Card card) {
		hand.insertTopCard(card);
	}
	
	//Update the current value of hand of cards.
	public void updateHandValue() {
		handValue = hand.computeHandValue();
	}
	
	//Method that returns wallet value
		public int getWallet() {
			return wallet;
		}
		
	//Update the amount of money the player has.
	public void setWallet(int payout) {
		//This is done through the prizes.
		wallet += payout;
	}
	
	//Method to get current hand for the player.
	public Hand getHand() {
		return hand;
	}
	
	//Method to return the current hand value.
	public int getHandValue() {
		return handValue;
	}


	/* We want to show the hand and score of dealer. However we want to hide some of the
	//information depending on who made the request. As a result, the dealer's score and hand
	 is shown when the round ends.
	*/
	 
	public void showHand(boolean roundOver) {
		System.out.println(name + " has " + hand.getNumCards() + " cards. ");
		//The current hand object will show on screen.
		hand.displayHand();
		
		//We check if the name of the player does not equal user or if the round is over.
		
		if(!name.equals("dealer") && !roundOver) {
			//Print players details if the roundOver is false, meaning the round is ongoing.
			System.out.println("The current hand value is : " + hand.getHandValue());
		}
			//Else the round is actually over.
			else if(roundOver) {
			System.out.println("The current hand value is : " + hand.getHandValue());
	
			}
			System.out.println("***************************");
			//This prints out a seperate line.
			System.out.println();
	}
	 /* Now we want to create a method to make a bet
	  * This will be by using the makeBet option
	  */
	public boolean makeBet(int bet) {
		if(wallet > 0 && bet <= wallet) {
			//This means you subtract the value of the bet
			//from the wallet.
			//You then get your total wallet value.
			wallet -= bet;
			//To return true that the bet was made.
			return true;
		}
		else {
			//bet wasn't made
			return false;
		}
		
	}
	/* Reset the hand of the player and the value of the hand for the next round
	 */
		public void newRound() {
			hand = new Hand();
			handValue = 0;
		}
}
//End of the class player!
s