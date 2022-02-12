package zoo;

import zoo.animal.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Zoo {
    private final String name;
    private final int yearOfEstablishment;
    private final List<Animal> animals;

    public Zoo(String name, int yearOfEstablishment) {
        this.name = name;
        this.yearOfEstablishment = yearOfEstablishment;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void showAnimals() {
        animals.forEach(System.out::println);
    }

    public int countAnimals() {
        return animals.size();
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void showInfo() {
        System.out.println("Zoo: " + name);
        System.out.println("Year of establishment: " + yearOfEstablishment);
        System.out.println("Average year of all animals: " + avgAge());
    }

    private double avgAge() {
        Optional<Integer> ageSum = animals.stream().map(Animal::getAnimalAge).reduce(Integer::sum);

        return ageSum.map(integer -> integer / animals.size()).orElse(0);
    }
}
