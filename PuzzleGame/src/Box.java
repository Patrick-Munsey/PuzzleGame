import javax.swing.ImageIcon;
import javax.swing.JLabel;


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
    public void updateLabel(JLabel label) {
<<<<<<< HEAD
	    //ImageIcon icon = createImageIcon("images/box.png");
    	
    	JLabel newLabel = draw(label);
	    newLabel.setIcon(icon);
=======
	ImageIcon icon = createImageIcon("images/box.png");
	label.setIcon(icon);
>>>>>>> branch 'master' of https://github.com/Patrick-Munsey/PuzzleGame
    }

    @Override
    public boolean isBox() {
	return true;
    }

<<<<<<< HEAD
	@Override
	public JLabel draw(JLabel Label) {
		
		return Label;
		// TODO Auto-generated method stub
		
	}
    
    
    //check out updating labels
	//check out stacking imageicons
	
=======


>>>>>>> branch 'master' of https://github.com/Patrick-Munsey/PuzzleGame
}
