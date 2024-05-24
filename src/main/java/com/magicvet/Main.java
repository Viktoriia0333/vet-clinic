package main.java.com.magicvet;

import java.util.Scanner;

public class Main {
    static String password ="default";
    static Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        run();
    }

    static void run(){
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
    }
}