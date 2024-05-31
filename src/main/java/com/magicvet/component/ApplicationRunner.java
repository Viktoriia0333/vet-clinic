package main.java.com.magicvet.component;

import main.java.com.magicvet.model.Client;
import main.java.com.magicvet.model.Pet;
import main.java.com.magicvet.service.ClientService;
import main.java.com.magicvet.service.PetService;

public class ApplicationRunner{
    private static final ClientService clientservice = new ClientService();
    private static final PetService petService = new PetService();
    public static void run(){
        if(Authenticator.auth()){
            Client client = clientservice.registerNewClient();

            if(client!=null){
                //if client want to add new pet
                if(PetService.addPetAfterRegister()){
                    System.out.println("Adding a new pet.");
                    //register new pet
                    Pet pet = petService.registerNewPet();
                    if(pet != null){
                        client.setPet(pet);
                        pet.setOwnerName(client.getFirstName()+ " "+ client.getLastName());
                        System.out.println("Pet has been added.");
                    }
                }else{
                    System.out.println("Registration finished.");
                }
                System.out.println(client);
            }
        }
    }
}
