package senCity;

import java.util.Map;

public abstract class MapTraces extends AbstractTraces {
	
	Map<String, Traces> dictionnaire;
	
	public Map getMap(){
		return dictionnaire;
	}
	
	public Traces extract(String ssid){
		return this.dictionnaire.get(ssid);	
	}
	
	public void addToMap(String key, Traces value){
		dictionnaire.put(key, value);
	}
	
	public void ajouter(Trace cl) {
		dictionnaire.put(cl.getSsid(), this.extract(cl.getSsid()));
	}	
}
