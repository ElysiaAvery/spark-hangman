import java.io.Console;

public class App {
  public static void main(String[] args) {
    Console consoleObj = System.console();
    System.out.println("Would you like to play 1 or 2 player (enter 1 or 2): ");
    int reception = Integer.parseInt(consoleObj.readLine());
    Hangman gameObj = new Hangman();
    if (reception == 2) {
      System.out.println("Player 2 enter a word to be guessed: ");
      String playerWord = String.valueOf(consoleObj.readLine());
      gameObj.setHangmanWord(playerWord);
      for (int i = 0; i < 500; i++) {
        System.out.println("\n");
      }
    }
    while (!gameObj.winCheck() && !gameObj.loseCheck()) {
      System.out.println("Player 1, guess a letter: ");
      String guess = consoleObj.readLine();
      gameObj.guessCharacter(guess.charAt(0));
      System.out.println("Past guesses: " + gameObj.getGuessedCharacters());
      System.out.println("Guesses left: " + gameObj.getGuessesLeft());
      System.out.println(gameObj.getHiddenWord());
    }
    if(gameObj.loseCheck()){
      System.out.println("You're a loser");
      System.out.println(gameObj.getHangmanWord());
    } else {
      System.out.println("You're a winner");
    }
  }
}
