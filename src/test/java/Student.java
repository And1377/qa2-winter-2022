public class Student {
    //----------------ATTRIBUTES
    private String fistName;
    private String lastName;
    private String email;
    private String phone;

    public Student() {

    }
//---------------- CONSTRUCTORS
    public Student(String fistName, String lastName, String email, String phone) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
//------------------------ GETTERS/SETTERS
    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    //----------------------- CUSTOM/METHODS
    public String getFullName() {
        return fistName + " " + lastName;
    }
}
