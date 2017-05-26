import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * The generic class that populates the board array
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class GamePiece {
	private int x;
	private int y;

	/**
	 * Constructor for GamePiece
	 */
	public GamePiece() {
	}


	/**
	 * author Patrick Munsey, z5020841
	 * @param board
	 * @param direction
	 * @param moves
	 * @param undo
	 * @return true if the piece was able to be moved
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

	/**
	 * Method to teleport a player to certain coordinates on the board
	 * @param board
	 * @param endX
	 * @param endY
	 * @return true if the player is able to move through a portal at the provided coordinates
	 */
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
	 * Method to place gamepiece based on x,y coordinate
	 * @param x
	 * @param y
	 */
	public void placePiece(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Method to update the label of the GP
	 * @param label
	 */
	public void updateLabel(JLabel label, int lvNum) {
		label.setText("GP");
	}

	/**
	 * @param path
	 * @return returns an appropriate imageIcon dependant on the type of GamePiece
	 */
	public ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = Wall.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * @return true if the Object is a Box
	 */
	public boolean isBox() {
		return false;
	}

	/**
	 * Method to get the X ordinate of GamePiece
	 * @return
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Method to get the Y ordinate of GamePiece
	 * @return
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * to override as a box
	 */
	public void updateBoxDeactivate() {
		// TODO Auto-generated method stub

	}

	/**
	 * to override as a box
	 */
	public void updateBoxActive() {
		// TODO Auto-generated method stub

	}

}
