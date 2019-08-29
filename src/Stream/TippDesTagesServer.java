package Stream;

import java.io.*;
import java.net.*;

public class TippDesTagesServer {
	
	String[] tippListe = {"Essen Sie weniger Chips und Gummibärchen.", "Holen Sie sich die engen Jeans. Nein, Sie sehen darin NICHT dick aus.", "Mit einem Wort: unmöglich!", "Seien Sie erhlich, nur heute.", "Sie sollten wirklich mal wieder zum Friseur gehen."};
	
	public void los()  {
		
		try  {
			
			ServerSocket serverSock = new ServerSocket(4242);
			
			while(true)  {
				
				Socket sock = serverSock.accept();
				
				PrintWriter writer = new PrintWriter(sock.getOutputStream());
				String tipp = getTipp();
				writer.println(tipp);
				writer.close();
				System.out.println(tipp);
			}
			
		} catch(IOException ex)  {
			ex.printStackTrace();
		}
	}    // los() Ende
	
	private String getTipp()  {
		int zufallszahl = (int) (Math.random() * tippListe.length);
		return tippListe[zufallszahl];
	}

	public static void main(String[] args) {
		TippDesTagesServer server = new TippDesTagesServer();
		server.los();
	}

}
