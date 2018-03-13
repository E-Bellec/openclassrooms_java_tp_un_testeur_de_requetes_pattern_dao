package openclassrooms_java_tp_un_testeur_de_requetes.model;

import java.util.HashSet;
import java.util.Set;

public class Class {
	private int id = 0;
	private String name = "";
	private Set<Professor> listProfesseur = new HashSet<Professor>();
	private Set<Student> listEleve = new HashSet<Student>();

	// CONSTRUCTEUR par defaut
	public Class() {}

	// CONSTRUCTEUR
	public Class(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	//Ajoute d'un proffesseur
	public void addProfesseur(Professor prof) {
		if(!listProfesseur.contains(prof))
			listProfesseur.add(prof);
	}

	//Suppression d'un proffesseur
	public void removeProfesseur(Professor prof ) {
		this.listProfesseur.remove(prof);
	}
	
	//Ajoute un élève à la classe
	public void addEleve(Student student){
		if(!this.listEleve.contains(student))
			this.listEleve.add(student);
	}

	//Retire un élève de la classe
	public void removeEleve(Student student){
		this.listEleve.remove(student);
	}

	// Comparer l'id de la classe
	public boolean equals(Class cls){
		return this.getId() == cls.getId();
	}
	
	// GETTER & SETTER
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Professor> getListProfesseur() {
		return listProfesseur;
	}

	public void setListProfesseur(Set<Professor> listProfesseur) {
		this.listProfesseur = listProfesseur;
	}

	public Set<Student> getListEleve() {
		return listEleve;
	}

	public void setListEleve(Set<Student> listEleve) {
		this.listEleve = listEleve;
	}
	
	
}
