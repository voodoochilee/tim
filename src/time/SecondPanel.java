package time;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class SecondPanel extends JPanel implements Runnable {
	
	private ImageIcon secondsIcon = new ImageIcon("digit_0.jpg");
	private JLabel secondsLabel = new JLabel(secondsIcon);
	
	public SecondPanel() {
		this.setBorder(new EmptyBorder(0,0,0,0));
		this.setLayout(new MigLayout());
		this.add(secondsLabel);
		this.setVisible(true);
		Thread secondsThread = new Thread(this);
		secondsThread.start();
	}

	@Override
	public void run() {
		synchronized(this) {
			while(true) {
				this.setSeconds();
			}
		}
		
		
	}
	
	private void setSeconds() {
		while(true) {
			for(int i = 1; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				secondsLabel.setIcon(new ImageIcon("digit_" + Integer.toString(i) + ".jpg"));
			}
		}
	}
	
	
	
	
}
