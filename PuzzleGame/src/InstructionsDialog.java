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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**
 * A class for the Instructions dialog box which is accessed from the menu
 * @author jamesdoldissen
 *
 */
public class InstructionsDialog extends JDialog {
    public InstructionsDialog (JFrame parent)
    {
	super(parent);
	initUI();
	setSize(new Dimension(400,400));
	setTitle("Instructions");
	setLocationRelativeTo(getParent());
    }

    private void initUI()
    {
	JLabel title_text = new JLabel ("Instructions");
	title_text.setFont(new Font("serif", Font.BOLD, 16));
	title_text.setAlignmentX(Component.CENTER_ALIGNMENT);

	JLabel instruction_text = new JLabel (
		"<html>Hey Elmo! Thanks for coming!<br><br>" +
			"Your job today is to feed the Cookie Monster <br>" +
			"He won't be full until you've given him all the cookies<br><br>" +
			"Oh and Elmo, if you've ever wanted to teleport, you're in for a treat!<br>" +
			"Jump into the portals and you'll see what I mean<br><br>" +
			"<div style='text-align: center;'><strong>CONTROLS: </strong></div><br>" +
			"    UP:&emsp UP_ARROW<br>" +
			"  DOWN:&emsp DOWN_ARROW<br>" +
			"  LEFT:&emsp LEFT_ARROW<br>" +
			" RIGHT:&emsp RIGHT_ARROW<br>" +
			"  RESTART:&emsp R<br>" +
			"  UNDO:&emsp U<br>" +
			"  QUIT:&emsp ESC<br><br></html>",
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
