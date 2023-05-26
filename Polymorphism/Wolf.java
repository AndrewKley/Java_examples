public class Wolf extends Animals {
    public Wolf(FoodType foodType, Location location) {
        super(foodType, location);
    }

    public void makeNoise() {
        System.out.println("I think you ...");
    }
}
