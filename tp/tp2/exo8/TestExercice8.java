public class TestExercice8 {
    public static void main(String[] args) {
        Etudiant2 e1 = new Etudiant2("NOM1", "PRENOM1", 12.0, 13.0, 12.5);
        Etudiant2 e2 = new Etudiant2("NOM2", "PRENOM2", 15.0, 17.0, 18.0);
        Classe2 maClasse = new Classe2();
        maClasse.ajouterEtudiant(e1);
        maClasse.ajouterEtudiant(e2);
        maClasse.afficherClasse();
    }
}