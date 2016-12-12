package playsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;

import anti.AntiFactory;
import anti.Antiviren;
import level.Level;
import menu.GameStartMenu;
import menu.HighScorePanel;
import menu.Player;
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
	private Virus virus;
	private JLabel score;
	private AntiFactory antiFactory;
	Set<Antiviren> antiArray;
	private Level level;
	private JLabel gameover;
	private HighScorePanel hsp;

	private static final long serialVersionUID = 1L;
	private JTextField playerName;

	public PlayFrame() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("VirusAttack");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// GAME START JPanel
		GameStartMenu gsm = new GameStartMenu(
				(new ImageIcon(PlayFrame.class.getResource("/icon/background2.jpg")).getImage()));

		gsm.setOpaque(false);
		gsm.setPreferredSize(new Dimension(PF_WIDTH, PF_HEGHT));
		gsm.setFocusable(true);
		getContentPane().add(gsm);
		gsm.setLayout(null);

		// JButton Game Start
		JButton GameStart = new JButton();
		GameStart.setBounds(430, 315, 423, 89);
		GameStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				GameStart.setIcon(new ImageIcon(GameStartMenu.class.getResource("/images/Game-Start.png")));
			}

			public void mousePressed(MouseEvent e) {
				gsm.setVisible(false);
				hsp.setVisible(false);
				jpnl.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				GameStart.setIcon(new ImageIcon(GameStartMenu.class.getResource("/images/Game-Start-white.png")));
			}
		});
		GameStart.setIcon(new ImageIcon(GameStartMenu.class.getResource("/images/Game-Start-white.png")));
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
				HighScore.setIcon(new ImageIcon(GameStartMenu.class.getResource("/images/High-Score.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				gsm.setVisible(false);
				hsp.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				HighScore.setIcon(new ImageIcon(GameStartMenu.class.getResource("/images/High-Score-white.png")));
			}
		});
		HighScore.setIcon(new ImageIcon(GameStartMenu.class.getResource("/images/High-Score-white.png")));
		HighScore.setContentAreaFilled(false);
		HighScore.setOpaque(false);
		HighScore.setBorder(null);
		gsm.add(HighScore);

		// High Score Panel
		hsp = new HighScorePanel((new ImageIcon(PlayFrame.class.getResource("/icon/background2.jpg")).getImage()));
		hsp.setOpaque(false);
		hsp.setPreferredSize(new Dimension(PF_WIDTH, PF_HEGHT));
		hsp.setFocusable(true);
		getContentPane().add(hsp);
		hsp.setLayout(null);
		hsp.setVisible(false);

		// GAME JPanel
		jpnl = new BackgroundPanel((new ImageIcon(PlayFrame.class.getResource("/icon/background2.jpg")).getImage()));

		jpnl.setOpaque(false);
		jpnl.setPreferredSize(new Dimension(PF_WIDTH, PF_HEGHT));
		jpnl.setFocusable(true);
		getContentPane().add(jpnl);
		jpnl.setLayout(null);
		jpnl.setVisible(false);

		antiFactory = new AntiFactory(jpnl);
		antiArray = antiFactory.getAntiArray();
		virus = new Virus();
		jpnl.add(virus);

		score = new JLabel("Score:0");
		score.setForeground(Color.WHITE);
		score.setFont(new Font("MV Boli", Font.PLAIN, 36));
		score.setBounds(53, 27, 284, 70);
		jpnl.add(score);

		// GameOver GIF
		gameover = new JLabel("");
		gameover.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/Gameover.gif")));
		gameover.setBounds(133, 148, 1014, 424);
		gameover.setVisible(false);
		jpnl.add(gameover);

		JLabel name = new JLabel("");
		name.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/endPanel/name.png")));
		name.setBounds(539, 606, 129, 48);
		jpnl.add(name);

		JButton back = new JButton();
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				back.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/highscore/back-shine.png")));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				hsp.setVisible(false);
				gsm.setVisible(true);
				jpnl.setVisible(false);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				back.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/highscore/back.png")));
			}
		});
		back.setIcon(new ImageIcon(GameStartMenu.class.getResource("/images/highscore/back.png")));
		back.setBounds(969, 631, 178, 64);
		back.setContentAreaFilled(false);
		back.setBorder(null);
		back.setOpaque(false);
		hsp.add(back);

		playerName = new JTextField();
		playerName.setBounds(698, 606, 196, 48);
		playerName.setColumns(10);
		jpnl.add(playerName);

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
					System.out.println("a");
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
			}
		});
		timer.start();
		anti_timer = new Timer(30, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				isCrashEat();
				if (virus.getLevel() == 5) {
					jpnl.setVisible(false);
				}
				for (Antiviren anti : antiArray) {
					if (antiArray.contains(anti))
						anti.move();
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
		pack();
	}

	public void isCrashEat() {
		for (Antiviren anti : antiArray) {
			if (virus.getDistance(anti.getCenter()) < (((anti.getRadius() + virus.getRadius()) / 2) - 20)) {
				if (virus.getRadius() >= anti.getRadius()) {
					anti.setDead(true);
					jpnl.remove(anti);
					if (antiArray.contains(anti)) {
						antiArray.remove(anti);
					}
					punkt += (anti.getRadius() * 2 / virus.getLevel());
					showpunkt += anti.getRadius();
					System.out.println(punkt);
					score.setText("Score:" + showpunkt);
					if (punkt >= 2000) {
						virus.levelup();
						level.levelUp();
						punkt = 0;
					}
					break;
				} else {
					virus.setVIRUS_SPEED(0);
					gameover.setVisible(true);
					for (Antiviren anti2 : antiArray) {
						anti2.setAnti_speed(0);
					}
					break;

				}

			}
		}

	}
}
