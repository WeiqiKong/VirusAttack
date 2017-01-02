package anti;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class Antiviren extends JLabel {
	private boolean isDead = false;
	private int anti_speed = 0;
	private int x = 1000;
	private int y = 300;
	private int radius;
	private int direction;
	private Point center = new Point(x + radius / 2, y + radius / 2);

	public void setDirection() {
		int randomZahl = (int) (Math.random() * 12);
		while (randomZahl != 3 && randomZahl != 4 && randomZahl != 6 && randomZahl != 7 && randomZahl != 9
				&& randomZahl != 10 && randomZahl != 12 && randomZahl != 1) {
			randomZahl = (int) (Math.random() * 12);

		}
		direction = randomZahl;

	}

	public Antiviren(int radius) {
		super();
		setRadius(radius);
		setDirection();
	}

	public void init(int speed) {
		setAnti_speed(speed);
		this.setIcon(new ImageIcon(("src/icon/anti_" + radius + "x" + radius + ".png")));
		// System.out.println("/icon/anti_" + radius + "x" + radius + ".png");
		this.setBounds(x, y, getRadius(), getRadius());
		// System.out.println(x + " " + y);
	}

	public void my_setLocation(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public void move() {
		this.turn();
		switch (getDirection()) {
		case 1:
			y -= anti_speed;
			x += anti_speed;
			break;
		case 3:
			x += anti_speed;
			break;
		case 4:
			x += anti_speed;
			y += anti_speed;
			break;
		case 6:
			y += anti_speed;
			break;
		case 7:
			y += anti_speed;
			x -= anti_speed;
			break;

		case 9:
			x -= anti_speed;
			break;
		case 10:
			y -= anti_speed;
			x -= anti_speed;
			break;
		case 12:
			y -= anti_speed;
			break;
		}

		this.setLocation(x, y);
		setCenter();

	}

	public void turn() {
		if (x > 1280 - getRadius()) {
			if (direction == 1) {
				direction = 10;
			} else if (direction == 3) {
				direction = 10;
			} else if (direction == 4) {
				direction = 7;
			}

		} else if (y > 720 - getRadius()) {
			if (direction == 4) {
				direction = 12;
			} else if (direction == 6) {
				direction = 1;
			} else if (direction == 7) {
				direction = 10;
			}
		} else if (x < 0) {
			if (direction == 7) {
				direction = 4;
			} else if (direction == 9) {
				direction = 4;
			} else if (direction == 10) {
				direction = 1;
			}
		} else if (y < 0) {
			if (direction == 10) {
				direction = 7;
			} else if (direction == 12) {
				direction = 4;
			} else if (direction == 1) {
				direction = 6;
			}

		}
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public int getDirection() {
		return direction;
	}

	public int getAnti_speed() {
		return anti_speed;
	}

	public void setAnti_speed(int anti_speed) {
		this.anti_speed = anti_speed;
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius
	 *            the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
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
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter() {
		this.center.x = x + radius / 2;
		this.center.y = y + radius / 2;
	}
	
	public void speedUp(){
		anti_speed++;
	}
	
	public void run(){
		this.setAnti_speed(10);
	}
		
}
