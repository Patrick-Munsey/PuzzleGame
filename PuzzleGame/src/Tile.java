import javax.swing.JLabel;

/**
 * @authors:	Patrick Munsey
 * zID: 	z5020841
 * 
 */
class Tile extends JLabel{
    
    public Tile() {
	super();
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
