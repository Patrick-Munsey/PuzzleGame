import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A class for the Options dialog box which is accessed from the menu
 * @author jamesdoldissen
 *
 */
public class OptionsDialog extends JDialog 
{
	public OptionsDialog (Frame parent)
	{
		super(parent);
		initUI();
		setSize(new Dimension(200,150));
		setTitle("Options");
		setLocationRelativeTo(getParent());
	}
	
	private void initUI()
	{
		JLabel title_text = new JLabel ("Options");
		title_text.setFont(new Font("serif", Font.BOLD, 16));
		title_text.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton option_one = new JButton ("Ferrari");
		option_one.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton option_two = new JButton ("Lamborghini");
		option_two.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton option_three = new JButton ("Holden");
		option_three.setAlignmentX(Component.CENTER_ALIGNMENT);
		create_layout(title_text, option_one, option_two, option_three);
		
	}
	
	private void create_layout (JComponent ... components)
	{
		JPanel cpane = (JPanel) getContentPane();
		cpane.setLayout(new BoxLayout(cpane, BoxLayout.Y_AXIS));
		cpane.add(Box.createRigidArea(new Dimension(0,4))); // add some padding
		cpane.add(components[0]);
		cpane.add(Box.createRigidArea(new Dimension(0,4))); 
		cpane.add(components[1]);
		cpane.add(components[2]);
		cpane.add(components[3]);
		pack();
	}
}
 
