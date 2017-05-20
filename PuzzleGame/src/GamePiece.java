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
    public boolean movePiece(Board board, Direction direction) {
	
		switch(direction) {
			case UP:
			    if(board.isMoveable(this.x, this.y +1)) {
				board.MovePiece(this.x, this.y, direction);
				return true;
			    }
			    else if(board.MovePiece(this.x, this.y +1, direction)) {
				board.MovePiece(this.x, this.y, direction);
				return true;
			    }
			    break;
			case DOWN:
			    if(board.isMoveable(this.x, this.y -1)) {
				board.MovePiece(this.x, this.y, direction);
				return true;
			    }
			    else if(board.MovePiece(this.x, this.y -1, direction)) {
				board.MovePiece(this.x, this.y, direction);
				return true;
			    }
			    break;
			case LEFT:
			    if(board.isMoveable(this.x -1, this.y)) {
				board.MovePiece(this.x, this.y, direction);
				return true;
			    }
			    else if(board.MovePiece(this.x -1, this.y, direction)) {
				board.MovePiece(this.x, this.y, direction);
				return true;
			    }
			    break;
			case RIGHT:
			    if(board.isMoveable(this.x +1, this.y)) {
				board.MovePiece(this.x, this.y, direction);
				return true;
			    }
			    else if(board.MovePiece(this.x +1, this.y, direction)) {
				board.MovePiece(this.x, this.y, direction);
				return true;
			    }
			    break;
			default:
			    break;
		}
			return false;
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
}
