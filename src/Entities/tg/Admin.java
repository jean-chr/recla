package Entities.tg;

public class Admin {
	private String nom,prenom,contact;
	private int idadmin,pswd;
	
	public Admin() {
		
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
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getIdadmin() {
		return idadmin;
	}
	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}
	public int getPswd() {
		return pswd;
	}
	public void setPswd(int pswd) {
		this.pswd = pswd;
	}
	public void seconnecter() {}
	public void consulter() {}
	public void compteudiant() {}
	public void comptenseignant() {}
}
