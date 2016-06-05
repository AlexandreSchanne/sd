package senCity;
import senCity.Node;

import java.util.Collection;
import java.util.Iterator;


public abstract class TreeTraces extends AbstractTraces {
	
	char lettre;
	Node fils;
	Node frere;
	ArrayListTraces tra;
	Node node;
	


	public Traces extract(String ssid) {
		boolean trouve = false;
		int lengthSSID = ssid.length();
		int i = 0;
		Node NO = this.node;
		while(!trouve && NO.getLettre() != '\u0000') {
			System.out.println("rentré dans la boucle");
			char charSSID = ssid.charAt(i);
			if(NO.getLettre() == charSSID) {
				if(i == lengthSSID-1) {
					trouve = true;
				}
				else {
					if(NO.getFils() != null) {
						NO = NO.getFils();
					}
					else {
						return new ArrayListTraces();
					}
				}
				i++;
			}
			else {
				if(NO.getFrere() != null) {
					NO = NO.getFrere();
				}
				else {
					return new ArrayListTraces();
				}
			}
		}
		if(trouve) {
			System.out.println(NO.getTraces());
			return NO.getTraces();
		}
		else {
			return new ArrayListTraces();
		}
	}
	
	public void ajouter(Trace t) {
		node.ajouter(t,0);
		
	}
}