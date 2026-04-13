class Complexe {
    private double reelle;
    private double imaginaire;
    public Complexe() {
        this.reelle = 0;
        this.imaginaire = 0;
    }
    public Complexe(double reelle, double imaginaire) {
        this.reelle = reelle;
        this.imaginaire = imaginaire;
    }
    public double getReelle() { 
        return reelle; }
    public void setReelle(double reelle) { 
        this.reelle = reelle; }

    public double getImaginaire() { 
        return imaginaire; }
    public void setImaginaire(double imaginaire) { 
        this.imaginaire = imaginaire; }

    public Complexe Plus(Complexe l) {
        double partie_reelle = this.reelle + l.reelle;
        double partie_imaginaire = this.imaginaire + l.imaginaire;
        return new Complexe(partie_reelle, partie_imaginaire);
    }

    public Complexe Moins(Complexe l) {
        double partie_reelle = this.reelle - l.reelle;
        double partie_imaginaire = this.imaginaire - l.imaginaire;
        return new Complexe(partie_reelle, partie_imaginaire);
    }

    public void afficher() {
        if (imaginaire >= 0) {
            System.out.println(reelle + " + " + imaginaire + " * i");
        } else {
            System.out.println(reelle + " - " + Math.abs(imaginaire) + " * i");
        }
    }
}

public class exo2TP2 {
    public static void main(String[] args) {
        Complexe a = new Complexe(5, 3);   
        Complexe b = new Complexe(2, 4);   
        System.out.print("a = ");
        a.afficher();
        System.out.print("b = ");
        b.afficher();
        Complexe somme = a.Plus(b);
        System.out.print("a + b = ");
        somme.afficher();
        Complexe difference = a.Moins(b);
        System.out.print("a - b = ");
        difference.afficher();
    }
}