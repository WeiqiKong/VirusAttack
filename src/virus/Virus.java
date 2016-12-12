package virus;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import playsystem.PlayFrame;

public class Virus extends JLabel {
	private int x = 0;
	private int y = 0;
	public static double VIRUS_SPEED = 10.0;
	private int Radius = 50;
	private int level = 1;
	private Point center = new Point(x + Radius / 2, y + Radius / 2);

	private static final long serialVersionUID = 1L;

	public Virus() {
		super();
		this.setIcon(new ImageIcon(PlayFrame.class.getResource("/icon/Virus_1_" + Radius + ".png")));
		this.setBounds(x, y, Radius, Radius);
		this.setCenter();
	}

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
			x -= VIRUS_SPEED;
			break;

		case 9:
			x -= VIRUS_SPEED;
			break;
		case 10:
			y -= VIRUS_SPEED;
			x -= VIRUS_SPEED;
			break;
		case 12:
			y -= VIRUS_SPEED;
			break;
		}

		this.setLocation(x, y);
		setCenter();

	}

	public void levelup() {
		setLevel(getLevel() + 1);
		Radius += 50;
		this.setIcon(new ImageIcon(PlayFrame.class.getResource("/icon/Virus_1_" + Radius + ".png")));
		this.setBounds(x, y, Radius, Radius);
		this.setCenter();
	}

	public double getDistance(Point p) {
		return Math.sqrt((center.x - p.x) * (center.x - p.x) + (center.y - p.y) * (center.y - p.y));
	}

	public Point getPostion() {
		return new Point(x, y);

	}

	public Point getCenter() {
		return center;

	}

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

	public double getVIRUS_SPEED() {
		return VIRUS_SPEED;
	}

	public void setVIRUS_SPEED(double vIRUS_SPEED) {
		VIRUS_SPEED = vIRUS_SPEED;
	}

	public int getRadius() {
		return Radius;
	}

	public void setRadius(int radius) {
		Radius = radius;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {

		this.level = level;
	}

	public void setCenter() {
		this.center.x = x + Radius / 2;
		this.center.y = y + Radius / 2;
	}

}
