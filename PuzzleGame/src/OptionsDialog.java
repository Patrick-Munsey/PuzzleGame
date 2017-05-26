import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Used ton select Key binding options
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class OptionsDialog extends JDialog {
	PuzzleGame PuzzleGame;

	/**
	 * @param PuzzleGame
	 */
	public OptionsDialog (PuzzleGame PuzzleGame)
	{
		super();
		this.PuzzleGame = PuzzleGame;
		initUI();
		setSize(new Dimension(200,150));
		setTitle("Options");
		setLocationRelativeTo(getParent());
	}

	private void initUI()
	{
		JLabel title_text = new JLabel ("Choose a key binding set");
		title_text.setFont(new Font("serif", Font.BOLD, 16));
		title_text.setAlignmentX(Component.CENTER_ALIGNMENT);

		JButton Binding1_button = new JButton ("ARROW Keys");
		Binding1_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		Binding1_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PuzzleGame.changeKeyBindings(1);
				dispose();
			}
		});

		JButton Binding2_button = new JButton ("WASD Keys");
		Binding2_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		Binding2_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PuzzleGame.changeKeyBindings(2);
				dispose();
			}
		});



		create_layout(title_text, Binding1_button, Binding2_button);

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
		pack();
	}
}

