package playsystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;

import anti.AntiFactory;
import anti.Antiviren;
import level.Level;
import menu.BackgroundPanel;
import menu.EndPanel;
import menu.GameStartMenu;
import menu.HighScorePanel;
import menu.Player;
import menu.WinPanel;
import virus.Virus;
import virus.VirusDirection;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import java.awt.FlowLayout;

public class PlayFrame extends JFrame {
	private int PF_WIDTH = 1280;
	private int PF_HEGHT = 720;
	private static int showpunkt = 0;
	private BackgroundPanel jpnl;
	private Timer timer, anti_timer;
	private static int punkt = 0;
	public Virus virus;
	private JLabel score;
	private AntiFactory antiFactory;
	private Level level;
	private HighScorePanel hsp;
	private JButton back;
	private JButton back_end, back_win;
	private JLabel name;
	private JTextField playerName;
	private JLabel gameover;
	private boolean isEnd = false;
	private boolean firstTime = true;
	private EndPanel edp;
	private WinPanel wp;
	private static final long serialVersionUID = 1L;

	public PlayFrame() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("VirusAttack");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// GAME START JPanel
		GameStartMenu gsm = new GameStartMenu(
				(new ImageIcon(PlayFrame.class.getResource("/icon/background2.jpg"))).getImage());
		gsm.setOpaque(false);
		gsm.setPreferredSize(new Dimension(PF_WIDTH, PF_HEGHT));
		gsm.setFocusable(true);
		gsm.setLayout(null);

