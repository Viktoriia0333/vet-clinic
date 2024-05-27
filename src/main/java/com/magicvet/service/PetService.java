package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Pet;

public class PetService {
    private static String dog_type = "dog";

    public Pet registerNewPet(){
        Pet pet = new Pet();
        System.out.print("Type (Dog / Cat / Other): ");
        String type = Main.SCANNER.nextLine();
        pet.setType(type);
        if (dog_type.equals(type)){
            pet = buildDog();
        }else{
            pet = buildPet(type);
        }
        return pet;
    }

    private Dog buildDog() {
        Pet pet = buildPet(dog_type);
        Dog dog = pettoDog(pet);
        System.out.println("Size (xs / s / m / l / xxl): ");
        dog.setSize(Main.SCANNER.nextLine());
        return dog;

    }

    private Dog pettoDog(Pet pet) {
        Dog dog = new Dog();
        dog.setName(pet.getName());
        dog.setAge(pet.getAge());
        dog.setGender(pet.getGender());
        return dog;
    }

    private Pet buildPet(String type){
        Pet pet = new Pet();
        pet.setType(type);
        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());
        System.out.print("Age:");
        pet.setAge(Main.SCANNER.nextLine());
        System.out.print("Gender: ");
        pet.setGender(Main.SCANNER.nextLine());
        System.out.print("Owner Name: ");
        pet.setOwnerName(Main.SCANNER.nextLine());
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
