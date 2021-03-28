package jeu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NombreTest {
	
	@Test
    void TestNombre() {
        // Arrange
        Nombre test;
                
        // Act
        test = new Nombre(1234);
        
        // Assert
        assertEquals(1,test.getChiffres()[0]);
        assertEquals(2,test.getChiffres()[1]);
        assertEquals(3,test.getChiffres()[2]);
        assertEquals(4,test.getChiffres()[3]);
     
    }
	
	@Test
    void TestNombreString() {
        // Arrange
        Nombre test;
                
        // Act
        test = new Nombre(1234);
        
        // Assert
        assertEquals("1234",test.getNbString());

    }
	
	@Test
    void TestNombreLongueur() {
        // Arrange
        Nombre test;
                
        // Act
        test = new Nombre(1234);
        
        // Assert
        assertEquals(4,test.getChiffres().length);

    }
	
}