import java.util.ArrayList;

public class Ship {
    private ArrayList<String> _locations = new ArrayList<String>();
    private String _name;

    public void setName(String name) {
        _name = name;
    }

    public void setLocationCell(ArrayList<String> locations) {
        _locations = locations;
    }

    public String checkYourSelf(String userInput) {
        String result = "past";
        int location = _locations.indexOf(userInput);
        if (location >= 0) {
            _locations.remove(location);

            if (_locations.isEmpty()) {
                result = "bust";
                System.out.println("You've bust the " + _name + " ship");
            } else {
                System.out.println("Hit!");
                result = "hit";
            }
        }
        return result;
    }
}