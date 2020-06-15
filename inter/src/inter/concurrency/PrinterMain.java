package inter.concurrency;

public class PrinterMain {

	public static void main(String[] args) {
		int limit = 20;
		NumberPrinter np = new NumberPrinter(limit);
		
		Thread t1 = new Thread(() -> np.print1());
		Thread t2 = new Thread(() -> np.print2());
		Thread t3 = new Thread(() -> np.print3());
		
		t1.start();
		t2.start();
		t3.start();
	}
}
