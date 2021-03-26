package jeu;

import java.util.Scanner;

public class OrdiDevine {
	private String textResultat;
	
	public void FaitDeviner() {
		//Demande un nombre au joueur et l'enregistre dans un objet de classe Nombre.
		Nombre resultat = new Nombre(DemandeNb());
		
		//L'ordinateur commence avec 0000 :
		int nb = 0;
		
		//La boucle for permet � l'ordinateur d'avoir 10 tentatives.
		for (int i = 0; i < 10; i++) {
			//Stock le nombre devin� par l'ordinateur dans un objet de classe Nombre
			Nombre devine = new Nombre(nb);
			
			//Cette fonction, d�taill�e dans Nombre.java, compare chaque chiffre du nombre devin� � chaque chiffre du
			//nombre � deviner et renvoie le r�sultat sous forme de string compos� de +, = et -.
			textResultat = devine.ComparaisonNombres(resultat, devine);
			
			//Affiche le nombre devin� par l'ordinateur et son r�sultat sous forme de string de +, - et =
			System.out.println("L'ordinateur a devin� le nombre : " + devine.NombreEnString(nb));
			System.out.println("Cette tentative a renvoy� le r�sultat suivant : " + textResultat + "\n");
			
			if(textResultat.equals("====")) {
				//Si l'ordinateur trouve le nombre, un message le signal.
				System.out.println("L'ordinateur a devin� votre nombre ! C'�tait " + resultat.getNbString() + ".\n");
				break;
			}else if(i == 9){
				//S'il s'agissait de la derni�re tentative de l'ordinateur et qu'il n'a toujours pas trouv� le 
				//nombre, un message le signal.
				System.out.println("L'ordinateur n'a pas r�ussi � deviner le nombre ! C'�tait " + resultat.getNbString() + ".\n");
				
			}else {
				//Si ce n'�tait pas sa derni�re tentative, l'ordinateur essaye � nouveau de deviner le nombre
				nb = NextTryNumber(textResultat, devine);				
			}			
		}
	}
	
	private int DemandeNb() {
		int nb;
		
		//On demande un nombre au joueur � faire deviner � l'ordinateur.
		do {
			System.out.println("Choisissez un nombre inf�rieur ou �gal � 9999 � faire deviner � l'ordinateur :");
			Scanner sc = new Scanner(System.in);
			nb = sc.nextInt();
			
		//On v�rifie que le nombre est valable...
		}while(nb>9999);
		//puis le renvoie.
		return nb;
	}
	
	private int NextTryNumber(String textResultat, Nombre devine) {
		//On r�cup�re chaque chiffre du nombre dans une liste
		int[] chiffres = devine.getChiffres();
		
		//On r�cup�re chaque caract�re du r�sultat sous forme de string compos� de +, = et -, et on adapte le chiffre
		//auquel il correspond en fonction
		int c1 = NextTryDigit(textResultat.charAt(0), chiffres[0]);
		int c2 = NextTryDigit(textResultat.charAt(1), chiffres[1]);
		int c3 = NextTryDigit(textResultat.charAt(2), chiffres[2]);
		int c4 = NextTryDigit(textResultat.charAt(3), chiffres[3]);
		
		//On r�alise la formule suivante pour recomposer un nombre � partir des nouveaux chiffres...
		int number = c1*1000 + c2*100 + c3*10 + c4;
		//et on renvoie le nombre.
		return number;
	}
	
	private int NextTryDigit(char charResultat, int c) {
		
		//Si le chiffre donn� a renvoy� un "+", alors on lui ajoute 1
		if(charResultat == '+') {
			c++;
			
		//Si le chiffre donn� a renvoy� un "-", alors on lui soustrait 1
		}else if(charResultat == '-') {
			c--;
		}
		
		//Si le chiffre donn� a renvoy� un "=", alors il n'y a aucune modification � faire
		//On renvoit le chiffre adapt� a ce qu'il a renvoy� pr�c�demment
		return c;
	}
}
