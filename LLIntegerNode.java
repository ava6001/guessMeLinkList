package guessme;

/**
 * This class defines a linked list node storing an integer.
 * Use primitive type int (do not use wrapper class Integer)
 * You must provide the following methods:
 * - a constructor
 * - a setInfo method and a getInfo method
 * - a setLink method and a getLink method
 */

//ptr.setlink(ptr.getLink().getLink);
public class LLIntegerNode {
  // TODO
  private int num;
  private LLIntegerNode link;
  public LLIntegerNode(int a, LLIntegerNode b) {
    num = a;
    link = b;
  }
  public int getInfo() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
  }
  public LLIntegerNode getLink() {
    return link;
  }
  public void setLink(LLIntegerNode link) {
    this.link = link;
  }
}

