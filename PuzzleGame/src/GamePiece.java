import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class GamePiece {
    private int x;
    private int y;
    
    /**
     * 
     */
    public GamePiece() {
    }
    
    /**
     * @param board
     * @param direction
     * @return true is the GamePiece was moved correctly
     */
    public boolean movePiece(Board board, Direction direction, MoveList moves, boolean undo) {
	
    	boolean move = false;
    	boolean boxMoved = false;
    	
		switch(direction) {
			case UP:
			    if(board.isMoveable(this.x, this.y +1)) {
					board.MovePiece(this.x, this.y, direction);
					move = true; //flag that GamePiece has been moved
			    }
			    else if(board.MovePiece(this.x, this.y +1, direction)) { // If box can and IS moved
					board.MovePiece(this.x, this.y, direction);
					boxMoved = true; //flag that a box has been moved
			    }
			    break;
			case DOWN:
			    if(board.isMoveable(this.x, this.y -1)) {
					board.MovePiece(this.x, this.y, direction);
					move = true; //flag that GamePiece has been moved
			    }
			    else if(board.MovePiece(this.x, this.y -1, direction)) {
					board.MovePiece(this.x, this.y, direction);
					boxMoved = true; //flag that a box has been moved
			    }
			    break;
			case LEFT:
			    if(board.isMoveable(this.x -1, this.y)) {
					board.MovePiece(this.x, this.y, direction);
					move = true; //flag that GamePiece has been moved
			    }
			    else if(board.MovePiece(this.x -1, this.y, direction)) {
					board.MovePiece(this.x, this.y, direction);
					boxMoved = true; //flag that a box has been moved
			    }
			    break;
			case RIGHT:
			    if(board.isMoveable(this.x +1, this.y)) {
					board.MovePiece(this.x, this.y, direction);
					move = true; //flag that GamePiece has been moved
			    }
			    else if(board.MovePiece(this.x +1, this.y, direction)) {
					board.MovePiece(this.x, this.y, direction);
					boxMoved = true; //flag that a box has been moved
			    }
			    break;
			default:
			    break;
		}
		
		// If undo is false, we will reverse the move but we don't add it to the moves list
		// Instead, we add it to the undoList
		
		if (boxMoved == true && undo == false) {
			moves.addMove(direction, true); // Add move and note that box has moved too
			return true;
		} else if (move == true && undo == false) {
			moves.addMove(direction, false); // Add move and note that box was not moved
			return true;
		} else {
			return false;
		}
		
    }
    
    public boolean teleport (Board board, int endX, int endY) {
    	
    	if (board.isMoveable(endX, endY)) {
    		board.MovePiece(this.x, this.y, endX, endY);
    		return true;
    	} else {
    		MoveList.playerInPortal = true;
    		return false;
    	}
    	
    }
    
    /**
     * @param x
     * @param y
     */
    public void placePiece(int x, int y) {
		this.x = x;
		this.y = y;
    }
    
    /**
     * @param label
     */
    public void updateLabel(JLabel label) {
    	label.setText("GP");
    }
    
    public ImageIcon createImageIcon(String path) {
  		java.net.URL imgURL = Wall.class.getResource(path);
  		if (imgURL != null) {
  			return new ImageIcon(imgURL);
  		} else {
  			System.err.println("Couldn't find file: " + path);
  			return null;
  		}
  	}
    public boolean isBox() {
	return false;
    }
    
    public int getX() {
    	return this.x;
    }
    
    public int getY() {
    	return this.y;
    }
}
