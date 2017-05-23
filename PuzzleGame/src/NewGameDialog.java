import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class NewGameDialog extends JDialog {
    PuzzleGame puzzlegame;
    
    public NewGameDialog (PuzzleGame puzzlegame)
    {
	super();
	this.puzzlegame = puzzlegame;
	initUI();
	setSize(new Dimension(200,150));
	setTitle("Options");
	setLocationRelativeTo(getParent());
    }

    private void initUI()
    {
	JLabel title_text = new JLabel ("NewGame");
	title_text.setFont(new Font("serif", Font.BOLD, 16));
	title_text.setAlignmentX(Component.CENTER_ALIGNMENT);
	JButton option_one = new JButton ("Level 1");
	option_one.setAlignmentX(Component.CENTER_ALIGNMENT);
	option_one.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		puzzlegame.changeLevel(1);
	    }
	});
	JButton option_two = new JButton ("Level 2");
	option_two.setAlignmentX(Component.CENTER_ALIGNMENT);
	option_one.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		puzzlegame.changeLevel(2);
	    }
	});
	JButton option_three = new JButton ("Level 3");
	option_three.setAlignmentX(Component.CENTER_ALIGNMENT);
	option_one.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		puzzlegame.changeLevel(3);
	    }
	});
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

