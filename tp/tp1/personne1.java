public class personne1 {
    private String CIN;
    private String Nom;
    private String Prenom;
    private int age ;

    public void initialiser(String CIN, String Nom, String Prenom, int age){
        this.CIN = CIN;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.age = age;
    }
    public void afficher(){
        System.out.println("CIN = "+this.CIN+", Nom = "+this.Nom+", Prenom = "+this.Prenom+", Age= "+this.age+);
    }   
}
