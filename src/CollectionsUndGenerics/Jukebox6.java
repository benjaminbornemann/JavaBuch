package CollectionsUndGenerics;

import java.util.*;
import java.io.*;


public class Jukebox6 {

	ArrayList<Song> songList = new ArrayList<Song>();
	
	
	public static void main(String[] args) {
		new Jukebox6().los();
	}
	
	public void los()  {
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
		HashSet<Song> songSet = new HashSet<Song>();
		songSet.addAll(songList);
		System.out.println(songSet);
	}
	
	void getSongs()  {
		try {
			File datei = new File("SongListPlus.txt");
			BufferedReader reader = new BufferedReader(new FileReader(datei));
			String zeile = null;
			while ((zeile=reader.readLine()) != null)  {
				addSong(zeile);
			}
			reader.close();
		}  catch(Exception ex)  {
			ex.printStackTrace();
		}
		
	}
	
	;

	void addSong(String zuParsendeZeile)  {
		String[] tokens = zuParsendeZeile.split("/");
		
		Song nächsterSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nächsterSong);
	}
	
}
