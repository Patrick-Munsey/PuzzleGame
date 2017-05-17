import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @authors:	Patrick Munsey
 * zID: 	z5020841
 * 
 */
public class Board extends JPanel  {
    

    
    private Tile[][] board;
    private int boardWidth;
    private int boardHeight;
    private HashMap<PlayerNumber, Player> players;
    
    /**
     * @param size
     */
    public Board() {
	this.boardWidth = 0;
	this.boardHeight = 0;
	board = new Tile[boardHeight][boardWidth];
	players = new  HashMap<PlayerNumber, Player>();
	
	initPlayer(PlayerNumber.Player1);
	initBoard(Difficulty.EASY, 1);
	initUI();
    }

    private void initUI() {	
	this.setLayout(new GridLayout(boardHeight, boardWidth));
	this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	
	for(int y = 0; y < boardHeight; y++){
		for(int x = 0; x < boardWidth; x++){
		    this.add(board[y][x].label);
		}
	}
	setFocusable(true);  
    }
    
    private void refreshUI() {
	this.revalidate();
        this.repaint();
    }
    
    public boolean MovePlayer(PlayerNumber playernumber, Direction direction) {
	Player player = players.get(playernumber);
	int x1 = player.getX();
	int y1 = player.getY();
	int x2 = x1;
	int y2 = y1;
	
	switch(direction) {
	case UP:
	    y2 = y2 + 1;
	    break;
	case DOWN:
	    y2 = y2 - 1;
	    break;
	case LEFT:
	    x2 = x2 - 1;
	    break;
	case RIGHT:
	    x2 = x2 + 1;
	    break;
	default:
	    return false;
	}
	
	Tile tempTile = board[y1][x1];
	board[y1][x1] = board[y2][x2];
	board[y2][x2] = tempTile;
	board[y1][x1].swapWith(board[y2][x2]);
	return true;
    }
    
    public boolean isMoveable() {
	
	
	
	return false;
    }
    
    public void swapTiles(int x1, int y1, int x2, int y2) {
	Tile tempTile = board[y1][x1];
	board[y1][x1] = board[y2][x2];
	board[y2][x2] = tempTile;
	board[y1][x1].swapWith(board[y2][x2]);
    }
    
    
    
    public void initPlayer(PlayerNumber playerNumber) {
	Player newPlayer = new Player(0,0,playerNumber);
	players.put(playerNumber, newPlayer);
    }
    
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
    
    private void initLevelE1() {
	this.boardWidth = 5;
	this.boardHeight = 5;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    board[y][x] = new Wall(x, y);
   		}
   	}
   	board[2][2] = players.get(PlayerNumber.Player1);
   	
    }
    
    private void initLevelE2() {
	this.boardWidth = 5;
	this.boardHeight = 5;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    board[y][x] = new Wall(x, y);
   		}
   	}
    }
    
    private void initLevelE3() {
	this.boardWidth = 5;
	this.boardHeight = 5;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    board[y][x] = new Wall(x, y);
   		}
   	}
    }
    
    private void initLevelM1() {
	this.boardWidth = 8;
	this.boardHeight = 8;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    board[y][x] = new Wall(x, y);
   		}
   	}
    }
    
    private void initLevelM2() {
	this.boardWidth = 8;
	this.boardHeight = 8;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    board[y][x] = new Wall(x, y);
   		}
   	}
    }
    
    private void initLevelM3() {
	this.boardWidth = 8;
	this.boardHeight = 8;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    board[y][x] = new Wall(x, y);
   		}
   	}
    }
    
    private void initLevelH1() {
	this.boardWidth = 10;
	this.boardHeight = 10;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    board[y][x] = new Wall(x, y);
   		}
   	}
    }
    
    private void initLevelH2() {
	this.boardWidth = 10;
	this.boardHeight = 10;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    board[y][x] = new Wall(x, y);
   		}
   	}
    }
    
    private void initLevelH3() {
	this.boardWidth = 10;
	this.boardHeight = 10;
	board = new Tile[boardHeight][boardWidth];
   	for(int y = 0; y < boardHeight; y++){
   		for(int x = 0; x < boardWidth; x++){
   		    board[y][x] = new Wall(x, y);
   		}
   	}
    }
    
    private void wipeBoard() {
	this.boardWidth = 0;
	this.boardHeight = 0;
	for(int y = 0; y < boardHeight; y++){
		for(int x = 0; x < boardWidth; x++){
		    board[y][x] = null;
		}
	}
    }
}
