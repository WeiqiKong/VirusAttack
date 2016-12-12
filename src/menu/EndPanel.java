package menu;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import playsystem.BackgroundPanel;
import playsystem.PlayFrame;

public class EndPanel extends BackgroundPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4620782161113975882L;
	private JLabel name;
	private JTextField playerName;
	private JLabel gameover;

	public EndPanel(Image image) {
		super(image);
		playerName = new JTextField();
		playerName.setBounds(698, 606, 196, 48);
		playerName.setColumns(10);
		playerName.setFont(new Font("MV Boli", Font.PLAIN, 36));

		name = new JLabel("");
		name.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/endPanel/name.png")));
		name.setBounds(539, 606, 129, 48);

		gameover = new JLabel("");
		gameover.setBounds(133, 148, 1014, 424);
		gameover.setIcon(new ImageIcon(PlayFrame.class.getResource("/images/Gameover.gif")));

		this.add(gameover);
		this.add(name);
		this.add(playerName);

	}

	public JTextField getPlayerName() {
		return playerName;
	}

	public void setPlayerName(JTextField playerName) {
		this.playerName = playerName;
	}
	
	
	

}
