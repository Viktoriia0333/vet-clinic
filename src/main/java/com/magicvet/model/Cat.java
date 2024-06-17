package main.java.com.magicvet.model;

public class Cat extends Pet{

    public Cat(){ }

    public Cat(int age, HealthState healthState){
        super.setAge(age);
        super.setHealthState(healthState);
    }

}
