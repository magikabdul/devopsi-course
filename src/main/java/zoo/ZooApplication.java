package zoo;

import zoo.animal.Animal;
import zoo.animal.Dog;
import zoo.animal.Fish;
import zoo.animal.Snake;
import zoo.animal.Speakable;

import java.util.List;
import java.util.stream.Collectors;

import static zoo.animal.AnimalType.AMPHIBIAN;
import static zoo.animal.AnimalType.MAMMAL;
import static zoo.animal.AnimalType.REPTILE;

public class ZooApplication {

    public static void main(String[] args) {

        Zoo zoo = new Zoo("Warszawa", 1928);

        Animal animal1 = new Animal("Frog", 2010, AMPHIBIAN);
        Animal animal2 = new Animal("Lizard", 1999, REPTILE);
        Animal animal3 = new Animal("Aligator", 1990, REPTILE);
        Animal animal4 = new Animal("Elephant", 1985, MAMMAL);
        Animal animal5 = new Snake("Python", 2013, false);
        Animal animal6 = new Snake("Cobra", 2011, true);
        Animal animal7 = new Dog("Husky", 2019, true);
        Animal animal8 = new Dog("York", 2021, false);
        Animal animal9 = new Fish("Shark", 2002, false);
        Animal animal10 = new Fish("Trout", 2012, true);

        zoo.addAnimal(animal1);
        zoo.addAnimal(animal2);
        zoo.addAnimal(animal3);
        zoo.addAnimal(animal4);
        zoo.addAnimal(animal5);
        zoo.addAnimal(animal6);
        zoo.addAnimal(animal7);
        zoo.addAnimal(animal8);
        zoo.addAnimal(animal9);
        zoo.addAnimal(animal10);

        List<Speakable> speakableAnimals;
        speakableAnimals = zoo.getAnimals()
                .stream()
                .filter(animal -> !Animal.class.equals(animal.getClass()))
                .collect(Collectors.toList());

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

        System.out.println("\nAnimals sounds:");
        speakableAnimals.forEach(Speakable::sound);
    }
}
