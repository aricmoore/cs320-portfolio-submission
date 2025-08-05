package contact;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    // It should create a valid contact with the correct fields
    @Test
    public void testValidContactCreation() {
        Contact c = new Contact("12345", "Cannoli", "Bardot", "1234567890", "221B Baker Street");
        assertEquals("12345", c.getContactId());
	assertEquals("Cannoli", c.getFirstName());
        assertEquals("Bardot", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("221B Baker Street", c.getAddress());
    }

    // It should throw an exception for invalid contact IDs (null, too long) and enforce immutability
    @Test
    public void testInvalidContactId() {
	assertThrows(IllegalArgumentException.class, () -> {
	    new Contact("12345678901", "Cannoli", "Bardot", "1234567890", "221B Baker Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Cannoli", "Bardot", "1234567890", "221B Baker Street");
        });

        // Tests immutability of ID (no setter should exist; if it does, this test should fail)
        Contact contact = new Contact("12345", "Cannoli", "Bardot", "1234567890", "221B Baker Street");

        // The line below should not compile if there is no setter (expected behaviour)
        // contact.setContactId("newId");  // Uncommenting this should result in a compile-time error

        // Confirms immutability: no setter method should exist
        assertThrows(NoSuchMethodException.class, () -> {
            Contact.class.getMethod("setContactId", String.class);
        });
    }

    // It should throw an exception when first name is null or too long
    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Bardot", "1234567890", "221B Baker Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "ThisNameIsWayTooLong", "Bardot", "1234567890", "221B Baker Street");
        });
    }

    // It should throw an exception when first name is blank or whitespace-only
    @Test
    public void testBlankFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "", "Bardot", "1234567890", "221B Baker Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "   ", "Bardot", "1234567890", "221B Baker Street");
        });
    }

    // It should throw an exception when last name is null or too long
    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Cannoli", null, "1234567890", "221B Baker Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Cannoli", "ThisLastNameIsTooLong", "1234567890", "221B Baker Street");
        });
    }

    // It should throw an exception when last name is blank or whitespace-only
    @Test
    public void testBlankLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Cannoli", "", "1234567890", "221B Baker Street");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Cannoli", "    ", "1234567890", "221B Baker Street");
        });
    }

    // It should throw an exception for invalid phone numbers (null, wrong length, or non-numeric)
    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Cannoli", "Bardot", null, "221B Baker Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Cannoli", "Bardot", "12345", "221B Baker Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Cannoli", "Bardot", "123456789012", "221B Baker Street");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Cannoli", "Bardot", "blah123456", "221B Baker Street");
        });
    }

    // It should throw an exception when address is null or too long
    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Cannoli", "Bardot", "1234567890", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Cannoli", "Bardot", "1234567890",
                "123 This Address Is Way Too Long For The Field Limitations");
        });
    }

    // It should throw an exception when address is blank or whitespace-only
    @Test
    public void testBlankAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Cannoli", "Bardot", "1234567890", "");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Cannoli", "Bardot", "1234567890", "   ");
        });
    }

    // It should allow valid updates and reject invalid updates to fields (except contactId)
    @Test
    public void testSettersValidation() {
        Contact c = new Contact("12345", "Cannoli", "Bardot", "1234567890", "221B Baker Street");

        // Valid updates
        c.setFirstName("Finnley");
        assertEquals("Finnley", c.getFirstName());

        c.setLastName("O'Flanagan");
        assertEquals("O'Flanagan", c.getLastName());

        c.setPhone("0987654321");
        assertEquals("0987654321", c.getPhone());

        c.setAddress("6 Johnston Terrace");
        assertEquals("6 Johnston Terrace", c.getAddress());

        // Invalid updates
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(""));
        assertThrows(IllegalArgumentException.class, () -> c.setLastName(""));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("123"));
        assertThrows(IllegalArgumentException.class, () -> c.setAddress(null));
    }
}
