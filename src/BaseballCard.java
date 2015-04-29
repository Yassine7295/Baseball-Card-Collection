/**
*Yassine Khaliqui
*109050245
*Homework Assignment Number 1
*CSE 214 Recitation Section 06
*Recitation TA: Kevin Flyangolts 
*Grading TA: Zheyuan (Jeffrey) Gao;
*@author Yassine
*/

public class BaseballCard implements Cloneable{
	// Variables
	private String name;
	private String manufacturer;
	private int year;
	private double price;
	private int[] size = new int[2];
	// Constructors
	/**
	 * Creates a new BaseballCard object with blank parameters.
	 */
	BaseballCard(){}
	/**
	 * Creates a new BaseballCard object with given parameters.
	 * @param name: name of the card.
	 * @param manufacturer: manufacturer of the card.
	 * @param year: year of the card.
	 * @param size: an array that stores the dimensions of the card.
	 */
	BaseballCard(String name, String manufacturer, int year, double price, int[] size){
			this.name = name;
			this.manufacturer = manufacturer;
			this.year = year;
			this.price = price;
			this.size = size;
	}
	/**
	 * Returns the name of a particular BaseballCard.
	 * @return the name of a baseball card as a String.
	 */
	public String getName(){
		return name;
	}
	/**
	 * Returns the manufacturer of a particular BaseballCard.
	 * @return the manufacturer of a baseball card as a String.
	 */
	public String getManufacturer(){
		return manufacturer;
	}
	/**
	 * Returns the year of a particular BaseballCard.
	 * @return the year of a baseball card as an int.
	 */
	public int getYear(){
		return year;
	}
	/**
	 * Returns the price of a particular BaseballCard.
	 * @return the price of a baseball card as a double.
	 */
	public double getPrice(){
		return price;
	}
	/**
	 * Returns the size (x value) of a particular BaseballCard.
	 * @return the size (x value) of a baseball card as an int.
	 */
	public int getSizeX(){
		return size[0];
	}
	/**
	 * Returns the size (y value) of a particular BaseballCard.
	 * @return the size (y value) of a baseball card as an int.
	 */
	public int getSizeY(){
		return size[1];
	}
	/**
	 * Renames a particular BaseballCard.
	 * @param name: the new name of the BaseballCard.
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * Changes the manufacturer value of a particular BaseballCard.
	 * @param manufacturer: the new manufacturer of the BaseballCard.
	 */
	public void setManufacturer(String manufacturer){
		this.manufacturer = manufacturer;
	}
	/**
	 * Changes the year value of a particular BaseballCard.
	 * @param year: the new year of the BaseballCard.
	 */
	public void setYear(int year)throws IllegalArgumentException{
		if(year < 0)
			throw new IllegalArgumentException();	
		else	
			this.year = year;
	}
	/**
	 * Changes the price value of a particular BaseballCard.
	 * @param price: the new price of the BaseballCard.
	 * @throws InvalidInputException: indicates that the price is negative.
	 */
	public void setPrice(double price) throws IllegalArgumentException{
		if(price < 0)
			throw new IllegalArgumentException();	
		else	
			this.price = price;
	}
	/**
	 * Changes the size (x value) of a particular BaseballCard.
	 * @param sizeX: the new size (x value) of the BaseballCard.
	 */
	public void setSizeX(int sizeX){
		size[0] = sizeX;
	}
	/**
	 * Changes the size (y value) of a particular BaseballCard.
	 * @param sizeY: the new size (y value) of the BaseballCard.
	 */
	public void setSizeY(int sizeY){
		size[1] = sizeY;
	}
	/**
	 * Clones an object casted to a BaseballCard.
	 * @return a clone object of type BaseballCard.
	 */
	public Object clone(){
		BaseballCard card = new BaseballCard();
		try{
			card = (BaseballCard) super.clone();
		}catch(CloneNotSupportedException ex){}
		card.manufacturer = getManufacturer();
		card.name = getName();
		card.size = (int[]) size.clone();
		return card;
	}
	/**
	 * Indicates whether two objects of type BaseballCard are equal.
	 * @return a boolean value based on whether the two objects are equal.
	 */
	public boolean equals(Object obj){
		if(!(obj instanceof BaseballCard))
			return false;
		return (getName().equals(((BaseballCard) obj).getName()) && getManufacturer().equals(((BaseballCard) obj).getManufacturer()) 
				&& getYear() == ((BaseballCard) obj).getYear() && getPrice() == ((BaseballCard) obj).getPrice() &&
				getSizeX() == ((BaseballCard) obj).getSizeX() && getSizeY() == ((BaseballCard) obj).getSizeY());
	}
}

