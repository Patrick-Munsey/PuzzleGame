import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;

/**Home page
 * @author lindatruong
 *
 */
public class Menu extends JPanel{
	
    private BufferedImage image = null;
	
	Menu() throws Exception{
		super();

	    try {
			image = ImageIO.read(new File("images/menuBackground.png"));	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initUI();
		
	}
	
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g); // paint the background image and scale it to fill the entire space
	    g.drawImage(image, 0, 0, null);
	}
	
	private void initUI() throws Exception{
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.gray);
		this.setBorder(new EmptyBorder(new Insets(300, 0, 0, 0)));

	}
	
}
