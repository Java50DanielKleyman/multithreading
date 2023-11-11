package telran.deadlock;

public class ExampleAppl {

	public static void main(String[] args) throws InterruptedException {
		CommonResourses commonResourses = new CommonResourses();
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				commonResourses.f1();
			}
		});
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				commonResourses.f2();
			}
		});
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}