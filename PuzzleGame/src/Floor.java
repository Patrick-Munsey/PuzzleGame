import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.OverlayLayout;


/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Floor extends Tile implements Piece{
    private GamePiece gamepiece;
    private Goal goal;
    
    // for portal purposes
    private Portal portal;
    private boolean portalLoc = false;
    private int locNum;
    private int locX;
    private int locY;
    
    /**
     * @param x
     * @param y
     */
    public Floor(int x, int y, int lvNum) {
    	super(x,y, lvNum);
    }

    @Override
    public boolean isMoveable() {
    	if (portal != null) {
    		return true;
    	} else if(gamepiece == null) {
		    return true;
		} 
		return false;
    }

    @Override
    public void updateLabel() {
    	if(gamepiece != null) {
    		gamepiece.updateLabel(this);
    	}

    	else {
    		if(goal != null) {
    			ImageIcon icon = createImageIcon("images/goal.png");
    			setIcon(icon);
    		} else if (portal != null) {
    			ImageIcon icon = createImageIcon("images/portal.png"); 
    			setIcon(icon);
    		} else {
    			ImageIcon icon = createImageIcon("images/floor.png");
    			setIcon(icon);
    		}  
    	}
    }
    

    public void placeGamePiece(GamePiece gamepiece) {
		this.gamepiece = gamepiece;
		gamepiece.placePiece(this.x, this.y);
		
		if((goal != null) && gamepiece.isBox()) {
		    goal.activate();
		} else if (portal != null && !gamepiece.isBox()) {
			MoveList.playerInPortal = true;
			portal.activate();
		} else if (portal != null && gamepiece.isBox()) { 
			//Box will go into portal: need to undo the move
			MoveList.boxInPortal = true;
		}
		
		updateLabel();
    }
    

    public GamePiece removeGamePiece() {
		GamePiece retGamePiece = this.gamepiece;
		this.gamepiece = null;
		if(goal != null) {
		    goal.deactivate();
		}
		updateLabel();
		return retGamePiece;
    }
    

    public void placeGoal(Goal goal) {
		this.goal = goal;
		updateLabel();
    }
    

    public void removeGoal() {
		this.goal = null;
		updateLabel();
    }
    

    public void placePortal(Portal portal) {
		this.portal = portal;
		updateLabel();
    }
    
    public void setPortalLoc() {
    	this.portalLoc = true;
    }
    
    public void setLocNum(int num) {
    	this.locNum = num;
    }
    
    public int getLocNum() {
    	return this.locNum;
    }
    
    public void setLocX(int locX) {
    	this.locX = locX;
    }
    
    public void setLocY(int locY) {
    	this.locY = locY;
    }
    
    public int getLocX() {
    	return this.locX;
    }
    
    public int getLocY() {
    	return this.locY;
    }
    
    public boolean isPortal() {
    	if (portal != null) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public JLabel draw(JLabel label){
		JLabel newLabel = new JLabel(); //child/parent label
		newLabel.setLayout(new OverlayLayout(newLabel));
		//newLabel = decoratedPiece.draw(oldLabel);
		return newLabel;
    }
}


