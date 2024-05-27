package main.java.com.magicvet.component;

import main.java.com.magicvet.Main;

public class Authenticator {
    private static String password ="default";
    public static boolean auth(){
        boolean accepted = false;
        for(int i=0; i<3;i++){
            System.out.print("enter your password: ");
            String enteredPassword = Main.SCANNER.nextLine();
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
}
