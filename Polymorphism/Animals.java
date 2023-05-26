enum FoodType {
    MEAT,
    GRASS,
    ALL
}

class Location {
    private int _x;
    private int _y;

    public Location (int x, int y) {
        _x = x;
        _y = y;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }
}

public abstract class Animals {
    private FoodType _foodType;
    private Location _location;

    public Animals (FoodType foodType, Location location) {
        _foodType = foodType;
        _location = location;
    }

    public FoodType getFoodType() {
        return _foodType;
    }

    public Location getLocation() {
        return _location;
    }

    public abstract void makeNoise();

    public void sleep() {
        System.out.println("Lies and snores");
    }
}
