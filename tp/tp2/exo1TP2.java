public class Rectangle {
    private double longueur;
    private double largeur;

    public Rectangle(double longueur, double largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public double getLongueur() {
        return longueur;
    }
    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }
    public double getLargeur() {
        return largeur;
    }
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double perimetre() {
        return 2 * (longueur + largeur);
    }
    public double aire() {
        return longueur * largeur;
    }

    public boolean estCarre() {
        return longueur == largeur;
    }

    public void afficherRectangle() {
    System.out.print("Longueur : [" + longueur + "] - ");
    System.out.print("Largeur : [" + largeur + "] - ");
    System.out.print("Périmètre : [" + perimetre() + "] - ");
    System.out.print("Aire : [" + aire() + "] - ");
    if (estCarre()) {
        System.out.println("Il s’agit d’un carré");
    } else {
        System.out.println("Il ne s’agit pas d’un carré");
    }
}
}