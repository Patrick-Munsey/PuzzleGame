import javax.swing.JLabel;

/**
 * @authors:	Patrick Munsey
 * zID: 	z5020841
 * 
 */
public class Floor extends Tile{
    private GamePiece gamepiece;
    
    public Floor() {
	super();
    }

    @Override
    public boolean isMoveable() {
	if(gamepiece == null) {
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
	    this.setText(".");
	}
	
    }
    
    public void placeGamePiece(GamePiece gamepiece) {
	this.gamepiece = gamepiece;
	updateLabel();
    }
    
    public GamePiece removeGamePiece() {
	GamePiece retGamePiece = this.gamepiece;
	this.gamepiece = null;
	updateLabel();
	return retGamePiece;
    }
    
    

}
