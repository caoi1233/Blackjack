
public class Hand {
	
	//Attributes of the hand class
	private Card topCard;
	private int handValue;
	private int numCards;
	
	//constructor of our hand class
	public Hand() {
		topCard = null;
		handValue = 0;
		numCards =0;
	}
	//We will check if our hand of cards is empty
	public boolean isEmpty() {
		return(topCard == null);
	}
	
	public void insertTopCard(Card card) {
		//This method will make the next card
		//the top card of the hand of cards.
		card.nextCard = topCard;
		topCard = card;
		numCards++;
	}
	//We are going to store our hand of cards in a linked list. 
	//For each linked list, we calculate the total value of current hand.
	
	public int computeHandValue() {
		//current hand value of hand of cards is 0.
		
		handValue =0;
		//If the hand is not empty
		if(!isEmpty()) { 
			Card current = topCard;
			while(current != null) {
				//compute the value of the current hand of card
				handValue += current.getValue();
				current = current.nextCard;
			}
		}
		return handValue;
	}
	//create a method to get the hand Value
	public int getHandValue() {
		return handValue;
	}
	
	//create a method to get the number of cards in the hand
	public int getNumCards() {
		return numCards;
	}
	//display the current hand of card
	public void displayHand() {
		if(!isEmpty()) {
			Card current = topCard;
			//If hand of current card is  empty
			while (current != null) {
				//print it out
				current.printCard();
				current = current.nextCard; //Keep going until you
											//reach the last card.
			}
		}
	}
	//Now set  hand of cards face up.
	public void setHandFaceUp() {
		if(!isEmpty()) {
			Card current = topCard;
			
		while(current != null) {
			//Print the hand of card out
			current.setFaceUp();
			current = current.nextCard; //Keep printing until you reach the last card.
			}
		}
	
	}
}