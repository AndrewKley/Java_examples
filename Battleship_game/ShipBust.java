import java.util.ArrayList;

public class ShipBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<Ship> shipList = new ArrayList<Ship>();
    private int numOfGuess = 0;

    public static void main(String[] args)  {
        ShipBust battleShip = new ShipBust();
        battleShip.setUpGame();
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

    }

    private void checkUserGuess() {

    }

    private void finish() {

    }
}