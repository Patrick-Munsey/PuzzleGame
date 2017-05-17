import javax.swing.JLabel;

/**
 * @authors:	Patrick Munsey
 * zID: 	z5020841
 * 
 */
public class Floor extends Tile{

    public Floor(int x, int y) {
		super(x,y);
		updateLabel();
    }

    @Override
    public void updateLabel() {
    	label.setText("#");
    }
    
}
