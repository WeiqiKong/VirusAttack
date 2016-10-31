import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Virus extends JLabel {
	private int x = 1000;
	private int y = 300;
	public final static int MOVE_UP = 1;
	public final static int MOVE_DOWN = 2;
	public final static int MOVE_RIGHT = 3;
	public final static int MOVE_LEFT = 4;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Virus() {
		super();
		this.setIcon(new ImageIcon(PlayFrame.class.getResource("/icon/testIcon.jpg")));
		this.setBounds(x, y, 293, 289);
	}

//	public void setLocation(int posX, int posY) {
//		this.x = posX;
//		this.y = posY;
//	}

	public void move(int step) {
		switch (step) {
		case MOVE_UP:
			y += 5;
			break;
		case MOVE_DOWN:
			y -= 5;
			break;
		case MOVE_RIGHT:
			x += 5;
			break;
		case MOVE_LEFT:
			x -= 5;
			break;
		}
		
		this.setLocation(x,y);

	}

	public void repeat() {
		this.setBounds(x, y, 293, 289);
	}

}
