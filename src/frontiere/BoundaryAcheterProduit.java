package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String nomVendeur = controlAcheterProduit.getNomVendeur();
		
		if (!controlAcheterProduit.estHabitantGaulois(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			StringBuilder questionProduit = new StringBuilder();
			questionProduit.append("Quel produit voulez-vous acheter ?\n");
			String produitChoisi = "";
			produitChoisi = Clavier.entrerChaine(questionProduit.toString());
			
			if (!controlAcheterProduit.estProduitVendu(produitChoisi)) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			} else {
				StringBuilder questionCommercant = new StringBuilder();
				questionCommercant.append("Chez quel commerçant voulez-vous acheter des fleurs ?\n");
				for (int i = 1; i < controlAcheterProduit.trouverVendeurProduit(produitChoisi).length; i++) {
					System.out.println(i + " - " + controlAcheterProduit.trouverEtalVendeur(nomVendeur).etatEtal()[1]);
				}
				int commercantChoisi = -1;
				commercantChoisi = Clavier.entrerEntier(questionCommercant.toString());
				if (commercantChoisi >= controlAcheterProduit.trouverVendeurProduit(produitChoisi).length) {
					System.out.println("Il n'y a pas de commerçant occupant la place " + commercantChoisi);
				} else {
					System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
					System.out.println("Bonjour " + nomAcheteur);
					StringBuilder questionNbProduit = new StringBuilder();
					questionNbProduit.append("Combien de " + produitChoisi + " voulez-vous acheter ?\n");
					int NbProduitChoisi = -1;
					NbProduitChoisi = Clavier.entrerEntier(questionNbProduit.toString());
					int NbProduitVendeur = controlAcheterProduit.getNbProduitVendeur();
					if (NbProduitChoisi > NbProduitVendeur) {
						System.out.println(nomAcheteur + " veut acheter " + NbProduitChoisi + " " + produitChoisi + ", malheureusement " + nomVendeur + " n’en a plus que " + NbProduitVendeur + ". " + nomAcheteur + " achète tout le stock de " + nomVendeur + ".");
						NbProduitVendeur = 0;
					} else if (NbProduitVendeur == 0) {
						System.out.println(nomAcheteur + " veut acheter " + NbProduitChoisi + " " + produitChoisi + ", malheureusement il n’y en a plus !");
					} else {
						System.out.println(nomAcheteur + " achète " + NbProduitChoisi  + " " + produitChoisi + " à " + nomVendeur);
						NbProduitVendeur -= NbProduitChoisi;
					}
				}
			}			
		}	
	}
}
