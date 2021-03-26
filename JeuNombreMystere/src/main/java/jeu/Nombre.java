package jeu;

public class Nombre {
	private int[] chiffres;
	private String nbString;
	
	public Nombre(int nb) {
		//D�composition du nombre en chiffres
		//La fonction Decomposition, d�taill�e plus bas, renvoie une liste des 4 chiffres qui composent le Nombre.
		//Ils sont enregistr�s dans une liste de chiffres.
		chiffres = Decomposition(nb);

		//Cette fonction retranscris le Nombre en char[] afin de pouvoir lui rajouter des 0 devant si n�cessaire pour
		//l'affichage.
		nbString = NombreEnString(nb);
	}

	private int[] Decomposition(int nb) {
		
		//Cette formule r�cup�re le chiffre des milli�mes. Si le nombre est inf�rieur � 1000, le r�sultat sera 0.
		int c1 = (nb - (nb%1000))/1000;
		//Cette formule r�cup�re le chiffre des centi�mes. Si le nombre est inf�rieur � 100, le r�sultat sera 0.
		int c2 = (nb - c1*1000 - (nb%100))/100;
		//Cette formule r�cup�re le chiffre des dixi�mes. Si le nombre est inf�rieur � 10, le r�sultat sera 0.
		int c3 = (nb - c1*1000 - c2*100 -(nb%10))/10;
		//Cette formule r�cup�re le chiffre des unit�s. Si le nombre est �gale � 0, le r�sultat sera 0.
		int c4 = nb - c1*1000 - c2*100 - c3*10;
		
		//Les chiffres sont enregistr�s dans une liste qui est ensuite renvoy�e par la fonction.
		int liste[] = {c1,c2,c3,c4};
		return liste;
	}
	
	//Cette fonction compare deux chiffres entre eux et renvoie le symbole correspondant au r�sultat (+, = ou -).
	private char ComparaisonChiffres(int chiffre, int chiffreDevine) {
		char result;
		
		//Si le chiffre devin� est inf�rieur au chiffre � deviner, le r�sultat est "-"
		if(chiffre < chiffreDevine) {
			result = '-';
		//Si le chiffre devin� est �gal au chiffre � deviner, le r�sultat est "="
		}else if(chiffre == chiffreDevine) {
			result = '=';
		//Si le chiffre devin� n'est ni inf�rieur, ni �gal, alors il est sup�rieur et le r�sultat est "+"
		}else{
			result = '+';
		}
		
		//Le r�sultat est ensuite renvoy�
		return result;
	}
	
	//Cette fonction compare un nombre de 4 chiffres � un autre.
	public String ComparaisonNombres(Nombre nombre, Nombre nombreDevine) {
		char[] result = new char[4];
		
		//Pour cela, il ex�cute la fonction comparant un chiffre � un autre pour chaque chiffre composant les nombres
		//� comparer.
		result[0] = ComparaisonChiffres(nombre.chiffres[0],nombreDevine.chiffres[0]);
		result[1] = ComparaisonChiffres(nombre.chiffres[1],nombreDevine.chiffres[1]);
		result[2] = ComparaisonChiffres(nombre.chiffres[2],nombreDevine.chiffres[2]);
		result[3] = ComparaisonChiffres(nombre.chiffres[3],nombreDevine.chiffres[3]);
		
		//Il renvoie ensuite le r�sultat qui correspond � un char[] compos� de +, = et -.
		return String.valueOf(result);
	}
	
	
	
	public String NombreEnString(int nb) {
		//On transforme le nombre choisi en String pour lui rajouter des 0 s'il est inf�rieur � 1000 afin
		//de composer un nombre � 4 chiffres
		String nbString = String.valueOf(nb);
		char[] nbChar = new char[4];
		
		//S'il est inf�rieur � 1000, on rajoute un z�ro devant (ex: 956 devient 0956)
		if(nb<1000) {
			nbChar[0] = '0';
			//S'il est inf�rieur � 100, on rajoute un z�ro devant le z�ro d�j� rajout� pr�c�demment 
			//(ex: 38 �tait devenu 038 au "if" pr�c�dent et devient 0038 dans celui-ci)
			
			if(nb<100) {
				nbChar[1] = '0';
				//S'il est inf�rieur � 10, on rajoute un z�ro devant les z�ros d�j� rajout�s pr�c�demment 
				//(ex: 7 �tait devenu 07 au premier "if", 007 au deuxi�me, et devient 0007 dans celui-ci)
				
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
		//Apr�s cet enchainement de conditions, le nombre retranscrit en string sera forc�ment un nombre � 4 chiffres
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
