package Client.Model;

import java.io.Serializable;

public abstract class User implements Serializable {
    private String firstName;
    private String lastName;
    private final String email;
    private String password;
    private int birthyear;

    public User(String firstName, String lastName, String email, String password, int birthyear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthyear = birthyear;
    }
//Change password

    public void changePassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public String getEmail() {
        return email;
    }
}
