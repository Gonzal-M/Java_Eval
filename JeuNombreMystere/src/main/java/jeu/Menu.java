package jeu;

import java.util.Scanner;

public class Menu {
	
	public void printMenu() {
		int menuChoice;
		do {
			//Affiche les diff�rentes options possibles du menu au joueur
			System.out.println("1. Devinez le nombre myst�re !\n2. Faites deviner votre nombre myst�re !\n3. Quitter le jeu\nChoisissez votre mode de jeu :\n");
			
			//Demande un chiffre correspondant au choix au joueur
			Scanner sc = new Scanner(System.in);
			menuChoice = sc.nextInt();
			
			switch (menuChoice) {
			
			//Si le joueur choisi le premier mode...
			case 1:
				//Un objet contenant les fonctions du premier mode est cr��...
				JoueurDevine j = new JoueurDevine();
				//et la partie est lanc�e
				j.Devine();
				break;
				
			//Si le joueur choisi le deuxi�me mode...
			case 2:
				//Un objet contenant les fonctions du deuxi�me mode est cr��...
				OrdiDevine o = new OrdiDevine();
				//et la partie est lanc�e
				o.FaitDeviner();
				break;
			
			//Si le joueur d�cide de quitter, on sort du switch directement
			case 3:
				break;
				
			//Si le joueur a entr� un nombre non reconnu, un message le signal et le joueur pourra en proposer un autre
			default :
				System.out.println("Merci de saisir une valeur entre 1 et 3.");
				break;
			}
			
		//Si on sort du switch et que le choix retenu est 3, le joueur voulait quitter, et on arr�te donc le jeu...
		} while(menuChoice != 3);
		//apr�s avoir remerci� le joueur :)
		System.out.println("Merci d'avoir jou� !");
	}
}