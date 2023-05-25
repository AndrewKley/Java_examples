import java.util.ArrayList;

public class ShipBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<Ship> shipList = new ArrayList<Ship>();
    private int numOfGuess = 0;

    public static void main(String[] args)  {
        ShipBust battleShip = new ShipBust();
        battleShip.setUpGame();
        battleShip.startPlaying();
    }

    private void setUpGame() {
        Ship pet = new Ship();
        pet.setName("Pet");
        Ship bob = new Ship();
        bob.setName("Bob");
        Ship gow = new Ship();
        gow.setName("Gow");
        shipList.add(pet);
        shipList.add(bob);
        shipList.add(gow);

        for (Ship shipToSet : shipList) {
            ArrayList<String> locations = helper.getPlaceShip(3);
            shipToSet.setLocationCell(locations);
        }
    }

    private void startPlaying() {
        while (!shipList.isEmpty()) {
            String userGuess = helper.getUserInput("Make a move");
            checkUserGuess(userGuess);
        }
        finish();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuess++;
        String result = "past";
        for (Ship ship : shipList) {
            result = ship.checkYourSelf(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("bust")) {
                shipList.remove(ship);
                break;
            }
        }
        System.out.println(result);
    }

    private void finish() {
        System.out.println("End of the game");
        if (numOfGuess <= 18) {
            System.out.println("It took you: " + numOfGuess + " attemp");
        } else {
            System.out.println("It took you a long time: " + numOfGuess + " ...");
        }
    }
}