package ex1TD;

public class Personne {
	
	private String nom ;
	private String prenom ;
	private String sex ; 
	private int dateNaissance ;
	private String statue ; 
	private Personne conjoint ;
	
	public Personne( String nom, String prenom , String sex ,int  dateNaissance, String statue) {
		this.nom = nom ; 
		this.prenom = prenom ; 
		this.dateNaissance = dateNaissance ; 
		this.sex = sex ;
		this.statue = statue ; 
		
	}
	
	public String toString() {
		
		if (this.statue == "encouple" && this.sex =="f") {
			String prefix =  "Mme ";
			String pronom  = " ,elle est  " ;
			return prefix + prenom + " " + nom + " est ne en " + dateNaissance + pronom + statue +"." ;
			
		}
		else {
			String prefix =  this.sex == "m"? "M. " : "Mlle. " ; 
			String pronom =  this.sex == "m"? " ,il est. " : " ,elle est  " ;
			return prefix + prenom + " " + nom + " est ne en " + dateNaissance + pronom + statue +"." ;
		}
	}
	
	public void marier(Personne p) {
		if (this.sex == p.sex) {
			System.out.println("we don't do that here  !!!");
		}
		else {
			this.conjoint = p ; 
			if(this.sex == "f") {
				this.nom = p.nom + " nee "  + this.nom ;
			}
			else {
				p.nom = this.nom + " nee "  + p.nom ;
			}
			this.statue = "encouple" ;
			p.statue = "encouple" ;
			System.out.println("Congratulations   !!!");
 		}
		 
	}
	
	public int age(int annee) {
		if (annee > this.dateNaissance) {
			return annee - dateNaissance ; 
		}
		else System.out.println("annee entree invalide !!");
		return 0;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Personne A , B , C ;
		A = new Personne("Ajaanit" , "Taoufik" , "m" , 1997 , "celibataire") ; 
		B = new Personne("ouahi" , "salim" , "m" , 1990 , "encouple") ; 
		C = new Personne("hilal" , "rajae" , "f" , 1999 , "celibataire") ; 
		System.out.println(C.toString());
		System.out.print(C.age(2018)+"\n");
		C.marier(C);
		System.out.println(C.toString());
		

	}

}
