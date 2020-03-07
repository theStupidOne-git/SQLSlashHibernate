package mostlyEntities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")	
private int id;
@Column(name="name")	
private String name;
@Column(name="description")	
private String description;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="leader_id")
private Person leader;


@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name="Department_id")
private List<Person> persons;

@ManyToMany(fetch = FetchType.LAZY, 
cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
@JoinTable(name="PersonDepartment",
           joinColumns = @JoinColumn(name= "Department_id"),
           inverseJoinColumns = @JoinColumn(name ="Person_id"))
List<Person> person;
Department() {

}


public Department(String name, String description) {
	this.name = name;
	this.description = description;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public List<Person> getPersons() {
	return persons;
}


public void setPersons(List<Person> persons) {
	this.persons = persons;
}


public void addPersonDepartment(Person person) {
	   if(persons ==null) {
		  persons = new ArrayList<>();
		   
		}
		persons.add(person);
}


public Person getLeader() {
	return leader;
}


public void setLeader(Person leader) {
	this.leader = leader;
}


public List<Person> getPerson() {
	return person;
}


public void setPerson(List<Person> person) {
	this.person = person;
}











}
