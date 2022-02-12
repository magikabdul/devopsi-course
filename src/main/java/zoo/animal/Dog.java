package zoo.animal;

import static zoo.animal.AnimalType.MAMMAL;

public class Dog extends Animal{
    private boolean needsLargeSpaces;

    public Dog(String name, int yearOfBirth, boolean needsLargeSpaces) {
        super(name, yearOfBirth, MAMMAL);
        this.needsLargeSpaces = needsLargeSpaces;
    }

    public boolean isNeedsLargeSpaces() {
        return needsLargeSpaces;
    }

    public void setNeedsLargeSpaces(boolean needsLargeSpaces) {
        this.needsLargeSpaces = needsLargeSpaces;
    }

    @Override
    public void sound() {
        System.out.println("hau hau");
    }
}
