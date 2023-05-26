public class Cat extends Animals implements Pet {
    public Cat(FoodType foodType, Location location) {
        super(foodType, location);
    }

    public void makeNoise() {
        System.out.println("Hello");
    }

    public void smile() {
        System.out.println("Show teeth");
    }
}
