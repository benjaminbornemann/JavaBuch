package Stream;

import java.io.*;
import java.net.*;
import java.util.*;

public class SehrEinfacherChatServer {

	ArrayList clientAusgabeStröme;
	
	public class ClientHandler implements Runnable  {
		BufferedReader reader;
		Socket sock;
		
		public ClientHandler(Socket clientSocket)  {
			try  {
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			}  catch(Exception ex)  {ex.printStackTrace();}
		}  // Konstruktor Ende
		
		public void run()  {
			String nachricht;
			try  {
				while ((nachricht = reader.readLine()) != null)  {
					System.out.println("gelesen: " + nachricht);
					esAllenWeitersagen(nachricht);
				}  // while Ende
			}  catch(Exception ex)  {ex.printStackTrace();}
		}  // run Ende
	}  // innere Klasse ClientHandler Ende
	
	
	
	public static void main(String[] args) {
		new SehrEinfacherChatServer().los();
	}
	
	public void los()  {
		clientAusgabeStröme = new ArrayList();
		
		try  {
			ServerSocket serverSock = new ServerSocket(5000);
			
		while(true)  {
			Socket clientSocket = serverSock.accept();
			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
			clientAusgabeStröme.add(writer);
			Thread t = new Thread(new ClientHandler(clientSocket));
			t.start();
			System.out.println("habe eine Verbindung");
			}
		
		}  catch(Exception ex)  {
			ex.printStackTrace();
		}
	}
	
	public void esAllenWeitersagen(String nachricht)  {
		
		Iterator it = clientAusgabeStröme.iterator();
		while(it.hasNext())  {
			try  {
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(nachricht);
				writer.flush();
			}  catch(Exception ex)  {
				ex.printStackTrace();
			}
		}  // while Ende
	} // esAllenWeitersagen Ende
}  // Klasse Ende
