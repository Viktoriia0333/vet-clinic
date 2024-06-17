package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

public class PetService {
    private final static String dog_type = "dog";
    private final static String cat_type = "cat";

    public Pet registerNewPet(){
        Pet pet = null;
        System.out.print("Type (Dog / Cat): ");
        String type = Main.SCANNER.nextLine();
        if (dog_type.equals(type) || cat_type.equals(type)){
            pet = buildPet(type);
        }else{
            System.out.println("Unknown pet type "+type);
        }
        return pet;
    }

    private Pet buildPet(String type){
        Pet pet = type.equals(cat_type) ? new Cat() : new Dog();
        pet.setType(type);
        System.out.println("Your pet`s health state (notBad / Bad(2) / veryBad(3) / critical): ");
        String healthState = Main.SCANNER.nextLine();
        pet.setHealthState(Pet.HealthState.valueOf(healthState));
        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());
        System.out.print("Age:");
        pet.setAge(Main.SCANNER.nextInt());
        Main.SCANNER.nextLine();
        System.out.print("Gender: ");
        pet.setGender(Main.SCANNER.nextLine());
        if(type.equals(dog_type)){
            System.out.println("Size (XS / S / M / L / XL): ");
            String size = Main.SCANNER.nextLine();
            ((Dog) pet).setSize(Dog.Size.valueOf(size));
        }
        return pet;
    }

    //function to ask client about adding pet after registration
    public static boolean addPetAfterRegister(){
        System.out.print("Do you want to add your pet now? (y/n): ");
        String input = Main.SCANNER.nextLine();
        if(input.equals("y")){
            return  true;
        }
        return false;
    }

}
