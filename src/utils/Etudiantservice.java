package utils;
import java.sql.*;
import java.util.Date;

import Entities.tg.Enseignant;
import Entities.tg.Etudiant;
import Entities.tg.Ue;

public class Etudiantservice {


	public boolean seconnecter( Etudiant et) {
	
			Basedonnee con= new Basedonnee("jdbc:mysql://localhost:3306/reclamation","root", "","com.mysql.jdbc.Driver");
			Connection connection = con.connectToDB();
			
			if (connection!=null) {
				try {
					Statement st = connection.createStatement();
					ResultSet resultat;
					resultat=st.executeQuery("SELECT * FROM `etudiant` WHERE idetudiant='"+et.getIdetudiant()+"' AND pswd='"+et.getPswd()+"'");
					
					if(resultat.next()) {
						System.out.println("vous etes connecté \r bienvenue "+resultat.getString("nom")+"  "+resultat.getString("prenom")+" sur votre compte");
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
	
	public boolean consulter( Etudiant  et) {

		Basedonnee con= new Basedonnee("jdbc:mysql://localhost:3306/reclamation","root", "","com.mysql.jdbc.Driver");
		Connection connection = con.connectToDB();
		if (connection!=null) {
			
			try {
				Statement st = connection.createStatement();
				ResultSet resultat;
				resultat=st.executeQuery("SELECT * FROM ue WHERE idetudiant='"+et.getIdetudiant()+"'");
				
					System.out.println("| \t id Ue: \t | \t nom UE: \t | \t  note: \t |\r");	
					while (resultat.next()) {
						System.out.println(" \t "+resultat.getInt("idue")+"\t  \t "+resultat.getString("departement")+"\t \t  \t "+resultat.getInt("note")+"\t \r");		
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return false;		
	}
	
	public boolean reclamer( Etudiant  et, Ue ue, Enseignant en) {
		
		Basedonnee con= new Basedonnee("jdbc:mysql://localhost:3306/reclamation","root", "","com.mysql.jdbc.Driver");
		Connection connection = con.connectToDB();
		if (connection!=null) {
			try {
				Statement st = connection.createStatement();

				ResultSet resultat;
				resultat=st.executeQuery("SELECT * FROM ue WHERE idetudiant='"+et.getIdetudiant()+"' AND idue='"+ue.getIdeu()+"'");				
				if (resultat.next()) {				
					String req="INSERT INTO `reclamer`( idue,idenseignant,note,idetudiant,date) "
							+ "VALUES ('"+ue.getIdeu()+"','"+resultat.getInt("idenseignant")+"','"+resultat.getFloat("note")+"','"+et.getIdetudiant()+"','"+new Date()+"')";
					st.executeUpdate(req);
					System.out.println("***********\treclamation envoyer \t*************");
				} else {
					System.out.println("------reclamation refusé la note identifier par "+ue.getIdeu()+" n'existe pas-------");
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;		
	
	}
	
			
}
