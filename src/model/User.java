package src.model;

// User = Superclass-name
// User kế thừa các tính chất, thuộc tính từ BaseEntity
public class User extends BaseEntity {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
