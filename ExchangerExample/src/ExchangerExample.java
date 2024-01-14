import java.util.concurrent.Exchanger;

public class ExchangerExample {
	
    public static void main(String[] args) {
    	
        Exchanger<String> exchanger = new Exchanger<>();

        Runnable task1 = () -> {
            try {
                String data = "Data from thread 1";
                System.out.println("Thread 1 is exchanging: " + data);
                String received = exchanger.exchange(data);
                System.out.println("Thread 1 received: " + received);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            try {
                String data = "Data from thread 2";
                System.out.println("Thread 2 is exchanging: " + data);
                String received = exchanger.exchange(data);
                System.out.println("Thread 2 received: " + received);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }
}
