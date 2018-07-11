package ir.kuroshfarsimadan.batch;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ir.kuroshfarsimadan.bean.Person;
import ir.kuroshfarsimadan.bean.PersonImpl;
import ir.kuroshfarsimadan.dao.PersonDAO;

public class PersonListHandler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		PersonDAO dao = (PersonDAO)context.getBean("daoClass");
		
		System.out.println("-------------------");
		System.out.println("Listing all");
		System.out.println("-------------------");
		
		List<Person> persons = dao.retrieveAll();
		for (Person p : persons) {
			System.out.println(p.getFirstname());
		}
		
		System.out.println("-------------------");
		System.out.println("Retrieving one (ID=3)");
		System.out.println("-------------------");
		
		Person test = dao.find(3);
		System.out.println(test.getId());
		System.out.println(test.getFirstname());
		System.out.println(test.getLastname());
		
		System.out.println("-------------------");
		System.out.println("Adding new");
		System.out.println("-------------------");
		
		Person person = new PersonImpl();
		person.setFirstname("New");
		person.setLastname("Guy");
		dao.save(person);
		
		System.out.println("-------------------");
		System.out.println("Retrieving all");
		System.out.println("-------------------");
		persons = dao.retrieveAll();
		for (Person h : persons) {
			System.out.println(h.getFirstname());
		}
		
		context.close();

	}

}
