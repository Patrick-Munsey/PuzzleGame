import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



/**
 * Class that manages the board display and mechanics. Is displayed in a JFrame 
 */
public class Board extends JPanel  {
    private Tile[][] board;
    private int boardWidth;
    private int boardHeight;
    private HashMap<PlayerNumber, Player> players;
    private LinkedList<Goal> goals;
    private LinkedList<Portal> portals;
    private LinkedList<Floor> portalLocs;
    private int box_size = 30;
    private Image background_img;

    public Level currLevel;
    private MoveList moves;
    private PuzzleGame puzzleGame;

	/**Board Constructor
	 */
	 public Board(PuzzleGame puzzleGame) {
		 this.puzzleGame = puzzleGame;
		 this.boardWidth = 0;
		 this.boardHeight = 0;
		 board = new Tile[boardWidth][boardHeight];
		 players = new  HashMap<PlayerNumber, Player>();
		 goals =  new LinkedList<Goal>();
		 portals = new LinkedList<Portal>();
		 portalLocs = new LinkedList<Floor>();
		 moves = new MoveList();
		 this.addKeyListener(new BoardAdapter());
		 initBoard(1);

	//setup background variables
	this.background_img = new ImageIcon("src/images/cookie_background.png").getImage();
	Dimension size = new Dimension(background_img.getWidth(null), background_img.getHeight(null));
	setPreferredSize(size);
	setMinimumSize(size);
	setMaximumSize(size);
	setSize(size);

	initUI();
    }

	 /**
	  * @author Patrick Munsey, z5020841
	  */  
	 private void initUI() {	
		 this.setLayout(new GridBagLayout());
		 tilesToBoard();
		 this.setFocusable(true); 

	 }

    /** @author James Doldissen
     * Write all the tiles in the board array to the jpanel
     */
    private void tilesToBoard ()
    {
	GridBagConstraints c = new GridBagConstraints();
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx = 0;
	c.gridy = 0;

	for(int y = 0; y < boardHeight; y++){
	    for(int x = 0; x < boardWidth; x++){
		c.gridx = x;
		c.gridy = y;
		this.add(board[x][boardHeight-1-y], c);//labels have to be added from top to bottom not bottom to top so reverse board y index	
	    }
	}
    }

    /** Refresh the JPanel after a move has been made
     * @author Patrick Munsey, z5020841
     */
    private void refreshUI() {
	this.revalidate();
	this.repaint();
    }




    /**
     * @author Patrick Munsey, z5020841
     * @param playernumber
     * @param direction
     * @return true if player was moved successfully
     */
    public boolean MovePlayer(PlayerNumber playernumber, Direction direction) {
		boolean moveCheck = players.get(playernumber).movePiece(this, direction, moves, false);
		checkCompletion();
		magicPortal(playernumber, false); //undo == false
		checkPortal();
		if (moveCheck == true) {
			//moves.addMove(direction, false);
			return true;
		} else {
			return false;
		}
    }

    /**
     * Method to undo moves
     * @author dennydien
     * @param playernumber
     * @return
     */
    public boolean undoMove(PlayerNumber playernumber) {
    	
    	Move undoMove = moves.undoMove(); 
    	if (undoMove == null) { //early exit if no move to undo
    		return false;
    	}
    	
    	Direction undoDirection = undoMove.getDirection(); //get the direction of the undo
    	boolean toMoveBox = undoMove.getBoxMoved(); //true if box must also move, false otherwise
    	boolean toTeleport = undoMove.getTeleported(); //true if last move was a teleport
    	
    	/*
    	 * If the last move was a teleport, find the direction of where the portal is
    	 * Move in that direction, and call magicPortal to teleport back
    	 */
    	if (toTeleport == true) {
    		Direction ofPortal = findPortal(playernumber);
    		players.get(playernumber).movePiece(this, ofPortal, moves, true);
    		magicPortal(playernumber, true);
    		return true; // leave method
    	}
    	
    	/*
    	 * If the last move was NOT a teleport, move the player back in the opp. direction
    	 */
    	boolean moveCheck = players.get(playernumber).movePiece(this, undoDirection, moves, true);

    	
    	/*
    	 * If the last move MOVED A BOX, we need to move it back as well
    	 */
    	if (toMoveBox == true) { // If we moved a box when making the move
    	
    		//Get the location of the player
    		Player player = players.get(playernumber);
        	int tempX = player.getX();
        	int tempY = player.getY();
        	
        	/*
        	 * Move the box back in the opposite direction
        	 * We use the coordinate of the player to find the coordinate of the box
        	 * We use +/- 2 because the player is moved before the box, so it isn't directly next to it
        	 */
        	switch(undoDirection) {
        	
        	case UP: 
    			this.MovePiece(tempX, tempY -2, undoDirection);
    			break;
    		
    		case DOWN:
    			this.MovePiece(tempX, tempY +2, undoDirection);
    			break;
    			
    		case LEFT: 
    			this.MovePiece(tempX +2, tempY, undoDirection);
    			break;
    			
    		case RIGHT: 
    			this.MovePiece(tempX -2, tempY, undoDirection);
    			break;
    			
    		default:
    			break;
        	
        	}
    	}
		return true;
    }

