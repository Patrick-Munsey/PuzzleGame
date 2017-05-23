import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.Timer;


/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class GameTimer extends JLabel implements ActionListener{
    private Timer timer;

    public GameTimer() {
	this.setText(new Date().toString());
	timer = new Timer(1000,this);
	timer.setInitialDelay(1);
	timer.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
	this.setText(new Date().toString());
    }
    
}
