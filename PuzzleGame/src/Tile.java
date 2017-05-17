import javax.swing.JLabel;

/**
 * @authors:	Patrick Munsey
 * zID: 	z5020841
 * 
 */
class Tile extends JLabel{
    private int x;
    private int y;
    
    public Tile(int x, int y) {
	super();
	this.x = x;
	this.y = y;
    }
    
    public int getType() {
	return 0;
    }
   
    
    
}
