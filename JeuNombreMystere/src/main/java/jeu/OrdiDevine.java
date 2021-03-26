package jeu;

import java.util.Scanner;

public class OrdiDevine {
	private String textResultat;
	
	public void FaitDeviner() {
		//Demande un nombre au joueur et l'enregistre dans un objet de classe Nombre.
		Nombre resultat = new Nombre(DemandeNb());
		
		//L'ordinateur commence avec 0000 :
		int nb = 0;
		
		//La boucle for permet à l'ordinateur d'avoir 10 tentatives.
		for (int i = 0; i < 10; i++) {
			//Stock le nombre deviné par l'ordinateur dans un objet de classe Nombre
			Nombre devine = new Nombre(nb);
			
			//Cette fonction, détaillée dans Nombre.java, compare chaque chiffre du nombre deviné à chaque chiffre du
			//nombre à deviner et renvoie le résultat sous forme de string composé de +, = et -.
			textResultat = devine.ComparaisonNombres(resultat, devine);
			
			//Affiche le nombre deviné par l'ordinateur et son résultat sous forme de string de +, - et =
			System.out.println("L'ordinateur a deviné le nombre : " + devine.NombreEnString(nb));
			System.out.println("Cette tentative a renvoyé le résultat suivant : " + textResultat + "\n");
			
			if(textResultat.equals("====")) {
				//Si l'ordinateur trouve le nombre, un message le signal.
				System.out.println("L'ordinateur a deviné votre nombre ! C'était " + resultat.getNbString() + ".\n");
				break;
			}else if(i == 9){
				//S'il s'agissait de la dernière tentative de l'ordinateur et qu'il n'a toujours pas trouvé le 
				//nombre, un message le signal.
				System.out.println("L'ordinateur n'a pas réussi à deviner le nombre ! C'était " + resultat.getNbString() + ".\n");
				
			}else {
				//Si ce n'était pas sa dernière tentative, l'ordinateur essaye à nouveau de deviner le nombre
				nb = NextTryNumber(textResultat, devine);				
			}			
		}
	}
	
	private int DemandeNb() {
		int nb;
		
		//On demande un nombre au joueur à faire deviner à l'ordinateur.
		do {
			System.out.println("Choisissez un nombre inférieur ou égal à 9999 à faire deviner à l'ordinateur :");
			Scanner sc = new Scanner(System.in);
			nb = sc.nextInt();
			
		//On vérifie que le nombre est valable...
		}while(nb>9999);
		//puis le renvoie.
		return nb;
	}
	
	private int NextTryNumber(String textResultat, Nombre devine) {
		//On récupère chaque chiffre du nombre dans une liste
		int[] chiffres = devine.getChiffres();
		
		//On récupère chaque caractère du résultat sous forme de string composé de +, = et -, et on adapte le chiffre
		//auquel il correspond en fonction
		int c1 = NextTryDigit(textResultat.charAt(0), chiffres[0]);
		int c2 = NextTryDigit(textResultat.charAt(1), chiffres[1]);
		int c3 = NextTryDigit(textResultat.charAt(2), chiffres[2]);
		int c4 = NextTryDigit(textResultat.charAt(3), chiffres[3]);
		
		//On réalise la formule suivante pour recomposer un nombre à partir des nouveaux chiffres...
		int number = c1*1000 + c2*100 + c3*10 + c4;
		//et on renvoie le nombre.
		return number;
	}
	
	private int NextTryDigit(char charResultat, int c) {
		
		//Si le chiffre donné a renvoyé un "+", alors on lui ajoute 1
		if(charResultat == '+') {
			c++;
			
		//Si le chiffre donné a renvoyé un "-", alors on lui soustrait 1
		}else if(charResultat == '-') {
			c--;
		}
		
		//Si le chiffre donné a renvoyé un "=", alors il n'y a aucune modification à faire
		//On renvoit le chiffre adapté a ce qu'il a renvoyé précédemment
		return c;
	}
}
