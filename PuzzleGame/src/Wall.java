import javax.swing.JLabel;

/**
 * @authors:	Patrick Munsey
 * zID: 	z5020841
 * 
 */
public class Wall extends Tile {

    
    public Wall(int x, int y) {
	super(x,y);
	updateLabel();
	// TODO Auto-generated constructor stub
    }

    @Override
    public void updateLabel() {
	label.setText("2");
    }

}
