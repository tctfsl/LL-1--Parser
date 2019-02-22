package plt;

public class C_Token {
  public static final int UNKNOW = 0;
  public static final int EOF = 1;
  public static final int IDENT = 2;
  
  public static final int NUMBER = 3;
  public static final int PLUS = 4;
  public static final int OPENBRACKET = 5;
  public static final int CLOSEBRACKET = 6;
  public static final int DOLLARSIGN = 7;
  
  public int kind;
  public String spelling;
  
  C_Token(int kind, String spelling) {
    this.kind = kind;
    this.spelling = spelling;
  }
  
  public String ToString() {
    if (kind == UNKNOW)
      return "Unknown";
    else if (kind == EOF)
      return "EOF";
    else if (kind == IDENT)
      return "IDENT";
    return "";
  }
}
