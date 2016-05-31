package senCity;

public class Node {
	private char lettre;
	private Node fils;
	private Node frere;
	private Traces alt;
	
	public Node() {
		lettre = '\u0000';
		fils = null;
		frere = null;
		alt = null;
	}
	
	public void ajouter(Trace t, int place) {
		String ssid = t.getSsid();
		char charSSID = ssid.charAt(place);
		int lengthSSID = ssid.length();
		if(lengthSSID == place+1) {
			if(lettre == '\u0000') {
				lettre = charSSID;
				if(alt == null) {
					alt = new ArrayListTraces();
				}
				alt.ajouter(t);;
			}
			else if(lettre == charSSID) {
				if(alt == null) {
					alt = new ArrayListTraces();
				}
				alt.ajouter(t);
			}
			else {
				if(frere == null) {
					frere = new Node();
				}
				frere.ajouter(t, place);
			}
		}
		else {
			if(lettre == '\u0000') {
				lettre = charSSID;
				if(fils == null) {
					fils = new Node();
				}
				fils.ajouter(t, place+1);
			}
			else if(lettre == charSSID) {
				if(fils == null) {
					fils = new Node();
				}
				fils.ajouter(t, place+1);
			}
			else if(lettre != charSSID) {
				if(frere == null) {
					frere = new Node();
				}
				frere.ajouter(t, place);
			}
		}
	}
	
	public int getTaille() {
		if(alt != null) {
			return alt.taille();
		}
		else {
			return 0;
		}
	}
	
	public void setFils(Node n) {
		fils = n;
	}
	
	public void setFrere(Node n) {
		frere = n;
	}
	
	public void setLettre(char c) {
		lettre = c;
	}
	
	public Node getFils() {
		return fils;
	}
	
	public Node getFrere() {
		return frere;
	}
	
	public char getLettre() {
		return lettre;
	}
	
	public Traces getTraces() {
		return alt;
	}
}
