package menu;

	import java.awt.Font;
	import java.awt.Image;

	import javax.swing.ImageIcon;
	import javax.swing.JLabel;
	import javax.swing.JTextField;

public class WinPanel extends BackgroundPanel{
	
		private static final long serialVersionUID = -4620782161113975882L;
		private JLabel name;
		private JTextField playerName;

		public WinPanel(Image image) {
			super(image);
			playerName = new JTextField();
			playerName.setBounds(698, 606, 196, 48);
			playerName.setColumns(10);
			playerName.setFont(new Font("MV Boli", Font.PLAIN, 36));

			name = new JLabel("");
			name.setIcon(new ImageIcon(WinPanel.class.getResource("/images/endPanel/name.png")));
			name.setBounds(539, 606, 129, 48);
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


