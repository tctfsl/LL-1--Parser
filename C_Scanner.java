package plt;

import java.lang.*;

public class C_Scanner {
  private char currentChar = ' ';
  private String currentSpelling;
  private int currentIndex = 0;
  private int currentKind;
  
  private void take_it(String text) {
    currentSpelling = currentSpelling + String.valueOf(currentChar);
    currentIndex += 1;
    
    if (currentIndex < text.length())
      currentChar = text.charAt(currentIndex);
    else
      currentChar = ' ';
  }
  
  public C_Token scan(String text) {
    while (Character.isWhitespace(currentChar))
      take_it(text);
    
    currentSpelling = "";
    currentKind = scanToken(text);
    
    return new C_Token(currentKind, currentSpelling);
  }
  
  private int scanToken(String text) {
    int state = 1;
    
    if (currentIndex == text.length())
      return C_Token.EOF;
    
    if (Character.isLetter(currentChar)) {
      take_it(text);
      state = 2;
      
      while (Character.isLetterOrDigit(currentChar))
        take_it(text);
    }
    else
      take_it(text);
    
    switch(state) {
      case 2:
       return C_Token.IDENT;
      default:
        return C_Token.UNKNOW;
    }
  }
}