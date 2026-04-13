 public class Classe2 {
    private int nbEtudiants = 0;
    private static final int MAX_ETUDIANTS = 30; 
    private Etudiant2[] listeEtudiants;

    public Classe2() {
        this.listeEtudiants = new Etudiant2[MAX_ETUDIANTS];
    }

    public void ajouterEtudiant(Etudiant2 e) {
        if (nbEtudiants < MAX_ETUDIANTS) {
            listeEtudiants[nbEtudiants] = e;
            nbEtudiants++;
        } else {
            System.out.println("Classe pleine !");
        }
    }

    public void afficherClasse() {
        System.out.println("CNE  Nom        Prenom     Moyenne");
        for (int i = 0; i < nbEtudiants; i++) {
            listeEtudiants[i].afficher();
        }
    }
}