import java.awt.Color;
import java.util.ArrayList;

/*
* This is a player class that holds the player information, such as race, color, money amount, and name.
* @author Andy Fang
* Version 1.0 10/7/2013
*/
public class Player{
	private String name;
	private String race;
	private Color color;
	private int money;
	private boolean done;
	private ArrayList<Tile> propertyOwned;
	
	/*
	* This is the constructor that instantiates the Player
	*@name - the name of the player
	*@race - the race of the player
	*@color - the color repesenting that player
	*/

	public Player(String name, String race, Color color){
		int i = 0;
		
		this.name = name;
		this.race = race;
		this.color = color;
		done=false;
		propertyOwned = new ArrayList<Tile>();
		
		if (race == "Flapper"){
			money = 1600;
		}
		else if (race == "Human"){
			money = 600;
		}
		else
			money = 1000;
	}
	
	public String getName(){
		return name;
	}
	
	
	
	public void setDone(boolean done){
		this.done = done;
	}
	
	public Color getColor(){
		return color;
	}
	
	public boolean isDone(){
		return done;
	}
	
	public boolean buyProperty(int cost, Tile tile){
		System.out.println("Is owned? " + tile.isOwned());
		if(cost<=money && tile.isOwned()==false){
			System.out.println("buy me dammit");
			money-=cost;
			propertyOwned.add(tile);
			tile.isBought(this);
			return true;
		}
		else{
			return false;
		}
			
	}
	
	public String toString(){
		return "Player name: " + name  + " Player race: " + race + " Player color: " + color.toString();
	}
}
