package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Person_Test {
		
	private static PersonDomainModel person1;
	private static UUID person1UUID = UUID.randomUUID();			
	
	@BeforeClass
	public static void personInstance() throws Exception{
		
		Date person1Birth = null;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		 person1 = new PersonDomainModel();
		 
		try {
			person1Birth = dateFormat.parse("1994-11-27");
		} catch (ParseException e) {
			System.out.println("Wrong date format, bucko!");
		}
		
		person1.setPersonID(person1UUID);
		person1.setFirstName("Mingkun");
		person1.setMiddleName("a");
		person1.setLastName("Chen");
		person1.setBirthday(person1Birth);
		person1.setCity("Elkton");
		person1.setStreet("702 Stone Gate Blvd");
		person1.setPostalCode(21921);
		
	}
	@Test
	public void testaddPerson(){
		PersonDomainModel personadded = PersonDAL.addPerson(person1);
		assertEquals(person1, personadded);
	}
	
	@Test
	public void testdeletePerson(){
		PersonDomainModel person2 = new PersonDomainModel();
		UUID person2UUID = UUID.randomUUID();
		person2.setPersonID(person2UUID);
		PersonDAL.addPerson(person2);
		PersonDAL.deletePerson(person2UUID);
		assertNull(person2);
	}
	@Test
	public void testupdatePerson(){
		PersonDomainModel person2 = new PersonDomainModel();
		assertEquals(person2, PersonDAL.updatePerson(person2));
	}
	@Test
	public void testgetPerson(){

		assertNotEquals(person1, PersonDAL.getPerson(person1UUID));
	}
	

}
