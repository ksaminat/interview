package inter;

public class NumberPrinter {

	int limit = 0;
	int count=1;
	boolean flag1 = false;
	boolean flag2 = false;
	boolean flag3 = false;
	
	public NumberPrinter(int limit) {
		this.limit = limit;
		this.flag1 = true;
	}
	
	public synchronized void print1() {
		while(count<limit) {
		if(flag1) {
			System.out.println(count++);
			flag1=false;
			flag2=true;
			flag3=false;
			this.notify();
		} else
			try {
				this.wait();
				this.notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void print2() {
		while(count<limit) {
		if(flag2) {
			System.out.println(count++);
			flag1=false;
			flag2=false;
			flag3=true;
			
			this.notify();
		} else
			try {
				this.wait();
				this.notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void print3() {
		while(count<limit) {
		if(flag3) {
			System.out.println(count++);
			flag1=true;
			flag2=false;
			flag3=false;
			
			this.notify();
		} else
			try {
				this.wait();
				this.notifyAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
