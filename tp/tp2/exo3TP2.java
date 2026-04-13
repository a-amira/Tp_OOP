import java.util.Scanner;
class MaDate {
    public int jour, mois, annee;
    
    public MaDate(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }
}

class Employe {
    private String matricule, nom, prenom;
    private MaDate dateNaissance, dateEmbauche; 
    private double salaire;

    public Employe(String matricule, String nom, String prenom, MaDate DateN, MaDate DateE, double salaire) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = DateN;
        this.dateEmbauche = DateE;
        this.salaire = salaire;
    }

    public int age() {
        return 2026 - dateNaissance.annee;
    }
    public int anciennete() {
        return 2026 - dateEmbauche.annee;
    }
    public void augmentationDuSalaire() {
        int anc = anciennete();
        if (anc < 5){
            this.salaire *= 1.02;
            } 
        else if (anc < 10) {
            this.salaire *= 1.05;
            } 
        else {
            this.salaire *= 1.10;
        } 
    }
    public void afficherEmploye() {
        System.out.println("- Matricule : " + matricule);
        System.out.println("- Nom complet : " + nom+ " " + prenom);
        System.out.println("- Age : " + age() + " ans");
        System.out.println("- Ancienneté : " + anciennete() + " ans");
        System.out.println("- Salaire : " + salaire + " DH"); 
    }
}

public class exo3TP2 {
    public static void main(String[] args) {
        MaDate dateN = new MaDate(26, 7, 2005);
        MaDate dateE = new MaDate(30, 3, 2015);
        Employe e= new Employe("001", "Ahriz", "Amira", dateN, dateE, 6000);
        e.augmentationDuSalaire();
        e.afficherEmploye();
    } 
} 