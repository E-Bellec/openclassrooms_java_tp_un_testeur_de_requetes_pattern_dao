package openclassrooms_java_tp_un_testeur_de_requetes.model;

public class Course {
	private int id = 0;
	private String name = "";
	
	// CONSTRUCTEUR par defaut
	public Course() {}
	
	// CONSTRUCTEUR
	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	//GETTER & SETTER
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
}
