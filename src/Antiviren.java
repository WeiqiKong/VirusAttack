import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Antiviren extends JLabel {
	private int radius;
	
	
	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	private int x = 1000;
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	private int y = 300;

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
	public Antiviren(int radius){
		super();
		setRadius(radius);
	}

	public void init(){
		this.setIcon(new ImageIcon(PlayFrame.class.getResource("/icon/anti_"+radius+"x"+radius+".png")));
		System.out.println("/icon/anti_"+radius+"x"+radius+".png");
		this.setBounds(x, y, getRadius(), getRadius());
		System.out.println(x+" " + y);
	}
	
	public void my_setLocation(int x,int y){
		this.setX(x);
		this.setY(y);
	}
	
	

}
