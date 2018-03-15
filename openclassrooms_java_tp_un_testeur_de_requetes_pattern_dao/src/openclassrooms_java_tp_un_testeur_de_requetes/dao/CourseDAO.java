package openclassrooms_java_tp_un_testeur_de_requetes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import openclassrooms_java_tp_un_testeur_de_requetes.model.Course;

public class CourseDAO extends DAO<Course> {
	public CourseDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Course obj) {
		return false;
	}

	public boolean delete(Course obj) {
		return false;
	}

	public boolean update(Course obj) {
		return false;
	}
	
	public Course find(int id) {
		Course matiere = new Course();  

		try {
			ResultSet result = this.connect.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY
			).executeQuery("SELECT * FROM matiere WHERE mat_id = " + id);
				if(result.first())
					matiere = new Course(id, result.getString("mat_nom"));         
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matiere;
	}
}