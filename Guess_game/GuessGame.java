public class GuessGame {
    Player p1, p2, p3;

    public void StartGame() {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        
        int targetNumber = (int)(Math.random() * 10);

        while(true) {
            System.out.println("I make a number: " + targetNumber);

            p1.Guess();
            p2.Guess();
            p3.Guess();

            System.out.println("The first player is thinking about number: " + p1.guess);
            System.out.println("The second player is thinking about number: " + p2.guess);
            System.out.println("The third player is thinking about number: " + p3.guess);

            Boolean isRightP1 = p1.guess == targetNumber;
            Boolean isRightP2 = p2.guess == targetNumber;
            Boolean isRightP3 = p3.guess == targetNumber;

            if (isRightP1) {
                System.out.println("The first player guessed!");
            }
            if (isRightP2) {
                System.out.println("The second player guessed!");
            }
            if (isRightP3) {
                System.out.println("The third player guessed!");
            }
            if (isRightP1 || isRightP2 || isRightP3) {
                System.out.println("End of the game");
                break;
            } else {
                System.out.println("Players should repeat");
            }
        }
    }
}