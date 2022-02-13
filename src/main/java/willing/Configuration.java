package willing;

import zoo.Zoo;
import zoo.animal.Animal;
import zoo.animal.Dog;
import zoo.animal.Fish;
import zoo.animal.Snake;

public class Configuration {

    private final Animal animal5 = new Snake("Python", 2013, false);
    private final Animal animal6 = new Snake("Cobra", 2011, true);
    private final Animal animal7 = new Dog("Husky", 2019, true);
    private final Animal animal8 = new Dog("York", 2021, false);
    private final Animal animal9 = new Fish("Shark", 2002, false);
    private final Animal animal10 = new Fish("Trout", 2012, true);

    public Zoo createInitialZooKrakow() {
        Zoo zoo = new Zoo("Krakow", 1929);

        zoo.addAnimal(animal5);
        zoo.addAnimal(animal6);
        zoo.addAnimal(animal7);
        zoo.addAnimal(animal8);
        zoo.addAnimal(animal9);
        zoo.addAnimal(animal10);

        return zoo;
    }
}
