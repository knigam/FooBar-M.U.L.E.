import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/*
* This is a Jframe class that allows you to configure the player settings.
* @author Cassidy Bellmor
* Version 1.0 10/7/2013
*/


public class PlayerConfig extends JPanel {
	private static final int WIDTH = 1220;
	private static final int HEIGHT = 650;
	
	private JTextField chooseName;
	private JComboBox chooseRace, chooseColor;
	private String playerName, playerRace, color;
	private Color playerColor;
	private ArrayList<Player> playerList;
	
	private String[] races = {"Select race...", "Flapper","Human","Others"}; 
	private String[] colors = {"Select color...", "Red", "Yellow", "Green", "Blue"};
	
	private boolean cont;
	private boolean back;
	
	private Player player;
	
	private JFrame frame;
	
	//public final int RED = 1;
	//public final int YELLOW=2;
	//public final int GREEN = 3;
	//public final int BLUE = 4;
	

	
	/*
	*This is the constructor class that creates the components necessary to configure player settings.
	*/
	public PlayerConfig(JFrame frame) {
		playerName="";
		playerRace="";
		playerList = new ArrayList<Player>();
		cont = false;
		back = false;
		this.frame = frame;
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		GroupLayout layout = new GroupLayout(this);
		frame.setTitle("M.U.L.E. - Player Configuration");
		JPanel entire = new JPanel();
		entire.setLayout(new GridLayout(3, 1));
		add(entire);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));
		entire.add(panel);
		
		/*
		ImageIcon mulePic = new ImageIcon("mule.gif");
		JLabel pic = new JLabel(mulePic);
		entire.add(pic);
		*/
		
		JLabel nameLabel = new JLabel("Player name: ");
	 	JLabel raceLabel = new JLabel("Player race: ");
        	JLabel colorLabel = new JLabel("Player color: ");
        
	        chooseRace = new JComboBox(races);
	        chooseRace.addActionListener(new raceListener());
	        
	        chooseColor = new JComboBox(colors);
	        chooseColor.addActionListener(new colorListener());
	        
	        chooseName = new JTextField();
	        /*
	        chooseName.addActionListener(new nameListener());
	        */
	        
	        panel.add(nameLabel);
	        panel.add(chooseName);
		panel.add(raceLabel);
		panel.add(chooseRace);
		panel.add(colorLabel);
		panel.add(chooseColor);
		entire.add(panel);
		        
			JButton back = new JButton("Back");
			back.addActionListener(new backListener());
	        JButton cont = new JButton("Continue");
	        cont.addActionListener(new continueListener(frame));
	        entire.add(back);
	        entire.add(cont);

    	   	frame.setContentPane(this);

	}
	
	/*
	* This method sets the color used to represent the player
	*@ color - the color the player wishes to be represented by, several options
	*/
	public Color setColor(String color) {
		if (color.equals("Red"))
 			playerColor = Color.RED;
	 	else if (color.equals("Yellow"))
	 		playerColor = Color.YELLOW;
	 	else if (color.equals("Green"))
	 		playerColor = Color.GREEN;
	 	else if (color.equals("Blue"))
	 		playerColor = Color.BLUE;
	 	else if (color.equals("Select color..."))
	 		System.out.println("Must select color.");	
	 	else
	 		System.out.println("Error with color selection.");	
		
		return playerColor;
	}

	/*
	* Getter for continue variable
	* @return Continue variable
	*/
	public boolean getContinue(){
    		return cont;
    	}
	
	/*
	* Getter for back variable
	* @return Back variable
	*/
	public boolean getBack(){
		return back;
	}
	
	/*
	* Getter for current player
	* @return Current player
	*/
	public Player getPlayer(){
		return player;
	}
	
	/*
	* Getter for player name
	* @return Player name
	*/
	public String getName() {
		return playerName;
	}
	
	/*
	* Getter for player color
	* @return Player color
	*/
	public Color getColor() {
		return playerColor;
	}
	
	/*
	* private Actionlistener class to implement selecting race option
	*/
	private class raceListener implements ActionListener {
       		public void actionPerformed (ActionEvent event) {
    	   		JComboBox r = (JComboBox)event.getSource();
           		playerRace = (String)r.getSelectedItem();
           		if (playerRace.equals("Select race..."))
        	   		System.out.println("Must select race.");
    	}
    }
	/*
	* private Actionlistener class to implement selecting color option
	*/
	private class colorListener implements ActionListener {
	       public void actionPerformed (ActionEvent event) {
	    	   JComboBox c = (JComboBox)event.getSource();
	    	   color = (String)c.getSelectedItem();
	    	   setColor(color);   
	    }
	}
	
	/*
	public class nameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setName();
		}
	}
	*/
	
	/*
	* private Actionlistener class to go back to previous screen
	*/
	private class backListener implements ActionListener {
       		public void actionPerformed (ActionEvent event) {
		    	back = true;
       		}
    	}
	
	/*
	* private Actionlistener class to continue onto the next selection screen
	*/
	private class continueListener implements ActionListener {
		JFrame frame;	
		public continueListener(JFrame frame){
				this.frame = frame;
			}
       		public void actionPerformed (ActionEvent event) {
       			playerName=chooseName.getText();
       			if(playerName.isEmpty())
       				playerName="Leo";
       			if(playerRace.isEmpty())
       				playerRace="Human";
       			if(playerColor==null)
       				playerColor=Color.red;
       				
		    	/**
		    	* Temporary
		    	
    	   		System.out.println("Continue clicked.");
	    		System.out.println("Player name: " + setName());
	    	   	System.out.println("Player race: " + playerRace);
	    	   	System.out.println("Player color: " + color);
	    	   	*/
       			player = new Player(chooseName.getText(), playerRace, playerColor);
       			System.out.println(player.toString());
       			playerList.add(player);
       			cont = true;
       		}
    	}
	
	/*
	* Getter for array of players
	* @return Players
	*/
	public ArrayList<Player> getPlayers(){
		return playerList;
	}
	
    }
