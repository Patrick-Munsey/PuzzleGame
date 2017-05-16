import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    
    /**
     * @param size
     */
    public Board() {
	this.boardWidth = 10;
	this.boardHeight = 10;
	
	initBoard();
    }

    private void initBoard() {
        
	setFocusable(true);  
	
	      
    }
    
    
    


}
