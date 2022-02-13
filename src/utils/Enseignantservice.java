package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entities.tg.Enseignant;
import Entities.tg.Etudiant;
import Entities.tg.Ue;



public class Enseignantservice {
	
	public boolean seconnecter(Enseignant en) {
		
		Basedonnee con= new Basedonnee("jdbc:mysql://localhost:3306/reclamation","root", "","com.mysql.jdbc.Driver");
		Connection connection = con.connectToDB();
		if (connection!=null) {
			try {
				Statement st = connection.createStatement();
				String req="SELECT * FROM enseignant WHERE idenseignant="+en.getIdenseignant()+" AND pswd="+en.getPswd()+"";
				ResultSet resultat;
				resultat=st.executeQuery(req);

				if(resultat.next() ) {
					System.out.println("Bienvenue "+resultat.getString("nom")+"  "+resultat.getString("prenom")+" sur votre compte");
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
	
	public void notifier(Enseignant en) {
		Basedonnee con= new Basedonnee("jdbc:mysql://localhost:3306/reclamation","root", "","com.mysql.jdbc.Driver");
		Connection connection = con.connectToDB();
		if (connection!=null) {
			try {
				Statement st = connection.createStatement();
				ResultSet resultat;
				resultat=st.executeQuery("SELECT * FROM `reclamer` WHERE idenseignant='"+en.getIdenseignant()+"'");
				
				if(resultat.next()) {
					System.out.println("vous avez une ou des reclamation (s)");
					while(resultat.next()) {
						System.out.println("voici les reclamation:\n "
								+ "id des etudiants: \t note obtenues :\t date de la reclamation :\n"
								+ " \t "+resultat.getInt("idetudiant")+" \t \t "+resultat.getFloat("note")+" \t \t "+resultat.getString("date")+"");
					}
					
				}else {
					System.out.println("pas de reclamation");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
		
	}
	
	public void enregistrenote(Etudiant et,Ue ue,Enseignant en ) {
		Basedonnee con= new Basedonnee("jdbc:mysql://localhost:3306/reclamation","root", "","com.mysql.jdbc.Driver");
		Connection connection = con.connectToDB();
		if (connection!=null) {
			try {
				Statement st = connection.createStatement();
				ResultSet resultat;
				resultat=st.executeQuery("SELECT * from ue where idetudiant='"+et.getIdetudiant()+"' AND idenseignant='"+en.getIdenseignant()+"'");
				
				
				if(resultat.next()) {
					System.out.println(" etudiant avec le id:"+ resultat.getInt("idetudiant")+" car vous avez deja donné note :"+resultat.getString("note")+"");
				}else {
					resultat=st.executeQuery("SELECT * from etudiant where idetudiant='"+et.getIdetudiant()+"'");
					List<Etudiant> etudiant = new ArrayList<>();
					etudiant.add(et);
					
					if(!etudiant.isEmpty() && resultat.next()) {
						st.executeUpdate("INSERT  INTO ue (note,idenseignant,idetudiant,departement) "
								+ " VALUES ('"+ue.getNote()+"','"+en.getIdenseignant()+"','"+et.getIdetudiant()+"','"+en.getDepartement()+"')");
						System.out.println(" ***********\tenregistrement  de la note terminé avec une note:"+ue.getNote()+"\t ********");
					}else {
					System.out.println("--------impossible de faire cette operation \n etudiant ayant le id "+et.getIdetudiant()+" n'existe pas-------");
					}
					
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
		public void modifier(Etudiant et, Enseignant en,Ue ue){
			Basedonnee con= new Basedonnee("jdbc:mysql://localhost:3306/reclamation","root", "","com.mysql.jdbc.Driver");
			Connection connection = con.connectToDB();
			if (connection!=null) {
				try {
					Statement st = connection.createStatement();
					ResultSet resultat;
					resultat=st.executeQuery("SELECT * FROM ue  Where idetudiant='"+et.getIdetudiant()+"' AND idenseignant='"+en.getIdenseignant()+"'");
					List<Etudiant> etudiant = new ArrayList<>();
					
					if(resultat.next()) {
						System.out.println("  idetudiant  avec le id:"+ resultat.getInt("idetudiant")+" a une note de :"+resultat.getInt("note"));
						etudiant.add(et);
						String query= ("UPDATE ue  set note ='"+ue.getNote()+"' where note='"+ resultat.getInt("note")+"'");
						st.executeUpdate(query);
						System.out.println("*********\t Desormais etudiant  avec le id:" +et.getIdetudiant()+" a  une note de"+ue.getNote()+"\t *********\n");
					}
					else {
						System.out.println(" impossible de faire cette operation \n le compte avec le id "+et.getIdetudiant()+" n'a pas de note veiller enregistrer un note ");
					}				
						
				} catch (Exception e) {
					e.printStackTrace();
				
				}
			}
		}
}
