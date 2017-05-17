import javax.swing.JLabel;

/**
 * @authors: 	Patrick Munsey
 * zID: 	z5020841
 * 
 */
public class GamePiece {
    private int x;
    private int y;
    
    public GamePiece() {
    }
    
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
    
    public void updateLabel(JLabel label) {
	label.setText("GP");
    }
}
