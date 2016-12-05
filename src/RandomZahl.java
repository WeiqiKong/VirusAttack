
public class RandomZahl {
	int randomZahl;

	public RandomZahl(int oben) {
		this.setRandomZahl((int)(Math.random()*oben));
	}

	public int getRandomZahl() {
		return randomZahl;
	}

	public void setRandomZahl(int randomZahl) {
		this.randomZahl = randomZahl;
	}
}
