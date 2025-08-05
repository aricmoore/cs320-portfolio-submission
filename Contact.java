package contact;

/* Module Three Milestone: Contact Service (OOP Java Implementation)
   Author: Arielle Moore
   Description: A contact management system that allows adding, updating,
                and deleting contacts. Includes enforced data validation
								and JUnit/Maven test coverage.
*/

public class Contact {
    private final String contactId;  // Ensures that the ID is immutable
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10)
            throw new IllegalArgumentException("Invalid contact ID");
        if (firstName == null || firstName.trim().isEmpty() || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");
        if (lastName == null || lastName.trim().isEmpty() || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}"))
            throw new IllegalArgumentException("Invalid phone number");
        if (address == null || address.trim().isEmpty() || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

		// Getters
    public String getContactId() { return contactId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

		// Setters (no setter needed for contactId because it's immutable)
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty() || firstName.length() > 10)
            throw new IllegalArgumentException("Invalid first name");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty() || lastName.length() > 10)
            throw new IllegalArgumentException("Invalid last name");
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}"))
            throw new IllegalArgumentException("Invalid phone number");
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty() || address.length() > 30)
            throw new IllegalArgumentException("Invalid address");
        this.address = address;
    }
}
