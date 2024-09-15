package src.model;

// Customer = Superclass-name
// Customer kế thừa các tính chất, thuộc tính từ BaseEntity
public class Customer extends BaseEntity {

    private String fullName;
    private String phone;
    private String email;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
