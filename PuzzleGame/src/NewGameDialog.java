import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
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
 * used to display the games level options and can be used to initiate a new level
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class NewGameDialog extends JDialog {
	PuzzleGame puzzlegame;

	/**
	 * @param puzzlegame
	 */
	public NewGameDialog (PuzzleGame puzzlegame)
	{
		super();
		this.puzzlegame = puzzlegame;
		initUI();
		setSize(200, 500);
		setTitle("New Game");
		setLocationRelativeTo(getParent());
	}

	private void initUI()
	{
		JComponent[] components = new JComponent[15];

		JLabel title_text = new JLabel ("Level Select");
		title_text.setFont(new Font("serif", Font.BOLD, 16));
		title_text.setAlignmentX(Component.CENTER_ALIGNMENT);
		components[0] = title_text;

		JButton level_button = new JButton ("Level 1");
		level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		level_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzlegame.changeLevel(1);
				dispose();
			}
		});
		components[1] = level_button;

		level_button = new JButton ("Level 2");
		level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		level_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzlegame.changeLevel(2);
				dispose();
			}
		});
		components[2] = level_button;

		level_button = new JButton ("Level 3");
		level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		level_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzlegame.changeLevel(3);
				dispose();
			}
		});
		components[3] = level_button;

		level_button = new JButton ("Level 4");
		level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		level_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzlegame.changeLevel(4);
				dispose();
			}
		});
		components[4] = level_button;

		level_button = new JButton ("Level 5");
		level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		level_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzlegame.changeLevel(5);
				dispose();
			}
		});
		components[5] = level_button;

		level_button = new JButton ("Level 6");
		level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		level_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzlegame.changeLevel(6);
				dispose();
			}
		});
		components[6] = level_button;

		level_button = new JButton ("Level 7");
		level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		level_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzlegame.changeLevel(7);
				dispose();
			}
		});
		components[7] = level_button;

		level_button = new JButton ("Level 8");
		level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		level_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzlegame.changeLevel(8);
				dispose();
			}
		});
		components[8] = level_button;

		level_button = new JButton ("Level 9");
		level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		level_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzlegame.changeLevel(9);
				dispose();
			}
		});
		components[9] = level_button;

		level_button = new JButton ("Level 10");
		level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		level_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzlegame.changeLevel(10);
				dispose();
			}
		});
		components[10] = level_button;

		level_button = new JButton ("Level 11");
		level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		level_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzlegame.changeLevel(11);
				dispose();
			}
		});
		components[11] = level_button;

		level_button = new JButton ("Level 12");
		level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		level_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzlegame.changeLevel(12);
				dispose();
			}
		});
		components[12] = level_button;

		level_button = new JButton ("Level 13");
		level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		level_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puzzlegame.changeLevel(13);
				dispose();
			}
		});
		components[13] = level_button;

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		components[14] = cancelButton;

		create_layout(components);

	}

	private void create_layout (JComponent[] components)
	{
		JPanel cpane = (JPanel) getContentPane();
		cpane.setLayout(new BoxLayout(cpane, BoxLayout.Y_AXIS));
		cpane.add(Box.createVerticalStrut(10));
		for(int i = 0; i < components.length; i++) {
			if(components[i] != null) {
				if(i == 0) {//pad the title
					cpane.add(components[i]);
					cpane.add(Box.createRigidArea(new Dimension(0,10)));
				}
				else if(i == components.length - 1) {// pad the cancel button
					//pad the cancel button
					cpane.add(Box.createRigidArea(new Dimension(0,10)));
					cpane.add(components[i]);
					cpane.add(Box.createRigidArea(new Dimension(0,10)));
				}
				else {
					cpane.add(components[i]);
				}
			}
		}
		pack();
	}
}

