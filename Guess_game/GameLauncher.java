class Player {
    int guess = -1;

    public void Guess() {
        guess = (int)(Math.random() * 10);
        System.out.println("I think this number is: " + guess);
    }
}

public class GameLauncher {
    public static void main(String args[]) {
        GuessGame gg = new GuessGame();
        gg.StartGame();
    }
}