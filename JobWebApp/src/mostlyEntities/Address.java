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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private int id;
@Column(name="street")
private String street;
@Column(name="city")
private String city;
@Column(name="county")
private String county;
@Column(name="state")
private String state;
@Column(name="country")
private String country;

@OneToMany(mappedBy ="address",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private List<Person> Persons;

public Address() {

}


public Address(String street, String city, String county, String state, String country) {
	this.street = street;
	this.city = city;
	this.county = county;
	this.state = state;
	this.country = country;
	
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getCounty() {
	return county;
}

public void setCounty(String county) {
	this.county = county;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

@Override
public String toString() {
	return "Address [id=" + id + ", street=" + street + ", city=" + city + ", county=" + county + ", state=" + state
			+ ", country=" + country + "]";
}

public List<Person> getPersons() {
	return Persons;
}

public void setPersons(List<Person> persons) {
	Persons = persons;
}

public void addPersonAdress(Person person) {
   if(Persons ==null) {
	  Persons = new ArrayList<>();
	   
	}
	Persons.add(person);
	person.setAddress(this);
}

}