    /**
     * Method to find portal
     * @param playernumber
     * @pre only used if there has been a teleport: i.e. portal always exists around player when method is called
     */
    public Direction findPortal (PlayerNumber playernumber) {
    	
    	// Due to precondition, we assume that the portal is around the player's current pos
    	Player player = players.get(playernumber);
    	int midX = player.getX();
    	int midY = player.getY();
    	
    	// Find the direction of the portal relative to the player
    	if (board[midX][midY+1].isPortal()) { // portal is above
    		return Direction.UP;
    	} else if (board[midX][midY-1].isPortal()) { // portal is below
    		return Direction.DOWN;
    	} else if (board[midX+1][midY].isPortal()) { // portal is on right
    		return Direction.RIGHT;
    	} else if (board[midX-1][midY].isPortal()) { // portal is on left
    		return Direction.LEFT;
    	} else {
    		return null;
    	}
    }
    
    /**
     * @author Patrick Munsey, z5020841
     * @return true if a GamePiece can move to this tile
     */
    public boolean isMoveable() {
    	return false;
    }
    
    /**
     * @author Patrick Munsey, z5020841
     * @param x
     * @param y
     * @param direction
     * @return true if GamePiece was moved successfully
     */
    public boolean MovePiece(int x, int y, Direction direction) {
	GamePiece gamepiece = board[x][y].removeGamePiece();
	if(gamepiece == null) {
	    return false;
	}

	switch(direction) {
	case UP:
	    if(board[x][y+1].isMoveable()) {
		board[x][y+1].placeGamePiece(gamepiece);
		refreshUI();
		return true;
	    }
	    break;
	case DOWN:
	    if(board[x][y-1].isMoveable()) {
		board[x][y-1].placeGamePiece(gamepiece);
		refreshUI();
		return true;
	    }
	    break;
	case LEFT:
	    if(board[x-1][y].isMoveable()) {
		board[x-1][y].placeGamePiece(gamepiece);
		refreshUI();
		return true;
	    }
	    break;
	case RIGHT:
	    if(board[x+1][y].isMoveable()) {
		board[x+1][y].placeGamePiece(gamepiece);
		refreshUI();
		return true;
	    }
	    break;
	default:
	    break;
	}

	board[x][y].placeGamePiece(gamepiece);
	return false;
    }

    public boolean MovePiece(int startX, int startY, int endX, int endY) {
	GamePiece gamepiece = board[startX][startY].removeGamePiece();
	if(gamepiece == null) {
	    return false;
	}
	board[endX][endY].placeGamePiece(gamepiece);
	return true;
    }

    /**
     * @author Patrick Munsey, z5020841
     * @param x
     * @param y
     * @return true if the tile is able to be occupied by a GamePiece
     */
    public boolean isMoveable(int x, int y) {	
    	return board[x][y].isMoveable();
    } 

    /**
     * @author Patrick Munsey, z5020841
     * @param playerNumber
     * @param x
     * @param y
     */
    public void initPlayer(PlayerNumber playerNumber, int x, int y) {
		Player newPlayer = new Player(playerNumber);
		players.put(playerNumber, newPlayer);
		placeGamePiece(newPlayer, x, y);
    }

    /**
     * @author Patrick Munsey, z5020841
     * @param x
     * @param y
     */
    public void initBox(int x, int y) {
		Box newBox = new Box();
		placeGamePiece(newBox, x, y);
    }

