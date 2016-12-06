import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;

public class PlayFrame extends JFrame {
	private int PF_WIDTH = 1280;
	private int PF_HEGHT = 720;
	ArrayList<Antiviren> antiArray = new ArrayList<Antiviren>();
	// HashSet<Antiviren> antiArray = new HashSet<Antiviren>();
	int virusCX, VirusCY;
	private static final long serialVersionUID = 1L;
	private static int showpunkt = 0;
	private BackgroundPanel jpnl;
	private Timer timer, anti_timer;

	private static int punkt = 0;
	private Antiviren center;

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
		virus.levelup();
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

		addCenter();
		textField = new JTextField("0");
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
					}

					if (virus.getLevel() > 2 && center.getAnti_speed() == 0) {
						center.setAnti_speed(10);
					}

				}

			}
		});
		newAntitd_50.start();

		antiFactory(6, 4, 1, 1);

		Thread newAntitd_100 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					{
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						if (antiArray.size() < 15 && virus.getLevel() > 1) {

							addAntivieren(new Antiviren(100), 100, 5);
						}
					}
				}

			}
		});
		newAntitd_100.start();

		Thread newAntitd_150 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {

					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
					}
					if (virus.getLevel() > 2)
						addAntivieren(new Antiviren(150), 150, 4);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
					if (virus.getLevel() > 2)
						addAntivieren(new Antiviren(200), 200, 4);
				}

			}
		});
		newAntitd_150.start();

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

	// Virus 能不能被吃的判断
	public void isCrashEat() {
		virusCX = virus.getCenter().x;
		VirusCY = virus.getCenter().y;
		int r = virus.getRadius() - virus.getRadius() / 3;
		for (Antiviren anti : antiArray) {
			int x = anti.getX() + anti.getRadius();
			int y = anti.getY() + anti.getRadius();
			if ((anti.getRadius() <= virus.getRadius()) && anti.isDead() == false) {
				if (x > virusCX - r && x < virusCX + r && y > VirusCY - r && y < VirusCY + r) {
					punkt += 100;
					showpunkt +=100;
					jpnl.remove(anti);
					anti.setDead(true);
					System.out.println(punkt);
					textField.setText(showpunkt + " ");
					antiArray.remove(anti);
					if (punkt >= 2000) {
						virus.levelup();
						punkt = 0;
					}
					break;
				}
			}

		}

	}

	// bei chi
	public void isCrashEated() {
		virusCX = virus.getCenter().x;
		VirusCY = virus.getCenter().y;

		for (Antiviren anti : antiArray) {
			int x = anti.getX() + anti.getRadius();
			int y = anti.getY() + anti.getRadius();
			int d = anti.getRadius() - anti.getRadius() / 3;
			if (anti.getRadius() > virus.getRadius()) {
				if (virusCX > x - d && virusCX < x + d / 4 && VirusCY > y - d && VirusCY < y + d / 4
						&& virus.getVIRUS_SPEED() != 0) {
					// System.out.println(anti.getRadius());
					// System.out.println("virusCX: " + virusCX
					// +" VirusCY : "+VirusCY);
					// System.out.println("AntiX : "+(x-d)+ " AntiY:"+(y-d));
					virus.setVIRUS_SPEED(0);
					for (Antiviren anti2 : antiArray) {
						anti2.setAnti_speed(0);
					}

					break;
				}
			}
		}

	}

	public void antiFactory(int a, int b, int c, int d) {
		for (int i = 0; i < a; i++) {
			addAntivieren(new Antiviren(50), 50, 4);
		}

		for (int i = 0; i < b; i++) {
			addAntivieren(new Antiviren(100), 100, 3);
		}

		for (int i = 0; i < c; i++) {
			addAntivieren(new Antiviren(150), 150, 2);
		}

		for (int i = 0; i < d; i++) {
			addAntivieren(new Antiviren(200), 200, 1);
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
