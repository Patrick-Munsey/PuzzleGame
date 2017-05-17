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
    private HashMap<Integer, Player> players;
    
    /**
     * @param size
     */
    public Board() {
	this.boardWidth = 0;
	this.boardHeight = 0;
	board = new Tile[boardHeight][boardWidth];
	players = new  HashMap<Integer, Player>();
	
	initPlayer(1);
	initBoard(Difficulty.EASY, 1);
	initUI();
    }

    private void initUI() {	
	this.setLayout(new GridLayout(boardHeight, boardWidth));
	this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	
	for(int y = 0; y < boardHeight; y++){
		for(int x = 0; x < boardWidth; x++){
		    this.add(board[y][x]);
		}
	}
	setFocusable(true);  
    }
    
    

    
    
    public boolean MovePlayer(int player, int direction) {
	
	
	return false;
    }
    
    public void swapTiles(int x1, int y1, int x2, int y2) {
	Tile tempTile = board[y1][x1];
	board[y1][x1] = board[y2][x2];
	board[y2][x2] = tempTile;
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
    
    public void initPlayer(int playerNumber) {
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
   	board[2][2] = players.get(1);
   	
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
}
