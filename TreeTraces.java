package senCity;
import senCity.Node;

import java.util.Collection;


public class TreeTraces extends AbstractTraces {

	Node racine;
	//int compteur;
	
	public void initialiser() {
		this.racine = null;
	}
	
	public Traces extract(String ssid) {
		char l;
		int i=0;
		Node actuel = this.racine;
		for(i=0;i<=ssid.length();i++){
			l=ssid.charAt(i);
			if(actuel.equals(l)){
				actuel.fils=actuel;
			}
			if(!actuel.equals(l)){
				actuel.frere=actuel;
			}
		}
		return actuel.t;
	}


	public void ajouter(Trace t) {

		
	}
	
	public Node setFrere(Node fr){
		return this.frere = fr;
	}
	
	public Node setFils(Node fi){
		return this.fils = fi;
	}
	
	
	public Node getfils(){
		return this.fils;
	}
	
	public Node getFrere(){
		return this.frere;
	}
	
	/*public int getCompteur(){
		return this.compteur;
	}*/
	

	
	public Traces getTrace(){
		return this.t;
	}
	

}
