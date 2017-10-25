package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="getAllUsers",
			query="select c from User c")
})

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String email;
	private long id;
<<<<<<< HEAD
	private String nome;
	private String password;

	public String getNome() {
		return nome;
=======
	private String email;
	private String name;
	private String password;

	public User(){
		
	}
	
	public User(String email, String name, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
>>>>>>> 7d41d4e729971d579c6e97d94a22dba5f6388be4
	}

	public boolean login(String email, String password) {
		return this.email.compareTo(email) > -1 && this.password.compareTo(password) > -1;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean login(String email, String password) {
		return this.email == email && this.password == password ? this : null;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}
}
