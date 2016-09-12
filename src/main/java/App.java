import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";
    Hangman newHangman = new Hangman();

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/hangman.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      boolean playGame = true;
      while (playGame == true) {
        String guess = request.queryParams("letter-guess");
        char[] guessWord = newHangman.getHiddenWord();
        int guessTracker = newHangman.getGuessesLeft();
        List<Character> guessedLetters = new ArrayList<Character>();
        // guessedLetters.add(newHangman.getGuessedCharacters());
        newHangman.guessCharacter(guess.charAt(0));

        model.put("wordToBeGuessed", guessWord);
        model.put("guessTracker", guessTracker);
        model.put("guessedLetters", guessedLetters);
        model.put("template", "templates/hangman.vtl");
        if(newHangman.loseCheck()){
          playGame = false;
          get("/lose", (requestLose, responseLose) -> {
            Map<String, Object> modelLose = new HashMap<String, Object>();
            model.put("template", "templates/lose.vtl");
            // public class LoseResult {
            //   new ModelAndView(modelLose, layout);
            //   playGame == false;
            // }
            return new ModelAndView(modelLose, layout);//LoseResult();
          }, new VelocityTemplateEngine());
        } else if(newHangman.winCheck()){
          get("/win", (requestWin, responseWin) -> {
            Map<String, Object> modelWin = new HashMap<String, Object>();
            model.put("template", "templates/win.vtl");
            // public class WinResult {
            // new ModelAndView(modelLose, layout);
            // playGame == false;
            // }
            return new ModelAndView(modelWin, layout);//WinResult();
          }, new VelocityTemplateEngine());
        }
      }
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    // System.out.println("Would you like to play 1 or 2 player (enter 1 or 2): ");
    // int reception = Integer.parseInt(consoleObj.readLine());
    // Hangman gameObj = new Hangman();
    // if (reception == 2) {
    //   System.out.println("Player 2 enter a word to be guessed: ");
    //   String playerWord = String.valueOf(consoleObj.readLine());
    //   gameObj.setHangmanWord(playerWord);
    //   for (int i = 0; i < 500; i++) {
    //     System.out.println("\n");
    //   }
    // }
    // while (!gameObj.winCheck() && !gameObj.loseCheck()) {
    //   System.out.println("Player 1, guess a letter: ");
    //   String guess = consoleObj.readLine();
    //   gameObj.guessCharacter(guess.charAt(0));
    //   System.out.println("Past guesses: " + gameObj.getGuessedCharacters());
    //   System.out.println("Guesses left: " + gameObj.getGuessesLeft());
    //   System.out.println(gameObj.getHiddenWord());
    // }
    // if(gameObj.loseCheck()){
    //   System.out.println("You're a loser");
    //   System.out.println(gameObj.getHangmanWord());
    // } else {
    //   System.out.println("You're a winner");
    // }
  }
}
