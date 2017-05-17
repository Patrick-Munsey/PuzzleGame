import javax.swing.JLabel;

/**
 * @authors:	Patrick Munsey
 * zID: 	z5020841
 * 
 */
public class Box extends GamePiece{

    public Box() {
	
    }

    @Override
    public void updateLabel(JLabel label) {
	label.setText("B");
    }
    
}
