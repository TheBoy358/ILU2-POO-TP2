package controleur;
 
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean estHabitantGaulois(String gaulois) {
		return controlVerifierIdentite.verifierIdentite(gaulois);
	}
	
	public boolean estProduitVendu(String produit) {
		return village.rechercherVendeursProduit(produit) != null;
	}
	
	public Gaulois[] trouverVendeurProduit(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public String getNomVendeur() {
		return village.donnerEtatMarche()[0];
	}
	
	public int getNbProduitVendeur() {
		return Integer.valueOf(village.donnerEtatMarche()[1]);
	}
	
	public Etal trouverEtalVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
}
