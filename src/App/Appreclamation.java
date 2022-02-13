package App;

import java.util.Scanner;

import Entities.tg.Admin;
import Entities.tg.Enseignant;
import Entities.tg.Etudiant;
import Entities.tg.Ue;
import utils.Adminservice;
import utils.Enseignantservice;
import utils.Etudiantservice;

public class Appreclamation {

	public static void main(String[] args) {

		System.out.println("quel est votre statut? \r 1 : etudiant \r 2 : enseignnant \r 3 : administrateur \n");
		@SuppressWarnings("resource")
		Scanner scann = new Scanner(System.in);
		int valeur1 = scann.nextInt();
			
			switch (valeur1) {
	
				case 1:
					compteetudiant();
					break;
	
				case 2:
					compteenseignant();
					break;
				case 3:
					compteadmin();
					break;
				default:
					compteetudiant();
					break;
			}	
		
		System.out.println("merci pour voir services goodbye.................!!!!!!!!");

	}
/*---------------------------------
 * -----gestion de compte
 * -----adminitration------
 * ------------------------------
 * */
	@SuppressWarnings("resource")
	private static void compteadmin() {
		
		Adminservice service = new Adminservice();
		Admin ad=new Admin();
		Etudiant et = new Etudiant();
		Enseignant en = new Enseignant();
		
		System.out.println("connectez vous en saisissant correctement vos donnees");
		Scanner scann = new Scanner(System.in);
		int valeur;
	
		do{
			System.out.println("identifiant");
			valeur = scann.nextInt();
			ad.setIdadmin(valeur);
			
			System.out.println("password");
			valeur = scann.nextInt();
			ad.setPswd(valeur);
		
		}while(service.seconnecter(ad)==false);
		
		
			System.out.println("que voulais vous faire: \r"
					+ " 1: ajouter un compte etudiant "
					+ " \r 2: ajouter compte enseignant "
					+ " \r 3: listes des enseignents avec leurs Ues \r"
					+ " 4: listes des etudiants  \r 5: quitter "+ "");
		
			int valeur1;
			valeur1 = scann.nextInt();
			do{		
			 
				if (valeur1 == 1) {
					
					String nom,dep,prenom;	
					
					System.out.println("nom du nouveau etudiant");			
					Scanner sc =new Scanner(System.in);
					nom = sc.nextLine();
					et.setNom(nom);

					System.out.println("son prenom");
					prenom = sc.nextLine();
					et.setPrenom(prenom);
					
					System.out.println("departement ou ue de enseignant");
					dep = sc.nextLine();
					et.setDepartement(dep);
					
					System.out.println("password  des entiers");
					valeur1 = scann.nextInt();
					et.setPswd(valeur1);
					
					service.comptetudiant(et);
					
					} 
				else if (valeur1 == 2){
					@SuppressWarnings("unused")
					String nom,dep,prenom,email,fac;
					
					System.out.println("nom du nouveau enseignant");
					Scanner sc =new Scanner(System.in);
					nom = sc.nextLine();
					en.setNom(nom);
					
					System.out.println("son prenom");
					prenom = sc.nextLine();
					en.setPrenom(prenom);
					

					System.out.println("son addresse mail");
					email = sc.nextLine();
					en.setEmail(email);
					
					System.out.println("faculte de etudiant");
					fac = sc.nextLine();
					en.setDepartement(fac);
					
					System.out.println("password en entier");
					valeur1 = scann.nextInt();
					
					en.setPswd(valeur1);
					
					service.comptenseignant(en);
					
				}else if (valeur1 == 3){
					
					service.listenseignant();
				}
				else if (valeur1 == 4){
					service.listetudiant();
				}
				else {
					System.out.println("merci saisit invalide!!!!!!!suivez les instructions merci");
				}
				System.out.println("que voulais vous faire de plus?");
				System.out.println("que voulais vous faire: \r"
						+ " 1: ajouter un compte etudiant "
						+ " \r 2: ajouter compte enseignant "
						+ " \r 3: listes des enseignents avec leurs Ues \r"
						+ " 4: listes des etudiants  \r 5: quitter "+ "");
				valeur1 = scann.nextInt();
				
			}while (valeur1 != 5 );

		
	}
/*--********
 * *********** 
 * **************enseignant**
 * ***************************/
	
	
	private static void compteenseignant() {
		
		Enseignantservice service = new Enseignantservice();
		Etudiant et = new Etudiant();
		Enseignant en = new Enseignant();
		Ue ue = new Ue();
		System.out.println("connectez vous en saisissant correctement vos donnees");
		@SuppressWarnings("resource")
		Scanner scann = new Scanner(System.in);
		int valeur;
	
		do{
			System.out.println("identifiant");
			valeur = scann.nextInt();
			en.setIdenseignant(valeur);
			
			System.out.println("password");
			valeur = scann.nextInt();
			en.setPswd(valeur);
		
		}while(service.seconnecter(en) == false);

		int valeur1;
		do {
		System.out.println("que voulais vous faire: \r "
				+ "1: enregistrer les notes  \r"
				+ " 2: modifier une note \r "
				+ "3: notification \r "
				+ "4: quitter  ?");
		valeur1 = scann.nextInt();
		
			if (valeur1 == 1) {
				
				System.out.println("id de etudiant ");
				valeur1 = scann.nextInt();
				et.setIdetudiant(valeur1);
				
				System.out.println("la note de etudiant");
				valeur1 = scann.nextInt();
				ue.setNote(valeur1);
				
				System.out.println("departement");
				String dep;
				@SuppressWarnings("resource")
				Scanner sc =new Scanner(System.in);
				dep = sc.nextLine();
				en.setDepartement(dep);
				
				service.enregistrenote(et, ue, en);
			} else if (valeur1 == 2){
				
				System.out.println("id de etudiant ");
				valeur1 = scann.nextInt();
				et.setIdetudiant(valeur1);
				
				System.out.println(" note de etudiant a modifier");
				valeur1 = scann.nextInt();
				ue.setNote(valeur1);
				
				service.modifier(et, en, ue);;
			}else if (valeur1 == 3){
				service.notifier(en);
			}else {
				System.out.println("saisir correctement vos données");
			}
		}while (valeur1 != 4);
		 
}

