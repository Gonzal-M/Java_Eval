package jeu;

import java.util.Random;
import java.util.Scanner;

public class JoueurDevine {
	
	//texte à afficher au début du tour
	//(texte introductif lors de l'initialisation car au premier tour le joueur n'a pas encore deviné de nombre)
	//(par la suite, affichera le résultat du tour précédent)
	private String text = "Dans ce mode, vous devez deviner le nombre de 4 chiffres de l'ordinateur !";
	
	//On créé d'avance un objet de classe Menu pour pouvoir lancer la fonction qui affiche le menu par la suite.
	Menu menu = new Menu();
	
	//Cette fonction prend le string contenant le résulat de la partie précédente composé de +, = et - pour pouvoir
	//l'afficher au joueur.
	private int AffichageJoueurDevine(String prevResult) {
		int choice;
		do {
			//Le jeu affiche donc le résultat précédent au joueur...
			System.out.println(prevResult);
			//et lui propose ensuite d'en deviner un nouveau.
			System.out.println("Proposez un nombre :");
			
			//Le joueur entre un nombre qui est enregistré dans la variable "choice"
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();	
			
		//Si ce choix est supérieur à 9999 (c'est à dire composé de 5 chiffres ou plus), la boucle se répète 
		//afin d'obtenir une proposition valable.
		}while(choice > 9999);
		
		//La proposition, une fois vérifiée comme valable, est renvoyée par la fonction.
		return choice;
	}
		
	public void Devine() {
		//L'ordinateur prend un nombre au hasard entre 0 et 9999
		int rd = new Random().nextInt(9999);
		
		
		//On utilise le constructeur de la classe Nombre pour créer le Nombre qui correspondra à la solution du jeu.
		Nombre resultat = new Nombre(rd);
		
		//On récupère le nombre sous forme de String pour l'afficher plus tard sous forme garantie de nombre à 4 chiffres.
		String nbString = resultat.getNbString();
		
		//On utilise un boucle "for" qui tournera 10 fois car le joueur a 10 chances pour trouver le nombre.
		for (int i = 0; i < 10; i++) {
				
			//Affiche le nombre de tentatives restantes au joueur.
			System.out.println("\nIl vous reste " + String.valueOf(10-i) + " tentatives.");
			
			//Cette fonction, comme dit plus haut, affiche le résultat deviné précédemment et demande un nouveau
			//nombre au joueur.
			int nbEntier = AffichageJoueurDevine(text);
			
			//Ce nombre est mis dans un objet de classe Nombre qui va le décomposer en 4 chiffres et le retranscrire
			//en string.
			Nombre nb = new Nombre(nbEntier);
			
			//Cette fonction, détaillée dans Nombre.java, compare chaque chiffre du nombre deviné à chaque chiffre du
			//nombre à deviner et renvoie le résultat sous forme de string composé de +, = et -.
			text = nb.ComparaisonNombres(resultat, nb);
				
			if(text.equals("====")) {
				//Si le nombre deviné renvoie "====", alors le joueur a deviné le bon nombre. Un
				//message s'affiche pour lui signaler qu'il a gagné en rappelant le nombre qui était à deviner.
				System.out.println("Vous avez trouvez le bon nombre ! Il s'agissait bien de " + nbString + ".\n");
				break;
				//La partie est finie, le menu s'affiche pour faire une autre partie, changer de mode, ou quitter le jeu.
				//menu.printMenu();
				
			}else if(i == 9) {
				//Si le joueur était à sa dernière tentative et que son nombre ne correspond toujours pas à la solution,
				//un message s'affiche pour lui signaler qu'il a perdu et pour lui donner la réponse qui était à deviner.
				System.out.println("Vous n'avez pas trouvé le bon nombre. La solution était : " + nbString + ".\n");
				
				break;
				//La partie est finie, le menu s'affiche pour faire une autre partie, changer de mode, ou quitter le jeu.
				//menu.printMenu();
			}
		}			
	}
}
