package CollectionsUndGenerics;

class Song {
	
	String titel;
	String künstler;
	String bewertung;
	String bpm;
	
	Song(String t ,String k, String bw, String b)  {
		titel = t;
		künstler = k;
		bewertung = bw;
		bpm = b;
	}
	
	public String getTitel()  {
		return titel;
	}
	
	public String getKünstler()  {
		return künstler;
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
