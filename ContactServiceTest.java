package contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;
    private Contact contact;

    // It should initialize a new ContactService and add a default contact before each test
    @BeforeEach
    public void setup() {
        service = new ContactService();
        contact = new Contact("1", "Finnley", "O'Flanagan", "9876543210", "6 Johnston Terrace");
        service.addContact(contact);
    }

    // It should add contacts with a unique ID
    @Test
    public void testAddDuplicateContact() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    // It should add a new contact with a different unique ID
    @Test
    public void testAddNewContact() {
	Contact newContact = new Contact("2", "Cannoli", "Bardot", "1234567890", "221B Baker Street");
	service.addContact(newContact);
	assertEquals("Cannoli", service.getContact("2").getFirstName());
    }

    // It should delete a contact per contact ID
    @Test
    public void testDeleteContact() {
        service.deleteContact("1");
        assertNull(service.getContact("1"));
    }

    // It should not delete a non-existent contact
    @Test
    public void testDeleteNonExistentContact() {
	assertThrows(IllegalArgumentException.class, () -> service.deleteContact("999"));
    }

    // It should update contact fields per contact ID (firstName, lastName, number, address)
    @Test
    public void testUpdateFields() {
        service.updateFirstName("1", "Frank");
        assertEquals("Frank", service.getContact("1").getFirstName());

        service.updateLastName("1", "Furter");
        assertEquals("Furter", service.getContact("1").getLastName());

        service.updatePhone("1", "1112223333");
        assertEquals("1112223333", service.getContact("1").getPhone());

        service.updateAddress("1", "10 Downing Street");
        assertEquals("10 Downing Street", service.getContact("1").getAddress());
    }

    // It should check for invalid updates (null, empty, too long, etc.)
    @Test
    public void testUpdateInvalidFields() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("1", null));
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("1", ""));  	       // added empty string check
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("1", null));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("1", ""));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "123")); 	       // too short
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "123456789012"));  // too long
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1", "blah123456"));    // non-digit chars
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("1", null));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("1", "")); 	       // empty string address
    }

    // It should not update a non-existent contact
    @Test
    public void testUpdateNonExistentContactFields() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("999", "Ghost"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("999", "Ghost"));
    assertThrows(IllegalArgumentException.class, () -> service.updatePhone("999", "1234567890"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("999", "Nope St"));
    }

    // It should not update a contact that does not exist
    @Test
    public void testUpdateInvalidContact() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("999", "Bob"));
    }
}
