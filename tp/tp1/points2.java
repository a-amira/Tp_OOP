public class points2 {
    private char Nom;
    private double abs;

    public void initialiser(char Nom, double abs){
        this.Nom = Nom ;
        this.abs = abs;
    }
    public void initialiser(points p){
        this.Nom = p.Nom;
        this.abs = p.abs;
    }
    public void afficher(){
        System.out.println("Nom du point:"+Nom+" et d'abscisse"+abs);
    }
    public void translate(double a){
        abs+=a;
    }
}
