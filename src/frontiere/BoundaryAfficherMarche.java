package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String vendeur = "";
		String quantite = "";
		String produit = "";
		if (controlAfficherMarche.donnerInfosMarche().length == 0) {
			System.out.println("Le marché est vide revenez plus tard");
		} else {
			System.out.println(nomAcheteur + ", vous trouverez au marché :");
			
			int i = 0;
			vendeur = controlAfficherMarche.donnerInfosMarche()[i];
			i++;
				
			quantite = controlAfficherMarche.donnerInfosMarche()[i];
			i++;
				
			produit = controlAfficherMarche.donnerInfosMarche()[i];
			
			System.out.println("- " + vendeur + " qui vend " + quantite + " " + produit);
		}
	}
}