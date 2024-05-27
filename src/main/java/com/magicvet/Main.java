package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String password ="default";
    static Scanner SCANNER = new Scanner(System.in);
    static String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String namesPattern = "^[a-zA-Z-_]{3,}$";
    public static void main(String[] args) {
        run();
    }

    static void run(){
        if(auth()){
            registerNewClient();
        }
    }

    static boolean auth(){
        boolean accepted = false;
        for(int i=0; i<3;i++){
            System.out.print("enter your password: ");
            String enteredPassword = SCANNER.nextLine();
            if(enteredPassword.equals(password)){
                accepted = true;
                break;
            }else {
                System.out.println("Wrong password");
            }
        }
        System.out.println(accepted? "Welcome to our clinic": "Application has been blocked");
        return accepted;
    }

    static void registerNewClient() {
        System.out.println("Please, provide client details.");
        System.out.print("Email: ");
        String email = SCANNER.nextLine();
        if(emailValid(email)){
            System.out.print("First Name: ");
            String FirstName = SCANNER.nextLine();
            if(isFirstNameValid(FirstName)){
                System.out.print("Last Name: ");
                String LastName = SCANNER.nextLine();
                if(isLastNameValid(LastName)) {
                    buildClient(email, FirstName, LastName);
                    System.out.println("New client: " + FirstName + " " + LastName + " " + "(" + email + ").");
                }else{
                    System.out.println("Invalid Last Name");
                }
            }else{
                System.out.println("Invalid first name");
            }
        }else{
            System.out.println("Email is invalid");
        }
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

    static boolean emailValid(String email){
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static Client buildClient(String email, String FirstName, String LastName) {
        Client client = new Client();
        client.email = email;
        client.FirstName = FirstName;
        client.LastName = LastName;
        return client;
    }
}