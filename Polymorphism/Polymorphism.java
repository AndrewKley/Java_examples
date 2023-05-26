public class Polymorphism {
    public static void main(String[] args) {
        Animals[] animals = new Animals[5];
        animals[0] = new Lion(FoodType.MEAT, new Location(1, 2));
        animals[1] = new Wolf(FoodType.MEAT, new Location(100, 500));
        animals[2] = new Dog(FoodType.ALL, new Location(-32, 10));
        animals[3] = new Cat(FoodType.MEAT, new Location(12, -3));
        animals[4] = new Hippo(FoodType.ALL, new Location(-56, -1));

        for (Animals a : animals) {
            System.out.println(a.getFoodType() + " " + a.getLocation().getX());
        }
    }
}
