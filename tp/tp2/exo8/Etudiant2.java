public class Etudiant2 {
    private int CNE;
    private String nom;
    private String prenom;
    private double[] notes = new double[3];
    private static int autoIncrement = 1;

    public Etudiant2(String nom, String prenom, double n1, double n2, double n3) {
        this.CNE = autoIncrement++;
        this.nom = nom;
        this.prenom = prenom;
        this.notes[0] = n1;
        this.notes[1] = n2;
        this.notes[2] = n3;
    }

    public double calculerMoyenne() {
        double m = (0.4 * notes[0]) + (0.4 * notes[1]) + (0.2 * notes[2]);
        return m;
    }

    public void afficher() {
    double m = calculerMoyenne();
    System.out.println(CNE + "    " + nom + "    " + prenom + "    " + m);
    }
}