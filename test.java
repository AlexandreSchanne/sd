package senCity;

import java.io.IOException;
import java.util.Scanner;

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

		Traces l = new ArrayListTraces();
		Traces n = new ArrayListTraces();

		if(args[0].equals("ArrayList")){
			n.load("capture_wifi.csv","capture_gps.csv",0.08);
			l=n.extract(args[1]);
			l.save("ArrayList.txt", n.compteurClass);
			System.out.println(l);
		}

		if(args[0].equals("LinkedList")){
			Traces li = new LinkedListTraces();
			li.load("capture_wifi.csv","capture_gps.csv",0.08);
			l=li.extract(args[1]);
			l.save("LinkedList.txt", li.compteurClass);
			System.out.println(l);
		}

		if(args[0].equals("Map")){
			HashMapTraces HM = new HashMapTraces();
			HM.load("capture_wifi.csv","capture_gps.csv",0.08);
			l = HM.extract(args[1]);
			l.save("HashMapTraces.txt",HM.compteurClass);
			System.out.println(l);
		}

		if(args[0].equals("Arbre")){
			TreeTraces TT = new Node();
			TT.load("capture_wifi.csv", "capture_gps.csv", 0.08);
			l = TT.extract(args[1]);
			l.save("treeTracesSave.txt",TT.compteurClass);
			System.out.println(l);

		}

			Scanner sc = new Scanner(System.in);

			System.out.println("Veuillez entrer les coordonnées de départ un mot :\n longitude : \n");
			String departLongi = sc.nextLine();
			System.out.println("latitude : \n");
			String departLati = sc.nextLine();
			System.out.println("Veuillez rentrer les coordonnées d'arrivée : \n longitude :\n");
			String arriveLongi = sc.nextLine();
			System.out.println("latitude : \n");
			String arriveLati = sc.nextLine();
			double longitude1 = Double.parseDouble(departLongi);
			double latitude1 = Double.parseDouble(departLati);
			double longitude2 = Double.parseDouble(arriveLongi);
			double latitude2 = Double.parseDouble(arriveLati);
			
			GrapheCouverture GC = new GrapheCouverture(l);
			Graphe g = new Graphe();
			GC.Barycentre(10);
			List<Sommet> list = new ArrayList();
			Trace t1 = new Trace();
			Trace t2 = new Trace();
			t1=GC.chercheTrace(longitude1, latitude1);
			t1=GC.chercheTrace(longitude2, latitude2);
			GC.couverture(t1, t2);
			GC.genereGraphe();
			
			if(args[2].equals("trouverChemin")){
			GC.cheminLePlusCourt(longitude1, latitude1, longitude2, latitude2);
		}
	}
}
