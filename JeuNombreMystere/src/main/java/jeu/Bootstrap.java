package jeu;

public class Bootstrap {

	public static void main(String[] args) {
		//On créé un objet de classe Menu...
		Menu menu = new Menu();
		//et on lance la fonction qui affiche le menu et demande un choix au joueur
		menu.printMenu();
	}

}
