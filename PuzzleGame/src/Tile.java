import javax.swing.JLabel;


/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
class Tile extends JLabel{
    protected int x;
    protected int y;
    
    /**
     * @param x
     * @param y
     */
    public Tile(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		updateLabel();
    }
    
    /**
     * 
     */
    public void updateLabel() {
    	this.setText("0");
    }
    
    /**
     * @return true if the Tile is able to be occupied by a GamePiece
     */
    public boolean isMoveable() {
    	return false;
    }
         
    /**
     * @param gamepiece
     */
    public void placeGamePiece(GamePiece gamepiece) {	
    }
    
    /**
     * @return the GamePiece from the tile
     */
    public GamePiece removeGamePiece() {
	return null;
    }
    
    /**
     * @param goal
     */
    public void placeGoal(Goal goal) {
    }
    
    /**
     * 
     */
    public void removeGoal() {
    }
    
}
