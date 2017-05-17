import javax.swing.JLabel;

/**
 * @authors: 	Patrick Munsey
 * zID: 	z5020841
 * 
 */
public class GamePiece {
    int x;
    int y;
    
    public GamePiece() {
	
    }
    
    public boolean movePiece(Direction direction) {
	return false;
    }
    
    public void updateLabel(JLabel label) {
	label.setText("GP");
    }
}
