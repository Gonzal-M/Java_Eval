package jeu;

import java.util.Random;
import java.util.Scanner;

public class JoueurDevine {
	
	//texte � afficher au d�but du tour
	//(texte introductif lors de l'initialisation car au premier tour le joueur n'a pas encore devin� de nombre)
	//(par la suite, affichera le r�sultat du tour pr�c�dent)
	private String text = "Dans ce mode, vous devez deviner le nombre de 4 chiffres de l'ordinateur !";
	
	//On cr�� d'avance un objet de classe Menu pour pouvoir lancer la fonction qui affiche le menu par la suite.
	Menu menu = new Menu();
	
	//Cette fonction prend le string contenant le r�sulat de la partie pr�c�dente compos� de +, = et - pour pouvoir
	//l'afficher au joueur.
	private int AffichageJoueurDevine(String prevResult) {
		int choice;
		do {
			//Le jeu affiche donc le r�sultat pr�c�dent au joueur...
			System.out.println(prevResult);
			//et lui propose ensuite d'en deviner un nouveau.
			System.out.println("Proposez un nombre :");
			
			//Le joueur entre un nombre qui est enregistr� dans la variable "choice"
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();	
			
		//Si ce choix est sup�rieur � 9999 (c'est � dire compos� de 5 chiffres ou plus), la boucle se r�p�te 
		//afin d'obtenir une proposition valable.
		}while(choice > 9999);
		
		//La proposition, une fois v�rifi�e comme valable, est renvoy�e par la fonction.
		return choice;
	}
		
	public void Devine() {
		//L'ordinateur prend un nombre au hasard entre 0 et 9999
		int rd = new Random().nextInt(9999);
		
		
		//On utilise le constructeur de la classe Nombre pour cr�er le Nombre qui correspondra � la solution du jeu.
		Nombre resultat = new Nombre(rd);
		
		//On r�cup�re le nombre sous forme de String pour l'afficher plus tard sous forme garantie de nombre � 4 chiffres.
		String nbString = resultat.getNbString();
		
		//On utilise un boucle "for" qui tournera 10 fois car le joueur a 10 chances pour trouver le nombre.
		for (int i = 0; i < 10; i++) {
				
			//Affiche le nombre de tentatives restantes au joueur.
			System.out.println("\nIl vous reste " + String.valueOf(10-i) + " tentatives.");
			
			//Cette fonction, comme dit plus haut, affiche le r�sultat devin� pr�c�demment et demande un nouveau
			//nombre au joueur.
			int nbEntier = AffichageJoueurDevine(text);
			
			//Ce nombre est mis dans un objet de classe Nombre qui va le d�composer en 4 chiffres et le retranscrire
			//en string.
			Nombre nb = new Nombre(nbEntier);
			
			//Cette fonction, d�taill�e dans Nombre.java, compare chaque chiffre du nombre devin� � chaque chiffre du
			//nombre � deviner et renvoie le r�sultat sous forme de string compos� de +, = et -.
			text = nb.ComparaisonNombres(resultat, nb);
				
			if(text.equals("====")) {
				//Si le nombre devin� renvoie "====", alors le joueur a devin� le bon nombre. Un
				//message s'affiche pour lui signaler qu'il a gagn� en rappelant le nombre qui �tait � deviner.
				System.out.println("Vous avez trouvez le bon nombre ! Il s'agissait bien de " + nbString + ".\n");
				break;
				//La partie est finie, le menu s'affiche pour faire une autre partie, changer de mode, ou quitter le jeu.
				//menu.printMenu();
				
			}else if(i == 9) {
				//Si le joueur �tait � sa derni�re tentative et que son nombre ne correspond toujours pas � la solution,
				//un message s'affiche pour lui signaler qu'il a perdu et pour lui donner la r�ponse qui �tait � deviner.
				System.out.println("Vous n'avez pas trouv� le bon nombre. La solution �tait : " + nbString + ".\n");
				
				break;
				//La partie est finie, le menu s'affiche pour faire une autre partie, changer de mode, ou quitter le jeu.
				//menu.printMenu();
			}
		}			
	}
}
