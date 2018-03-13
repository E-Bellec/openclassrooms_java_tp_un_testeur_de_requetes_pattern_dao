package openclassrooms_java_tp_un_testeur_de_requetes.model;

public class Student {
	private int id = 0;
	private String lastName = "";
	private String firstName = "";
	
	// CONSTRUCTEUR par defaut
	public Student() {}
	
	// CONSTRUCTEUR
	public Student(int id, String lastName, String firstName) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	//GETTER & SETTER
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
}
