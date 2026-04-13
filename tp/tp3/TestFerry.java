import java.util.*;

class Colis {
    private float poids;
    public Colis(float p) { this.poids = p; }
    public float getPoids() { return poids; }
}

abstract class Personne {
    protected String nom, prenom;
    protected int age;
    protected String dateNaissance;
    protected String adresse;
    public abstract void voyager();
}

class Voyageur extends Personne {
    protected Date dateVoyage;
    @Override
    public void voyager() {
        System.out.println(nom + " est en train de voyager.");
    }
}

class Conducteur extends Voyageur {
    private String numPermis;
    public boolean obtenirPermis(String nouveauNuméro) {
        if (this.age >= 18) {
            this.numPermis = nouveauNuméro; 
            System.out.println("Permis accordé : " + numPermis);
            return true;
        } else {
            System.out.println("Refus : Le conducteur n'a que " + this.age + " ans.");
            return false;
        }
    }
}


class Vehicule {
    
    protected String modele;
    protected String immatriculation;
    protected float kilometrage;
    protected float poidsAVide;
    protected float longueur;
    protected float reserveCarburant;
    protected Conducteur conducteur; 

    public Vehicule(String modele, String immat, float longueur, float poids) {
        this.modele = modele;
        this.immatriculation = immat;
        this.longueur = longueur;
        this.poidsAVide = poids;
        this.kilometrage = 0;
        this.reserveCarburant = 0;
        this.conducteur = null;//personne n'est au volant.
    }

    public void changeConducteur(Conducteur nouveauConducteur) {
        this.conducteur = nouveauConducteur;
    }

    public String toString() {
        String info = "Modèle: " + modele + " | Immat: " + immatriculation;
        if (conducteur == null) {
            info =info+ " | Conducteur: Aucun";
        } else {
            info=info+ " | Conducteur: " + conducteur.nom;
        }
        return info;
    }

    public float getPoids() {
        float poidsConducteur;
        if (conducteur == null) {
            poidsConducteur = 0; 
        }else{
            poidsConducteur = 75;
        } 
        return poidsAVide + reserveCarburant + poidsConducteur;
    }
    public float allerAlaPompe(float quantite) {
        this.reserveCarburant += quantite;
        return this.reserveCarburant;
    }

    public void rouler(float distance, float tauxConsommation) throws Exception {
        if (conducteur == null) {
            throw new Exception("Erreur : Le véhicule n'a pas de conducteur !");
        }
        float carbNecessaire = distance * tauxConsommation;
        if (reserveCarburant < carbNecessaire) {
            throw new Exception("Erreur : Carburant insuffisant pour ce trajet !");
        }
        this.reserveCarburant -= carbNecessaire;
        this.kilometrage += distance;
        System.out.println("Le véhicule a roulé " + distance + " km.");
    }
}

class Camion extends Vehicule {
    private ArrayList<Colis> cargaison;

    public Camion(String modele, String immat, float longueur, float poids) {
        super(modele, immat, longueur, poids);
        this.cargaison = new ArrayList<Colis>();
    }

    public int ajouter(Colis c) {
        this.cargaison.add(c);
        return this.cargaison.size();
    }

    public boolean retirer(Colis c) {
        return this.cargaison.remove(c);
    }

    public float PoidCamion() {
        float poidsCargaison = 0;
        for (Colis c : cargaison) {
            poidsCargaison += c.getPoids();
        }
        return getPoids() + poidsCargaison; 
    }

    @Override
    public String toString() {
        return super.toString() + " | Colis à bord : " + cargaison.size();
    }
}

class Voiture extends Vehicule {
    private int maxPassagers;
    private ArrayList<Voyageur> passagers;

    public Voiture(String modele, String immat, float longueur, float poids, int max) {
        super(modele, immat, longueur, poids);
        this.maxPassagers = max;
        this.passagers = new ArrayList<Voyageur>();
    }

    public ArrayList<Voyageur> getPassagers() {
        return this.passagers; 
    }

    public int monter(Voyageur p) throws Exception {
        if (passagers.size() >= maxPassagers) {
            throw new Exception("La voiture est pleine !");
        }
        passagers.add(p);
        return passagers.size();
    }

    public boolean descendre(Voyageur p) {
        return passagers.remove(p);
    }

    public float PoidVoiture() {
        float poidsPassagers = 0;
        for (Voyageur v : passagers) {
            poidsPassagers += 75; 
        }
        return getPoids() + poidsPassagers;
    }
    @Override
    public String toString() {
        String s = super.toString();
        s = s + " | Passagers: " + passagers.size() + "/" + maxPassagers;
        return s;
    }
}

class CarFerry extends Vehicule {
    private Stack<Vehicule> pileGauche = new Stack<>();
    private Stack<Vehicule> pileDroite = new Stack<>();
    private float longueurMax;
    private float chargeMax;

    public CarFerry(String modele, String immat, float longueur, float poids, float longMax, float chMax) {
        super(modele, immat, longueur, poids);
        this.longueurMax = longMax;
        this.chargeMax = chMax;
    }

    private float calculerPoidsPile(Stack<Vehicule> pile) {
        float p = 0;
        for (Vehicule v : pile) p += v.getPoids();
        return p;
    }

    public float PoidsCarFerry() {
        return getPoids() + calculerPoidsPile(pileGauche) + calculerPoidsPile(pileDroite);
    }

    public void embarquer(Vehicule v) throws Exception {
        if (PoidsCarFerry() + v.getPoids() > chargeMax) {
            throw new Exception("Trop lourd pour le ferry");
        }
        if (calculerPoidsPile(pileGauche) <= calculerPoidsPile(pileDroite)) {
            pileGauche.push(v);
        } else {
            pileDroite.push(v);
        }
    }
    public boolean Debarquer(Vehicule v) {
        if (pileGauche.contains(v)) {
            pileGauche.remove(v); 
            System.out.println(v.modele + " a quitté la pile Gauche.");
            return true;
        } 
        if (pileDroite.contains(v)) {
            pileDroite.remove(v);
            System.out.println(v.modele + " a quitté la pile Droite.");
            return true;
        }
        System.out.println("Erreur : Le véhicule n'est pas sur le ferry.");
        return false;
    }
    public float PropVoiture() {
        int totalVehicules = pileGauche.size() + pileDroite.size();
        if (totalVehicules == 0) return 0.0f;

        int nbVoitures = 0;
        for (Vehicule v : pileGauche) {
            if (v instanceof Voiture) nbVoitures++;
        }
        for (Vehicule v : pileDroite) {
            if (v instanceof Voiture) nbVoitures++;
        }

    return (float) nbVoitures / totalVehicules;
    }
    public void Chercher(Voyageur p) {
        List<Stack<Vehicule>> lesPiles = Arrays.asList(pileGauche, pileDroite);
        for (Stack<Vehicule> pile : lesPiles) {
            for (Vehicule v : pile) {
                if (v.conducteur == p) {
                    System.out.println(p.nom + " est conducteur de " + v.modele);
                    return; 
             }
                if (v instanceof Voiture && ((Voiture) v).getPassagers().contains(p)) {
                    System.out.println(p.nom + " est passager de " + v.modele);
                    return;
                }
            }
        }
    System.out.println("Personne non localisée sur le ferry.");
    }
}

public class TestFerry {
    public static void main(String[] args) {
        System.out.println("Système Ferry initialisé.");
    }
}