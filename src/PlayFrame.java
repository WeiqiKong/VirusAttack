import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Toolkit;

public class PlayFrame extends JFrame {
	private int PF_WIDTH = 1280;
	private int PF_HEGHT = 720;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private BackgroundPanel jpnl;
	private Timer timer;  
	
	public PlayFrame() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("VirusAttack");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jpnl = new BackgroundPanel((new ImageIcon(PlayFrame.class.getResource("/icon/background2.jpg")).getImage()));
		jpnl.setOpaque(false);
		jpnl.setPreferredSize(new Dimension(PF_WIDTH, PF_HEGHT));
		jpnl.setFocusable(true);
		getContentPane().add(jpnl, BorderLayout.CENTER);
		jpnl.setLayout(null);
		
		Virus virus = new Virus();
		jpnl.add(virus);
		
		jpnl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_UP){
					VirusDirection.IS_UP_PRESSED = false;
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					VirusDirection.IS_DOWN_PRESSED = false;
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					VirusDirection.IS_RIGHT_PRESSED = false;
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					VirusDirection.IS_LEFT_PRESSED = false;
				}
//				System.out.println(VirusDirection.getDirection());
//				virus.move(VirusDirection.getDirection());
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_UP){
					VirusDirection.IS_UP_PRESSED = true;
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN){
					VirusDirection.IS_DOWN_PRESSED = true;
				}
				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
					VirusDirection.IS_RIGHT_PRESSED = true;
				}
				if(e.getKeyCode()==KeyEvent.VK_LEFT){
					VirusDirection.IS_LEFT_PRESSED = true;
				}
//				System.out.println(VirusDirection.getDirection());
//				virus.move(VirusDirection.getDirection());
			}
		});
//	使用Timer增加刷新频率 	
		timer  = new Timer(10,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				virus.move(VirusDirection.getDirection());	
			}
		} );
		timer.start();
		
		System.out.println(this.getWidth());
		Antiviren anti1 = new Antiviren(250);	
		anti1.my_setLocation((PF_WIDTH-anti1.getRadius())/2,(PF_HEGHT-anti1.getRadius())/2 );
		anti1.init();
		jpnl.add(anti1);
		
		
		 
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
// 成功完成8个方向的移动		
//		jpnl.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				if(e.getKeyCode()==KeyEvent.VK_UP){
//					VirusDirection.IS_UP_PRESSED = false;
//				}
//				if(e.getKeyCode()==KeyEvent.VK_DOWN){
//					VirusDirection.IS_DOWN_PRESSED = false;
//				}
//				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
//					VirusDirection.IS_RIGHT_PRESSED = false;
//				}
//				if(e.getKeyCode()==KeyEvent.VK_LEFT){
//					VirusDirection.IS_LEFT_PRESSED = false;
//				}
//				System.out.println(VirusDirection.getDirection());
//				virus.move(VirusDirection.getDirection());
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if(e.getKeyCode()==KeyEvent.VK_UP){
//					VirusDirection.IS_UP_PRESSED = true;
//				}
//				if(e.getKeyCode()==KeyEvent.VK_DOWN){
//					VirusDirection.IS_DOWN_PRESSED = true;
//				}
//				if(e.getKeyCode()==KeyEvent.VK_RIGHT){
//					VirusDirection.IS_RIGHT_PRESSED = true;
//				}
//				if(e.getKeyCode()==KeyEvent.VK_LEFT){
//					VirusDirection.IS_LEFT_PRESSED = true;
//				}
//				System.out.println(VirusDirection.getDirection());
//				virus.move(VirusDirection.getDirection());
//			}
//		});
		
		
		
		// use Thread test
//		Thread t1 = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				jpnl.addKeyListener(new KeyAdapter() {
//					@Override
//					public void keyPressed(KeyEvent e) {
//						int keyCode = e.getKeyCode();
//						if (keyCode == KeyEvent.VK_DOWN) {
//							virus.setY(virus.getY() + 5);
//							System.out.println(virus.getY() + 5);
//							System.out.println(KeyStroke.getAWTKeyStrokeForEvent(e));
//							virus.setLocation(virus.getPostion());
//						}
//					}
//				});
//
//			}
//
//		});
//		t1.start();
//
//		Thread t2 = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				jpnl.addKeyListener(new KeyAdapter() {
//					@Override
//					public void keyPressed(KeyEvent e) {
//						int keyCode = e.getKeyCode();
//						if (keyCode == KeyEvent.VK_UP) {
//							virus.setY(virus.getY() - 5);
//							System.out.println(virus.getY() - 5);
//							virus.setLocation(virus.getPostion());
//						}
//					}
//				});
//
//			}
//
//		});
//		t2.start();
//
//		Thread t3 = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				jpnl.addKeyListener(new KeyAdapter() {
//					@Override
//					public void keyPressed(KeyEvent e) {
//						int keyCode = e.getKeyCode();
//						switch (keyCode) {
//						case KeyEvent.VK_RIGHT:
//							virus.move(3);
//							break;
//						}
//					}
//				});
//
//			}
//
//		});
//		t3.start();
//		Thread t4 = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				jpnl.addKeyListener(new KeyAdapter() {
//					@Override
//					public void keyPressed(KeyEvent e) {
//						int keyCode = e.getKeyCode();
//						switch (keyCode) {
//						case KeyEvent.VK_LEFT:
//							virus.move(4);
//							break;
//						}
//					}
//				});
//
//			}
//
//		});
//		t4.start();

		

		// 不使用线程
//		jpnl.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				int keyCode = e.getKeyCode();
//				System.out.print(keyCode + " ");
//				System.out.print(e.getID() + " ");
//				System.out.println(e.hashCode());
//				System.out.println(KeyStroke.getAWTKeyStrokeForEvent(e));
//
//				switch (keyCode) {
//				case KeyEvent.VK_LEFT: {
//					virus.move(4);
//					
//					// jpnl.addKeyListener(new KeyAdapter() {
//					// @Override
//					// public void keyPressed(KeyEvent e) {
//					// int keyCode2 = e.getKeyCode();
//					// switch (keyCode2) {
//					// case KeyEvent.VK_RIGHT:
//					// System.out.println("1");
//					// break;
//					// case KeyEvent.VK_UP:
//					// System.out.println("2");
//					// break;
//					// case KeyEvent.VK_DOWN:
//					// System.out.println("3");
//					// break;
//					// }
//					//
//					// }
//					// });
//				}
//					break;
//				case KeyEvent.VK_RIGHT:
//					virus.move(3);
//					break;
//				case KeyEvent.VK_UP:
//					virus.move(2);
//					break;
//				case KeyEvent.VK_DOWN:
//					virus.move(1);
//					break;
//				}
//			}

			// @Override
			// public void keyTyped(KeyEvent e) {
			// int keyCode = e.getKeyCode();
			// System.out.print(keyCode+" ");
			// System.out.print(e.getID()+" ");
			// System.out.println(e.hashCode());
			// switch (keyCode) {
			// case KeyEvent.VK_LEFT: {
			// virus.move(4);
			//
			// }
			// break;
			// case KeyEvent.VK_RIGHT:
			// virus.move(3);
			// break;
			// case KeyEvent.VK_UP:
			// virus.move(2);
			// break;
			// case KeyEvent.VK_DOWN:
			// virus.move(1);
			// break;
			// }
			// }
//		});
		pack();
	}
}
