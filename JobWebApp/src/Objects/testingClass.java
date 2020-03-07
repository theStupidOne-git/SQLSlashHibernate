package Objects;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mostlyEntities.Address;
import mostlyEntities.Department;
import mostlyEntities.Person;

public class testingClass {
	public static void main(String[] args) {
		SessionFactory s=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Person.class).addAnnotatedClass(Address.class).addAnnotatedClass(Department.class)
				.buildSessionFactory();	
		Session session=s.getCurrentSession();	
	
		BigDecimal b = new BigDecimal("2000");
		BigDecimal b1 = new BigDecimal("4000");
		BigDecimal b2 = new BigDecimal("10000");
		try {
			session.beginTransaction();
		    Department department1=new Department("Development","Objednavni pizze");
		    Department department2=new Department("Sales","Smuchani zadku");
	        Department department3=new Department("Marketing","Prdeni z oken");
	     	Address address1=new Address("Avenue","Reading","Berskhire","Britain","London");
	        Address address2=new Address("Burstok","Prdel","Hlobk","Czech","UH");	   
	        Address address3=new Address("Loza","Banov","Prdel","Czech","UH");		 
			Person p1=new Person("0777851234","Jakub","Gaba","Active", b);
			Person p2=new Person("888993209","Petr","Skala","Active", b1);
			Person p3=new Person("605804633","Igor","Potmesil","Non-active", b1);
			Person p4=new Person("606888932","Jirka","Strkal","Active", b2);
		    Person p5=new Person("473829738","Prdel","Doe","Active", b2);
		    Person p6=new Person("312538380","Podklon","John","Non-active", b);
			System.out.println("Saving...");
			department1.addPersonDepartment(p1);
			department1.addPersonDepartment(p2);
			department2.addPersonDepartment(p3);
			department2.addPersonDepartment(p4);
			department3.addPersonDepartment(p5);
			department3.addPersonDepartment(p6);
			address1.addPersonAdress(p1);
			address1.addPersonAdress(p2);
		    address2.addPersonAdress(p3);
		    address2.addPersonAdress(p4);
		    address3.addPersonAdress(p5);
		    address3.addPersonAdress(p6);
		    department1.setLeader(p1);
		    department2.setLeader(p1);
		    department3.setLeader(p5);
		    session.save(department1);
		    p1.addDepartment(department1);
		    p2.addDepartment(department1);
		    session.save(department2);
		    p3.addDepartment(department2);
		    p4.addDepartment(department2);
		    session.save(department3);
		    p5.addDepartment(department3);
		    p6.addDepartment(department3);
		    session.save(address1);
		    session.save(address2);
		    session.save(address3);
		    session.getTransaction().commit();
		     }
		     finally {
		     s.close();
		     session.close();
		     }
		
		
	}
	
}
