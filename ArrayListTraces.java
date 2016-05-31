
package senCity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ArrayListTraces extends Traces{

	public void ajouter(Trace trace){
		list.add(trace);
	}

	public void initialiser() {
		this.list=new ArrayList <Trace> ();
	}

	public Traces extract(String ssid){
		//double t1 = System.currentTimeMillis();
		ArrayListTraces nouveau = new ArrayListTraces();
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