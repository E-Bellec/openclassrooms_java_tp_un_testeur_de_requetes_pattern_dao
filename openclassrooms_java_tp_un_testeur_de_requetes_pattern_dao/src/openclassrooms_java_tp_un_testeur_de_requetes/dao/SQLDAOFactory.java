package openclassrooms_java_tp_un_testeur_de_requetes.dao;

import java.sql.Connection;

import openclassrooms_java_jdbc_connexion_simplifiee.SdzConnection;


/*
	la factory dans le pattern DAO sert à construire nos instances d'objets d'accès aux données. 
	Du coup, vu que nous disposons d'un super type d'objet, nous savons ce que va retourner notre fabrique
*/
public class SQLDAOFactory extends AbstractDAOFactory{
	protected static final Connection conn = SdzConnection.getInstance();   
	 
	/**
	* Retourne un objet Classe interagissant avec la BDD
	* @return DAO
	*/
	@Override
	public DAO getClassDAO(){
		return new ClassDAO(conn);
	}

	/**
	* Retourne un objet Professeur interagissant avec la BDD
	* @return DAO
	*/
	@Override
	public DAO getProfessorDAO(){
		return new ProfessorDAO(conn);
	}

	/**
	* Retourne un objet Eleve interagissant avec la BDD
	* @return DAO
	*/
	@Override
	public DAO getStudentDAO(){
		return new StudentDAO(conn);
	}

	/**
	* Retourne un objet Matiere interagissant avec la BDD
	* @return DAO
	*/
	@Override
	public DAO getCourseDAO(){
		return new CourseDAO(conn);
	}   
}
