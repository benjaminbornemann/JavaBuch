package Stream;

public class DoppelThreadtest implements Runnable  {

	public static void main(String[] args) {
		DoppelThreadtest aufgabe = new DoppelThreadtest();
		Thread alpha = new Thread(aufgabe);
		Thread beta = new Thread(aufgabe);
		alpha.setName("Alpha-Thread");
		beta.setName("Beta-Thread");
		alpha.start();
		beta.start();
	}

	public void run()  {
		for (int i = 0; i < 25; i++)  {
			String threadName = Thread.currentThread().getName();
			System.out.println("jetzt läuft der " + threadName + i);
		}
	}
	
}
