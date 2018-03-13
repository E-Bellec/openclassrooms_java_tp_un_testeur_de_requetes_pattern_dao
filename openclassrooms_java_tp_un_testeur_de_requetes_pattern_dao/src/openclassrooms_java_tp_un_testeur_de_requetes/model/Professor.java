package openclassrooms_java_tp_un_testeur_de_requetes.model;

import java.util.HashSet;
import java.util.Set;

public class Professor {
	private int id = 0;
	private String lastName = "";
	private String firstName = "";
	private Set<Course> listCourse = new HashSet<Course>();
	
	// CONSTRUCTEUR par defaut
	public Professor() {}

	// CONSTRUCTEUR
	public Professor(int id, String lastName, String firstName) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	//Ajoute une matière à un professeur
	public void addMatiere(Course course){
		this.listCourse.add(course);
	}

	//Retire une matière à un professeur
	public void removeMatiere(Course course){
		this.listCourse.remove(course);
	}

	// GETTER & SETTER
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public Set<Course> getListCourse() {
		return listCourse;
	}


	public void setListCourse(Set<Course> listCourse) {
		this.listCourse = listCourse;
	}
	
	
	
	
}
