package time;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;


public class MainGUI extends JFrame {
	
	private SecondPanel seconds = new SecondPanel();
	private TenthsPanel hundreths = new TenthsPanel();
	private JButton button = new JButton("Pause");
	
	public MainGUI() {
		this.setLayout(new MigLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.add(seconds);
		this.add(hundreths, "wrap paragraph");
		this.add(button, "skip 1, tag ok");
		this.pack();
		this.setVisible(true);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
	}
	
	public static void main(String[] args) {
		MainGUI gui = new MainGUI();
	}
	
}   
