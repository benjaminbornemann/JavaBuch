package CollectionsUndGenerics;

class Song {
	
	String titel;
	String k�nstler;
	String bewertung;
	String bpm;
	
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
