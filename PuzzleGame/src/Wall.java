import javax.swing.JLabel;

/**
 * @authors:	Patrick Munsey
 * zID: 	z5020841
 * 
 */
public class Wall extends Tile {

    
    public Wall() {
	super();
    }

    @Override
    public void updateLabel() {
	this.setText("#");
    }



}