		// JButton Game Start
		JButton GameStart = new JButton();
		GameStart.setBounds(430, 315, 423, 89);
		GameStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				GameStart.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/Game-Start.png")));
			}

			public void mousePressed(MouseEvent e) {
				jpnl.setVisible(true);
				gsm.setVisible(false);
				hsp.setVisible(false);
				edp.setVisible(false);
				wp.setVisible(false);
				jpnl.setFocusable(true);
				gameStart();

			}

			@Override
			public void mouseExited(MouseEvent e) {
				GameStart.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/Game-Start-white.png")));
			}
		});
		GameStart.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/Game-Start-white.png")));
		GameStart.setBackground(UIManager.getColor("Button.highlight"));
		GameStart.setContentAreaFilled(false);
		GameStart.setOpaque(false);
		GameStart.setBorder(null);
		gsm.add(GameStart);

		// JButton High Score
		JButton HighScore = new JButton("");
		HighScore.setBounds(459, 424, 348, 70);
		HighScore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				HighScore.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/High-Score.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				gsm.setVisible(false);
				hsp.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HighScore.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/High-Score-white.png")));
			}
		});
		HighScore.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/High-Score-white.png")));
		HighScore.setContentAreaFilled(false);
		HighScore.setOpaque(false);
		HighScore.setBorder(null);
		gsm.add(HighScore);
		
		JButton Exit = new JButton("");
		Exit.setBounds(1080, 640, 200, 79);
		Exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
					System.exit(0);
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		Exit.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/exit.png")));
		Exit.setContentAreaFilled(false);
		Exit.setOpaque(false);
		Exit.setBorder(null);
		gsm.add(Exit);
		

		// High Score Panel
		hsp = new HighScorePanel((new ImageIcon(PlayFrame.class.getResource("/icon/background2.jpg")).getImage()));
		hsp.setOpaque(false);
		hsp.setPreferredSize(new Dimension(PF_WIDTH, PF_HEGHT));
		hsp.setFocusable(true);
		hsp.setLayout(null);
		hsp.setVisible(false);

		// GAME JPanel
		jpnl = new BackgroundPanel((new ImageIcon(PlayFrame.class.getResource("/icon/background2.jpg")).getImage()));

		jpnl.setOpaque(false);
		jpnl.setPreferredSize(new Dimension(PF_WIDTH, PF_HEGHT));
		jpnl.setFocusable(true);
		jpnl.setLayout(null);
		jpnl.setVisible(false);
		
		

		antiFactory = new AntiFactory(jpnl);
		virus = new Virus();
		jpnl.add(virus);

		score = new JLabel("Score:0");
		score.setForeground(Color.WHITE);
		score.setFont(new Font("MV Boli", Font.PLAIN, 36));
		score.setBounds(53, 27, 284, 70);
		jpnl.add(score);

		// EndPanel
		edp = new EndPanel((new ImageIcon(PlayFrame.class.getResource("/icon/background2.jpg")).getImage()));
		edp.setOpaque(false);
		edp.setPreferredSize(new Dimension(PF_WIDTH, PF_HEGHT));
		edp.setFocusable(true);
		edp.setLayout(null);
		edp.setVisible(false);

		// WinPanel
		wp = new WinPanel((new ImageIcon(PlayFrame.class.getResource("/icon/background2.jpg")).getImage()));
		wp.setOpaque(false);
		wp.setPreferredSize(new Dimension(PF_WIDTH, PF_HEGHT));
		wp.setFocusable(true);
		wp.setLayout(null);
		wp.setVisible(false);

		// GameOver GIF
		gameover = new JLabel("");
		gameover.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/Gameover.gif")));
		gameover.setBounds(133, 148, 1014, 424);

		back = new JButton();
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				back.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/highscore/back-shine.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				jpnl.setVisible(false);
				gsm.setVisible(true);
				hsp.setVisible(false);
				edp.setVisible(false);
				wp.setVisible(false);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				back.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/highscore/back.png")));
			}
		});
		back.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/highscore/back.png")));
		back.setBounds(969, 631, 178, 64);
		back.setContentAreaFilled(false);
		back.setBorder(null);
		back.setOpaque(false);
		hsp.add(back);

		back_end = new JButton();
		back_end.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				back_end.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/highscore/back-shine.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				jpnl.setVisible(false);
				gsm.setVisible(true);
				hsp.setVisible(false);
				edp.setVisible(false);
				wp.setVisible(false);
				isEnd = false;
				hsp.addDate(new Player(edp.getPlayerName().getText(), showpunkt));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				back_end.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/highscore/back.png")));
			}
		});
		back_end.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/highscore/back.png")));
		back_end.setBounds(969, 606, 178, 64);
		back_end.setContentAreaFilled(false);
		back_end.setBorder(null);
		back_end.setOpaque(false);
		edp.add(back_end);

		back_win = new JButton();
		back_win.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				back_win.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/highscore/back-shine.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				hsp.setVisible(false);
				gsm.setVisible(true);
				jpnl.setVisible(false);
				edp.setVisible(false);
				wp.setVisible(false);
				hsp.addDate(new Player(edp.getPlayerName().getText(), showpunkt));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				back_win.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/highscore/back.png")));
			}
		});
		back_win.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/highscore/back.png")));
		back_win.setBounds(969, 606, 178, 64);
		back_win.setContentAreaFilled(false);
		back_win.setBorder(null);
		back_win.setOpaque(false);
		wp.add(back_win);

		name = new JLabel("");
		name.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/endPanel/name.png")));
		name.setBounds(539, 606, 129, 48);

		playerName = new JTextField();
		playerName.setBounds(698, 606, 196, 48);
		playerName.setFont(new Font("MV Boli", Font.PLAIN, 39));
		playerName.setColumns(10);
		playerName.setText("name");

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
				if (e.getKeyChar() == KeyEvent.VK_L) {
					virus.levelup();
					level.levelUp();
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

		antiFactory.init(6, 6, 2, 1);
		antiFactory.addCenter();

		timer = new Timer(20, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				virus.move(VirusDirection.getDirection());
				if (isEnd) {
//					virus.init();
					jpnl.setVisible(false);
					gsm.setVisible(false);
					hsp.setVisible(false);
					edp.setVisible(true);
					wp.setVisible(false);
					for (Antiviren anti : antiFactory.getAntiArray()) {
						if (antiFactory.getAntiArray().contains(anti))
							jpnl.remove(anti);
					}
					antiFactory.getAntiArray().clear();
					anti_timer.stop();
					isEnd = false;
				}
			}
		});
		timer.start();

		anti_timer = new Timer(30, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (level.getLevel() == 5) {
					isEnd = true;
					firstTime = false;
					VirusDirection.init();
					virus.init();
					timer.stop();
					anti_timer.stop();
					level.setLevel(1);
					level.setStop(true);
					hsp.setVisible(false);
					gsm.setVisible(false);
					jpnl.setVisible(false);
					edp.setVisible(false);
					wp.setVisible(true);
					
				}

				if (!isEnd) {
					isCrashEat();
					isCrashEated();
				}

				// if (virus.getLevel() == 5) {
				// hsp.setVisible(false);
				// gsm.setVisible(true);
				// jpnl.setVisible(false);
				// edp.setVisible(false);
				// wp.setVisible(false);
				// }

				for (Antiviren anti : antiFactory.getAntiArray()) {
					if (antiFactory.getAntiArray().contains(anti)) {
						anti.move();
					}
				}
			}
		});

		anti_timer.start();

		level = new Level(antiFactory);
		level.start();

		hsp.addDate(new Player("Weiqi", 1523));
		hsp.addDate(new Player("Philip", 6143));
		hsp.addDate(new Player("Max", 5213));
		hsp.addDate(new Player("Lucas", 3415));
		hsp.addDate(new Player("Norman", 6321));
		hsp.addDate(new Player("Sven", 3414));
		getContentPane().add(wp);

		JLabel lblYouWin = new JLabel("YOU WIN");
		lblYouWin.setFont(new Font("MV Boli", Font.BOLD, 99));
		lblYouWin.setForeground(Color.WHITE);
		lblYouWin.setBounds(237, 115, 723, 279);
		wp.add(lblYouWin);

		getContentPane().add(hsp);
		getContentPane().add(gsm);
		getContentPane().add(jpnl);
		getContentPane().add(edp);
		getContentPane().add(wp);

		hsp.setVisible(false);
		gsm.setVisible(true);
		jpnl.setVisible(false);
		edp.setVisible(false);
		wp.setVisible(false);

		pack();

	}

	public void isCrashEat() {
		for (Antiviren anti : antiFactory.getAntiArray()) {
			if (virus.getDistance(anti.getCenter()) < (((anti.getRadius() + virus.getRadius()) / 2) - 20)) {
				if (virus.getRadius() >= anti.getRadius()) {
					anti.setDead(true);
					jpnl.remove(anti);
					if (antiFactory.getAntiArray().contains(anti)) {
						antiFactory.getAntiArray().remove(anti);
					}
					punkt += (anti.getRadius() * 2 / virus.getLevel());
					showpunkt += anti.getRadius();
//					System.out.println("punkt" + punkt);
					score.setText("Score:" + showpunkt);
					if (punkt >= 2000) {
						virus.levelup();
						level.levelUp();
						punkt = 0;
					}
					break;
				}

			}
		}

	}

	public void isCrashEated() {
		for (Antiviren anti : antiFactory.getAntiArray()) {
			if (virus.getDistance(anti.getCenter()) < (((anti.getRadius() + virus.getRadius()) / 2) - 40)) {
				if (virus.getRadius() <= anti.getRadius() && !isEnd) {
					isEnd = true;
					firstTime = false;
					VirusDirection.init();
					virus.init();
					virus.setLocation(0, 0);
					virus.setRadius(50);
					virus.setCenter();
					level.setStop(true);
					level.setLevel(1);
//					score.setText("Score: 0");
					// timer.stop();
					// anti_timer.stop();
				}

			}
		}
	}

	public void gameStart() {
//		System.out.println("firstTime:" + firstTime);
		isEnd = false;
		if (!firstTime) {
			// virus.setLocation(0, 0);
			// virus.setCenter();
			// virus.init();

			// System.out.println("Level:" + virus.getLevel());
			punkt = 0;
			showpunkt = 0;
			isEnd = false;
			antiFactory.init(6, 6, 2, 1);
			antiFactory.addCenter();
			level.setStop(false);
			timer.start();
			anti_timer.start();
			jpnl.setFocusable(true);
			score.setText("Score: 0");


		}
	}

}
