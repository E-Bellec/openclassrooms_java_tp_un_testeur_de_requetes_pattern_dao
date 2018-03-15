package openclassrooms_java_tp_un_testeur_de_requetes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import openclassrooms_java_tp_un_testeur_de_requetes.model.Professor;

public class ProfessorDAO extends DAO<Professor> {
	public ProfessorDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Professor obj) {
		return false;
	}

	public boolean delete(Professor obj) {
		return false;
	}

	public boolean update(Professor obj) {
		return false;
	}
	 
	public Professor find(int id) {
		Professor professeur = new Professor();            
		try {
			ResultSet result = this.connect.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY
			).executeQuery(
				"SELECT * FROM professeur "+
				"LEFT JOIN j_mat_prof ON jmp_prof_k = prof_id " + 
				"AND prof_id = "+ id +
				" INNER JOIN matiere ON jmp_mat_k = mat_id"
			);
			if(result.first()){
				professeur = new Professor(id, result.getString("prof_nom"), result.getString("prof_prenom"));
				result.beforeFirst();
				CourseDAO matDao = new CourseDAO(this.connect);
						
				while(result.next())
					professeur.addMatiere(matDao.find(result.getInt("mat_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return professeur;
	}
}
