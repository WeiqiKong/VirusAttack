package anti;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

import playsystem.RandomZahl;

public class AntiFactory {
	private int PF_WIDTH = 1280;
	private int PF_HEGHT = 720;
	JPanel jpnl;
	private Antiviren center;
	Set<Antiviren> antiArray = new HashSet<Antiviren>();

	public AntiFactory(JPanel jpnl) {
		this.jpnl = jpnl;
		System.out.println(jpnl.getWidth());
	}

	public void init(int a, int b, int c, int d) {
		for (int i = 0; i < a; i++) {
			addAntivieren(new Antiviren(50), 50, 4);
		}

		for (int i = 0; i < b; i++) {
			addAntivieren(new Antiviren(100), 100, 3);
		}

		for (int i = 0; i < c; i++) {
			addAntivieren(new Antiviren(150), 150, 2);
		}

		for (int i = 0; i < d; i++) {
			addAntivieren(new Antiviren(200), 200, 1);
		}

	}

	public void addAntivieren(Antiviren anti, int radius, int speed) {
		anti = new Antiviren(radius);
		antiArray.add(anti);
		anti.my_setLocation((new RandomZahl(PF_WIDTH)).getRandomZahl(), (new RandomZahl(PF_HEGHT)).getRandomZahl());
		anti.init(speed);
		jpnl.add(anti);
	}

	public void addCenter() {
		center = new Antiviren(250);
		antiArray.add(center);
		center.my_setLocation(515, 235);
		center.init(0);
		jpnl.add(center);
	}

	public Antiviren getCenter() {
		return center;
	}

	public void setCenter(Antiviren center) {
		this.center = center;
	}

	public Set<Antiviren> getAntiArray() {
		return antiArray;
	}

	public void setAntiArray(Set<Antiviren> antiArray) {
		this.antiArray = antiArray;
	}
	
	public void clear(){
		antiArray.clear();
	}

}
