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
import javax.swing.JPanel;
import javax.swing.Timer;



public class Board extends JPanel  {
    
    private Tile[][] board;
    private int boardWidth;
    private int boardHeight;
    private HashMap<PlayerNumber, Player> players;
    private LinkedList<Goal> goals;
    private int box_size = 30;
    private JPanel the_board;
    public Level currLevel;
    
   
    public Board() {
    	the_board = new JPanel();
		this.boardWidth = 0;
		this.boardHeight = 0;
		board = new Tile[boardWidth][boardHeight];
		players = new  HashMap<PlayerNumber, Player>();
		goals =  new LinkedList<Goal>();
		the_board.addKeyListener(new BoardAdapter());
		currLevel = new Level();
		//initBoard(Difficulty.EASY, 0);
		//initBoard(Difficulty.EASY, 1);
		initBoard(Difficulty.EASY, 0);
		initUI();
    }

   
    private void initUI() {	
	    setLayout(new GridBagLayout());
		the_board.setLayout(new GridLayout(boardHeight, boardWidth));
		the_board.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		tilesToBoard();
		the_board.setFocusable(true); 
		add(the_board);
    }
    
    
    private void tilesToBoard ()
    {
	for(int y = 0; y < boardHeight; y++){
	    for(int x = 0; x < boardWidth; x++){
		the_board.add(board[x][boardHeight-1-y]);//labels have to be added from top to bottom not bottom to top so reverse board y index
	    }
	}
    }
    
   
    private void refreshUI() {
	the_board.revalidate();
	the_board.repaint();
    }
    

   
    public boolean MovePlayer(PlayerNumber playernumber, Direction direction) {
	players.get(playernumber).movePiece(this, direction);
	checkCompletion();
	return true;
    }

    
    public boolean isMoveable() {
    	return false;
    }
    
    
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
    
   
    public boolean isMoveable(int x, int y) {	
    	return board[x][y].isMoveable();
    } 
    
    
    public void initPlayer(PlayerNumber playerNumber, int x, int y) {
		Player newPlayer = new Player(playerNumber);
		players.put(playerNumber, newPlayer);
		placeGamePiece(newPlayer, x, y);
    }
    
   
    public void initBox(int x, int y) {
		Box newBox = new Box();
		placeGamePiece(newBox, x, y);
    }
    
    
    public void initGoal(int x, int y) {
		Goal newGoal = new Goal();
		goals.add(newGoal);
		board[x][y].placeGoal(newGoal);
    }
    
    
    public void initWall(int x, int y) {
    	board[x][y] = new Wall(x,y);
    }
    
    
    public void initFloor(int x, int y) {
    	board[x][y] = new Floor(x,y);
    }
    
    
    public void placeGamePiece(GamePiece gamepiece, int x, int y) {
    	board[x][y].placeGamePiece(gamepiece);
    }
    
    
    public void clearTile(int x, int y) {
		board[x][y].removeGoal();
		board[x][y].removeGamePiece();
		board[x][y] = null;
    }
    

    
    private void initBoard(Difficulty difficulty, int levelNumber) {
    	//changing to level.getLevelFromFile
    	String filePath = "../PuzzleGame/levels/main/";
    	currLevel = new Level();
    	goals.clear();
    	
		currLevel.setDiff(difficulty);
		currLevel.setNum(levelNumber);
		
			switch(difficulty) {
			case EASY:
				filePath = filePath + "e";
			    break;
			case MEDIUM:
				filePath = filePath + "m";
			    break;
			case HARD:
			    filePath = filePath + "h";
			    break;
			default:
			    System.out.println("Invalid difficulty");
			    return;   
		}
			filePath = filePath + levelNumber + ".txt";
			currLevel.makeLevelFromFile(filePath);
			initLevel(currLevel, currLevel.getWidth(), currLevel.getHeight());
			boardHeight = currLevel.getHeight();
			boardWidth = currLevel.getWidth();
			return;
    }
    
    
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
    
    
    public void restart()
    {
    	the_board.removeAll();
    	the_board.setLayout(new GridLayout(boardHeight, boardWidth));
    	initBoard(currLevel.getDiff(), currLevel.getNum());
    	tilesToBoard();
    	revalidate();
    	repaint();
    }
    
    public void checkCompletion() {
	for(Goal goal : goals) {
	    if(!goal.isactivated()) {
		return;
	    }
	}
	System.out.println("Level complete!!!");
	
	try {
		Level nextLevel = currLevel.loadNextLevel(this);
		boardHeight = nextLevel.getHeight();
		boardWidth = nextLevel.getWidth();
		System.out.println("Next level loading");
		currLevel = nextLevel;
		//initUI();
		//System.out.println(this.currLevel.);
		restart();
    	
	} catch (FileNotFoundException e) {
		System.out.println("You've Won!! (maybe)");
	}
    }
    
    
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
	        }
	    }
	}
}
