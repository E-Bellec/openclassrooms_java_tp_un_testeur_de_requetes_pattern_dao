package openclassrooms_java_tp_un_testeur_de_requetes.dao;

/*
 Classe qui permet de choisir le type de données reçus 
 ici grace au getFactory nous aurons le choix en SQL et XML
 
 
 */
public abstract class AbstractDAOFactory {
	public static final int SQL_DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;

	//Retourne un objet Classe interagissant avec la BDD
	public abstract DAO getClassDAO();
	 
	//Retourne un objet Professeur interagissant avec la BDD
	public abstract DAO getProfessorDAO();
	 
	//Retourne un objet Eleve interagissant avec la BDD
	public abstract DAO getStudentDAO();
	 
	//Retourne un objet Matiere interagissant avec la BDD
	public abstract DAO getCourseDAO();
	 
	//Méthode permettant de récupérer les Factory
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
			case SQL_DAO_FACTORY:
				return new SQLDAOFactory();
			case XML_DAO_FACTORY: 
				return new XMLDAOFactory();
			default:
				return null;
		}
	}
}
