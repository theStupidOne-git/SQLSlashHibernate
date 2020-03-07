package Objects;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import mostlyEntities.Address;
import mostlyEntities.Department;
import mostlyEntities.Person;




public class SettingLeader {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		statickeBlbost sb=new statickeBlbost();
		SessionFactory s=new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Person.class).addAnnotatedClass(Address.class).addAnnotatedClass(Department.class)
			.buildSessionFactory();	
		Session session=s.getCurrentSession();		
		try {
		session.beginTransaction();
		System.out.println("----Seznam osob----");
		sb.ukazat(Person.class, session);
		session.getTransaction().commit();
		session=s.getCurrentSession();	
		session.beginTransaction();
		System.out.println("----Seznam departmentu----");
		sb.ukazat(Department.class, session);
		session.getTransaction().commit();
		session=s.getCurrentSession();	
		session.beginTransaction();
		System.out.println("Nastavte leadera pro Development (napiste jmeno z uvedenych osob)");
		sc.hasNextLine();
		}
		finally {
		s.close();	
		}
	}

}
class statickeBlbost {
@SuppressWarnings("unchecked")
static void ukazat(Class<?> object, Session s) {
if(object.equals(Person.class)) {
List<Person> osoby;
osoby=s.createQuery("from Person").list();
for(Person obj: osoby) {
	System.out.println(obj.getFirstname()+" "+obj.getLastname());
	}
}
else if(object.equals(Department.class)) {
List<Department> Oddeleni;
Oddeleni=s.createQuery("from Department").list();
for(Department obj: Oddeleni) {
	System.out.println(obj.getName());
	}
}
}
}
