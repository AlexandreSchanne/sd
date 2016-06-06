package senCity;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class GrapheCouverture {

	double hauteur;
	double largeur;
	Traces AllTraces;
	Trace loin;
	Trace Barycentre;
	int nombreDeTrace;

	public GrapheCouverture (Traces trace){
		this.AllTraces=trace;
		this.hauteur=0;
		this.largeur=0;
	}

	public String getTrace(){
		return this.AllTraces.toString();
	}

	public void Barycentre(int signal){

		double centreLongitude=0.0;
		double latitude;
		double longitude;
		double centreLatitude=0.0;
		int compteur=0;
		double dimensionFinale = 0;

		for(Trace t : AllTraces){
			centreLongitude = centreLongitude+t.getGps().getLongitude();
			centreLatitude = centreLatitude+t.getGps().getLatitude();
			compteur++;
		}

		centreLongitude = centreLongitude/compteur;
		centreLatitude = centreLatitude/compteur;

		Barycentre = new Trace("","",1,new GPS(centreLongitude,centreLatitude));

		for(Trace t:AllTraces){
			if(t.getSignal()>signal){
				nombreDeTrace++;
				latitude=t.getGps().getLatitude();
				longitude=t.getGps().getLongitude();

				if(latitude-centreLatitude > hauteur){
					hauteur = latitude-centreLatitude;
					if(longitude-centreLongitude > hauteur){
						hauteur=longitude-latitude;
						loin =t;
					}
				}

			}
			if(hauteur-largeur <0){
				dimensionFinale=2*largeur;
			}
			if(hauteur-largeur>0){
				dimensionFinale=2*hauteur;
			}
		}
		System.out.println(loin);
		System.out.println(dimensionFinale);
		System.out.println(centreLatitude+" "+centreLongitude);
		System.out.println("Nombre de Trace : "+compteur);

	}

	public double calculMetre(Trace t1, Trace t2){
		double PI = Math.PI;
		double metre;
		metre =Math.acos(Math.sin(t1.getGps().getLatitude() * PI / 180)
				*Math.sin(t2.getGps().getLatitude()* PI / 180)
				+ Math.cos(t1.getGps().getLatitude()* PI / 180) 
				* Math.cos(t2.getGps().getLatitude()* PI / 180)
				* Math.cos((t1.getGps().getLongitude()* PI / 180) - (t2.getGps().getLongitude()* PI / 180))) * 6378137;
		return metre;
	}

	public double couverture(Trace t1, Trace t2){

		double PI = Math.PI;
		double metre;
		metre=calculMetre(t1,t2);
		System.out.println(metre+" mètre");
		return metre;
	}

	public Graphe genereGraphe(){
		Graphe g = new Graphe();

		for(Trace t: AllTraces){
			g.addSommet(t.getGps());
		}
		Trace courant=new Trace();
		GPS G1 = new GPS(0,0);
		Trace suivant=new Trace();
		GPS G2 = new GPS(0,0);
		Sommet s1 = new Sommet(G2);
		
		for(Trace t: AllTraces){
			int cpt=0;
			if(cpt==0){
				courant = t;
				G1=courant.getGps();
				s1 = new Sommet(G1);
			}
			if(cpt>0){
				suivant = t;
				G2=suivant.getGps();
				Sommet s2 = new Sommet(G2);
				double poids = calculMetre(courant,suivant);
				g.addPoids(s1,s2, poids);
				courant = suivant;
			}
			cpt++;
		}

		return g;
	}
	
	public Trace chercheTrace(double longi, double lati){
		Trace meilleur = new Trace();
		double resultat=0;
		double courant;
		for(Trace t : AllTraces){
			GPS s1 = new GPS(longi,lati);
			Trace tra = new Trace("","",1,s1);
				courant = calculMetre(t, tra);
				if(courant > resultat){
					resultat = courant;
					meilleur = t;
				}
		}
		return meilleur;
	}

	public List<Sommet> cheminLePlusCourt(double longi, double lati, double longi2, double lati2){

		Trace tr = new Trace();
		tr = chercheTrace(longi,lati);
		Trace tra = new Trace();
		tra = chercheTrace(longi2,lati2);
		Graphe g = new Graphe<>();
		g=this.genereGraphe();
		List<Sommet> l=new ArrayList();
		l=g.dijkstra(tr,tra);
		return l;
	}
}
