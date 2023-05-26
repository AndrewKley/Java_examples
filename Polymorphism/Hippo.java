public class Hippo extends Animals {
    public Hippo(FoodType foodType, Location location) {
        super(foodType, location);
    }

    public void makeNoise() {
        System.out.println("Hello brother");
    }

    public void eat() {
        System.out.println("Omnom nom");
    }
}
