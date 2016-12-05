import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Virus extends JLabel {
	private int x = 200;
	private int y = 300;
	public static double VIRUS_SPEED = 15.0;
	public int Radius  = 75;
	
	
	
	
//	public final static int MOVE_UP = 1;
//	public final static int MOVE_DOWN = 2;
//	public final static int MOVE_RIGHT = 3;
//	public final static int MOVE_LEFT = 4;
	/**
	 * 
	 */
	
	
	
	
	private static final long serialVersionUID = 1L;

	public Virus() {
		super();
		this.setIcon(new ImageIcon(PlayFrame.class.getResource("/icon/Virus_1.png")));
		System.out.println("/icon/Virus_1.png");
		this.setBounds(x, y, 150,150);
	}

//	public void setLocation(int posX, int posY) {
//		this.x = posX;
//		this.y = posY;
//	}

	public void move(int step) {
		switch (step) {
		case 1:
			y -= VIRUS_SPEED;
			x += VIRUS_SPEED;
			break;
		case 3:
			x += VIRUS_SPEED;
			break;
		case 4:
			x += VIRUS_SPEED;
			y += VIRUS_SPEED;
			break;
		case 6:
			y += VIRUS_SPEED;
			break;
		case 7:
			y += VIRUS_SPEED;
			x -=VIRUS_SPEED;
			break;
			
		case 9:
			x -=VIRUS_SPEED;
			break;
		case 10:
			y -= VIRUS_SPEED;
			x -=VIRUS_SPEED;
			break;
		case 12:
			y -= VIRUS_SPEED;
			break;
		}
		
		this.setLocation(x,y);

	}

	public void repeat() {
		this.setBounds(x, y, 200, 200);
	}
	
	public Point getPostion(){
		return new Point(x,y);
		
	}
	
	public Point getCenter(){
		return new Point(x+Radius,y+Radius);
		
	}
	
	
	
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

}
