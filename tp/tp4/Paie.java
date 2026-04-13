import java.util.*;

abstract class Employe {
    private final String matricule; 
    private String nom;
    private String adresse;
    protected double salaire;

    public Employe(String matricule, String nom, String adresse) {
        this.matricule = matricule;
        this.nom = nom;
        this.adresse = adresse;
    }

    public Employe(String matricule, String nom, String adresse, double salaire) {
        this(matricule, nom, adresse);
        this.salaire = salaire;
    }

    public String getMatricule() { return matricule; }
    public String getNom() { return nom; }
    public String getAdresse() { return adresse; }
    public double getSalaire() { return salaire; }
    
    public abstract void setSalaire();

    public void afficherSalaire() {
        System.out.println("Employé: " + nom + " " + matricule + "- Salaire Hebdo: " + salaire + " dh");
    }
}

class EmployeHeure extends Employe {
    private double tauxHoraire;
    private int nbHeures;

    public EmployeHeure(String mat, String nom, String adr) { super(mat, nom, adr); }

    public EmployeHeure(String mat, String nom, String adr, double taux, int h) {
        super(mat, nom, adr);
        this.tauxHoraire = taux;
        this.nbHeures = h;
        setSalaire(); 
    }

    @Override
    public void setSalaire() {
        this.salaire = tauxHoraire * nbHeures;
    }

    public void setInfosSalaire(double taux, int h) {
        this.tauxHoraire = taux;
        this.nbHeures = h;
        setSalaire();
    }
}

class EmployeForfait extends Employe {
    private double forfaitJour;
    private int joursTravailles;

    public EmployeForfait(String mat, String nom, String adr) { super(mat, nom, adr); }

    public EmployeForfait(String mat, String nom, String adr, double forfait, int jours) {
        super(mat, nom, adr);
        this.forfaitJour = forfait;
        this.joursTravailles = jours;
        setSalaire();
    }

    @Override
    public void setSalaire() {
        this.salaire = forfaitJour * joursTravailles;
    }

    public void setInfosSalaire(double forfait, int jours) {
        this.forfaitJour = forfait;
        this.joursTravailles = jours;
        setSalaire();
    }
}

class Commercial extends Employe {
    public Commercial(String mat, String nom, String adr) { super(mat, nom, adr); }

    public Commercial(String mat, String nom, String adr, double fixe) {
        super(mat, nom, adr, fixe);
    }

    @Override
    public void setSalaire() {
    
    }
}

public class Paie {
    public static void main(String[] args) {
        Employe[] employes = new Employe[7];

        employes[0] = new Commercial("001", "Ouardek", "Safi", 3000);
        employes[1] = new Commercial("002", "Hadi", "Safi", 3200);
        Commercial c3 = new Commercial("003", "Ahriz", "Safi");
        c3.salaire = 3500; 
        employes[2] = c3;
        employes[3] = new EmployeHeure("008", "Aboulanouar", "Casablanca", 50, 40);
        EmployeHeure h2 = new EmployeHeure("005", "Sadr", "Rabat");
        h2.setInfosSalaire(60, 35); /
        employes[4] = h2;
        employes[5] = new EmployeForfait("101", "Fax", "Marrakech", 400, 5);
        employes[6] = new EmployeForfait("102", "Hajji", "Agadir", 500, 4);
        double masseSalariale = 0;
        System.out.println("États des salaires hebdomadaires");
        for (Employe e : employes) {
            if (e != null) {
                e.afficherSalaire();
                masseSalariale += e.getSalaire();
            }
        }
        System.out.println("Masse salaire totale: " + masseSalariale + " dh");
    }
}