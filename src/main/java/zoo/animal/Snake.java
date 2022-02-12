package zoo.animal;

import static zoo.animal.AnimalType.REPTILE;

public class Snake extends Animal {
    private boolean isPoisonous;

    public Snake(String name, int yearOfBirth, boolean isPoisonous) {
        super(name, yearOfBirth, REPTILE);
        this.isPoisonous = isPoisonous;
    }

    public boolean isPoisonous() {
        return isPoisonous;
    }

    public void setPoisonous(boolean poisonous) {
        isPoisonous = poisonous;
    }

    @Override
    public void sound() {
        System.out.println("tssss");
    }
}
