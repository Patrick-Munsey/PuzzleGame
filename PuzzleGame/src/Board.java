import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.GroupLayout;
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
		this.boardWidth = 10;
		this.boardHeight = 10;
		
		board = createNewBoard();
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
    
    private int squareWidth() {
	return (int) getSize().getWidth() / boardWidth; 
    }
    
    private int squareHeight() {
	return (int) getSize().getHeight() / boardHeight;
    }
    
    private Tile[][] createNewBoard() {
		Tile[][] newBoard = new Tile[boardHeight][boardWidth];
		
		for(int y = 0; y < boardHeight; y++){
			for(int x = 0; x < boardWidth; x++){
			    newBoard[y][x] = new Wall(x, y);
			}
		}
		 newBoard[5][5] = new Player(5, 5, 1);
		
		return newBoard;
    }
    
    public boolean MovePlayer(int player, int direction) {
	
	
	return false;
    }
    


}
