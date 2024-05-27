package main.java.com.magicvet.model;

public class Client {
    private String email;
    private String FirstName;
    private String LastName;
    private Pet pet;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }
}
