package CollectionsUndGenerics;

class Song implements Comparable<Song>{
	
	String titel;
	String k�nstler;
	String bewertung;
	String bpm;
	
	public int compareTo(Song s)  {
		return titel.compareTo(s.getTitel());
	}
		
	Song(String t ,String k, String bw, String b)  {
		titel = t;
		k�nstler = k;
		bewertung = bw;
		bpm = b;
	}
	
	public String getTitel()  {
		return titel;
	}
	
	public String getK�nstler()  {
		return k�nstler;
	}
	
	public String getBewertung()  {
		return bewertung;
	}
	
	public String getBpm()  {
		return bpm;
	}
	
	public String toString()  {
		return titel;
	}
}
