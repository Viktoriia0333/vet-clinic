package main.java.com.magicvet.comparator;

import java.util.Comparator;
import main.java.com.magicvet.model.Dog;

public class DogSizeComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog dog1, Dog dog2) {
        return convertSize(dog1.getSize()) - convertSize(dog2.getSize());
    }
    private static int convertSize(String size){
        return switch (size){
            case Dog.xs -> 1;
            case Dog.s -> 2;
            case Dog.m -> 3;
            case Dog.l -> 4;
            case Dog.xxl -> 5;
            default -> 0;
        };
    }
}
