package CollectionsUndGenerics;

import java.util.*;
import java.io.*;

public class Jukebox1 {

	ArrayList<String> songList = new ArrayList<String>();
	
	
	public static void main(String[] args) {
		new Jukebox1().los();
	}
	
	public void los()  {
		getSongs();
		System.out.println(songList);
	}
	
	void getSongs()  {
		try {
			File datei = new File("SongList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(datei));
			String zeile = null;
			while ((zeile=reader.readLine()) != null)  {
				addSong(zeile);
			}
		}  catch(Exception ex)  {
			ex.printStackTrace();
		}
	}

	void addSong(String zuParsendeZeile)  {
		String[] tokens = zuParsendeZeile.split("/");
		songList.add(tokens[0]);
	}
	
}
