package Entities.tg;

import java.util.Date;


public class Ue {
	private int ideu,note;
	private String nomue;
	private Enseignant enseignant;
	private Etudiant etudiant;
	
	public Ue() {
		super();
	}
	private Date datemodifer;
	public int getIdeu() {
		return ideu;
	}
	public void setIdeu(int ideu) {
		this.ideu = ideu;
	}
	
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
	public Date getDatemodifer() {
		return datemodifer;
	}
	public void setDatemodifer(Date datemodifer) {
		this.datemodifer = datemodifer;
	}
	public String getNomue() {
		return nomue;
	}
	public void setNomue(String nomue) {
		this.nomue = nomue;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	

}
