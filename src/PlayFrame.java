import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class PlayFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jpnl;

	public PlayFrame() {
		setTitle("VirusAttack");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		this.setSize(1280, 720);
//		this.setResizable(false);
//		this.setLayout(null);
//		Virus virus = new Virus();
//		this.getContentPane().add(virus);
//		virus.setLocation(1000,500);
//		this.addKeyListener(new KeyAdapter() {
//		@Override
//		public void keyPressed(KeyEvent e) {
//			int keyCode = e.getKeyCode();
//			switch (keyCode) {
//			case KeyEvent.VK_LEFT: {
//				virus.setLocation(300,300);
//				System.out.println("aa");
//			}
//				break;
//			case KeyEvent.VK_RIGHT:
//				virus.move(3);
//				break;
//			case KeyEvent.VK_UP:
//				virus.move(1);
//				break;
//			case KeyEvent.VK_DOWN:
//				virus.move(2);
//				break;
//			}
//		}
//	});
		
		
		jpnl = new JPanel();
		jpnl.setPreferredSize(new Dimension(1280, 720));
		jpnl.setFocusable(true);
		getContentPane().add(jpnl);
		jpnl.setLayout(null);
		
		Virus virus = new Virus();
		jpnl.add(virus);
		jpnl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_LEFT: {
					virus.move(4);;
					System.out.println("aa");
				}
					break;
				case KeyEvent.VK_RIGHT:
					virus.move(3);
					break;
				case KeyEvent.VK_UP:
					virus.move(2);
					break;
				case KeyEvent.VK_DOWN:
					virus.move(1);
					break;
				}
			}
		});
		pack();
	}
}
