import javax.swing.*;
public class Mule extends Item{
	
	protected ImageIcon image;
	protected int type;
	protected Tile tileType;
	protected Player owner;
	
	public Mule(){
		type=Item.FOOD;
		
	}
	

	
	public void produce(){
		tileType.produce(type, owner);
	}
	
	public void setMuleType(int type){
		this.type=type;
		System.out.print(type);
	}
	
	public void addValue(int value){
		if(value>=0){
			this.value+=value;
		}
	}
	
	public void emplace(Tile tile){
		tileType=tile;
	}
	
	public void setOwner(Player p){
		owner=p;
	}

}
