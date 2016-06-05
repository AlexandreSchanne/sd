package senCity;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

public abstract class MapTraces extends AbstractTraces implements Iterable {

	Map<String, Traces> dictionnaire;
	
	public Map getMap(){
		return dictionnaire;
	}
	
	public Traces extract(String ssid){
		Traces TR = new ArrayListTraces();
		//for (Entry<String, Traces> entry : dictionnaire.entrySet()) {
		TR = dictionnaire.get(ssid);
		//}
		return TR;
	}
	
	public void ajouter(Trace tra) {
		if(dictionnaire.get(tra.getSsid()) == null){
			Traces tr = new ArrayListTraces();
			tr.ajouter(tra);
			dictionnaire.put(tra.getSsid(),tr);
		}else{
			Traces tr = new ArrayListTraces();
			tr = dictionnaire.get(tra.getSsid());
			tr.ajouter(tra);
			dictionnaire.put(tra.getSsid(),tr);
			
		}
	}
	
	/*dictionnaire.put(cl.getSsid(),this.extract(cl.getSsid()));*/
}