    /**
     * @author Patrick Munsey, z5020841
     * @param x
     * @param y
     */
    public void initGoal(int x, int y) {
	Goal newGoal = new Goal();
	goals.add(newGoal);
	board[x][y].placeGoal(newGoal);
    }

    /**
     * @param x
     * @param y
     * @param index
     */
    public void initPortal(int x, int y, int index) {
	Portal newPortal = new Portal(index);
	portals.add(newPortal);
	board[x][y].placePortal(newPortal);
    }

    /**
     * @param x
     * @param y
     * @param index
     */
    public void initPortalLoc(int x, int y, int index, int lvNum) {

	Floor newPortalLoc = new Floor(x,y,lvNum);
	newPortalLoc.setLocNum(index);
	newPortalLoc.setLocX(x);
	newPortalLoc.setLocY(y);
	board[x][y] = newPortalLoc;
	portalLocs.add(newPortalLoc);
    }

    /**
     * @author Patrick Munsey, z5020841
     * @param x
     * @param y
     */
    public void initWall(int x, int y, int lvNum) {
	board[x][y] = new Wall(x,y, lvNum);
    }

    /**
     * @author Patrick Munsey, z5020841
     * @param x
     * @param y
     */
    public void initFloor(int x, int y, int lvNum) {
	board[x][y] = new Floor(x,y, lvNum);
    }

	 /**
	  * @author Patrick Munsey, z5020841
	  * @param gamepiece
	  * @param x
	  * @param y
	  */
	 public void placeGamePiece(GamePiece gamepiece, int x, int y) {
		 board[x][y].placeGamePiece(gamepiece);
	 }

	 /**
	  * @author Patrick Munsey, z5020841
	  * @param x
	  * @param y
	  */
	 public void clearTile(int x, int y) {
		 board[x][y].removeGoal();
		 board[x][y].removeGamePiece();
		 board[x][y] = null;
	 }


	 /**
	  * @author Patrick Munsey, z5020841
	  * @param difficulty
	  * @param levelNumber
	  */
	 private void initBoard(int levelNumber) {
		 //changing to level.getLevelFromFile
		 currLevel = new Level(levelNumber);
		 goals.clear();
		 initLevel(currLevel, currLevel.getWidth(), currLevel.getHeight());
		 boardHeight = currLevel.getHeight();
		 boardWidth = currLevel.getWidth();
		 return;
	 }

	 /**
	  * Method which translates string representations of levels into the board
	  * Starts by setting up the board with floors
	  * Then updates the rest of the board based on the string inputs
	  * @author Denny Dien
	  * @param level
	  */
	 private void initLevel(Level level, int boardWidth, int boardHeight) {

		 // Initialise the board with all floors
		 board = new Tile[boardWidth][boardHeight];
		 for(int y = 0; y < boardHeight; y++){
			 for(int x = 0; x < boardWidth; x++){
				 initFloor(x,y, currLevel.getlevelNum());
			 }
		 }

		 // Set up the level based on the string input
		 Iterator<String> itr = level.getLevel().iterator();
		 int row = boardHeight-1;
		 while (itr.hasNext()) {	
			 String strRow = (String) itr.next(); // read the string
			 for (int col = 0; col < boardWidth ; col++) { 
				 char symbol = strRow.charAt(col); // get each char from the string
				 this.createObject(symbol, col, row); // create an object
			 }
			 row--;
		 }

	 }

	 /**
	  * Method which initialises game objects based on their allocated symbol
	  * @author Denny Dien
	  * @param symbol
	  * @param row
	  * @param col
	  */
	 public void createObject(char symbol, int row, int col) {
		 String objectType = TileID.getTileID(symbol);
		 int lvNum = currLevel.getlevelNum();
		 if (objectType.equals("Wall")) {
			 this.initWall(row, col, lvNum);
			 //} else if (objectType.equals("Floor")) {
			 //this.initFloor(row, col);
		 } else if (objectType.equals("Box")) {
			 this.initBox(row, col);
		 } else if (objectType.equals("Goal")) {
			 this.initGoal(row, col);
		 } else if (objectType.equals("Player")) {
			 this.initPlayer(PlayerNumber.Player1, row, col);
		 } else if (objectType.equals("Portal1")) {
			 this.initPortal(row, col, 1);
		 } else if (objectType.equals("Portal2")) {
			 this.initPortal(row, col, 2);
		 } else if (objectType.equals("PortalLoc1")) {
			 this.initPortalLoc(row, col, 1, lvNum);
		 } else if (objectType.equals("PortalLoc2")) {
			 this.initPortalLoc(row, col, 2, lvNum);
		 }
	 }

