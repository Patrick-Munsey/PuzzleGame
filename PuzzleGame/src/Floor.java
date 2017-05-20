import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Floor extends Tile{
    private GamePiece gamepiece;
    private Goal goal;
    
    /**
     * @param x
     * @param y
     */
    public Floor(int x, int y) {
    	super(x,y);
    }

    /* (non-Javadoc)
     * @see Tile#isMoveable()
     */
    @Override
    public boolean isMoveable() {
		if(gamepiece == null) {
		    return true;
		}
		return false;
    }

    /* (non-Javadoc)
     * @see Tile#updateLabel()
     */
    @Override
    public void updateLabel() {
		if(gamepiece != null) {
		    gamepiece.updateLabel(this);
		}
		
		else {
			if(goal != null) {
				ImageIcon icon = createImageIcon("images/goal.png");
		    	setIcon(icon);
				
			}
			else {
				ImageIcon icon = createImageIcon("images/floor.png");
				setIcon(icon);
			}  
		}
    }
    
    /* (non-Javadoc)
     * @see Tile#placeGamePiece(GamePiece)
     */
    public void placeGamePiece(GamePiece gamepiece) {
		this.gamepiece = gamepiece;
		gamepiece.placePiece(this.x, this.y);
		
		updateLabel();
    }
    
    /* (non-Javadoc)
     * @see Tile#removeGamePiece()
     */
    public GamePiece removeGamePiece() {
		GamePiece retGamePiece = this.gamepiece;
		this.gamepiece = null;
		updateLabel();
		return retGamePiece;
    }
    
    /* (non-Javadoc)
     * @see Tile#placeGoal(Goal)
     */
    public void placeGoal(Goal goal) {
		this.goal = goal;
		updateLabel();
    }
    
    /* (non-Javadoc)
     * @see Tile#removeGoal()
     */
    public void removeGoal() {
		this.goal = null;
		updateLabel();
    }
}
