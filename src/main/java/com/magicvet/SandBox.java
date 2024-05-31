package main.java.com.magicvet;

import main.java.com.magicvet.comparator.DogAgeComparator;
import main.java.com.magicvet.comparator.DogSizeComparator;
import main.java.com.magicvet.model.Dog;

import java.util.Arrays;

public class SandBox {
    public static void main(String[] args){
        Dog[] dogs = {
                new Dog(Dog.m, 15),
                new Dog(Dog.s,6),
                new Dog(Dog.xs,8),
                new Dog(Dog.m,3),
                new Dog(Dog.l,1),
                new Dog(Dog.xxl,4),
        };

        Arrays.sort(dogs, new DogSizeComparator());

        System.out.println("By size: ");

        for(Dog dog: dogs){
            System.out.println(dog);
        }

        Arrays.sort(dogs, new DogAgeComparator());

        System.out.println("By age: ");

        for(Dog dog: dogs){
            System.out.println(dog);
        }

    }
}
