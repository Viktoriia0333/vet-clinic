package main.java.com.magicvet;

import main.java.com.magicvet.model.Dog;
import main.java.com.magicvet.model.Cat;

import java.util.Arrays;
import java.util.Comparator;

public class SandBox {
    public static void main(String[] args){
        Dog[] dogs = {
                new Dog(Dog.Size.M, 15, Dog.HealthState.Bad),
                new Dog(Dog.Size.UNKNOWN,6, Dog.HealthState.notBad),
                new Dog(Dog.Size.XS,8, Dog.HealthState.critical),
                new Dog(Dog.Size.S,3, Dog.HealthState.notBad),
                new Dog(Dog.Size.L,1,Dog.HealthState.veryBad),
                new Dog(Dog.Size.XL,4, Dog.HealthState.veryBad),
        };
        Cat[] cats = {
                new Cat(15, Cat.HealthState.Bad),
                new Cat( 10, Cat.HealthState.critical),
                new Cat(7, Cat.HealthState.notBad),
                new Cat(5, Cat.HealthState.Bad),
        };

        //sort dogs by health
        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o2.getHealthState().getHealthValue()-o1.getHealthState().getHealthValue();
            }
        });

        System.out.println("sort dogs by health state: ");

        for(Dog dog: dogs){
            System.out.println(dog);
        }

        //sort cats by health
        Arrays.sort(cats, new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o2.getHealthState().getHealthValue()-o1.getHealthState().getHealthValue();
            }
        });

        System.out.println("sort cats by health: ");

        for(Cat cat: cats){
            System.out.println(cat);
        }

        //sort dogs by size

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getSize().getValue()-o2.getSize().getValue();
            }
        });

        System.out.println("sort dogs by size");
        for(Dog dog: dogs){
            System.out.println(dog);
        }
    }
}
