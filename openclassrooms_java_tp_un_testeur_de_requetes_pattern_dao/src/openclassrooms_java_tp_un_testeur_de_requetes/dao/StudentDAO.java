package openclassrooms_java_tp_un_testeur_de_requetes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import openclassrooms_java_tp_un_testeur_de_requetes.model.Student;

public class StudentDAO extends DAO<Student> {
	
	public StudentDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Student obj) {
		return false;
	}

	public boolean delete(Student obj) {
		return false;
	}
	 
	public boolean update(Student obj) {
		return false;
	}
	 
	public Student find(int id) {
		Student eleve = new Student();      
			
		try {
			ResultSet result = this.connect.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM eleve WHERE elv_id = " + id);
			if(result.first())
				eleve = new Student(
					id,
					result.getString("elv_nom"),
					result.getString("elv_prenom"
				));         
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eleve;
	}

}
