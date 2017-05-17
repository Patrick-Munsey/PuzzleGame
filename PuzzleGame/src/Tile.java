import javax.swing.JLabel;

/**
 * @authors:	Patrick Munsey
 * zID: 	z5020841
 * 
 */
class Tile {
    public JLabel label;
    private int x;
    private int y;
    
    public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		label = new JLabel();
		updateLabel();
    }
    
    public void updateLabel() {
    	label.setText("0");
    }
    
    public void swapWith(Tile tile) {
		JLabel temp = this.label;
		this.label = tile.label;
		tile.label = temp;
		
		int tempx = this.x;
		int tempy = this.y;
		this.x = tile.x;
		this.y = tile.y;
		tile.x = tempx;
		tile.y = tempy;	
		
		this.updateLabel();
		tile.updateLabel();
    }
    
    public int getX() {
    	return this.x;
    }
    
    public int getY() {
    	return this.y;
    }
   
    
    
}
