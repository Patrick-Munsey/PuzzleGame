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
    private int sec;
    private int min;

    public GameTimer() {
	this.sec = 0;
	this.min = 0;
	this.setText(toString());
	timer = new Timer(1000,this);
	timer.setInitialDelay(1);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
	sec = sec + 1;
	if(sec >= 60) {
	    sec = 0;
	    min = min + 1;
	}
	this.setText(toString());
    }

    @Override
    public String toString() {
	return String.format("    Time: %02d:%02d    ", this.min, this.sec);
    }

    /**
     * @author Patrick Munsey, z5020841
     */
    public void restart() {
	timer.stop();
	sec = 0;
	min = 0;
	timer.start();
    }

    /**
     * @author Patrick Munsey, z5020841
     */
    public void pause() {
	timer.stop();
    }

    /**
     * @author Patrick Munsey, z5020841
     */
    public void start() {
	timer.start();
    }


}
