package Entities.tg;
import java.util.List;

public class Etudiant {
	
	private  int idetudiant,pswd;
	private String nom,prenom,departement;
	private List<Ue> ue;
	
	public Etudiant() {
		
	}
	
	public int getIdetudiant() {
		return idetudiant;
	}
	public void setIdetudiant(int idetudiant) {
		this.idetudiant = idetudiant;
	}

	public int getPswd() {
		return pswd;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public void setPswd(int pswd) {
		this.pswd = pswd;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public boolean seconnecter() {
		return true;
	}
		
	public void reclamer() {

	}
	public void consulter() {

	}
	public void listetudiant() {
		
	}
	
	public List<Ue> getUe() {
		return ue;
	}
	public void setUe(List<Ue> ue) {
		this.ue = ue;
	}

}
