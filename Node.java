package senCity;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class Node extends TreeTraces implements Iterable<Trace> {


	public Node(){
		this.lettre = '@';
		this.fils = null;
		this.frere = null;
		this.tra = new ArrayListTraces();
	}

	public void ajouter(Trace t, int position) {
		String ssid = t.getSsid();
		int tailleMOT = ssid.length();
		char ssidSEPARE = ssid.charAt(position);


		if(tailleMOT != position+1) {
			if(lettre == '@') {
				lettre = ssidSEPARE;
				if(fils == null) {
					fils = new Node();	
				}
				fils.ajouter(t,position+1);
			}
			else if(lettre == ssidSEPARE) {
				if(fils == null) {
					fils = new Node();
				}
				fils.ajouter(t,position+1);
			}
			else if(lettre != ssidSEPARE) {
				if(frere == null) {
					frere = new Node();
				}
				this.frere.ajouter(t,position);
			}
		}


		else {
			if(this.lettre == '@') {
				lettre = ssidSEPARE;
				if(tra == null) {
					tra = new ArrayListTraces();
				}
				tra.ajouter(t);
			}
			else if(lettre == ssidSEPARE) {
				if(tra == null) {
					tra = new ArrayListTraces();
				}
				tra.ajouter(t);
			}
			else {
				if(frere == null) {
					frere = new Node();
				}
				frere.ajouter(t,position);
			}
		}
	}

	public void initialiser(){
		this.node = new Node();
		this.tra = new ArrayListTraces();
	}

	public String toString(){
		return ("lettre = "+lettre+", fils = "+fils+", frere = "+frere+", tra = "+tra);
	}

	public void setFils(Node n) {
		fils = n;
	}

	public Node getFils() {
		return fils;
	}

	public void setFrere(Node n) {
		frere = n;
	}

	public Node getFrere() {
		return this.frere;
	}

	public void setLettre(char c) {
		lettre = c;
	}

	public char getLettre() {
		return this.lettre;
	}

	public Traces getTraces() {
		return this.tra;
	}

}
