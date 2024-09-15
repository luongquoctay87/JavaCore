package src;

import java.util.Date;

// SampleClass là tên class (Lớp)
public class SampleClass { // Ký tự { bắt đầu Block của lớp SampleClass

    // Các fields này chính là instance variables
    private Integer id; // đây là fields
    private String firstName; // đây là fields
    private String lastName; // đây là fields
    private Date dateOfBirth; // đây là fields
    private Address address; // đây là fields
    public String message; // đây là fields

    // đây là constructor
    public SampleClass() {
    }

    // đây là constructor có tham số truyền vào
    public SampleClass(Integer id, String firstName, String lastName, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    // đây là method để thể hiện các hành vi (Behavior)
    public Integer getId() { // { bắt đầu Block của method getId()
        return id;
    } // } kết thúc Block của method getId()

    // đây là method để thể hiện các hành vi (Behavior)
    public void setId(Integer id) {
        this.id = id;
    }

    // đây là method để thể hiện các hành vi (Behavior)
    public String getFirstName() {
        return firstName;
    }

    // đây là method để thể hiện các hành vi (Behavior)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // đây là method để thể hiện các hành vi (Behavior)
    public String getLastName() {
        return lastName;
    }

    // đây là method để thể hiện các hành vi (Behavior)
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // đây là method để thể hiện các hành vi (Behavior)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    // đây là method để thể hiện các hành vi (Behavior)
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // đây là method để thể hiện các hành vi (Behavior)
    public String getFullName() {
        return this.firstName + " " + lastName;
    }

    // đây là method để thể hiện các hành vi (Behavior)
    public Address getAddress() {
        return address;
    }

    // đây là method để thể hiện các hành vi (Behavior)
    public void setAddress(Address address) {
        this.address = address;
    }

    // Nested class (Lớp lồng nhau)
    class Address {
        private String street;
        private String district;
        private String city;
        private String country;
    }

    @Override
    public String toString() {
        return "SampleClass{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
} // Ký tự } kết thúc Block của lớp SampleClass
