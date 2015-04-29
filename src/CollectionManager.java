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

public class CollectionManager{
	public static void main(String[] args) throws IllegalArgumentException, FullCollectionException{
		CardCollection A = new CardCollection();
		CardCollection B = new CardCollection();
		Scanner s = new Scanner(System.in);
		String input = "";
		String menu = "Main Menu:\n "
				+ "\n"
				+ "A) Add Card\n"
				+ "C) Copy\n"
				+ "E) Update Price\n"
				+ "G) Get Card\n"
				+ "L) Locate Card\n"
				+ "N) Update Name\n"
				+ "P) Print All Cards\n"
				+ "R) Remove Card\n"
				+ "S) Size\n"
				+ "T) Trade\n"
				+ "V) Value\n"
				+ "Q) Quit\n"
				+ "\n"
				+ "Select an operation: ";
		System.out.print(menu);
		input = s.nextLine().toUpperCase();
		String col;
		int position;
		String name;
		String manu;
		int year;
		double price;
		String sizeInput;
		String[] sizeString = new String[2];
		int[] size = new int[2];
		BaseballCard card = new BaseballCard();
		
		while(!input.equalsIgnoreCase("Q")){
			// Add card
			if(input.equalsIgnoreCase("A")){
				System.out.println();
				System.out.print("Enter the collection: ");
				col = s.nextLine().toUpperCase();
				System.out.print("Enter the name: ");
				name = s.nextLine();
				System.out.print("Enter the manufacturer: ");
				manu = s.nextLine();
				System.out.print("Enter the year: ");
				year = s.nextInt();
				while(year < 0){
					System.out.print("Enter a positive value for year: ");
					year = s.nextInt();
				}	
				s.nextLine();
				System.out.print("Enter the size: ");
				sizeInput = s.nextLine();
				sizeString = sizeInput.trim().split(" ");
				size = new int[2];
				size[0] = Integer.parseInt(sizeString[0]);
				size[1] = Integer.parseInt(sizeString[1]);
				System.out.print("Enter the price: ");
				price = s.nextDouble();
				while(price < 0){
					System.out.print("Enter a valid price: ");
					price = s.nextDouble();
				}	
				System.out.print("Enter the position: ");
				position = s.nextInt();
				card = new BaseballCard(name, manu, year, price, size);
				if(col.equalsIgnoreCase("A")){
					try{
						A.addCard(card, position);
					}catch (IllegalArgumentException e) {
						System.out.print("Please enter a valid position: ");
						position = s.nextInt();
						A.addCard(card, position);
					}catch (FullCollectionException e) {
						System.out.println();
						System.out.println("This collection is full.");
					}
				}
				if(col.equalsIgnoreCase("B")){
					try{
						B.addCard(card, position);
					}catch (IllegalArgumentException e) {
						System.out.print("Please enter a valid position: ");
						position = s.nextInt();
						B.addCard(card, position);
					}catch (FullCollectionException e) {
						System.out.println();
						System.out.println("This collection is full.");
					}
				}
				System.out.println();
				System.out.println("Added " + card.getName() + ", " + card.getManufacturer()
							+ ", " + card.getYear() + ", $" + String.format("%.2f", card.getPrice()) + ", " + card.getSizeX() + "x" +
							card.getSizeY() + " to collection " + col + " at the chosen position.");
				printMenu(menu);
			}
			// Copy card
			else if(input.equalsIgnoreCase("C")){
				System.out.println();
				System.out.print("Enter the collection: ");
				col = s.nextLine().toUpperCase();
				System.out.print("Enter the position of the card: ");
				position = s.nextInt();
				s.nextLine();
				System.out.print("Enter the destination collection: ");
				String dest = s.nextLine();
				if(col.equalsIgnoreCase("A")){
					try{
						card = (BaseballCard) A.getCard(position).clone();
					}catch (IllegalArgumentException e) {
						System.out.print("Please enter a valid position: ");
						position = s.nextInt();
						card = (BaseballCard) A.getCard(position).clone();
					}
				}
				if(col.equalsIgnoreCase("B")){
					try{
						card = (BaseballCard) B.getCard(position).clone();
					}catch (IllegalArgumentException e) {
						System.out.print("Please enter a valid position: ");
						position = s.nextInt();
						card = (BaseballCard) B.getCard(position).clone();
					}
				}
//				if(col.equalsIgnoreCase("A"))
//					card = (BaseballCard) A.getCard(position).clone();
//				else
//					card = (BaseballCard) B.getCard(position).clone();
				if(dest.equalsIgnoreCase("A"))
					A.addCard(card);
				if(dest.equalsIgnoreCase("B"))
					B.addCard(card);
				System.out.println();
				System.out.println("The card in collection " + col + " at the chosen position has been added to the end of collection " + dest + ".");
				printMenu(menu);
			}
			// Update price
			else if(input.equalsIgnoreCase("E")){
				System.out.println();
				System.out.print("Enter the collection: ");
				col = s.nextLine().toUpperCase();
				System.out.print("Enter the position: ");
				position = s.nextInt();
				if(col.equalsIgnoreCase("A")){
					card = (BaseballCard) A.getCard(position).clone();
					A.removeCard(position);
				}
				else{
					card = (BaseballCard) B.getCard(position).clone();
					B.removeCard(position);
				}
				System.out.print("Enter the price: ");
				price = s.nextDouble();
				while(price < 0){
					System.out.print("Enter a valid price: ");
					price = s.nextDouble();
				}
				card.setPrice(price);
				if(col.equals("A"))
					A.addCard(card, position);
				else
					B.addCard(card, position);
				System.out.println();
				System.out.println("The price of the card in collection " + col + " at the chosen position has been changed to $" + price);
				printMenu(menu);
			}
			// Get card
			else if(input.equalsIgnoreCase("G")){
				System.out.println();
				System.out.print("Enter the collection: ");
				col = s.nextLine().toUpperCase();
				System.out.print("Enter the position: ");
				position = s.nextInt();
				if(col.equals("A"))
					card = (BaseballCard) A.getCard(position).clone();
				else
					card = (BaseballCard) B.getCard(position).clone();
				System.out.println();
				System.out.println("In collection " + col + " at the position chosen is the card: "
						+ card.getName() + ", " + card.getManufacturer() + ", " + 
						card.getYear() + ", $" + card.getPrice() + ".");
				printMenu(menu);
			}
			// Locate card IF there are any cards in either collection
			else if(input.equalsIgnoreCase("L")){
				System.out.println();
				System.out.print("Enter the name: ");
				name = s.nextLine();
				System.out.print("Enter the manufacturer: ");
				manu = s.nextLine();
				System.out.print("Enter the year: ");
				year = s.nextInt();
				s.nextLine();
				System.out.print("Enter the size: ");
				sizeInput = s.nextLine();
				sizeString = sizeInput.trim().split(" ");
				size = new int[2];
				size[0] = Integer.parseInt(sizeString[0]);
				size[1] = Integer.parseInt(sizeString[1]);
				System.out.print("Enter the price: ");
				price = s.nextDouble();
				while(price < 0){
					System.out.print("Enter a valid price: ");
					price = s.nextDouble();
				}	
				card = new BaseballCard(name, manu, year, price, size);
				System.out.println();
				if(A.exists(card))
					System.out.println("This card exists in collection A.");
				else if(B.exists(card))
					System.out.println("This card exists in collection B.");
				else
					System.out.println("This card does not exist in either collections.");
				printMenu(menu);
			}
			// Update name
			else if(input.equalsIgnoreCase("N")){
				System.out.println();
				System.out.print("Enter the collection: ");
				col = s.nextLine().toUpperCase();
				System.out.print("Enter the position: ");
				position = s.nextInt();
				s.nextLine(); // Clears the scanner for nextLine()
				System.out.print("Enter the new name: ");
				name = s.nextLine();
				if(col.equalsIgnoreCase("A")){
					card = (BaseballCard) A.getCard(position).clone();
					A.removeCard(position);
				}
				else{
					card = (BaseballCard) B.getCard(position).clone();
					B.removeCard(position);
				}
				card.setName(name);
				if(col.equals("A"))
					A.addCard(card, position);
				else
					B.addCard(card, position);
				System.out.println();
				System.out.println("The name of the card in collection " + col + " at the chosen position has been changed to " + name + ".");
				printMenu(menu);
			}
			// Print all cards
			else if(input.equalsIgnoreCase("P")){
				System.out.println();
				System.out.println("Collection A:");
				System.out.println();
				A.printAllCards();
				System.out.println();
				System.out.println("Collection B:");
				System.out.println();
				B.printAllCards();
				printMenu(menu);
			}
			// Remove card 
			else if(input.equalsIgnoreCase("R")){
				System.out.println();
				System.out.print("Enter the collection: ");
				col = s.nextLine().toUpperCase();
				System.out.print("Enter the position: ");
				position = s.nextInt();
				try{
					if(col.equals("A"))
						A.removeCard(position);
					else
						B.removeCard(position);
				}catch(IllegalArgumentException ex){
					System.out.print("Please select a valid position: ");
					position = s.nextInt();
				}
				System.out.println();
				System.out.println("The card in collection " + col + " at the chosen position has been removed from the collection.");
				printMenu(menu);
			}
			// Size
			else if(input.equalsIgnoreCase("S")){
				System.out.println();
				System.out.println("There are " + A.size() + " cards in collection A.");
				System.out.println("There are " + B.size() + " cards in collection B.");
				printMenu(menu);
			}
			// Trade
			else if(input.equalsIgnoreCase("T")){
				System.out.println();
				System.out.print("Enter the position of the card in collection A: ");
				position = s.nextInt();
				System.out.print("Enter the position of the card in collection B: ");
				int positionB = s.nextInt();
				A.trade(B, position, positionB);
				System.out.println();				
				System.out.println("The two cards at the position you have indicated have traded places.");				
				printMenu(menu);
			}
			// Value
			else if(input.equalsIgnoreCase("V")){
				System.out.println();
				float valueA = 0;
				float valueB = 0;
				for(int i = 1; i < A.size() + 1; i++){
					valueA += (A.getCard(i)).getPrice();
				}
				for(int i = 1; i < B.size() + 1; i++){
					valueB += (B.getCard(i)).getPrice();
				}
				System.out.printf("%s%-2.2f", "The value of all of the cards in collection A is: $", valueA);
				System.out.println();
				System.out.printf("%s%-2.2f", "The value of all of the cards in collection B is: $", valueB);
				printMenu(menu);
			}
			input = s.nextLine().toUpperCase();
		}	
	}
	
	private static void printMenu(String menu){
			System.out.println();
			System.out.print(menu);
		}
}
