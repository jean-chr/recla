package Entities.tg;

import java.util.List;

public class Enseignant {
	private String nom,prenom,email,departement;
	private int idenseignant,pswd;

	private List<Etudiant> etudiant;
	
 public Enseignant() {
	// TODO Auto-generated constructor stub
}
	public int getIdenseignant() {
		return idenseignant;
	}
	public void setIdenseignant(int idenseignant) {
		this.idenseignant = idenseignant;
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
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public int getPswd() {
		return pswd;
	}
	public void setPswd(int pswd) {
		this.pswd = pswd;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public List<Etudiant> getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(List<Etudiant> etudiant) {
		this.etudiant = etudiant;
	}
	public boolean seconnecter() {
		return true;
	}
	
	public void enregistrenote() {

	}
	public void modifier() {

	}
	

	public void notifier() {

	}

	public void consulter() {
			
	}
	public void setUe() {
		
	}
	

}
