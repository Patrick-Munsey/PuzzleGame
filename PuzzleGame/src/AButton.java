import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**Generic button with actionlisteners already
 * 
 * @author lindatruong
 *
 */
public class AButton extends JButton {
	
	public AButton(String nameButton){
		super(nameButton);
		initUI();
	}
	
	public AButton(Image image) {
		super(new ImageIcon(image));
		initUI();
	}
	
	public void initUI() {
		setBackground(Color.white);
		setOpaque(true);
		BorderFactory.createLineBorder(Color.gray); //lines the button
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBorder(BorderFactory.createLineBorder(Color.blue));
			}
	
			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(BorderFactory.createLineBorder(Color.gray));
			}
		});
		
		//addActionListener(new ActionListener(){
		//	@Override
		//	public void actionPerformed(ActionEvent e) 		
		//	}
		//});

	}
}
