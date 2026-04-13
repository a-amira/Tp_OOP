public class Personne{
    private String nom;
    private String prenom;
    private String mail;
    public Personne(String nom, String prenom, String mail){
        this.nom=nom;
        this.prenom=prenom;
        this.mail=mail;
    }
    public String getnom(){return nom;}
    public String getprenom(){return prenom;}
    public String getmail(){return mail;}
    public void setnom(String nom){ this.nom=nom; }
    public void setprenom(String prenom){ this.prenom=prenom; }
    public void setmail(String mail){ this.mail=mail; }
    @Override
    public String toString() {
        return String.format("Nom: %s, Prénom: %s, Email: %s", nom, prenom, mail);
    }
    
}