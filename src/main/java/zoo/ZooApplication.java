package zoo;

import static zoo.AnimalType.AMPHIBIAN;
import static zoo.AnimalType.MAMMAL;
import static zoo.AnimalType.REPTILE;

public class ZooApplication {

    public static void main(String[] args) {

        Zoo zoo = new Zoo("Warszawa", 1928);

        Animal animal1 = new Animal("Frog", 2010, AMPHIBIAN);
        Animal animal2 = new Animal("Lizard", 1999, REPTILE);
        Animal animal3 = new Animal("Aligator", 1990, REPTILE);
        Animal animal4 = new Animal("Elephant", 1985, MAMMAL);

        zoo.addAnimal(animal1);
        zoo.addAnimal(animal2);
        zoo.addAnimal(animal3);
        zoo.addAnimal(animal4);

        System.out.println("Zoo details:");
        zoo.showInfo();

        System.out.println("\nTotal number of all animals in zoo: " + zoo.countAnimals());

        System.out.println("\nList of all animals:");
        zoo.showAnimals();

        System.out.println("\nList of all animals by names:");
        zoo.getAnimals()
                .stream()
                .map(Animal::getName)
                .forEach(System.out::println);

        System.out.println("\nList of all animals born before 1995:");
        zoo.getAnimals()
                .stream()
                .filter(animal -> animal.getYearOfBirth() <= 1995)
                .forEach(System.out::println);

        System.out.println("\nList of all mammals:");
        zoo.getAnimals()
                .stream()
                .filter(animal -> animal.getType().equals(MAMMAL))
                .forEach(System.out::println);
    }


}
