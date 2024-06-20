package main.java.com.magicvet.service;
import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {
    private static final String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String namesPattern = "^[a-zA-Z-_]{3,}$";
    public Optional<Client> registerNewClient() {
        Client client = null;
        System.out.println("Please, provide client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();
        if(emailValid(email)){
            client = buildClient(email);
            System.out.println("New client: " + client.getFirstName() + " " + client.getLastName()
                            + " " + "(" + client.getEmail() + ").");
        }else{
            System.out.println("Email is invalid");
        }
        return Optional.ofNullable(client);
    }

    static boolean emailValid(String email){
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    static boolean isFirstNameValid(String FirstName) {
        Pattern firstNamePattern = Pattern.compile(namesPattern);
        Matcher firstName_matcher = firstNamePattern.matcher(FirstName);
        return firstName_matcher.matches();
    }
    static boolean isLastNameValid(String LastName){
        Pattern lastNamePattern = Pattern.compile(namesPattern);
        Matcher lastName_matcher = lastNamePattern.matcher(LastName);
        return lastName_matcher.matches();
    }

    static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);
        System.out.print("First Name: ");
        String FirstName = Main.SCANNER.nextLine();
        if(isFirstNameValid(FirstName)){
            client.setFirstName(FirstName);
            System.out.print("Last Name: ");
            String LastName = Main.SCANNER.nextLine();
            if(isLastNameValid(LastName)) {
                client.setLastName(LastName);
            }else{
                System.out.println("Invalid last name");
            }
        }else{
            System.out.println("Invalid first name");
        }
        System.out.println("Location: ");

        Client.Location location;
        String locationInput = Main.SCANNER.nextLine();
        try{
            location = Client.Location.valueOf(locationInput);
        }catch (IllegalArgumentException e){
            location = Client.Location.UNKNOWN;
            System.out.println("Unable to pars value '"+locationInput
                    +"'. Using default value: "+Client.Location.UNKNOWN);
        }

        client.setLocation(location);
        return client;
    }
}
