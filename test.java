package senCity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import senCity.Traces;
import senCity.ArrayListTraces;
import senCity.LinkedListTraces;

public class test {


	public static void main(String args[]) throws IOException{

		try{
			switch (args[1]){

			case  "SSID" :
				StatsSSID.SSIDVrai(args);
				break;

			case "Timestamp":
				Stat.testIntervalle(args);
				break;

			case "Intervalle":
				Stats2.testIntervalle(args);
				break;
			}
		}catch(ArrayIndexOutOfBoundsException e){System.out.println("Il n'y a rien en argument");}

		Traces l = new ArrayListTraces();
		/*Traces n = new ArrayListTraces();
		l.load("capture_wifi.csv","capture_gps.csv",0.08);
		n = l.extract("eduroam");
		n.save("01.txt", l.compteurClass);
		
		HashMapTraces HM = new HashMapTraces();
		HM.load("capture_wifi.csv","capture_gps.csv",0.08);
		l = HM.extract("eduroam");
		System.out.println(l);
		//l = (HM.extract("eduroam"));
		//System.out.println(HM.dictionnaire.values());
		l.save("HashMapTraces.txt",l.compteurClass);*/
		
		TreeTraces TT = new Node();
		TreeTraces YY = new Node();
		Node no = new Node();
		TT.load("capture_wifi.csv", "capture_gps.csv", 0.08);
		l = TT.extract("eduroam");
		//System.out.println(l);
		l.save("treeTracesSave.txt",l.compteurClass);
		
		//n=l.extract("eduroam");
		//System.out.println("memoire : "+Runtime.getRuntime().freeMemory());	// taille de l'espace libre
		
	}
}
