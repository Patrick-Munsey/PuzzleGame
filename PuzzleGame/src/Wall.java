import javax.swing.JLabel;

/**
 * @authors:	Patrick Munsey
 * zID: 	z5020841
 * 
 */
public class Wall extends Tile {

    
    public Wall(int x, int y) {
	super(x,y);
	setText("0");
	// TODO Auto-generated constructor stub
    }

    @Override
    public int getType() {
	// TODO Auto-generated method stub
	return 2;
    }

}
