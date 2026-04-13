public class Points3{
    private char Nom;
    private double abs;

    public Points3(char Nom, double abs){
        this.Nom=Nom;
        this.abs=abs;
    }
    public void afficher(){
        System.out.println("Nom du point"+Nom+"et d'abscisse"+abs);
    }
    public void translate( double a){
        abs+=a;
    }
}