package Speicherung;

public class QuizKarte {

	String frage, antwort;
	
	public QuizKarte(String f, String a)  {
		frage = f;
		antwort = a;
	}
	
	public String getFrage()  {
		return frage;
	}
	
	public String getAntwort()  {
		return antwort;
	}
	
}	