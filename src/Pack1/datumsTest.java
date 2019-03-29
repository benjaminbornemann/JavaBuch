package Pack1;
import java.util.Date;
import java.util.Calendar;


public class datumsTest {

	public static void main(String[] args) {
		
		Date heute = new Date();
		System.out.println(String.format("%tA, %td. %tB", heute, heute, heute));
		
		Calendar c = Calendar.getInstance();
		c.set(2004,0,7,15,40);
		System.out.println(c.getTime());
		
		
	}

}
