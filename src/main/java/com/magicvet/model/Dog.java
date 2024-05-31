package main.java.com.magicvet.model;

import java.util.Objects;

public class Dog extends Pet{
    public static final String xs = "xs";
    public static final String s = "s";
    public static final String m = "m";
    public static final String l = "l";
    public static final String xxl = "xxl";
    private String size;
    public Dog(){ }
    public Dog(String size, int age){
        this.size = size;
        super.setAge(age);
    }

    @Override
    public String toString() {
        return super.toString().concat(", size: "+size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
