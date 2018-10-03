/**
 * 
 */
package exo2TD;

/**
 * @author taoufik
 *
 */
public class Compte {
	
	private static long  nbComptes = 0 ;
	private long numCompte ;
	private String titulaire ;
	private double solde ;
	private double decouverte  ;
	private double decouverteMax ;
	private double debitMax ;
	
	private static void incrimentnbComptes() {
		nbComptes ++ ;
	}
	
	
	  public static class Builder {
		    // Required parameters
		    private final String titulaire;
		    // Optional parameters - initialized to default values
		    private double solde = 0;
		    private double decouvertMax = 800;
		    private double debitMax = 1000;

		    public Builder(String titulaire) {
		      this.titulaire = titulaire;
		    }

		    public Builder solde(double val) {
		      solde = val;
		      return this;
		    }

		    public Builder decouverteMax(long val) {
		    	decouvertMax = val;
		      return this;
		    }

		    public Builder debitMax(long val) {
		      debitMax = val;
		      return this;
		    }

		    public Compte build() {
		      return new Compte(this);
		    }
	  }
	//end of builder class

	private Compte(Builder builder) {
		// TODO Auto-generated constructor stub
		numCompte = this.nbComptes +1 ;
		incrimentnbComptes() ;
		titulaire = builder.titulaire ;
		solde = builder.solde ;
		decouverte = solde < 0 ? Math.abs(solde) : 0 ;
		decouverteMax = builder.decouvertMax ;
		debitMax = builder.debitMax ;
	}
	
	
	
	
	public void crediter(long montant) {
		if (this.solde + montant > debitMax) {
			System.out.println("operation impossible vous depassez credit max !!");
		}
		else {
			this.solde += montant ;
			this.decouverte = this.solde < 0 ? Math.abs(solde) : 0 ;
			System.out.println("operation reussi votre nouveau solde est : "+ solde);
		}
		
	}
	
    public void debiter(long montant) {
    	if (this.solde - montant > decouverteMax) {
			this.solde -= montant ;
			this.decouverte = this.solde < 0 ? Math.abs(solde) : 0 ;
			
			System.out.println("operation reussi votre nouveau solde est : "+ solde);
		}
		else {
			System.out.println("operation impossible vous depasser la decouverte max ! ");
		}
	}
    
    
    public void virer(Compte dist, long montant) {
    	if (this.solde - montant > decouverteMax && dist.solde + montant < dist.debitMax ) {
    		this.solde -= montant ;
    		dist.solde += montant ;
    		dist.decouverte = dist.solde < 0 ? Math.abs(solde) : 0 ;
    		this.decouverte = this.solde < 0 ? Math.abs(solde) : 0 ;
    		System.out.println("Operation Reussie !!!");
    	}
    	else {
    		System.out.println("Operation Impossible !!!");
    	}
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Compte a = new Compte.Builder("taoufik").solde(-100).build() ;
		System.out.println(a.titulaire);
	}

}
