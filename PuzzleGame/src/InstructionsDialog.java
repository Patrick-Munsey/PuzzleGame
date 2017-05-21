import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**
 * A class for the Instructions dialog box which is accessed from the menu
 * @author jamesdoldissen
 *
 */
public class InstructionsDialog extends JDialog {
	public InstructionsDialog (Frame parent)
	{
		super(parent);
		initUI();
		setSize(new Dimension(400,300));
		setTitle("Instructions");
		setLocationRelativeTo(getParent());
	}
	
	private void initUI()
	{
		JLabel title_text = new JLabel ("Instructions");
		title_text.setFont(new Font("serif", Font.BOLD, 16));
		title_text.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel instruction_text = new JLabel (
			"<html>Your are a warehouse boss.<br>" +
			"Your objective is to push all of the boxes so that the <br>" +
			"goal locations are all filled at the same time<br><br>" +
			"<strong>CONTROLS: </strong><br>" +
			"    UP:&emsp UP_ARROW<br>" +
			"  DOWN:&emsp DOWN_ARROW<br>" +
			"  LEFT:&emsp LEFT_ARROW<br>" +
			" RIGHT:&emsp RIGHT_ARROW<br><br></html>",
			SwingConstants.CENTER);
		instruction_text.setFont(new Font("serif", Font.PLAIN, 14));
		instruction_text.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton okButton = new JButton("OK");
		okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		okButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			dispose();
		    }
		});

		create_layout(title_text, instruction_text, okButton);
	}
	
	private void create_layout (JComponent ... components)
	{
		JPanel cpane = (JPanel) getContentPane();
		cpane.setLayout(new BoxLayout(cpane, BoxLayout.Y_AXIS));
		cpane.setAlignmentY(CENTER_ALIGNMENT);
		cpane.add(Box.createRigidArea(new Dimension(0,4))); // space between options title & options buttons
		cpane.add(components[0]);
		cpane.add(Box.createRigidArea(new Dimension(0,4))); // space between options title & options buttons
		cpane.add(components[1]);
		cpane.add(components[2]);
		pack();
	}
}
