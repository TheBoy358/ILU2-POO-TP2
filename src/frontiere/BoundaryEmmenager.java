package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà  un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Etes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois " + nomVisiteur);
					StringBuilder questionGaulois = new StringBuilder();
					questionGaulois.append("Quelle est votre force ?");
					int forceGaulois = -1;
					forceGaulois = Clavier.entrerEntier(questionGaulois.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide " + nomVisiteur);
		StringBuilder questionDruideForce = new StringBuilder();
		questionDruideForce.append("Quelle est votre force ?\n");
		int forceDruide = -1;
		forceDruide = Clavier.entrerEntier(questionDruideForce.toString());
		
		StringBuilder questionDruideEffetMin = new StringBuilder();
		questionDruideEffetMin.append("Quelle est la force de potion la plus faible que vous produisez ?\n");
		int effetPotionMin = -1;
		effetPotionMin = Clavier.entrerEntier(questionDruideEffetMin.toString());
		
		StringBuilder questionDruideEffetMax = new StringBuilder();
		questionDruideEffetMax.append("Quelle est la force de potion la plus forte que vous produisez ?\n");
		int effetPotionMax = -1;
		effetPotionMax = Clavier.entrerEntier(questionDruideEffetMax.toString());
		if (effetPotionMax < effetPotionMin) {
			System.out.println("Attention druide, vous vous êtes trompé entre le minimum et le maximum");
		} else {
			controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
		}
	}
}
