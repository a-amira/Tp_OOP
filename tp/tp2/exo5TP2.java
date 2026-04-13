import java.util.Scanner;

class Client {
    private String cin, nom, prenom, tel;
    public Client(String cin, String nom, String prenom, String tel) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }
    public Client(String cin, String nom, String prenom) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
    }
    public String getCin() { 
        return cin;
         }
    public void setCin(String cin) {
         this.cin = cin;
          }
    public String getNom() { 
        return nom; 
        }
    public void setNom(String nom) {
         this.nom = nom; 
         }
    public String getPrenom() {
         return prenom; 
         }
    public void setPrenom(String prenom) {
         this.prenom = prenom;
          }
    public String getTel() {
         return tel;
          }
    public void setTel(String tel) { 
        this.tel = tel;
         }

    public void afficher() {
        System.out.println("Client : " + nom + " " + prenom + " CIN: " + cin);
    }
}

class Compte {
    private final int code;
    private double solde;
    private Client proprietaire;
    private static int compteur = 0;

    public Compte(Client proprietaire) {
        compteur++;
        this.code = compteur;
        this.solde = 0;
        this.proprietaire = proprietaire;
    }

    public int getCode() {
         return code;
          }
    public double getSolde() {
         return solde; 
         }
    public Client getProprietaire() { 
        return proprietaire;
         }
    public void setProprietaire(Client proprietaire) {
         this.proprietaire = proprietaire; 
         }
    public void crediter(double somme) {
        if (somme > 0) {
            this.solde += somme;
        }
    }
    public void crediter(double somme, Compte source) {
        if (source.solde >= somme) {
            source.debiter(somme);
            this.crediter(somme);
        }
    }
    public void debiter(double somme) {
        if (this.solde >= somme) {
            this.solde -= somme;
        }
    }
    public void debiter(double somme, Compte destination) {
        if (this.solde >= somme) {
            this.debiter(somme);
            destination.crediter(somme);
        }
    }
    public void afficherResume() {
        System.out.println("Compte num" + code);
        proprietaire.afficher();
        System.out.println("Solde : " + solde + " DH");
    }
    public static void afficherNbComptes() {
        System.out.println("Nombre de comptes : " + compteur);
    }
}
public class exo5TP2 {
    public static void main(String[] args) {
        Client c1 = new Client("0003", "Hadi", "Sabrine", "0606060606");
        Client c2 = new Client("0004", "Ouardek", "Hafsa");

        Compte cp1 = new Compte(c1);
        Compte cp2 = new Compte(c2);

        cp1.crediter(5000);
        cp1.debiter(1000, cp2);

        cp1.afficherResume();
        cp2.afficherResume();
        Compte.afficherNbComptes();
    }
}