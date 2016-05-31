package senCity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StatsSSID {


	public static void SSIDVrai (String args[]){

		FileReader flot;
		BufferedReader flotfiltre;
		String premier;
		String deuxieme;

		try{
			flot = new FileReader(args[0]);						// Fichier � lire : d�fini avec args[0]
			flotfiltre = new BufferedReader(flot);				// Cr�ation d'un flot sur le fichier pour en sortir les valeurs

			String ligne = flotfiltre.readLine();				// On lis la premi�re ligne (titre)
			while((ligne = flotfiltre.readLine()) != null){		// Tant que la ligne n'est pas nulle (� partir de la deuxi�me ligne)
				Scanner sc = new Scanner(ligne);				// Scanner sur "ligne"
				sc.useDelimiter(",");							// On d�compose les ligne en mot tous les ","
				String s = sc.next();							// On regarde le premier mot de la ligne
				premier = s;
				s = sc.next();
				deuxieme = s;
				s=sc.next();
				if(s.equals("eduroam")){						// Fonction de test dans un intervalle de deux timestamp
					System.out.println(premier);					// On affiche le timestamp s'il est bon
					System.out.println(deuxieme);
					System.out.println(s);
					while(sc.hasNext()){
						s=sc.next();
						System.out.println(s + " ");
					}
					System.out.println();						// println pour sauter une ligne
				}
			}
		}catch(IOException e)									// arriv� � la fin du document, plus de ligne
		{System.out.println("pas de ligne");					// Message d'erreur
		}




	}
}