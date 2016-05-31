package senCity;

import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HashMapTraces extends MapTraces {

	public HashMapTraces(){
		dictionnaire = new HashMap <String, Traces>();
	}

	public void initialiser() {
		dictionnaire = new HashMap <String, Traces>();
	}

	
}
