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
import java.util.HashMap;
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
    private int box_size = 30;
    JPanel the_board = new JPanel();
    
    /**
     * @author Patrick Munsey, z5020841
     */
    public Board() {
		this.boardWidth = 0;
		this.boardHeight = 0;
		board = new Tile[boardHeight][boardWidth];
		players = new  HashMap<PlayerNumber, Player>();
		goals =  new LinkedList<Goal>();
		the_board.addKeyListener(new BoardAdapter());
		
		//initBoard(Difficulty.EASY, 1);
		//initBoard(Difficulty.EASY, 2);
		initBoard(Difficulty.MEDIUM, 1);
    	//initBoard(Difficulty.MEDIUM, 3);
		initUI();
		setPreferredSize(new Dimension(box_size*boardWidth*2, box_size*boardHeight*2));
    }

    /**
     * @author Patrick Munsey, z5020841
     */
    private void initUI() {	
    setLayout(new GridBagLayout());
	the_board.setLayout(new GridLayout(boardHeight, boardWidth));
	the_board.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	
	for(int y = 0; y < boardHeight; y++){
		for(int x = 0; x < boardWidth; x++){
		    the_board.add(board[boardWidth-1-y][x]);//labels have to be added from top to bottom not bottom to top so reverse board y index
		}
	}
		the_board.setFocusable(true); 
		add(the_board);
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
			switch(difficulty) {
			case EASY:
			    switch(levelNumber) {
			    	case 1:
			    	    initLevelE1();
			    	    return;
			    	case 2:
			    	    initLevelE2();
			    	    return;
			    	case 3:
			    	    initLevelE3();
			    	    return;
			    	default:
			    	    System.out.println("Invalid level");
			    	    return;
			    }
			case MEDIUM:
			    switch(levelNumber) {
			    	case 1:
			    	    initLevelM1();
			    	    return;
			    	case 2:
			    	    initLevelM2();
			    	    return;
			    	case 3:
			    	    initLevelM3();
			    	    return;
			    	default:
			    	    System.out.println("Invalid level");
			    	    return;
			    }
			case HARD:
			    switch(levelNumber) {
			    	case 1:
			    	    initLevelH1();
			    	    return;
			    	case 2:
			    	    initLevelH2();
			    	    return;
			    	case 3:
			    	    initLevelH3();
			    	    return;
			    	default:
			    	    System.out.println("Invalid level");
			    	    return;
			    }
			default:
			    System.out.println("Invalid difficulty");
			    return;   
		}
    }
    
    /**
     * 
     */
    private void initLevelE1() {
	this.boardWidth = 5;
	this.boardHeight = 5;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    initWall(x,y);
   		}
   	}
   	
   	initFloor(1,2);
   	initFloor(2,2);
   	initFloor(3,2);
   	initFloor(3,3);

	initPlayer(PlayerNumber.Player1, 3, 2);
	initBox(2,2);
	initGoal(1,2);
    }
    
    /**
     * 
     */
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
     */
    private void initLevelE3() {
	this.boardWidth = 5;
	this.boardHeight = 5;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    initWall(x,y);
   		}
   	}
    }
    
    /**
     * 
     */
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
     */
    private void initLevelM2() {
	this.boardWidth = 8;
	this.boardHeight = 8;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    initWall(x,y);
   		}
   	}
    }
    
    /**
     * 
     */
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
     */
    private void initLevelH1() {
	this.boardWidth = 10;
	this.boardHeight = 10;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    initWall(x,y);
   		}
   	}
    }
    
    /**
     * 
     */
    private void initLevelH2() {
	this.boardWidth = 10;
	this.boardHeight = 10;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    initWall(x,y);
   		}
   	}
    }
    

    /**
     *
     */
    private void initLevelH3() {
	this.boardWidth = 10;
	this.boardHeight = 10;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    initWall(x,y);
   		}
   	}
    }
    

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
    	//initBoard(Difficulty.EASY, 1);
    	//initBoard(Difficulty.EASY, 2);
    	initBoard(Difficulty.MEDIUM, 1);
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
