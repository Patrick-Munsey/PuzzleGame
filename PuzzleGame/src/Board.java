import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
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
    
    /**
     * @author Patrick Munsey, z5020841
     */
    public Board() {
		this.boardWidth = 0;
		this.boardHeight = 0;
		board = new Tile[boardHeight][boardWidth];
		players = new  HashMap<PlayerNumber, Player>();
		goals =  new LinkedList<Goal>();
		addKeyListener(new BoardAdapter());
		
		initBoard(Difficulty.EASY, 0);
		//initBoard(Difficulty.EASY, 2);
		//initBoard(Difficulty.MEDIUM, 1);
    	//initBoard(Difficulty.MEDIUM, 3);
		initUI();
    }

    /**
     * @author Patrick Munsey, z5020841
     */
    private void initUI() {	
		this.setLayout(new GridLayout(boardHeight, boardWidth));
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		for(int y = 0; y < boardHeight; y++){
			for(int x = 0; x < boardWidth; x++){
			    this.add(board[boardWidth-1-y][x]);//labels have to be added from top to bottom not bottom to top so reverse board y index
			}
		}
			setFocusable(true);  
    }
    
    /**
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
		players.get(playernumber).movePiece(this, direction);
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
		GamePiece gamepiece = board[y][x].removeGamePiece();
		if(gamepiece == null) {
		    return false;
		}
		
		switch(direction) {
			case UP:
			    if(board[y+1][x].isMoveable()) {
				board[y+1][x].placeGamePiece(gamepiece);
				refreshUI();
				return true;
			    }
			    break;
			case DOWN:
			    if(board[y-1][x].isMoveable()) {
				board[y-1][x].placeGamePiece(gamepiece);
				refreshUI();
				return true;
			    }
			    break;
			case LEFT:
			    if(board[y][x-1].isMoveable()) {
				board[y][x-1].placeGamePiece(gamepiece);
				refreshUI();
				return true;
			    }
			    break;
			case RIGHT:
			    if(board[y][x+1].isMoveable()) {
				board[y][x+1].placeGamePiece(gamepiece);
				refreshUI();
				return true;
			    }
			    break;
			default:
			    break;
		}
		
		board[y][x].placeGamePiece(gamepiece);
		return false;
    }
    
    /**
     * @author Patrick Munsey, z5020841
     * @param x
     * @param y
     * @return true if the tile is able to be occupied by a GamePiece
     */
    public boolean isMoveable(int x, int y) {	
    	return board[y][x].isMoveable();
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
		board[y][x].placeGoal(newGoal);
    }
    
    /**
     * @author Patrick Munsey, z5020841
     * @param x
     * @param y
     */
    public void initWall(int x, int y) {
    	board[y][x] = new Wall(x,y);
    }
    
    /**
     * @author Patrick Munsey, z5020841
     * @param x
     * @param y
     */
    public void initFloor(int x, int y) {
    	board[y][x] = new Floor(x,y);
    }
    
    /**
     * @author Patrick Munsey, z5020841
     * @param gamepiece
     * @param x
     * @param y
     */
    public void placeGamePiece(GamePiece gamepiece, int x, int y) {
    	board[y][x].placeGamePiece(gamepiece);
    }
    
    /**
     * @author Patrick Munsey, z5020841
     * @param x
     * @param y
     */
    public void clearTile(int x, int y) {
		board[y][x].removeGoal();
		board[y][x].removeGamePiece();
		board[y][x] = null;
    }
    

    /**
     * @author Patrick Munsey, z5020841
     * @param difficulty
     * @param levelNumber
     */
    private void initBoard(Difficulty difficulty, int levelNumber) {
    	wipeBoard();
    	//changing to level.getLevelFromFile
    	String filePath = "../PuzzleGame/levels/main/";
			switch(difficulty) {
			case EASY:
				filePath = filePath + "e";
			    break;
			case MEDIUM:
				filePath = filePath + "m";
			    break;
			case HARD:
			    filePath = filePath + "h";
			default:
			    System.out.println("Invalid difficulty");
			    return;   
		}
			filePath = filePath + levelNumber + ".txt";
			System.out.println(filePath);
			Level currLevel = new Level();
			currLevel.makeLevelFromFile(filePath);
			initLevel(currLevel, currLevel.getWidth(), currLevel.getHeight());
			this.boardHeight = currLevel.getHeight();
			this.boardWidth = currLevel.getWidth();
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
    	board = new Tile[boardHeight][boardWidth];
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
				System.out.print(symbol);
				//System.out.print(symbol + "(" + row +"," + col +") ");
			}
			System.out.println();
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
     * 
     */
    /*private void initLevelE1() {
    	
    	this.boardWidth = 5;
		this.boardHeight = 5;

	   	Level level = new Level();
		level.addRow("#####"); // 0
		level.addRow("##.##"); // 1
		level.addRow("##$##"); // 2
		level.addRow("##-##"); // 3
		level.addRow("##@##"); // 4
		//initLevel(level, this.boardWidth, this.boardHeight);
		//level.initLevelFromFile("../PuzzleGame/levels/main/e0.txt", board, this);
    }
    
    /**
     * 
     *
    private void initLevelE2() {
		this.boardWidth = 6;
		this.boardHeight = 6;
		board = new Tile[boardHeight][boardWidth];
	   	for(int y = 0; y < boardHeight; y++){
	   		for(int x = 0; x < boardWidth; x++){
	   		    initWall(x,y);
	   		}
	   	}
	   	initFloor(1,2);
	   	initFloor(1,3);
	   	initFloor(1,4);
	   	initFloor(2,1);
	   	initFloor(2,2);
	   	initFloor(2,3);
	   	initFloor(2,4);
	   	initFloor(3,2);
	   	initFloor(3,3);
	   	initFloor(4,1);
	   	initFloor(4,2);
	   	initFloor(4,3);
	   	initFloor(4,4);
	   	
	   	initPlayer(PlayerNumber.Player1, 1, 4);
	   	
	   	initBox(2,3);
	   	
	   	initGoal(4,1);
    }
    
    /**
     * 
     *
    private void initLevelE3() {
		this.boardWidth = 5;
		this.boardHeight = 5;
		Level level = new Level();
		// Insert level strings here
		initLevel(level, this.boardWidth, this.boardHeight);
    }
    
    /**
     * 
     *
    private void initLevelM1() {
		this.boardWidth = 8;
		this.boardHeight = 8;
		board = new Tile[boardHeight][boardWidth];
	   	for(int y = 0; y < boardHeight; y++){
	   		for(int x = 0; x < boardWidth; x++){
	   		    initWall(x,y);
	   		}
	   	}
	   	
	   	initFloor(1,1);
	   	initFloor(1,2);
	   	initFloor(1,3);
	   	initFloor(1,4);
	   	initFloor(1,5);
	   	initFloor(1,6);
	   	initFloor(2,1);
	   	initFloor(2,4);
	   	initFloor(3,1);
	   	initFloor(3,4);
	   	initFloor(4,1);
	   	initFloor(4,4);
	   	initFloor(5,1);
	   	initFloor(5,4);
	   	initFloor(6,1);
	   	initFloor(6,2);
	   	initFloor(6,3);
	   	initFloor(6,4);
	   	initFloor(6,5);
	   	
	   	initPlayer(PlayerNumber.Player1, 1, 6);
	   	
	   	initBox(2,4);
	   	initBox(6,2);
	   	
	   	initGoal(6,4);
	   	initGoal(6,5);
   	
    }
    
    /**
     * 
     *
    private void initLevelM2() {
		this.boardWidth = 8;
		this.boardHeight = 8;
		Level level = new Level();
		// Insert level strings here
		initLevel(level, this.boardWidth, this.boardHeight);
    }
    
    /**
     * 
     *
    private void initLevelM3() {
		this.boardWidth = 8;
		this.boardHeight = 8;
		board = new Tile[boardHeight][boardWidth];
	   	for(int y = 0; y < boardHeight; y++){
	   		for(int x = 0; x < boardWidth; x++){
	   		    initWall(x,y);
	   		}
	   	}
	   	initFloor(1,1);
	   	initFloor(1,2);
	   	initFloor(1,3);
	   	initFloor(1,4);
	   	initFloor(1,5);
	   	initFloor(1,6);
	   	initFloor(2,1);
	   	initFloor(2,2);
	   	initFloor(2,6);
	   	initFloor(3,2);
	   	initFloor(3,3);
	   	initFloor(3,4);
	   	initFloor(3,6);
	   	initFloor(4,2);
	   	initFloor(4,3);
	   	initFloor(4,6);
	   	initFloor(5,1);
	   	initFloor(5,2);
	   	initFloor(5,3);
	   	initFloor(5,6);
	   	initFloor(6,1);
	   	initFloor(6,2);
	   	initFloor(6,3);
	   	initFloor(6,4);
	   	initFloor(6,5);
	   	initFloor(6,6);
	   	
	   	initPlayer(PlayerNumber.Player1, 1, 6);
	   	
	   	initBox(2, 2);
	   	initBox(5, 2);
	   	
	   	initGoal(3,4);
	   	initGoal(4,3);
   	
    }
    
    /**
     * 
     *
    private void initLevelH1() {
		this.boardWidth = 10;
		this.boardHeight = 10;
		Level level = new Level();
		// Insert level strings here
		initLevel(level, this.boardWidth, this.boardHeight);
    }
    
    /**
     * 
     *
    private void initLevelH2() {
		this.boardWidth = 10;
		this.boardHeight = 10;
		Level level = new Level();
		// Insert level strings here
		initLevel(level, this.boardWidth, this.boardHeight);
    }
    

    /**
     *
     *
    private void initLevelH3() {
		this.boardWidth = 10;
		this.boardHeight = 10;
		Level level = new Level();
		// Insert level strings here
		initLevel(level, this.boardWidth, this.boardHeight);
    }*/
    

    /**
     * 
     */
    private void wipeBoard() {
		this.boardWidth = 0;
		this.boardHeight = 0;
		for(int y = 0; y < boardHeight; y++){
			for(int x = 0; x < boardWidth; x++){
			    clearTile(x,y);
			}
		}
    }
    
    /**
     * @author James Doldissen
     * Restart the current level
     */
    public void restart()
    {
    	wipeBoard();
    	initBoard(Difficulty.EASY, 0);
    	//initBoard(Difficulty.EASY, 2);
    	//initBoard(Difficulty.MEDIUM, 1);
    	//initBoard(Difficulty.MEDIUM, 3);
    	updateUI();
    }
    
    /**
     * @authors: 	Patrick Munsey
     * zID: 	z5020841
=======

    /**
     * @author Patrick Munsey
     * zID: z5020841
>>>>>>> refs/remotes/origin/Patrick
     * 
     */
    class BoardAdapter extends KeyAdapter {
	    
	    @Override
	    public void keyPressed(KeyEvent e) {

	        int keycode = e.getKeyCode();

	        switch (keycode) {
	            
	        case KeyEvent.VK_LEFT:
	            MovePlayer(PlayerNumber.Player1, Direction.LEFT);
	            System.out.println("moving player left\n");
	            break;
	            
	        case KeyEvent.VK_RIGHT:
	            MovePlayer(PlayerNumber.Player1, Direction.RIGHT);
	            System.out.println("moving player right\n");
	            break;
	            
	        case KeyEvent.VK_DOWN:
	            MovePlayer(PlayerNumber.Player1, Direction.DOWN);
	            System.out.println("moving player down\n");
	            break;
	            
	        case KeyEvent.VK_UP:
	            MovePlayer(PlayerNumber.Player1, Direction.UP);
	            System.out.println("moving player up\n");
	            break;
	        }
	    }
	}
}
