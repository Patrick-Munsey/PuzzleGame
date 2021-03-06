import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * A type of Tile that can hold goals and be moved on by GamePieces
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Floor extends Tile{
	private GamePiece gamepiece;
	private Goal goal;
	private Box box;

	// for portal purposes
	private Portal portal;
	private boolean portalLoc = false;
	private int locNum;
	private int locX;
	private int locY;

	/**
	 * Constructor for Floor
	 * @param x
	 * @param y
	 */
	public Floor(int x, int y, int lvNum) {
		super(x,y, lvNum);
	}

	/**
	 * Check if floor can be moved into
	 */
	@Override
	public boolean isMoveable() {
		if (portal != null) {
			return true;
		} else if(gamepiece == null) {
			return true;
		} 
		return false;
	}
	
	/**
	 * Update the image icon of the floor
	 */
	@Override
	public void updateLabel() {
		if(gamepiece != null) {
			gamepiece.updateLabel(this, lvNum);
		}

		else {
			if(goal != null) {
				ImageIcon icon = createImageIcon("images/goal.png");
				setIcon(icon);
			} else if (portal != null) {
				//ImageIcon icon = createImageIcon("images/" + lvNum + "/portal.png"); 
				ImageIcon icon = createImageIcon("images/magic1.png");
				setIcon(icon);
			} else {
				ImageIcon icon = createImageIcon("images/floor.png");
				setIcon(icon);
			}  
		}
	}

	/**
	 * Method to place game pieces onto this floor
	 */
	public void placeGamePiece(GamePiece gamepiece) {
		this.gamepiece = gamepiece;
		gamepiece.placePiece(this.x, this.y);

		if((goal != null) && gamepiece.isBox()) {
			goal.activate();
			gamepiece.updateBoxActive();
		} else if (portal != null && !gamepiece.isBox()) {
			MoveList.playerInPortal = true;
			portal.activate();
		} else if (portal != null && gamepiece.isBox()) { 
			//Box will go into portal: need to undo the move
			MoveList.boxInPortal = true;
		}

		updateLabel();
	}


	/**
	 * Method to remove game pieces from this floor piece
	 */
	public GamePiece removeGamePiece() {
		GamePiece retGamePiece = this.gamepiece;
		this.gamepiece = null;
		if(goal != null) {
			goal.deactivate();
			retGamePiece.updateBoxDeactivate();
		}
		updateLabel();
		return retGamePiece;
	}


	/**
	 * Method to place goals onto this floor piece
	 */
	public void placeGoal(Goal goal) {
		this.goal = goal;
		updateLabel();
	}


	/**
	 * Method to remove goals from this floor
	 */
	public void removeGoal() {
		this.goal = null;
		updateLabel();
	}

	/**
	 * Method to place portal on this floor
	 */
	public void placePortal(Portal portal) {
		this.portal = portal;
		updateLabel();
	}

	/**
	 * Method to set this floor as the location of a portal teleport
	 */
	public void setPortalLoc() {
		this.portalLoc = true;
	}

	/**
	 * Method to set the location number of this floor for teleports
	 */
	public void setLocNum(int num) {
		this.locNum = num;
	}

	/**
	 * Method to get the location number of this floor for teleports
	 */
	public int getLocNum() {
		return this.locNum;
	}

	/**
	 * Method to set the X ordinate of this floor
	 * @param locX
	 */
	public void setLocX(int locX) {
		this.locX = locX;
	}

	/**
	 * Method to set the Y ordinate of this floor
	 * @param locY
	 */
	public void setLocY(int locY) {
		this.locY = locY;
	}

	/**
	 * Method to get the X ordinate of this floor
	 * @return
	 */
	public int getLocX() {
		return this.locX;
	}

	/**
	 * Method to get the Y ordinate of this floor
	 * @return
	 */
	public int getLocY() {
		return this.locY;
	}

	/**
	 * Method to check if this floor is a portal
	 */
	public boolean isPortal() {
		if (portal != null) {
			return true;
		} else {
			return false;
		}
	}

}


