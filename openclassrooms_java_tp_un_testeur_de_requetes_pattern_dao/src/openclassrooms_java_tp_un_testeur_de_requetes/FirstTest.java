package openclassrooms_java_tp_un_testeur_de_requetes;

import openclassrooms_java_jdbc_connexion_simplifiee.SdzConnection;
import openclassrooms_java_tp_un_testeur_de_requetes.dao.ClassDAO;
import openclassrooms_java_tp_un_testeur_de_requetes.dao.DAO;
import openclassrooms_java_tp_un_testeur_de_requetes.dao.ProfessorDAO;
import openclassrooms_java_tp_un_testeur_de_requetes.dao.StudentDAO;
import openclassrooms_java_tp_un_testeur_de_requetes.model.ClassStudent;
import openclassrooms_java_tp_un_testeur_de_requetes.model.Course;
import openclassrooms_java_tp_un_testeur_de_requetes.model.Professor;
import openclassrooms_java_tp_un_testeur_de_requetes.model.Student;

public class FirstTest { 
	public static void main(String[] args) {
	//Testons des élèves
	 DAO<Student> eleveDao = new StudentDAO(SdzConnection.getInstance());
	 	for(int i = 1; i < 5; i++){
	 		Student eleve = eleveDao.find(i);
	 		System.out.println("Elève N°" + eleve.getId() + "  - " + eleve.getLastName() + " " + eleve.getFirstName());
	 	}
	      
	 	System.out.println("\n********************************\n");
	      
	 	//Voyons voir les professeurs
	 	DAO<Professor> profDao = new ProfessorDAO(SdzConnection.getInstance());
	 	for(int i = 4; i < 8; i++){
	 		Professor prof = profDao.find(i);
	 		System.out.println(prof.getLastName() + " " + prof.getFirstName() + " enseigne : ");
	 		for(Course mat : prof.getListCourse())
	 			System.out.println("\t * " + mat.getName());
	    }
	      
	 	System.out.println("\n********************************\n");
	      
	 	//Et là, c'est la classe
	 	DAO<ClassStudent> classeDao = new ClassDAO(SdzConnection.getInstance());
	 	ClassStudent classe = classeDao.find(11);
	      
	 	System.out.println("Classe de " + classe.getName());
	 	System.out.println("\nListe des élèves :");
	 	for(Student eleve : classe.getListEleve())
	 		System.out.println("  - " + eleve.getLastName() + " " + eleve.getFirstName());
	      
	 	System.out.println("\nListe des professeurs :");
	 	for(Professor prof : classe.getListProfesseur())
	 		System.out.println("  - " + prof.getLastName() + " " + prof.getFirstName());      
	}
}