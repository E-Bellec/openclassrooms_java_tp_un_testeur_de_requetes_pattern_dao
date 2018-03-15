package openclassrooms_java_tp_un_testeur_de_requetes;

import openclassrooms_java_tp_un_testeur_de_requetes.dao.DAO;
import openclassrooms_java_tp_un_testeur_de_requetes.dao.DAOFactory;
import openclassrooms_java_tp_un_testeur_de_requetes.model.ClassStudent;
import openclassrooms_java_tp_un_testeur_de_requetes.model.Course;
import openclassrooms_java_tp_un_testeur_de_requetes.model.Professor;
import openclassrooms_java_tp_un_testeur_de_requetes.model.Student;

//CTRL + SHIFT + O pour générer les imports
public class TestDAOFactory {
	public static void main(String[] args) {
		System.out.println("TEST DAO FACTORY");
		//On récupère un objet faisant le lien entre la base et nos objets 
		DAO<Student> studentDao = DAOFactory.getStudentDAO();

		for(int i = 1; i < 5; i++){
			//On fait notre recherche
			Student student = studentDao.find(i);
			System.out.println("\tELEVE N°" + student.getId() + " - NOM : " + student.getLastName() + " - PRENOM : " + student.getFirstName());
		}

		System.out.println("\n\t****************************************");

		//On fgit de même pour une classe
		DAO<ClassStudent> classeDao = DAOFactory.getClassDAO();
		//On cherche la classe ayant pour ID 10
		ClassStudent classe = classeDao.find(10);

		System.out.println("\tCLASSE DE " + classe.getName());

		//On récupère la liste des élèves
		System.out.println("\n\tCelle-ci contient " + classe.getListEleve().size() + " élève(s)");
		for(Student student : classe.getListEleve())
			System.out.println("\t\t - " + student.getLastName() + " " + student.getFirstName());
						
		//De même pour la liste des professeurs
		System.out.println("\n\tCelle-ci a " + classe.getListProfesseur().size() + " professeur(s)");      
		for(Professor prof : classe.getListProfesseur()){
			System.out.println("\t\t - Mr " + prof.getLastName() + " " + prof.getFirstName() + " professeur de :");
				 
			//Tant qu'à faire, on prend aussi les matières
			for(Course mat : prof.getListCourse())
				System.out.println("\t\t\t * " + mat.getName());         
		}
			
		System.out.println("\n\t****************************************");
			
		//Un petit essai sur les matières
		DAO<Course> matiereDao = DAOFactory.getCourseDAO();
		Course mat = matiereDao.find(2);
		System.out.println("\tMATIERE " + mat.getId() + " : " + mat.getName());      
	}
}
