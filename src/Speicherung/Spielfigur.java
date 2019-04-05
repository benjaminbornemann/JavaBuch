package Speicherung;

import java.io.*;

public class Spielfigur implements Serializable {
	
	int stärke;
	String typ;
	String[] waffen;
	
	public Spielfigur(int s, String t, String[] w)  {
		stärke = s;
		typ = t;
		waffen = w;
	}
	
	public int getStärke()  {
		return stärke;
	}
	
	public String getTyp()  {
		return typ;
	}
	
	public String getWaffen()  {
		String waffenliste ="";
		
		for (int i = 0; i < waffen.length; i++)  {
			waffenliste += waffen[i] + " ";
		}
		return waffenliste;
	}
	
	
}
