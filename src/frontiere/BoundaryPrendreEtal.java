package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux vous trouver un étal.");
			
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolée " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé.");
			} else {
				installerVendeur(nomVendeur);
				System.out.println("C'est parfait, il me reste un étal pour vous !");
				System.out.println("Il me faudrait quelques renseignement :");
				
				StringBuilder questionProduit = new StringBuilder();
				questionProduit.append("Quel produit souhaitez-vous vendre ?\n");
				String produit = "";
				produit = Clavier.entrerChaine(questionProduit.toString());
				
				StringBuilder questionNbProduit = new StringBuilder();
				questionNbProduit.append("Combien souhaitez-vous en vendre ?\n");
				int nbProduit = -1;
				nbProduit = Clavier.entrerEntier(questionNbProduit.toString());
				
				if (controlPrendreEtal.prendreEtal(nomVendeur,produit,nbProduit) != -1) {
					System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + controlPrendreEtal.prendreEtal(nomVendeur,produit,nbProduit));
				}
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
