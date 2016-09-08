import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {
  private String[] randomWords = {"gator", "glass", "jazz", "octane", "oxygen", "gasoline", "chestful", "interlaid", "ungulate", "onychectomy", "pissant", "propitious"};
  private List<Character> guessedCharacters = new ArrayList<Character>();
  private String hangmanWord;
  private char[] hiddenWord;
  private int guessesLeft;

  public Hangman() {
    guessesLeft = 5;
    Random randomWordIndex = new Random();
    hangmanWord = randomWords[randomWordIndex.nextInt(randomWords.length)];
    hiddenWord = new char[hangmanWord.length()];
    for (int i = 0; i < hiddenWord.length; i++) {
      hiddenWord[i] = '-';
    }
  }

  public void setHangmanWord(String word) {
    hangmanWord = word;
    hiddenWord = new char[hangmanWord.length()];
    for (int i = 0; i < hiddenWord.length; i++) {
      hiddenWord[i] = '-';
    }
  }

  public void guessCharacter(char guess) {
    guessedCharacters.add(guess);
    if (hangmanWord.contains(String.valueOf(guess))){
      for (int i = 0; i < hangmanWord.length(); i++) {
        if (hangmanWord.charAt(i) == guess)
          hiddenWord[i] = guess;
      }
    } else {
      guessesLeft --;
    }
  }

  public List<Character> getGuessedCharacters() {
    return guessedCharacters;
  }

  public char[] getHiddenWord() {
    return hiddenWord;
  }

  public String getHangmanWord() {
    return hangmanWord;
  }

  public int getGuessesLeft() {
    return guessesLeft;
  }

  public boolean winCheck() {
    for (int i = 0; i < hiddenWord.length; i++) {
      if (hiddenWord[i] == '-') {
        return false;
      }
    }
    return true;
  }

  public boolean loseCheck() {
    if (guessesLeft <= 0) {
      return true;
    } else {
      return false;
    }
  }
}
