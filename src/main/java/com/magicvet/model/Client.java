package main.java.com.magicvet.model;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private static final DateTimeFormatter clientFORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String email;
    private String FirstName;
    private String LastName;
    private List<Pet> pets = new ArrayList<>();
    private final LocalDate registrationDate = LocalDate.now();

    @Override
    public String toString(){
        //if pet is not null -> print with pet information
        return pets != null ?"Client:\nFirst name: "+ FirstName
                +", last name: "+ LastName
                +", email: "+ email
                +", registration date: " + registrationDate
                +"\nPet: " + pets
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
                && Objects.equals(pets, client.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, FirstName, LastName, pets);
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

    public void setPet(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Pet> getPets() {
        return pets;
    }
    public void addPet(Pet pet){
        pets.add(pet);
    }
}
