package openclassrooms_java_tp_un_testeur_de_requetes;

import openclassrooms_java_tp_un_testeur_de_requetes.dao.AbstractDAOFactory;
import openclassrooms_java_tp_un_testeur_de_requetes.dao.DAO;
import openclassrooms_java_tp_un_testeur_de_requetes.model.ClassStudent;
import openclassrooms_java_tp_un_testeur_de_requetes.model.Course;
import openclassrooms_java_tp_un_testeur_de_requetes.model.Professor;
import openclassrooms_java_tp_un_testeur_de_requetes.model.Student;


public class TestDAOFactory {

	public static void main(String[] args) {
		System.out.println("");
		
		// Nous utilisons notre factory abstraite, ici nous pouvons appeler SQLFactory ou XMLFactory pour avoir accès au donner
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.SQL_DAO_FACTORY);
		//On récupère un objet faisant le lien entre la base et nos objets 
		DAO<Student> eleveDao = adf.getStudentDAO();
			
		for(int i = 1; i < 5; i++){
			//On fait notre recherche
			Student eleve = eleveDao.find(i);
			System.out.println("\tELEVE N°" + eleve.getId() + " - NOM : " + eleve.getLastName() + " - PRENOM : " + eleve.getFirstName());
		}
			
		System.out.println("\n\t************************************");
			
		//On fait de même pour une classe
		DAO<ClassStudent> classeDao = adf.getClassDAO();
		//On cherche la classe ayant pour ID 10
		ClassStudent classe = classeDao.find(10);
			
		System.out.println("\tCLASSE DE " + classe.getName());
			
		//On récupère la liste des élèves
		System.out.println("\n\tCelle-ci contient " + classe.getListEleve().size() + " élève(s)");
		for(Student eleve : classe.getListEleve())
			System.out.println("\t\t - " + eleve.getLastName() + " " + eleve.getFirstName());
			
		//De même pour la liste des professeurs
		System.out.println("\n\tCelle-ci a " + classe.getListProfesseur().size() + " professeur(s)");      
		for(Professor prof : classe.getListProfesseur()){
			System.out.println("\t\t - Mr " + prof.getLastName() + " " + prof.getFirstName() + " professeur de :");
				 
			//Tant qu'à faire, on prend aussi les matières
			for(Course mat : prof.getListCourse())
				System.out.println("\t\t\t * " + mat.getName());
		}
			
		System.out.println("\n\t***********************************");
			
		//Un petit essai sur les matières
		DAO<Course> matiereDao = adf.getCourseDAO();
		Course mat = matiereDao.find(2);
		System.out.println("\tMATIERE " + mat.getId() + " : " + mat.getName());      
	}
}