	 /**
	  * @author James Doldissen
	  * Restart the current level
	  */
	 public void restart()
	 {
		 this.removeAll();
		 this.setLayout(new GridBagLayout());
		 initBoard(currLevel.getlevelNum());
		 tilesToBoard();
		 moves.clear();
		 revalidate();
		 repaint();
	 }

	 /**
	  * Method which checks if magic portals are activated and tries to teleport player
	  * to the correct portal location
	  * @param playernumber
	  * @param undo
	  */
	 public void magicPortal(PlayerNumber playernumber, boolean undo) {

		 int endX;
		 int endY;

		 for (Portal portal: portals) {
			 if(portal.isActivated()) { // If portal is activated

				 //Get the teleport location portal
				 int index = portal.getIndex(); //get the portal # to move to the right portal location
				 for (Floor portalLocs: portalLocs) {

					 if(portalLocs.getLocNum() == index) {
						 // Get the coordinates of the portal location
						 endX = portalLocs.getLocX();
						 endY = portalLocs.getLocY();

						 //Teleport
						 boolean result = players.get(playernumber).teleport(this,endX,endY);
						 if (result == false) { // if cannot teleport, player would have moved into the portal
							 MoveList.playerInPortal = false;
							 this.undoMove(playernumber); // move the player out of the portal
							 break;
						 } else { // if teleport was a success, set player is not in portal
							 MoveList.playerInPortal = false;
							 if (undo == false) {
								 moves.setTeleported(); // set last move: teleported
							 } 
							 break;
						 }
					 }

				 }
				 portal.deactivate();
				 break;

			 }
		 }
	 }

	 /**
	  */
	 public void checkPortal(){

		 if (MoveList.boxInPortal == true) {
			 this.undoMove(PlayerNumber.Player1);
			 MoveList.boxInPortal = false;
		 }

	 }


	 /**
	  * @author Patrick Munsey, z5020841
	  */
	 public void checkCompletion() {
		 for(Goal goal : goals) {
			 if(!goal.isactivated()) {
				 return;
			 }
		 }

		 puzzleGame.displayLevelCompleteScreen();

	 }

	 /**
	  * @author Patrick Munsey, z5020841
	  * @param levelNumber
	  */
	 public void changeLevel(int levelNumber) {
		 currLevel = new Level(levelNumber);
		 boardHeight = currLevel.getHeight();
		 boardWidth = currLevel.getWidth();
		 portals.clear();
		 portalLocs.clear();
		 restart();
	 }

	 /* (non-Javadoc)
	  * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	  */
	 protected void paintComponent(Graphics g) {
		 super.paintComponent(g); // paint the background image and scale it to fill the entire space
		 g.drawImage(this.background_img, 0, 0, this.getWidth(), this.getHeight(), null);
	 }

	 /**
	  * @authors: 	Patrick Munsey
	  * zID: 	z5020841
	  * 
	  */
	 class BoardAdapter extends KeyAdapter {

		 @Override
		 public void keyPressed(KeyEvent e) {

			 int keycode = e.getKeyCode();

			 switch (keycode) {

			 case KeyEvent.VK_LEFT:
				 MovePlayer(PlayerNumber.Player1, Direction.LEFT);
				 break;

			 case KeyEvent.VK_RIGHT:
				 MovePlayer(PlayerNumber.Player1, Direction.RIGHT);
				 break;

			 case KeyEvent.VK_DOWN:
				 MovePlayer(PlayerNumber.Player1, Direction.DOWN);
				 break;

			 case KeyEvent.VK_UP:
				 MovePlayer(PlayerNumber.Player1, Direction.UP);
				 break;

			 case KeyEvent.VK_U:
				 undoMove(PlayerNumber.Player1);
				 break;

			 case KeyEvent.VK_R:
				 restart();
				 break;

			 case KeyEvent.VK_ESCAPE:
				 System.exit(1);
				 break;
			 }
		 }
	 }
}
