package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		} else {
			String etalOccupe = controlLibererEtal.libererEtal(nomVendeur)[0];
			 if (etalOccupe == "true") {
				 nomVendeur = controlLibererEtal.libererEtal(nomVendeur)[1];
				 String produit = controlLibererEtal.libererEtal(nomVendeur)[2];
				 String quantiteInitial = controlLibererEtal.libererEtal(nomVendeur)[3];
				 String quantiteVendu = controlLibererEtal.libererEtal(nomVendeur)[4];
				 System.out.println("Vous avez vendu " + quantiteVendu + " sur " + quantiteInitial + " " + produit + ".");
				 System.out.println("En revoir " + nomVendeur + ", passez une bonne journée.");
			 }
		}
	}

}
