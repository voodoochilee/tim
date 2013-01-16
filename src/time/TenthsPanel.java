package time;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class TenthsPanel extends JPanel implements Runnable {

	private ImageIcon tenthsIcon = new ImageIcon("digit_0.jpg");
	private JLabel tenthsLabel = new JLabel(tenthsIcon);
	
	public TenthsPanel() {
		this.setBorder(new EmptyBorder(0,0,0,0));
		this.setLayout(new MigLayout());
		this.add(tenthsLabel);
		this.setVisible(true);
		Thread tenthsThread = new Thread(this);
		tenthsThread.start();
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
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				tenthsLabel.setIcon(new ImageIcon("digit_" + Integer.toString(i) + ".jpg"));
			}
		}
	}
	
	
	

}
