public class SleepExample extends Thread {



	public SleepExample(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " " + this.getName());
			System.out.println("------------------------");
			try {
				sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Done! " + this.getName());
	}

	public static void main(String[] args) {
		new SleepExample("One").start();
		new SleepExample("Two").start();

		System.out.println("The current Thread " + Thread.currentThread().getName());
	}

}