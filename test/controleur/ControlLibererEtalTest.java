package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlLibererEtal controlLibererEtal;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	    controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
	}

	@Test
	void testControlLibererEtal() {
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testIsVendeur() {
		Gaulois asterix = new Gaulois("Astérix", 3);
		village.ajouterHabitant(asterix);
		assertFalse(controlLibererEtal.isVendeur("Astérix"));
		village.installerVendeur(asterix, "boucliers", 10);
		assertTrue(controlLibererEtal.isVendeur("Astérix"));
	}
	
	@Test
	void testLibererEtal() {
		assertEquals(controlLibererEtal.libererEtal("nomVendeur"), controlTrouverEtalVendeur.trouverEtalVendeur("nomVendeur").etatEtal());
	}
}
