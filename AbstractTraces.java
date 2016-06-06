package senCity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public abstract class AbstractTraces{

	Collection<Trace> list;
	double compteurClass;



	public abstract void ajouter(Trace t);
	public abstract void initialiser();


	public void load(String fichierWifi,String fichierGPS, double pourcentage) throws IOException {
		Traces l = new ArrayListTraces();
		FileReader flot1;
		FileReader flot2;
		BufferedReader flotFiltre1;
		BufferedReader flotFiltre2;
		initialiser();
		double compteurSucces = 0;
		double compteurts1 =0;
		double compteurts2 =0;
		double compteur =0;
		try {
			flot1 = new FileReader(fichierWifi);
			flotFiltre1 = new BufferedReader(flot1);
			flot2 = new FileReader(fichierGPS);
			flotFiltre2 = new BufferedReader(flot2);

			String ligne1 = flotFiltre1.readLine();
			String ligne2 = flotFiltre2.readLine();
			ligne2=flotFiltre2.readLine();



			while((ligne1=flotFiltre1.readLine())!= null){
				Scanner sc2 = new Scanner(ligne2);
				sc2.useDelimiter(",");
				String s2=sc2.next();	

				Scanner sc1 = new Scanner(ligne1);
				sc1.useDelimiter(",");
				String s1=sc1.next();

				long ts2 = Long.parseLong(s2)/1000000000;
				long ts1 = Long.parseLong(s1)/1000000000;

				compteur++;
				if (ts1<ts2) {
					while(ts1<ts2 ){
						try{
							ligne1 = flotFiltre1.readLine();
							compteurts1++;
							Scanner sc = new Scanner(ligne1);
							sc.useDelimiter(",");
							s1=sc.next();
							ts1 = Long.parseLong(s1)/1000000000;
							sc1=sc;
						} 
						catch(NullPointerException e1){System.out.println("fin du fichier");}
					}
				}
				if (ts1>ts2) {
					while(ts1>ts2){
						try{
							ligne2 = flotFiltre2.readLine();
							compteurts2++;
							Scanner sc = new Scanner(ligne2);
							sc.useDelimiter(",");
							s2=sc.next();
							ts2 = Long.parseLong(s2)/1000000000;
							sc2=sc;
						}
						catch(NullPointerException e1){System.out.println("fin du fichier");}
					}
				}
				if(ts1==ts2){
					compteurSucces++;
					s1=sc1.next();
					s1=sc1.next();
					String ssid = s1;
					if(ssid.equals("<hidden>")) {continue;}
					s1=sc1.next();
					s1=sc1.next();
					s1=sc1.next();
					int signal = Integer.parseInt(s1);
					s2=sc2.next();
					double latitude = Double.parseDouble(s2);
					s2=sc2.next();
					double longitude = Double.parseDouble(s2);
					String ts = String.valueOf(ts1);
					Trace nouveau = new Trace(ts,ssid,signal,new GPS (longitude, latitude));
					/*System.out.println(nouveau);
					System.out.println(list);*/
					this.ajouter(nouveau);
				}
				sc1.close();
				sc2.close();
			}
			//System.out.println(dictionnaire.values());
		}
		catch (IOException E) {
			System.out.println("Il y a une erreur de type IOException");
		}

		System.out.println("nombre de réussite : "+compteurSucces);
		this.compteurClass=compteurSucces;	
		double valeur = (compteurts1/(compteurts1+compteur));
		System.out.println("tour de boucle si ts1<ts2 : "+compteurts1);
		System.out.println("tour de boucle si ts2<ts1 : "+compteurts2);
		System.out.println("pourcentage d'erreur : "+valeur);
		if(valeur>pourcentage){throw new IOException("Valeur pourcentage supérieur");}
	}

	public void save(String nomFichier, double compteur){
		try{
			PrintWriter reecriture = new PrintWriter (new BufferedWriter (new FileWriter (nomFichier)));
			reecriture.println("Nombre de Trace dans le fichier : "+compteur);
			for(Trace d :list){
				reecriture.println(d.ts);
				reecriture.println(d.ssid);
				reecriture.println(d.signal);
				reecriture.println(d.g.latitude);
				reecriture.println(d.g.longitude);
				reecriture.println("            ");
			}
			reecriture.close();

		}catch(Exception e2){System.out.println("Problème" + e2.getMessage());}				
	}

	public String toString(){
		String a = null;
		for(Trace d :list){
			a=a+d.toString();
		}
		return a;
	}

	public Iterator<Trace> iterator(){
		Iterator<Trace> it = list.iterator();
		return it;
	}
}
