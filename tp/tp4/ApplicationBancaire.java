import java.util.*;

class Agence {
    private static int nb = 0;
    private String id, adresse;

    public Agence(String adr) {
        nb++;
        this.id = this.getClass().getName() + ":" + nb;
        this.adresse = adr;
    }
    public String toString() { return id + " ,Adresse:" + adresse; }
}

class Client {
    private static int nb = 0;
    private String id, nom, prenom;
    private ArrayList<Compte> comptes = new ArrayList<>();

    public Client(String n, String p, Agence ag) {
        nb++;
        this.id = this.getClass().getName() + ":" + nb;
        this.nom = n; this.prenom = p;
    }

    public void ajouterCompte(Compte c) { comptes.add(c); }
    public ArrayList<Compte> getComptes() { return comptes; }

    public double getSoldeTotal() {
        double total = 0;
        for (Compte c : comptes) total += c.getSolde();
        return total;
    }

    public String toString() {
        return id + " ; " + nom + " " + prenom + " ; Total: " + getSoldeTotal() + "dh";
    }
}

abstract class Compte {
    private static int nb = 0;
    protected String id;
    protected double solde;

    public Compte(double s, Client p) {
        nb++;
        this.id = this.getClass().getName() + ":" + nb;
        this.solde = s;
        p.ajouterCompte(this);  
    }

    public double getSolde() { return solde; }
    public void deposer(double m) { solde += m; }
    public void retirer(double m) { solde -= m; }
    public String toString() { return id + " ; Solde: " + solde + "dh"; }
}

class CompteEpargne extends Compte {
    public CompteEpargne(double s, Client p) { super(s, p); }
    public void calculInteret() { solde += solde * 0.06; }
}

class ComptePayant extends Compte {
    public ComptePayant(double s, Client p) { super(s, p); }
    public void deposer(double m) { super.deposer(m - 5); }
    public void retirer(double m) { super.retirer(m + 5); }
}

public class ApplicationBancaire {
    private ArrayList<Client> liste = new ArrayList<>();

    public void addClient(Client c) { liste.add(c); }

    public static void main(String[] args) {
        ApplicationBancaire app = new ApplicationBancaire();
        Agence ag = new Agence("Safi Ensa");

        Client c1 = new Client("Hadi", "Sabrine", ag);
        new CompteEpargne(1000, c1);

        Client c2 = new Client("Ahriz", "Amira", ag);
        new ComptePayant(2500, c2);

        Client c3 = new Client("Ouardek", "Hafsa", ag);
        new ComptePayant(0, c3); new ComptePayant(3000, c3);

        Client c4 = new Client("Aboulanouar", "Imane", ag);
        new CompteEpargne(2300, c4); new ComptePayant(0, c4);

        app.addClient(c1); app.addClient(c2); app.addClient(c3); app.addClient(c4);

        for (Client c : app.liste) {
            for (Compte cp : c.getComptes()) {
                if (cp instanceof CompteEpargne) ((CompteEpargne) cp).calculInteret();
            }
        }

        app.liste.sort((a, b) -> Double.compare(b.getSoldeTotal(), a.getSoldeTotal()));

        System.out.println("Liste des comptes des clients :");
        for (Client c : app.liste) {
            System.out.println(c);
            for (Compte cp : c.getComptes()) System.out.println("   " + cp);
        }
        System.out.println("Liste des comptes payants de l'agence");
        for (Client c : app.liste) {
            for (Compte cp : c.getComptes()) {
                if (cp instanceof ComptePayant) System.out.println(cp);
            }
        }
        System.out.println("Liste des comptes d'épargne de l'agence :");
        for (Client c : app.liste) {
            for (Compte cp : c.getComptes()) {
                if (cp instanceof CompteEpargne) System.out.println(cp);
            }
        }
    }
}