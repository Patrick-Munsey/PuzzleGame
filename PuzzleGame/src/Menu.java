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
		
		JButton start = new JButton("Start Game");
		JButton instructions = new JButton("Instructions");
		
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		instructions.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.add(start);
		this.add(Box.createRigidArea(new Dimension(0, 50)));
		this.add(instructions);
		
		
		start.setMaximumSize(new Dimension(300, 100));
	
		instructions.setMaximumSize(new Dimension(300, 100));


		//start.addActionListener(new ActionListener() {

			//TODO 
            //@Override
			// public void actionPerformed(ActionEvent e) {
			//   selectedOption = Options.ACEPT;
			//     dispose();
			// }
		//});
		
		//fix
		/*start.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setBorder(BorderFactory.createLineBorder(Color.blue));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(BorderFactory.createLineBorder(Color.gray));
			}
			
		});
		
		//fix
		instructions.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setBorder(BorderFactory.createLineBorder(Color.blue));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(BorderFactory.createLineBorder(Color.gray));
			}
			
		});*/
	}
	
}
