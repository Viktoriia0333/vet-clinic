package main.java.com.magicvet.model;

import java.util.Objects;

public class Client {
    private String email;
    private String FirstName;
    private String LastName;
    private Pet pet;

    @Override
    public String toString(){
        return "Client\n{First name: "+FirstName
                +", last name: "+LastName
                +", email: "+email
                +"}"
                +"\nPet: "+ pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(email, client.email)
                && Objects.equals(FirstName, client.FirstName)
                && Objects.equals(LastName, client.LastName)
                && Objects.equals(pet, client.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, FirstName, LastName, pet);
    }

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
