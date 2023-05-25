import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridSize = 49;
    private int shipCount = 0;
    private int gridLength = 7;
    private int[] grid = new int[gridSize];

    public String getUserInput(String prompt) {
        String line = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            line = is.readLine();
            if (line.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return line.toLowerCase();
    }

    public ArrayList<String> getPlaceShip(int shipSize) {
        boolean success = false;
        int attempts = 0;
        int location = 0;
        int[] coords = new int[shipSize];
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphaCoords = new String[shipSize];
        String temp = null;

        shipCount++;
        int incrementToX = 1;
        if ((shipCount % 2) == 1) {
            incrementToX = gridLength;
        }

        while (!success & attempts++ < 200) {
            location = (int)(Math.random() * gridSize);
            int x = 0;
            success = true;
            while (success && x < shipSize) {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incrementToX;
                    if (location >= gridSize) {
                        success = false;
                    }
                    if (x > 0 && (location % gridLength) == 0) {
                        success = false;
                    }
                } else {
                    success = false;
                }
            }
        }

        int x = 0, row = 0, col = 0;

        while (x < shipSize) {
            grid[coords[x]] = 1;
            row = (int)(coords[x] / gridLength);
            col = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(col));

            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
        }

        return alphaCells;
    }
}