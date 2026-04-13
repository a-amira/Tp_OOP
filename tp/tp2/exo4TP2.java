import java.util.Scanner;
class Article {
    private String reference;
    private String designation;
    private double prixHT;
    private static double tauxTVA = 10; 

    public Article() {
    }
    public Article(String reference, String designation, double prixHT) {
        this.reference = reference;
        this.designation = designation;
        this.prixHT = prixHT;
    }
    public Article(String reference, String designation) {
        this.reference = reference;
        this.designation = designation;
    }
    public Article(Article autre) {
        this.reference = autre.reference;
        this.designation = autre.designation;
        this.prixHT = autre.prixHT;
    }
    public String getReference() {
         return reference; 
         }
    public void setReference(String reference) { 
        this.reference = reference; 
        }
    public String getDesignation() { 
        return designation; 
        }
    public void setDesignation(String designation) { 
        this.designation = designation;
         }
    public double getPrixHT() {
         return prixHT;
          }
    public void setPrixHT(double prixHT) {
         this.prixHT = prixHT;
          }
    public static double getTauxTVA() { 
        return tauxTVA; 
        }
    public static void setTauxTVA(double tauxTVA) { 
        tauxTVA = tauxTVA; 
        }
    public double calculerPrixTTC() {
        return prixHT + (prixHT * tauxTVA / 100);
    }
    public void afficherArticle() {
        System.out.println("Référence   : " + reference);
        System.out.println("Désignation : " + designation);
        System.out.println("Prix HT     : " + prixHT + " DH");
        System.out.println("Taux TVA    : " + tauxTVA + "%");
        System.out.println("Prix TTC    : " + calculerPrixTTC() + " DH");
    }
}

public class exo4TP2 {
    public static void main(String[] args) {
        Article art1 = new Article();
        art1.setReference("001");
        art1.setDesignation("Clavier");
        art1.setPrixHT(152.5);
        Article art2 = new Article("002", "Souris", 80);
        Article art3 = new Article("003", "Écran");
        art3.setPrixHT(1295);
        System.out.println("Articles avec TVA à % 10");
        art1.afficherArticle();
        art2.afficherArticle();
        art3.afficherArticle();
    }
}