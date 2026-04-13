public class Etudiant {
    private String nom;
    private double[] s1 = new double[8];
    private double[] s2 = new double[8];
    private double moyenne;
    private String resultat;

    public Etudiant(String nom, double[] notesS1, double[] notesS2) {
        this.nom = nom;
        this.s1 = notesS1;
        this.s2 = notesS2;
        calculerMoyenne();
        determinerResultat();
        afficherInfos();
    }

    public void calculerMoyenne() {
        double somme = 0;
        for (double note : s1) {
            somme += note;
        }
        for (double note : s2) {
            somme += note;
        }
        this.moyenne = somme / 16;
    }

    public void determinerResultat() {
        if (this.moyenne < 12) {
            this.resultat = "non admis";
        } else {
            this.resultat = "admis";
        }
    }

    public void afficherInfos() {
        System.out.println("Étudiant : " + nom);
        System.out.println("Moyenne  : " + moyenne);
        System.out.println("Statut   : " + resultat);
    }
}