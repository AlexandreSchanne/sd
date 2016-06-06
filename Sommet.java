package senCity;

public class Sommet {
	
	GPS numero;

	public Sommet(GPS numero){
		this.numero=numero;
	}
	
	public String toString(){
		return numero.toString();
	}
	
	public GPS getSommet(){
		return this.numero;
	}
}
