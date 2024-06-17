package main.java.com.magicvet.model;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Client {
    private static final DateTimeFormatter clientFORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String email;
    private String FirstName;
    private String LastName;
    private Pet pet;
    private final LocalDate registrationDate = LocalDate.now();

    @Override
    public String toString(){
        //if pet is not null -> print with pet information
        return pet != null ?"Client:\nFirst name: "+ FirstName
                +", last name: "+ LastName
                +", email: "+ email
                +", registration date: " + registrationDate
                +"\nPet: " + pet
                //else print that client don`t have pet yet
                :
                "Client:\nFirst name: "+ FirstName
                +", last name: "+ LastName
                +", email: "+ email
                +", registration date: " + registrationDate.format(clientFORMATTER)
                +"\nHas no registered pet yet.";
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
