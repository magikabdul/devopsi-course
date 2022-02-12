package zoo.animal;

import java.util.Objects;

public class Animal implements Speakable{
    private String name;
    private int yearOfBirth;
    private AnimalType type;

    private static final int CURRENT_YEAR = 2022;

    public Animal(String name, int yearOfBirth, AnimalType type) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.type = type;
    }

    public int getAnimalAge() {
        return CURRENT_YEAR - yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public AnimalType getType() {
        return type;
    }

    public void setType(AnimalType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return yearOfBirth == animal.yearOfBirth && name.equals(animal.name) && type == animal.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfBirth, type);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", type=" + type +
                '}';
    }

    @Override
    public void sound() {
        System.out.println("wrrr");
    }
}
