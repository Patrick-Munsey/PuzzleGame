import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Box extends GamePiece implements Piece{
	int level;
	/**
	 * 
	 */
	public Box() {
	}

	/* (non-Javadoc)
	 * @see GamePiece#updateLabel(javax.swing.JLabel)
	 */
	@Override
	public void updateLabel(JLabel label, int lvNum) throws IOException {
		level = lvNum;
		ImageIcon icon = createImageIcon("images/" + lvNum + "/box.png");
		ImageIcon newIcon = applyLayer(icon);
		label.setIcon(newIcon);
		//label.setIcon(icon);
	}

	@Override
	public boolean isBox() {
		return true;
	}

	public ImageIcon applyLayer(ImageIcon oldIcon) throws IOException {
		JLabel newLabel = new JLabel();

		//ImageIcon oldIcon = (ImageIcon) oldLabel.getIcon();    
		int w = oldIcon.getIconWidth();
		int h = oldIcon.getIconHeight();
		BufferedImage oldImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = (Graphics2D) oldImg.getGraphics();
		oldIcon.paintIcon(null, g2d, 0, 0);
		BufferedImage newImg = getImageOverlay(oldImg);
		g2d.dispose();
		ImageIcon newIcon = new ImageIcon(newImg);
		return newIcon;
	}

	private BufferedImage getImageOverlay(BufferedImage oldImg) throws IOException {
		BufferedImage newImg = ImageIO.read(new File("src/images/" + level + "/floor.png"));	
		//BImage = newImg;

		int w = newImg.getWidth();
		int h = newImg.getHeight();

		BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = combined.createGraphics();
		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F));
		//g2d.drawImage(oldImg, null, 0, 0);
		g2d.drawImage(newImg, 0, 0, null);
		g2d.drawImage(oldImg, 0, 0, null);
		
		
		g2d.dispose();
		return combined;
	}

	@Override
	public JLabel applyLayer(JLabel Label) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
