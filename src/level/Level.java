package level;

import anti.AntiFactory;
import anti.Antiviren;

public class Level extends Thread {

	private int level = 1;
	private AntiFactory antiFactory;
	private boolean stop = false;

	public Level(AntiFactory antiFactory) {
		this.setAntiFactory(antiFactory);
	}

	@Override
	public void run() {
		while (true) {
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (antiFactory.getAntiArray().size() < 16&&(!stop)) {
				switch (level) {

				case 1: {
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					antiFactory.addAntivieren(new Antiviren(50), 50, 7);
					antiFactory.addAntivieren(new Antiviren(50), 50, 7);
					break;
				}
				case 2: {
					antiFactory.addAntivieren(new Antiviren(50), 50, 7);
					antiFactory.addAntivieren(new Antiviren(100), 100, 6);
					antiFactory.addAntivieren(new Antiviren(150), 100, 5);

					break;
				}
				case 3: {
					if (antiFactory.getCenter().getAnti_speed() == 0)
						antiFactory.getCenter().run();
					antiFactory.addAntivieren(new Antiviren(100), 100, 6);
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					antiFactory.addAntivieren(new Antiviren(50), 50, 7);
					antiFactory.addAntivieren(new Antiviren(150), 150, 6);
					antiFactory.addAntivieren(new Antiviren(200), 200, 5);
					break;
				}
				case 4: {
					antiFactory.getCenter().setAnti_speed(14);
					antiFactory.addAntivieren(new Antiviren(50), 50, 7);
					try {
						sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					antiFactory.addAntivieren(new Antiviren(100), 100, 6);
					try {
						sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					antiFactory.addAntivieren(new Antiviren(150), 100, 5);
					try {
						sleep(8000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					antiFactory.addAntivieren(new Antiviren(200), 200, 5);
					break;
				}
				
				}
			}
		}

	}

	public void levelUp() {
		level++;
	}

	public AntiFactory getAntiFactory() {
		return antiFactory;
	}

	public void setAntiFactory(AntiFactory antiFactory) {
		this.antiFactory = antiFactory;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	

}
