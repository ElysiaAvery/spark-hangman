import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class HangmanTest {

  @Test
  public void constructor_CheckObjectInstantion_true() {
    Hangman testObject = new Hangman();
    boolean expectedOutput = true;
    assertEquals(expectedOutput, testObject instanceof Hangman);
  }

  @Test
  public void getGuessedCharacters_returnsArrayListOfGuessedCharactersForGame_ArrayList(){
    Hangman testObj = new Hangman();
    List<Character> expectedOutput = new ArrayList<Character>();
    expectedOutput.add('a');
    testObj.guessCharacter('a');
    assertEquals(expectedOutput, testObj.getGuessedCharacters());
  }

  @Test
  public void getHiddenWord_returnsInitialHiddenWord_charArray() {
    Hangman testObj = new Hangman();
    assertEquals('-', testObj.getHiddenWord()[0]);
  }

  @Test
  public void getGuessesLeft_returnsRemaingGuessCount_int() {
    Hangman testObj = new Hangman();
    assertEquals(5, testObj.getGuessesLeft());
  }

  @Test
  public void winCheck_returnsWinner_boolean() {
    Hangman testObj = new Hangman();
    testObj.setHangmanWord("a");
    testObj.guessCharacter('a');
    assertEquals(true, testObj.winCheck());
  }

  @Test
  public void loseCheck_returnsLoser_boolean() {
    Hangman testObj = new Hangman();
    testObj.setHangmanWord("a");
    testObj.guessCharacter('e');
    testObj.guessCharacter('e');
    testObj.guessCharacter('e');
    testObj.guessCharacter('e');
    testObj.guessCharacter('e');
    testObj.guessCharacter('e');
    assertEquals(true, testObj.loseCheck());    
  }
}
