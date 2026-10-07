package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite, Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		return !village.rechercherEtalVide();
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		Gaulois gaulois = village.trouverHabitant(nomVendeur);
		int numeroEtal = village.installerVendeur(gaulois, produit, nbProduit);
		if (numeroEtal != -1)
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numeroEtal);
		return numeroEtal;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return !controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
}
