package openclassrooms_java_tp_un_testeur_de_requetes.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import openclassrooms_java_tp_un_testeur_de_requetes.model.Class;

public class ClassDAO extends DAO<Class> {
	public ClassDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Class obj) {
		return false;
	}

	public boolean delete(Class obj) {
		return false;
	}
	 
	public boolean update(Class obj) {
		return false;
	}

	public Class find(int id) {
		Class classStudent = new Class();
		try {
			ResultSet result = this.connect.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY
			).executeQuery("SELECT * FROM classe WHERE cls_id = " + id); 

			if(result.first()){
				classStudent = new Class(id, result.getString("cls_nom"));

				result = this.connect.createStatement().executeQuery(
					"SELECT prof_id, prof_nom, prof_prenom from professeur " +
					"INNER JOIN j_mat_prof ON prof_id = jmp_prof_k " +
					"INNER JOIN j_cls_jmp ON jmp_id = jcm_jmp_k AND jcm_cls_k = " + id
				);

				ProfessorDAO profDao = new ProfessorDAO(this.connect);

				while(result.next())
					classStudent.addProfesseur(profDao.find(result.getInt("prof_id")));

				StudentDAO eleveDao = new StudentDAO(this.connect);
				result = this.connect.createStatement().executeQuery(
					"SELECT elv_id, elv_nom, elv_prenom FROM eleve " +
					"INNER JOIN classe ON elv_cls_k = cls_id AND cls_id = " + id
				);

				while(result.next())
					classStudent.addEleve(eleveDao.find(result.getInt("elv_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classStudent;
	}
}

