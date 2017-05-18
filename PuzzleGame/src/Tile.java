import javax.swing.JLabel;

/**
 * @authors:	Patrick Munsey
 * zID: 	z5020841
 * 
 */
class Tile extends JLabel{
    protected int x;
    protected int y;
    
    public Tile(int x, int y) {
	super();
	this.x = x;
	this.y = y;
	updateLabel();
    }
    
    public void updateLabel() {
	this.setText("0");
    }
    
    public boolean isMoveable() {
	return false;
    }
         
    public void placeGamePiece(GamePiece gamepiece) {	
    }
    
    public GamePiece removeGamePiece() {
	return null;
    }
    
}
