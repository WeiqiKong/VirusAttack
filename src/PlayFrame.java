import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Toolkit;

public class PlayFrame extends JFrame {
	private int PF_WIDTH = 1280;
	private int PF_HEGHT = 720;
	ArrayList<Antiviren> antiArray = new ArrayList<Antiviren>();
	// HashSet<Antiviren> antiArray = new HashSet<Antiviren>();
	int virusCX, VirusCY;
	private static final long serialVersionUID = 1L;
	private BackgroundPanel jpnl;
	private Timer timer, anti_timer;

	private static int punkt = 0;
	private Antiviren center ;

	// private Image virusImage = new
	// ImageIcon(PlayFrame.class.getResource("/icon/Virus_1.png")).getImage();
	private Virus virus;
	private JTextField textField;

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

		virus = new Virus();
		jpnl.add(virus);
		jpnl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					VirusDirection.IS_UP_PRESSED = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					VirusDirection.IS_DOWN_PRESSED = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					VirusDirection.IS_RIGHT_PRESSED = false;
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					VirusDirection.IS_LEFT_PRESSED = false;
				}
				// System.out.println(VirusDirection.getDirection());
				// virus.move(VirusDirection.getDirection());
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					VirusDirection.IS_UP_PRESSED = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					VirusDirection.IS_DOWN_PRESSED = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					VirusDirection.IS_RIGHT_PRESSED = true;
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					VirusDirection.IS_LEFT_PRESSED = true;
				}
				// System.out.println(VirusDirection.getDirection());
				// virus.move(VirusDirection.getDirection());
			}
		});
		// 使用Timer增加刷新频率
		timer = new Timer(20, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				virus.move(VirusDirection.getDirection());
			}
		});

		timer.start();

		for (int i = 0; i < 5; i++) {
			addAntivieren(new Antiviren(50), 50, 4);
		}

		for (int i = 0; i < 3; i++) {
			addAntivieren(new Antiviren(100), 100, 3);
		}
		
		for (int i = 0; i < 2; i++) {
			addAntivieren(new Antiviren(150), 150, 2);
		}
		
		for (int i = 0; i < 1; i++) {
			addAntivieren(new Antiviren(200), 200, 1);
		}
		
		addCenter();
		textField = new JTextField();
		textField.setBounds(44, 58, 66, 21);
		jpnl.add(textField);
		textField.setColumns(10);
		

		
		
		
		
		

		Thread newAntitd_50 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (antiArray.size() < 15) {
						addAntivieren(new Antiviren(50), 50, 4);
						addAntivieren(new Antiviren(50), 50, 4);
						System.out.println(antiArray.size());
					}
				}

			}
		});
		 newAntitd_50.start();
		 
		 Thread newAntitd_100 = new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (antiArray.size() < 15) {
							addAntivieren(new Antiviren(100), 100, 3);
						}
					}

				}
			});
		 newAntitd_100.start();

		anti_timer = new Timer(30, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				isCrashEat();
				isCrashEated();
				for (Antiviren anti : antiArray) {

					anti.move();
				}
			}
		});

		anti_timer.start();

		pack();
	}

	public void isCrashEat() {
		virusCX = virus.getCenter().x;
		VirusCY = virus.getCenter().y;
		for (Antiviren anti : antiArray) {
			if (anti.getRadius() <=100 && anti.isDead() == false) {
				if (virusCX > anti.getX() && virusCX < anti.getX() + anti.getRadius() && VirusCY > anti.getY()
						&& VirusCY < anti.getY() + anti.getRadius()) {
					anti.setVisible(false);
					punkt += anti.getRadius();
					jpnl.remove(anti);
					punkt += anti.getRadius();
					antiArray.remove(anti);
					anti.setDead(true);
					System.out.println(punkt);
					textField.setText(punkt+" ");
					break;
				}
			}
		}

	}

	public void isCrashEated() {
		virusCX = virus.getCenter().x;
		VirusCY = virus.getCenter().y;

		for (Antiviren anti : antiArray) {
			if (anti.getRadius() > 100) {
				if (virusCX > anti.getX() && virusCX < anti.getX() + anti.getRadius() && VirusCY > anti.getY()
						&& VirusCY < anti.getY() + anti.getRadius()) {
					jpnl.remove(virus);

				}
			}
		}

	}

	public void addAntivieren(Antiviren anti, int radius, int speed) {
		anti = new Antiviren(radius);
		antiArray.add(anti);
		anti.my_setLocation((new RandomZahl(PF_WIDTH)).getRandomZahl(), (new RandomZahl(PF_HEGHT)).getRandomZahl());
		anti.init(speed);
		jpnl.add(anti);
	}
	
	public void addCenter() {
		center = new Antiviren(250);
		antiArray.add(center);
		center.my_setLocation(515, 235);
		center.init(0);
		jpnl.add(center);
	}
}
