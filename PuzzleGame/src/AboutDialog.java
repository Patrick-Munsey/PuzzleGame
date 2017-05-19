import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A class for the About dialog box which is accessed from the menu
 * @author jamesdoldissen
 *
 */
public class AboutDialog extends JDialog {
	public AboutDialog (Frame parent)
	{
		super(parent);
		initUI();
		setSize(new Dimension(200,150));
		setTitle("About");
		setLocationRelativeTo(getParent());
	}
	
	private void initUI()
	{
		JLabel title_text = new JLabel ("About");
		title_text.setFont(new Font("serif", Font.BOLD, 16));
		title_text.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel about_text = new JLabel ("We are all about that base");
		about_text.setFont(new Font("serif", Font.PLAIN, 14));
		about_text.setAlignmentX(Component.CENTER_ALIGNMENT);
		create_layout(title_text, about_text);
	}
	
	private void create_layout (JComponent ... components)
	{
		JPanel cpane = (JPanel) getContentPane();
		cpane.setLayout(new BoxLayout(cpane, BoxLayout.Y_AXIS));
		cpane.add(Box.createRigidArea(new Dimension(0,4))); // space between options title & options buttons
		cpane.add(components[0]);
		cpane.add(Box.createRigidArea(new Dimension(0,4))); // space between options title & options buttons
		cpane.add(components[1]);
		pack();
	}
}
