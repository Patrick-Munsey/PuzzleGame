import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.OverlayLayout;


/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Box extends GamePiece implements Piece{
	private ImageIcon icon;
    /**
     * 
     */
    public Box() {
    }

    /* (non-Javadoc)
     * @see GamePiece#updateLabel(javax.swing.JLabel)
     */
    @Override
    public void updateLabel(JLabel label, , int lvNum) {
	    ImageIcon icon = createImageIcon("images/" + lvNum + "/box.png"); //to take in new image
    	JLabel newLabel = draw(label); //send image to draw thing
    	newLabel.getIcon(); //grabs the new icon at this label
	    newLabel.setIcon(icon);
    }

    @Override
    public boolean isBox() {
	return true;
    }


	@Override
	public JLabel draw(JLabel Label) {
		return Label;
		// TODO Auto-generated method stub
		
	}
    
    //check out updating labels
	//check out stacking imageicons
}
