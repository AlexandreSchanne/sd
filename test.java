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
		Traces n = new ArrayListTraces();
		l.load("capture_wifi.csv","capture_gps.csv",0.08);
		l.save("01.txt", l.compteurClass);
		//n=l.extract("eduroam");
		//System.out.println("memoire : "+Runtime.getRuntime().freeMemory());	// taille de l'espace libre
		

		System.out.println(n);
		
	}
}
