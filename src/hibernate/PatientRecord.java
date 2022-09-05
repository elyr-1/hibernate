package hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PatientRecord {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Patient.class).buildSessionFactory();

		// create session
		Session session = factory.openSession();
		
		// call saveRecords function to push objects to database
		saveRecords(session);
		
		// call fetchRecords function to retrieve records from database
		fetchRecords(session);
		
		factory.close();
		
	}
	
	// fetch record function
	private static void fetchRecords(Session s) {
		
		try {
			
			// start transaction
			s.beginTransaction();
			
			// query patients
			List<Patient> patients = s.createQuery("FROM Patient p ORDER BY p.patientNo").list();
			
			// display records
			for (Patient p : patients) {
				System.out.println(p);
			}
			
			// commit transaction	
			s.getTransaction().commit();
		
		} 
		finally {
			System.out.println("Records retrieved successfully!");
		}
	}
	
	// create records function
	private static void saveRecords(Session s) {
		
		try {
			System.out.println("Creating entries...");
			// create Patient objects
			Patient p1 = new Patient("S101", "Richard Dela Cruz", "P1100", "Ricky Mastrano", "O11");
			Patient p2 = new Patient("S101", "Richard Dela Cruz", "P1105", "Jun Nicat", "O15");
			Patient p3 = new Patient("S123", "Nenita Guanzon", "P1108", "Penelope Ramos", "O11");
			Patient p4 = new Patient("S123", "Nenita Guanzon", "P1108", "Penelope Ramos", "O11");
			Patient p5 = new Patient("S125", "Ronnie Reyes", "P1105", "Jun Nicat", "O15");
			Patient p6 = new Patient("S125", "Ronnie Reyes", "P1110", "Jose Quizon", "O12");
			
			// start transaction
			s.beginTransaction();
			
			// save the student objects
			s.save(p1);
			s.save(p2);
			s.save(p3);
			s.save(p4);
			s.save(p5);
			s.save(p6);
			
			// commit transaction
			s.getTransaction().commit();

		}
		finally {
			System.out.println("Records saved successfully!\n");
		}
	}

}
