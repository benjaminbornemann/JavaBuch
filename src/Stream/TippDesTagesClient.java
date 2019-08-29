package Stream;

import java.io.*;
import java.net.*;

public class TippDesTagesClient {

	public void los()  {
		try  {
			Socket s = new Socket("127.0.0.1", 4242);
			
			InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader);
			
			String tipp = reader.readLine();
			System.out.println("Tipp des Tages: " + tipp);
			
			reader.close();
		}  catch(IOException ex)  {
			ex.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		TippDesTagesClient client = new TippDesTagesClient();
		client.los();
	}

}
