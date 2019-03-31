package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dmacc.beans.Contact;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.ContactRepository;

@SpringBootApplication
public class SpringContactsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringContactsApplication.class, args);
	}

	@Autowired
	ContactRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);

		List<Contact> allMyContacts = repo.findAll();
		for (Contact people : allMyContacts) {
			System.out.println(people.toString());
		}

		((AnnotationConfigApplicationContext) appContext).close();

	}

}
