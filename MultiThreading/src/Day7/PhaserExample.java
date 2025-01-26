package Day7;
import java.util.concurrent.Phaser;

public class PhaserExample {

	public static void main(String[] args) {

		int parties = 3;

		Phaser phaser = new Phaser(parties);

		Runnable task = () -> {

			System.out.println("Thread is in phase " + phaser.getPhase());

			phaser.arriveAndAwaitAdvance(); // Synchronize at the barrier

			System.out.println("Thread is continuing after the barrier.");
			
			

			System.out.println("Thread is in phase " + phaser.getPhase());

			phaser.arriveAndAwaitAdvance(); // Synchronize at the barrier

			System.out.println("Thread is continuing after the barrier.");

		};

		for (int i = 0; i < parties; i++) {
			new Thread(task).start();
		}
	}
}
