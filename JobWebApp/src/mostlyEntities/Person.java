package mostlyEntities;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="Person")
public class Person {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")	
private int id;
@Column(name="persno")	
private String persno;
@Column(name="firstname")	
private String firstname;
@Column(name="lastname")	
private String lastname;
@Column(name="status")	
private String status;
@Column(name="salary")	
private BigDecimal salary;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="Address_id")
private Address address;	

@ManyToMany(fetch = FetchType.LAZY, 
cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
@JoinTable(name="PersonDepartment",
           joinColumns = @JoinColumn(name= "Person_id"),
           inverseJoinColumns = @JoinColumn(name ="Department_id"))
List<Department> departments;

public Person() {

}

public Person(String persno, String firstname, String lastname, String status, BigDecimal salary) {
	this.persno = persno;
	this.firstname = firstname;
	this.lastname = lastname;
	this.status = status;
	this.salary = salary;
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getPersno() {
	return persno;
}

public void setPersno(String persno) {
	this.persno = persno;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public BigDecimal getSalary() {
	return salary;
}

public void setSalary(BigDecimal salary) {
	this.salary = salary;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public List<Department> getDepartments() {
	return departments;
}

public void setDepartments(List<Department> departments) {
	this.departments = departments;
}

public void addDepartment(Department department) {
	if(departments ==null) {
	departments= new ArrayList<>();
		   
		}
	departments.add(department);
}

	
}
