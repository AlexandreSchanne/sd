package senCity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Graphe<Sommet> {

	ArrayList<Sommet> ListeDeSommets;
	ArrayList<ArrayList<CoupleDeSommets>> listeDeCouples;

	public Graphe (){
		this.ListeDeSommets = new ArrayList<Sommet>();
		this.listeDeCouples = new ArrayList<ArrayList <CoupleDeSommets>>();
	}

	public ArrayList<Sommet> getListeDeSommets(){
		return this.ListeDeSommets;
	}


	public ArrayList<ArrayList<CoupleDeSommets>> getListeDeCouple(){
		return this.listeDeCouples;
	}

	public String toString(){
		String s = "   ";
		for(Sommet element : this.ListeDeSommets){
			ArrayList<CoupleDeSommets> successeur = this.suivant(element);
			for(CoupleDeSommets couple : successeur){
				s = s+element.toString()+" vers "+ListeDeSommets.get(couple.getPosition())+" et coûte "+couple.getValuation()+"\n";
			}
		}
		return s;
	}


	public void addSommet(Sommet sommet){
		boolean contient = false;
		for(Sommet SO: ListeDeSommets){
			if(sommet.equals(SO)){
				contient=true;
			}
		}
		if(contient == false){
			this.ListeDeSommets.add(sommet);
			this.listeDeCouples.add(new ArrayList<CoupleDeSommets>());
		}
	}

	public void remove(Sommet sommet){
		int position;
		int i=0;
		while(ListeDeSommets.get(i) != sommet){
			i++;}
		position=i;
		this.listeDeCouples.remove(i);
		try{
			for(ArrayList<CoupleDeSommets> l : this.listeDeCouples){
				for(CoupleDeSommets c : new ArrayList<CoupleDeSommets>(l)){
					if(c.getPosition() == this.ListeDeSommets.indexOf(sommet)){
						l.remove(c);
					}
				}
			}
		}catch(NullPointerException e){System.out.println("Il n'y a rien à supprimer !");}
		this.ListeDeSommets.remove(sommet);
	}

	public void addPoids(Sommet sommet1, Sommet sommet2, double poids){
		if(this.ListeDeSommets.contains(sommet1) && this.ListeDeSommets.contains(sommet2)){
			int Position1DansTableau=0;
			int Position2DansTableau=0;
			for(int i=0;i<ListeDeSommets.size();i++){
				if(sommet1 == ListeDeSommets.get(i)){
					Position1DansTableau = i;
				}
				if(sommet2 == ListeDeSommets.get(i)){
					Position2DansTableau=i;
				}
			}
			ArrayList<CoupleDeSommets> list = this.listeDeCouples.get(Position1DansTableau);
			boolean trouve=false;
			for(CoupleDeSommets couple : list){
				if(!(couple.getPosition() == Position2DansTableau)){
					trouve=true;
				}
			}
			if(!trouve){
				list.add(new CoupleDeSommets(Position2DansTableau, poids));}
		}
	}


	public ArrayList<CoupleDeSommets> suivant(Sommet plusPetit){
		ArrayList<CoupleDeSommets> element= null;
		if(this.ListeDeSommets.contains(plusPetit)){
			int index = this.ListeDeSommets.indexOf(plusPetit);
			element = this.listeDeCouples.get(index);
		}
		return element;
	}


	public List<Sommet> dijkstra(Sommet origine, Sommet destination){			
		HashMap<Sommet, Double> prix = new HashMap<Sommet, Double>();
		HashMap<Sommet,Sommet> etape = new HashMap<Sommet,Sommet>();
		ArrayList<Sommet> enCours = new ArrayList<Sommet>();
		ArrayList<Sommet> dejaFait = new ArrayList<Sommet>();
		prix.put(origine, 0.0);
		enCours.add(origine);
		for(Sommet sommet : this.ListeDeSommets){
			prix.put(sommet, 99999999.0);
			etape.put(sommet, null);
		}

		while(!enCours.isEmpty() && !dejaFait.contains(destination)){
			Sommet plusPetit = enCours.get(0);
			double minCout = 999999999.0;
			for(Sommet sommet : enCours){
				double cout = prix.get(sommet);
				if(minCout > cout){
					minCout = cout;
					plusPetit = sommet;
				}
			}
			dejaFait.add(plusPetit);
			enCours.remove(plusPetit);
			ArrayList<CoupleDeSommets> succ = this.suivant(plusPetit);
			for(CoupleDeSommets c : succ){
				Sommet element = this.ListeDeSommets.get(c.getPosition());
				if(!dejaFait.contains(element)){
					double coutPlusPetit = prix.get(plusPetit);
					double coutElement = prix.get(element);
					if(coutElement > coutPlusPetit+c.getValuation()){
						prix.put(element, coutPlusPetit+c.getValuation());
						etape.put(element, plusPetit);
						enCours.add(element);
					}
				}
			}
		}
		List<Sommet> chemin = new ArrayList<Sommet>();
		chemin.add(0, destination);
		Sommet var;
		while((var = etape.get(chemin.get(0))) != null){
			chemin.add(0,var);
		}
		for(Sommet e : chemin){
			System.out.print(" - "+e.toString()+" - ");
		}
		System.out.println("");
		return chemin;
	}
}
