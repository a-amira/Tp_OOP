class Livre{
    private String titre;
    private String auteur;
    private int page;
    private double prix;
    private boolean prixFixe;

    public Livre(String titre, String auteur, int page){
        this.titre=titre;
        this.auteur=auteur;
        this.page=page;
        this.prix=-1;
        this.prixFixe=false;
    }

    public Livre(String titre, String auteur, int page,double prix){
        this.titre=titre;
        this.auteur=auteur;
        this.page=page;
        this.prix=prix;
        this.prixFixe=true;
    }

    public String gettitre(){
        return titre;
    }
    public void settitre(String titre){ 
        this.titre=titre; 
    }
    public String getauteur(){
        return auteur;
    }
    public void setauteur(String auteur){ 
        this.auteur=auteur; 
    }
    public int getpage(){
        return page;
    }
    public void setpage(int page) { 
        this.page=page;
    }
    public double getprix(){
        return prix;
    }
    public void setprix(double prix){
        if (prixFixe){
            System.out.println("prix fixé")
        }
        else{
            this.prix=prix;
            prixFixe=true;
        }
    }

    public String toString() {
        if (prix == -1) {
            return  "Livre:"+ titre + "d'auteur" + auteur + "son nombre de page est:"
                    + page + "coute"+ "Prix pas encore donné";
        } else {
            return "Livre:"+ titre + "d'auteur" + auteur + "son nombre de page est:"
                    + page + "coute" + prix;
        }
    }

    public boolean PrixestFixe() {
        return this.prixFixe;
    }

    public int compare(Livre l) {
        if (this.page == l.page)
            return 0;
        if (this.page > l.page)
            return 1;
        return -1;
    }
}
class Etagere {
    private Livre[] livres;
    private int nbLivres; 

    public Etagere(int capacite) {
    this.livres=new Livre[capacite];
    this.nbLivres=0;
    }

    public int getCapacite() { 
        return livres.length; 
    }
    public int getNbLivres() { 
        return nbLivres; 
    }

    public void ajouter(Livre l) {
        if (nbLivres==livres.length) {
            System.out.println("L'étagère est pleine.");
        } else {
            livres[nbLivres]=l;
            nbLivres++;
        }
    }

    public Livre getLivre(int pos) {
        int i=pos-1;
        if (i>=0 && i<nbLivres) {
            return livres[i];
        }
    return null;
    }

    public int chercher(String titre, String auteur) {
        for (int i = 0; i < nbLivres; i++) {
            if (livres[i].gettitre().equals(titre) && livres[i].getauteur().equals(auteur)) {
                return i + 1; 
            }
        }
        return 0; 
    }

    public void supprimer(int position) {
        int j = position - 1;
        if (j >= 0 && j < nbLivres) { 
            for (int i = j; i < nbLivres - 1; i++) {
                livres[i] = livres[i + 1];
            }
            livres[nbLivres - 1] = null;
            nbLivres--;
            System.out.println("Livre supprimé avec succès.");
        } 
    }
}