	/*--*******
	 * ************ *etudiant*
	 * **************************
	 * */
	private static void compteetudiant() {
			
		Etudiantservice service = new Etudiantservice();
		Etudiant et =new Etudiant();
		
		System.out.println("connectez vous en saisissant correctement vos donnees");
		@SuppressWarnings("resource")
		Scanner scann = new Scanner(System.in);
		int valeur;
		int valeur1;
	
		do{
			System.out.println("identifiant");
			valeur = scann.nextInt();
			et.setIdetudiant(valeur);
			
			System.out.println("password");
			valeur1 = scann.nextInt();
			et.setPswd(valeur1);
		
		}while(service.seconnecter(et) == false);
		
		do {
			System.out.println("que voulais vous faire:\r "
				+ "1: consulter mes notes\r"
				+ "2: reclamer une note \r"
				+ "3: quitter ");
			
				valeur = scann.nextInt();
				
				if (valeur==1) {
					System.out.println("vos notes:");
					service.consulter(et);
				}else if (valeur==2) {
					Enseignant en = new Enseignant();
					Ue ue = new Ue();
					System.out.println("reclamer en donnant: ");
					System.out.println("id eu");
					valeur1 = scann.nextInt();
					ue.setIdeu(valeur1);
					//ue.setDatemodifer(new Date());			
					service.reclamer(et, ue, en);
				}
				else {
					System.out.println("saisit incorrecte");
				}
			}while (valeur != 3);
	}
			
}
