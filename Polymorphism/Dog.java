public class Dog extends Animals implements Pet, Robot {
    public Dog(FoodType foodType, Location location) {
        super(foodType, location);
    }

    public void makeNoise() {
        System.out.println("Gav");
    }

    public void smile() {
        System.out.println("what's up");
    }

    public void getUp() {
        System.out.println("Scary sounds");
    }
}
