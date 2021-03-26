package jeu;

public class Nombre {
	private int[] chiffres;
	private String nbString;
	
	public Nombre(int nb) {
		//Décomposition du nombre en chiffres
		//La fonction Decomposition, détaillée plus bas, renvoie une liste des 4 chiffres qui composent le Nombre.
		//Ils sont enregistrés dans une liste de chiffres.
		chiffres = Decomposition(nb);

		//Cette fonction retranscris le Nombre en char[] afin de pouvoir lui rajouter des 0 devant si nécessaire pour
		//l'affichage.
		nbString = NombreEnString(nb);
	}

	private int[] Decomposition(int nb) {
		
		//Cette formule récupère le chiffre des millièmes. Si le nombre est inférieur à 1000, le résultat sera 0.
		int c1 = (nb - (nb%1000))/1000;
		//Cette formule récupère le chiffre des centièmes. Si le nombre est inférieur à 100, le résultat sera 0.
		int c2 = (nb - c1*1000 - (nb%100))/100;
		//Cette formule récupère le chiffre des dixièmes. Si le nombre est inférieur à 10, le résultat sera 0.
		int c3 = (nb - c1*1000 - c2*100 -(nb%10))/10;
		//Cette formule récupère le chiffre des unités. Si le nombre est égale à 0, le résultat sera 0.
		int c4 = nb - c1*1000 - c2*100 - c3*10;
		
		//Les chiffres sont enregistrés dans une liste qui est ensuite renvoyée par la fonction.
		int liste[] = {c1,c2,c3,c4};
		return liste;
	}
	
	//Cette fonction compare deux chiffres entre eux et renvoie le symbole correspondant au résultat (+, = ou -).
	private char ComparaisonChiffres(int chiffre, int chiffreDevine) {
		char result;
		
		//Si le chiffre deviné est inférieur au chiffre à deviner, le résultat est "-"
		if(chiffre < chiffreDevine) {
			result = '-';
		//Si le chiffre deviné est égal au chiffre à deviner, le résultat est "="
		}else if(chiffre == chiffreDevine) {
			result = '=';
		//Si le chiffre deviné n'est ni inférieur, ni égal, alors il est supérieur et le résultat est "+"
		}else{
			result = '+';
		}
		
		//Le résultat est ensuite renvoyé
		return result;
	}
	
	//Cette fonction compare un nombre de 4 chiffres à un autre.
	public String ComparaisonNombres(Nombre nombre, Nombre nombreDevine) {
		char[] result = new char[4];
		
		//Pour cela, il exécute la fonction comparant un chiffre à un autre pour chaque chiffre composant les nombres
		//à comparer.
		result[0] = ComparaisonChiffres(nombre.chiffres[0],nombreDevine.chiffres[0]);
		result[1] = ComparaisonChiffres(nombre.chiffres[1],nombreDevine.chiffres[1]);
		result[2] = ComparaisonChiffres(nombre.chiffres[2],nombreDevine.chiffres[2]);
		result[3] = ComparaisonChiffres(nombre.chiffres[3],nombreDevine.chiffres[3]);
		
		//Il renvoie ensuite le résultat qui correspond à un char[] composé de +, = et -.
		return String.valueOf(result);
	}
	
	
	
	public String NombreEnString(int nb) {
		//On transforme le nombre choisi en String pour lui rajouter des 0 s'il est inférieur à 1000 afin
		//de composer un nombre à 4 chiffres
		String nbString = String.valueOf(nb);
		char[] nbChar = new char[4];
		
		//S'il est inférieur à 1000, on rajoute un zéro devant (ex: 956 devient 0956)
		if(nb<1000) {
			nbChar[0] = '0';
			//S'il est inférieur à 100, on rajoute un zéro devant le zéro déjà rajouté précédemment 
			//(ex: 38 était devenu 038 au "if" précédent et devient 0038 dans celui-ci)
			
			if(nb<100) {
				nbChar[1] = '0';
				//S'il est inférieur à 10, on rajoute un zéro devant les zéros déjà rajoutés précédemment 
				//(ex: 7 était devenu 07 au premier "if", 007 au deuxième, et devient 0007 dans celui-ci)
				
				if(nb<10) {
					nbChar[2] = '0';
					nbChar[3] = nbString.charAt(0);
				}else {
					nbChar[2] = nbString.charAt(0);
					nbChar[3] = nbString.charAt(1);
				}
				
			}else {
				nbChar[1] = nbString.charAt(0);
				nbChar[2] = nbString.charAt(1);
				nbChar[3] = nbString.charAt(2);
			}
		}else {
			nbChar[0] = nbString.charAt(0);
			nbChar[1] = nbString.charAt(1);
			nbChar[2] = nbString.charAt(2);
			nbChar[3] = nbString.charAt(3);
		}
		//Après cet enchainement de conditions, le nombre retranscrit en string sera forcément un nombre à 4 chiffres
		return String.valueOf(nbChar);
	}
	
	//Le getter du Nombre sous forme de String
	public String getNbString() {
		return nbString;
	}

	public int[] getChiffres() {
		return chiffres;
	}
}
