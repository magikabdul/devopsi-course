package zoo.animal;

import static zoo.animal.AnimalType.FISH;

public class Fish extends Animal{
    private boolean isFreshWater;

    public Fish(String name, int yearOfBirth, boolean isFreshWater) {
        super(name, yearOfBirth, FISH);
        this.isFreshWater = isFreshWater;
    }

    public boolean isFreshWater() {
        return isFreshWater;
    }

    public void setFreshWater(boolean freshWater) {
        isFreshWater = freshWater;
    }

    @Override
    public void sound() {
        System.out.println("Makes no sound");
    }
}
