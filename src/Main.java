import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				PlayFrame f = new PlayFrame();
				f.setVisible(true);
			}
		});
	}
}
