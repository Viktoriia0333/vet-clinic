package main.java.com.magicvet.model;

import java.util.Objects;

public abstract class Pet {
    private HealthState healthState;
    private String type;
    private String gender;
    private int age;
    private String name;
    private String ownerName;

    @Override
    public String toString(){
        return "\nType: " + type
                +", name: " + name
                +", age: " + age
                +", gender: " + gender
                +", health state: " + healthState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(type, pet.type)
                && Objects.equals(gender, pet.gender)
                && Objects.equals(age, pet.age)
                && Objects.equals(name, pet.name)
                && Objects.equals(ownerName, pet.ownerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, gender, age, name, ownerName);
    }

    public void setHealthState(HealthState healthState) {
        this.healthState = healthState;
    }

    public HealthState getHealthState() {
        return healthState;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }
    public enum HealthState{
        notBad(1),
        Bad(2),
        veryBad(3),
        critical(4);
        private final int healthValue;
        HealthState(int value){
            this.healthValue = value;
        }

        public int getHealthValue() {
            return healthValue;
        }
    }
}
