package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Cat;
import main.java.com.magicvet.model.Client;
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
        System.out.println("Your pet`s health state (notBad / Bad / veryBad / critical): ");
        Pet.HealthState healthState;
        String healthInput = Main.SCANNER.nextLine();
        try{
            healthState = Pet.HealthState.valueOf(healthInput);
        }catch (IllegalArgumentException e){
            healthState = Pet.HealthState.UNKNOWN;
            System.out.println("Unable to pars value '"+healthInput
                    +"'. Using default value: "+ Pet.HealthState.UNKNOWN);
        }
        pet.setHealthState(healthState);
        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());
        System.out.print("Age:");
        pet.setAge(Main.SCANNER.nextInt());
        Main.SCANNER.nextLine();
        System.out.print("Gender: ");
        pet.setGender(Main.SCANNER.nextLine());
        if(type.equals(dog_type)){
            System.out.println("Size (XS / S / M / L / XL): ");
            Dog.Size size;
            String sizeInput = Main.SCANNER.nextLine();
            try{
                size = Dog.Size.valueOf(sizeInput);
            }catch (IllegalArgumentException e){
                size = Dog.Size.UNKNOWN;
                System.out.println("Unable to pars value '"+sizeInput
                        +"'. Using default value: "+ Client.Location.UNKNOWN);
            }
            ((Dog) pet).setSize(size);
        }
        return pet;
    }

}
