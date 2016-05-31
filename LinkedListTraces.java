package senCity;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTraces extends Traces {

	public void ajouter(Trace trace){
		list.add(trace);
	}

	public void initialiser() {
		this.list = new LinkedList <Trace> ();
	}

	public Traces extract(String ssid){
		//double t1 = System.currentTimeMillis();
		LinkedListTraces nouveau = new LinkedListTraces();
		for(Trace t: this){
			if(t.getSsid().equals(ssid)){
				nouveau.ajouter(t);
			}
		}
		//double t2 = System.currentTimeMillis();
		//System.out.println("temps d'exécution : "+((t2-t1)/1000));
		return nouveau;
	}
}