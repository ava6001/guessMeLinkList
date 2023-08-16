package guessme;

/**
 * A LinkedList-based implementation of the Guess-A-Number game.
 */

public class LinkedListGame {

  // TODO: declare data members as necessary


  /********************************************************
   * NOTE: for this project you must use linked lists
   * implemented by yourself. You are NOT ALLOWED to use
   * Java arrays of any type, or any class in the java.util
   * package (such as ArrayList).
   *******************************************************/

  /********************************************************
   * NOTE: you are allowed to add new methods if necessary,
   * but DO NOT remove any provided method, and do NOT add
   * new files (as they will be ignored by the autograder).
   *******************************************************/
  private int guess;
  private LLIntegerNode head;
  private LLIntegerNode pointer;
  private LLIntegerNode headGuess;
  private int numGuess;
  private boolean over;

  // LinkedListGame constructor method
  public LinkedListGame() {
    // TODO
    numGuess = 0;
    over = false;
    guess = 1000;
    head = null;
    pointer = null;
    headGuess = null;
    for (int i = 9999; i >= 1000; i--) {
      pointer = new LLIntegerNode(i, null);
      pointer.setLink(head);
      head = pointer;
    }
  }

  /** Resets data members and game state so we can play again.
   * 
   */
  
  public void reset() {
    // TODO
    numGuess = 0;
    over = false;
    guess = 1000;
    head = null;
    pointer = null;
    headGuess = null;
    for (int i = 9999; i >= 1000; i--) {
      pointer = new LLIntegerNode(i, null);
      pointer.setLink(head);
      head = pointer;
    }
  }

  /** Returns true if n is a prior guess; false otherwise.
   * 
   */
  
  public boolean isPriorGuess(int n) {
    // TODO
    LLIntegerNode tmp = headGuess;
    while (tmp != null) {
      if (n == tmp.getInfo()) {
        return true;
      }   
      tmp = tmp.getLink();
    }
    return false;
  }

  /** Returns the number of guesses so far.
   * 
   */
  
  public int numGuesses() {
    // TODO
    return numGuess;
  }

  /**
   * Returns the number of matches between integers a and b.
   * You can assume that both are 4-digits long (i.e. between 1000 and 9999).
   * The return value must be between 0 and 4.
   * 
   * <p>A match is the same digit at the same location. For example:
   *   1234 and 4321 have 0 match;
   *   1234 and 1114 have 2 matches (1 and 4);
   *   1000 and 9000 have 3 matches (three 0's).
   */
  
  public static int numMatches(int a, int b) {
    // TODO
    int num = 0;
    for (int i = 1; i <= a; i = i * 10) {
      if ((a / i) % 10 == (b / i) % 10) {
        num++;
      }
    }
    return num;
  }

  /**
   * Returns true if the game is over; false otherwise.
   * The game is over if the number has been correctly guessed
   * or if no candidate is left.
   */
  
  public boolean isOver() {
    // TODO
    return over;
  }

  /**
   * Returns the guess number and adds it to the list of prior guesses.
   * The insertion should occur at the end of the prior guesses list,
   * so that the order of the nodes follow the order of prior guesses.
   */
  
  public int getGuess() {
    // TODO: add guess to the list of prior guesses.
    LLIntegerNode tmp = headGuess;
    if (headGuess == null) {
      tmp = new LLIntegerNode(guess, headGuess);
      headGuess = tmp;
    }
    else {
      while (tmp.getLink() != null) {
        tmp = tmp.getLink();
      }
      LLIntegerNode in = new LLIntegerNode(guess, null);
      tmp.setLink(in);
    }
    numGuess++;
    return guess;
  }

  /**
   * Updates guess based on the number of matches of the previous guess.
   * If nmatches is 4, the previous guess is correct and the game is over.
   * Check project description for implementation details.
   * 
   * <p>Returns true if the update has no error; false if no candidate 
   * is left (indicating a state of error);
   */
  
  public boolean updateGuess(int nmatches) {
    // TODO
    LLIntegerNode tmp = head;
    LLIntegerNode hape = null;
    boolean finish = false;
    if (nmatches == 4) {
      over = true;
      finish = true;
    }
    else {
      while (tmp != null) {
        if (numMatches(tmp.getInfo(), guess) == nmatches) {
          if (hape == null) {
            hape = new LLIntegerNode(tmp.getInfo(), null);
            finish = true;

          }
          else {
            LLIntegerNode now = hape;
            while (now.getLink() != null) {
              now = now.getLink();
            }
            LLIntegerNode in = new LLIntegerNode(tmp.getInfo(), null);
            now.setLink(in);
            finish = true;
          }

        }       
        tmp = tmp.getLink();

      }
      if (hape == null) {
        finish = false;
      }
      else {
        guess = hape.getInfo();
      }
    }
    head = hape; 
    return finish;
  }

  /**
   *  Returns the head of the prior guesses list.
   *  Returns null if there hasn't been any prior guess
   */
  
  public LLIntegerNode priorGuesses() {
    // TODO
    if (headGuess == null) {
      return null;
    }
    else {
      return headGuess;
    }   
  }

  /**
   * Returns the list of prior guesses as a String. For example,
   * if the prior guesses are 1000, 2111, 3222, in that order,
   * the returned string should be "1000, 2111, 3222", in the same order,
   * with every two numbers separated by a comma and space, except the
   * last number (which should not be followed by either comma or space).
   *
   * <p>Returns an empty string if here hasn't been any prior guess
   */
  
  public String priorGuessesString() {
    // TODO
    String kong = "";
    if (headGuess == null) {
      return kong;
    }
    else {
      LLIntegerNode tmp;
      tmp = headGuess;   
      while (tmp != null) {     
        if (tmp.getLink() == null) {
          kong = kong + tmp.getInfo();
        }
        else {
          kong = kong + tmp.getInfo() + ", ";
        }
        tmp = tmp.getLink();
      }
    }
    return kong;
  }

}
