package senCity;
import java.lang.Math;

public class CoupleDeSommets{

	public int position;
	public double poids;
	public Sommet sommet1;
	public Sommet sommet2;
	

	public CoupleDeSommets(int position, double Poids)
	{
		this.position=position;
		this.poids=Math.abs(Poids);
	}

	public int getPosition()
	{
		return this.position;
	}

	public double getValuation()
	{
		return this.poids;
	}
	
	public String getSommet1(){
		return sommet1.toString();
	}
	
	public String getSommet2(){
		return sommet2.toString();
	}
	public String toString(){
		return "\nPosition : "+this.position+", distance : "+this.poids;
	}
}
