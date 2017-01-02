package menu;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class HighScorePanel extends BackgroundPanel {

	private ArrayList<Player> rank = new ArrayList<Player>();
	private Comparator<Player> comparator = new Comparator<Player>() {

		@Override
		public int compare(Player o1, Player o2) {
			return -Integer.compare(o1.getScore(), o2.getScore());
		}
	};

	private JLabel[] nr;

	private JLabel[] name;

	private JLabel[] score;

	private static final long serialVersionUID = 3040280116708403578L;

	public HighScorePanel(Image image) {
		super(image);
		this.setPreferredSize(new Dimension(1280, 720));
		setLayout(null);
		nr = new JLabel[6];
		nr[0] = new JLabel("1.");
		nr[0].setForeground(Color.WHITE);
		nr[0].setFont(new Font("MV Boli", Font.PLAIN, 44));
		nr[0].setBounds(192, 159, 67, 50);
		add(nr[0]);

		nr[1] = new JLabel("2.");
		nr[1].setFont(new Font("MV Boli", Font.PLAIN, 44));
		nr[1].setBounds(192, 260, 67, 50);
		nr[1].setForeground(Color.WHITE);
		add(nr[1]);

		nr[2] = new JLabel("3.");
		nr[2].setFont(new Font("MV Boli", Font.PLAIN, 44));
		nr[2].setBounds(192, 350, 67, 50);
		nr[2].setForeground(Color.WHITE);
		add(nr[2]);

		nr[3] = new JLabel("4.");
		nr[3].setFont(new Font("MV Boli", Font.PLAIN, 44));
		nr[3].setBounds(192, 450, 67, 50);
		nr[3].setForeground(Color.WHITE);
		add(nr[3]);

		nr[4] = new JLabel("5.");
		nr[4].setFont(new Font("MV Boli", Font.PLAIN, 44));
		nr[4].setBounds(192, 557, 67, 50);
		nr[4].setForeground(Color.WHITE);
		add(nr[4]);

		nr[5] = new JLabel("6.");
		nr[5].setFont(new Font("MV Boli", Font.PLAIN, 44));
		nr[5].setBounds(192, 657, 67, 50);
		nr[5].setForeground(Color.WHITE);
		add(nr[5]);

		JLabel lblHighScore = new JLabel("High Score\r\n");
		lblHighScore.setForeground(Color.WHITE);
		lblHighScore.setFont(new Font("MV Boli", Font.PLAIN, 44));
		lblHighScore.setBounds(68, 32, 347, 102);
		add(lblHighScore);

		name = new JLabel[6];
		name[0] = new JLabel("");
		name[0].setFont(new Font("MV Boli", Font.PLAIN, 44));
		name[0].setBounds(362, 159, 286, 50);
		name[0].setForeground(Color.WHITE);
		add(name[0]);

		name[1] = new JLabel("");
		name[1].setFont(new Font("MV Boli", Font.PLAIN, 44));
		name[1].setBounds(362, 260, 286, 50);
		name[1].setForeground(Color.WHITE);
		add(name[1]);

		name[2] = new JLabel("");
		name[2].setFont(new Font("MV Boli", Font.PLAIN, 44));
		name[2].setBounds(362, 350, 286, 50);
		name[2].setForeground(Color.WHITE);
		add(name[2]);

		name[3] = new JLabel("");
		name[3].setFont(new Font("MV Boli", Font.PLAIN, 44));
		name[3].setBounds(362, 450, 286, 50);
		name[3].setForeground(Color.WHITE);
		add(name[3]);

		name[4] = new JLabel("");
		name[4].setFont(new Font("MV Boli", Font.PLAIN, 44));
		name[4].setBounds(362, 557, 286, 50);
		name[4].setForeground(Color.WHITE);
		add(name[4]);

		name[5] = new JLabel("");
		name[5].setFont(new Font("MV Boli", Font.PLAIN, 44));
		name[5].setBounds(362, 657, 286, 50);
		name[5].setForeground(Color.WHITE);
		add(name[5]);

		score = new JLabel[6];
		score[0] = new JLabel("");
		score[0].setFont(new Font("MV Boli", Font.PLAIN, 44));
		score[0].setBounds(665, 159, 186, 50);
		score[0].setForeground(Color.WHITE);
		add(score[0]);

		score[1] = new JLabel("");
		score[1].setFont(new Font("MV Boli", Font.PLAIN, 44));
		score[1].setBounds(665, 260, 186, 50);
		score[1].setForeground(Color.WHITE);
		add(score[1]);

		score[2] = new JLabel("");
		score[2].setFont(new Font("MV Boli", Font.PLAIN, 44));
		score[2].setBounds(665, 350, 186, 50);
		score[2].setForeground(Color.WHITE);
		add(score[2]);

		score[3] = new JLabel("");
		score[3].setFont(new Font("MV Boli", Font.PLAIN, 44));
		score[3].setBounds(665, 450, 186, 50);
		score[3].setForeground(Color.WHITE);
		add(score[3]);

		score[4] = new JLabel("");
		score[4].setFont(new Font("MV Boli", Font.PLAIN, 44));
		score[4].setBounds(665, 557, 186, 50);
		score[4].setForeground(Color.WHITE);
		add(score[4]);

		score[5] = new JLabel("");
		score[5].setFont(new Font("MV Boli", Font.PLAIN, 44));
		score[5].setBounds(665, 657, 186, 50);
		score[5].setForeground(Color.WHITE);
		add(score[5]);

	}

	public void addDate(Player player) {
		rank.add(player);
		Collections.sort(rank, comparator);
		for (int i = 0; i < rank.size(); i++) {
			name[i].setText(rank.get(i).getName());
			score[i].setText(rank.get(i).getScore() + "");
			if (i == 5)
				break;
		}
	}

}
