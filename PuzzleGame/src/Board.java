import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Board extends JPanel  {
    private Tile[][] board;
    private int boardWidth;
    private int boardHeight;
    private HashMap<PlayerNumber, Player> players;
    private LinkedList<Goal> goals;
    private int box_size = 30;
    private JPanel the_board;
    public Level currLevel;
    private MoveList moves;
    private int countMoves; //counter for every move you make
    private JFrame frame;
    
    /**
     * @author Patrick Munsey, z5020841
     */
    public Board(JFrame frame) {
    	this.frame = frame;
		the_board = new JPanel();
		this.boardWidth = 0;
		this.boardHeight = 0;
		board = new Tile[boardWidth][boardHeight];
		players = new  HashMap<PlayerNumber, Player>();
		goals =  new LinkedList<Goal>();
		moves = new MoveList();
		the_board.addKeyListener(new BoardAdapter());
		countMoves = 0;
		initBoard(12);
		initUI();
    }

    /**
     * @author Patrick Munsey, z5020841
     */
    private void initUI() {	
	    setLayout(new GridBagLayout());
		the_board.setLayout(new GridLayout(boardHeight, boardWidth));
		the_board.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tilesToBoard();
		the_board.setFocusable(true); 
		add(the_board);
    }
    
    /** @author James Doldissen
     * Write all the tiles in the board array to the jpanel
     */
    private void tilesToBoard ()
    {
		for(int y = 0; y < boardHeight; y++){
		    for(int x = 0; x < boardWidth; x++){
			the_board.add(board[x][boardHeight-1-y]);//labels have to be added from top to bottom not bottom to top so reverse board y index
		    }
		}
    }
    
    /** Refresh the JPanel after a move has been made
     * @author Patrick Munsey, z5020841
     */
    private void refreshUI() {
		the_board.revalidate();
		the_board.repaint();
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
    	
    	//move the player back
    	boolean moveCheck = players.get(playernumber).movePiece(this, undoDirection, moves, true); 
    	
    	//move the box back
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
     * @author Patrick Munsey, z5020841
     * @param x
     * @param y
     */
    public void initWall(int x, int y) {
    	board[x][y] = new Wall(x,y);
    }
    
    /**
     * @author Patrick Munsey, z5020841
     * @param x
     * @param y
     */
    public void initFloor(int x, int y) {
    	board[x][y] = new Floor(x,y);
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
	   		    initFloor(x,y);
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
		
		if (objectType.equals("Wall")) {
			this.initWall(row, col);
		//} else if (objectType.equals("Floor")) {
			//this.initFloor(row, col);
		} else if (objectType.equals("Box")) {
			this.initBox(row, col);
		} else if (objectType.equals("Goal")) {
			this.initGoal(row, col);
		} else if (objectType.equals("Player")) {
			this.initPlayer(PlayerNumber.Player1, row, col);
		} 
	}
    
    /**
     * @author James Doldissen
     * Restart the current level
     */
    public void restart() {
    	the_board.removeAll();
    	the_board.setLayout(new GridLayout(boardHeight, boardWidth));
    	initBoard(currLevel.getlevelNum());
    	tilesToBoard();
    	moves.clear();
    	revalidate();
    	repaint();
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
		
		try {
			Level nextLevel = currLevel.loadNextLevel(this);
			boardHeight = nextLevel.getHeight();
			boardWidth = nextLevel.getWidth();
			currLevel = nextLevel;
			restart();
	    	
		} catch (FileNotFoundException e) {
			System.out.println("You've Won!! (maybe)");
		}
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
	        countMoves++;

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
