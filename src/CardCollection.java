/**
*Yassine Khaliqui
*109050245
*Homework Assignment Number 1
*CSE 214 Recitation Section 06
*Recitation TA: Kevin Flyangolts 
*Grading TA: Zheyuan (Jeffrey) Gao;
*@author Yassine
*/

import java.util.Scanner;

public class CardCollection {

	final static int MAX_CARDS = 100;
	private BaseballCard[] deck;
	private Scanner s = new Scanner(System.in);
	private int newPosition;
	private int add = 0;
	private int remove = 0;
	
	/**
	 * Construct an instance of the CardCollection class with no BaseballCard objects in it.
	 * <dt><b>Postcondition:</b><dd> This CardCollection has been initialized to an empty list of BaseballCards.
	 */
	public CardCollection(){
		deck = new BaseballCard[MAX_CARDS];
	}
	/**
	 * Determines the number of items currently in the collection.
	 * <dt><b>Precondition:</b><dd> This CardCollection object has been instantiated.
	 * @return the number of cards in the card collection.
	 */
	public int size(){
		return add + remove;
	}
	/**
	 * Adds a card to the card collection at a specific position.
	 * @param newCard: the object that will be placed in the card collection of type BaseballCard.
	 * @param position: the position in the card will be placed in the collection of type int.
	 * <dt><b>Precondition:</b><dd> This CardCollection object has been instantiated and 1 <= position <= total_items + 1 and total_items < MAX_CARDS.
	 * <dt><b>Postcondition:</b><dd> the BaseballCard has been added to the card collection at the desired position. All cards that were originally in positions greater than or equal to position are moved back one position.
	 * @throws IllegalArgumentException: Indicates that position is not within the valid range.
	 * @throws FullCollectionException(): Indicates that there is no more room inside of the CardCollection to store the new BaseballCard object.
	 */
	public void addCard(BaseballCard newCard, int position) throws IllegalArgumentException, FullCollectionException{
		if(position > size() + 1 || position < 1)
			throw new IllegalArgumentException();
		else{
			int index = size() - 1;
				if(index + 1 == MAX_CARDS)
					throw new FullCollectionException();
				else{
					for(int i = index; i > position - 2; i--){
						deck[i + 1] = (BaseballCard) deck[i].clone();
					}
					deck[position - 1] = (BaseballCard) newCard.clone();
				}
		}
		add++;
	}
	/**
	 * Adds a card to the back of the card collection.
	 * @param newCard: The object to be added of type BaseballCard.
	 *<dt><b>Precondition:</b><dd> This CardCollection object has been instantiated and total_items < MAX_CARDS.
	 *<dt><b>Postcondition:</b><dd> the BaseballCard has been added to the card collection at the last position. 
	 * @throws IllegalArgumentException: Indicates that position is not within the valid range.
	 * @throws FullCollectionException(): Indicates that there is no more room inside of the CardCollection to store the new BaseballCard object.
	 */
	public void addCard(BaseballCard newCard) throws IllegalArgumentException, FullCollectionException{
		addCard(newCard, size() + 1);
		add++;
	}
	/**
	 * Removes the card from a card collection at the given position.
	 * @param position: The position of the card to be removed.
	 * <dt><b>Precondition:</b><dd> The CardCollection object has been instantiated and 1 <= position <= total_cards.
	 * <dt><b>Postcondition:</b><dd> The card at the desired position in the collection has been removed. All cards that were originally in positions greater than or equal to position are moved forward one position. 
	 * @throws IllegalArgumentException: Indicates that position is not within the valid range.
	 */
	public void removeCard(int position) throws IllegalArgumentException{
		if(position > size() || position < 1)
			throw new IllegalArgumentException();
		else{
			int size = size();
				for(int i = position; i < size; i++){
					deck[i - 1] = (BaseballCard) deck[i].clone();
				}
			deck[size - 1] = new BaseballCard();
			remove--;
		}
	}
	/**
	 * Retrieves the card from a card collection at the desired position.
	 * @param position: the position of the desired card.
	 * <dt><b>Precondition:</b><dd> The CardCollection object has been instantiated and 1 <= position <= total_cards.
	 * @return the BaseballCard at the desired position.
	 * @throws IllegalArgumentException: Indicates that position is not within the valid range.
	 */
	public BaseballCard getCard(int position) throws IllegalArgumentException{
			if(position > size() || position < 1)
				throw new IllegalArgumentException();
			else
				return (BaseballCard) deck[position - 1].clone();
	}
	/**
	 * Exchange a card from this collection for a card from another collection.
	 * @param other: the card collection to be traded with of type CardCollection.
	 * @param myPosition: the position of the card from the initial collection of type BaseballCard.
	 * @param theirPosition: the position of the other card in the other collection of type BaseballCard.
	 * <dt><b>Precondition:</b><dd>Both CardCollection objects have been instantiated and 1 < myPosition < total_cards and 1 < theirPosition < total_cards.
	 */
	public void trade(CardCollection other, int myPosition, int theirPosition) throws IllegalArgumentException, FullCollectionException{
		if(myPosition < 1 || myPosition > size() + 1 || theirPosition < 1 || theirPosition > other.size() + 1)
			throw new IllegalArgumentException();
		else{
			BaseballCard temp = (BaseballCard) getCard(myPosition).clone();
			BaseballCard temp2 = (BaseballCard) other.getCard(theirPosition).clone();
			removeCard(myPosition);
			other.removeCard(theirPosition);
			addCard(temp2, myPosition);
			other.addCard(temp, theirPosition);
		}
	}
	/**
	 * Indicates whether a card exists in a specific card collection.
	 * @param card: the card that is in question of type BaseballCard.
	 * <dt><b>Precondition:</b><dd> This CardCollection and the BaseballCard object have both been instantiated.
	 * @return the verdict of whether or not the card exists in boolean form.
	 */
	public boolean exists(BaseballCard card) throws IllegalArgumentException{
		boolean exists = false;
		for(int i = 1; i < size() + 1; i++){
			if(getCard(i).equals(card))
				exists = true;
		}
		return exists;
	}
	/**
	 * Prints a neatly formatted table of each item in the collection on its own line with its position number.
	 * <dt><b>Precondition:</b><dd> This CardCollection object has been instantiated.
	 * <dt><b>Postcondition:</b><dd> A neatly formatted table of each card in the collection on its own line with its position number has been displayed to the user.
	 */
	public void printAllCards() throws IllegalArgumentException{
		System.out.print(toString());
	}
	/**
	 * Gets the String representation of this CardCollection object, which is a neatly formatted table of each BaseballCard in the CardCollection on its own line with its position number.
	 * @return the String representation of this CardCollection object.
	 */
	public String toString(){
		String body = "";
		System.out.println("# Name \t \t Manufacturer \t Year \t Price \t Size\n"
				+ "- ---- \t \t ------------ \t ---- \t ----- \t ----");
		for(int i = 1; i < size() + 1; i++){
			try {
				body = String.format("%-2d%-15s%-16s%-8d%-1s%-7.2f%2s", i, getCard(i).getName(), getCard(i).getManufacturer(), 
						getCard(i).getYear(), "$", getCard(i).getPrice(), formatSize(getCard(i).getSizeX(),getCard(i).getSizeY()));
			} catch (IllegalArgumentException e) {}
			System.out.println(body);
		}
		String nil = "";
		return nil;
	}
	/**
	 * Formats the size of the card so that it can be printed easily.
	 * @param sizeX: The x value of the size of the card of type int.
	 * @param sizeY: The y value of the size of the card of type int.
	 * <dt><b>Precondition:</b><dd> This CardCollection object has been instantiated.
	 * <dt><b>Postcondition:</b><dd> A nicely formatted string of both the x and y value of the size.
	 * @return a representation of the size of the card of type String.
	 */
	private String formatSize(int sizeX, int sizeY){
		String size = String.valueOf(sizeX) + "x" + String.valueOf(sizeY);
		return size;
	}
}
