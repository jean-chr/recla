package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Entities.tg.Admin;
import Entities.tg.Enseignant;
import Entities.tg.Etudiant;

public class Adminservice {

	public Adminservice() {
		super();
	}
	
	public Boolean seconnecter(Admin ad) {
		Basedonnee connecteur = new Basedonnee("jdbc:mysql://localhost:3306/reclamation","root", "","com.mysql.jdbc.Driver");
		Connection connection=connecteur.connectToDB();
		
		if (connection!=null) {
			try {		
				Statement st = connection.createStatement();
				String req="SELECT * FROM admin WHERE idadmin="+ad.getIdadmin()+" AND pswd="+ad.getPswd()+"";
				ResultSet result;
				result= st.executeQuery(req);
				
				if(result.next()) {
					System.out.println("Bienvenue "+result.getString("nom")+"  "+result.getString("prenom")+" sur votre compte "+result.getString("email"));
				return true;
				}else {
					System.out.println(" donnees  incorrectes");
					return false;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	return false;
	}
	public Boolean listetudiant() {
		Basedonnee connecteur = new Basedonnee("jdbc:mysql://localhost:3306/reclamation","root", "","com.mysql.jdbc.Driver");
		Connection connection=connecteur.connectToDB();
		
		if (connection!=null) {
			try {		
				Statement st = connection.createStatement();
				String req="SELECT * FROM etudiant";
				ResultSet result;
				result= st.executeQuery(req);
				System.out.println("voici la liste \n id: \t \t nom: \t \t prenom:");
				
					while (result.next()) {
						System.out.println(result.getString("idetudiant")+" \t "+result.getString("nom")+"  \t " +result.getString("prenom")+"  ");
					} 
					System.out.println("-------------fin----------------");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	return null;
	}
	
	public Boolean listenseignant() {
		Basedonnee connecteur = new Basedonnee("jdbc:mysql://localhost:3306/reclamation","root", "","com.mysql.jdbc.Driver");
		Connection connection=connecteur.connectToDB();
		
		if (connection!=null) {
			try {		
				Statement st = connection.createStatement();
				String req="SELECT * FROM enseignant";
				ResultSet result;
				result= st.executeQuery(req);
		
				System.out.println("voici la liste \n id: \t|\t\tnom: \t |\t prenom:");
				while (result.next()) {
					
					System.out.println(result.getString("idenseignant")+"  \t "+result.getString("nom")+"  \t " +result.getString("prenom"));
				
				} 
				System.out.println("-------------fin----------------");
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
			
	return null;
	}
	public Boolean comptetudiant(Etudiant et) {
		Basedonnee connecteur = new Basedonnee("jdbc:mysql://localhost:3306/reclamation","root", "","com.mysql.jdbc.Driver");
		Connection connection=connecteur.connectToDB();
		
		if (connection!=null) {
			try {		
				Statement st = connection.createStatement();
				String req="INSERT INTO `etudiant`( nom,prenom, departement,pswd) "
						+ "VALUES ('"+et.getNom()+"','"+et.getPrenom()+"','"+et.getDepartement()+"','"+et.getPswd()+"')";
				st.executeUpdate(req);			
				System.out.println("enregistrement de etudiant: "+et.getNom()+" bien reussit");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
			
	return null;
	}
	public Boolean comptenseignant(Enseignant en) {
		Basedonnee connecteur = new Basedonnee("jdbc:mysql://localhost:3306/reclamation","root", "","com.mysql.jdbc.Driver");
		Connection connection=connecteur.connectToDB();
		
		if (connection!=null) {
			try {		
				Statement st = connection.createStatement();
				st.executeUpdate("INSERT INTO enseignant ( nom, prenom, email,pswd, departement) VALUES ('"+en.getNom()+"','"+en.getPrenom()+"','"+en.getEmail()+"','"+en.getPswd()+"','"+en.getDepartement()+"')");
				System.out.println("enregistrement de: "+en.getNom()+" bien reussit");
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
			
	return null;
	}
}
