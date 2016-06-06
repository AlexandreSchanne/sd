package senCity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public abstract class Traces extends AbstractTraces implements Iterable<Trace>{
	
	Collection<Trace> list2;
	
	public abstract Traces extract(String ssid);
	
	public void ajouter(Trace trace){
		list.add(trace);
	}
	
	public int taille(){
		return list.size();
	}

	public Trace get(int i) {
		int j=0;
		Iterator<Trace> it = this.list.iterator();
		Trace t = new Trace();
		while(j!=i){
			t=it.next();
		}
		return t;
	}

}
