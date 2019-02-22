package plt;

public class PLT {
  
  C_Token nextToken;
        
  public static void main(String[] args) {
    String example_string = "(1+2+(3+4))+5";
    C_Scanner scanner = new C_Scanner();
    C_Token currentToken;
    
    currentToken = scanner.scan(example_string);
    
    while (currentToken.kind != C_Token.EOF)
        currentToken = scanner.scan(example_string);
  }
  
  private void acceptToken(int k, String text) {
    if (nextToken.kind == k) {
      
      nextToken = Module.scanner.scan(text);
    }
    else {
      Module.syntaxError = true;
    }
  }

  // This function is incomplete
  void parse_S(C_Token nexttoken) {
    switch (nexttoken.kind) {
      case C_Token.EOF:
        parse_E(nexttoken);
        parse_S_apost(nexttoken);
        return;
      case "(": 
        parse_E(nexttoken); 
        parse_S_apost(nexttoken); 
        return;
      default:
        parseError();
      }
  }
  
  // This function is incomplete
  void parse_S_apost(C_Token nexttoken) {
    switch (nexttoken.kind) {
      case C_Token.PLUS:
        acceptToken(nexttoken, );
        parse_S(nexttoken);
        return;
      case C_Token.CLOSEBRACKET:
        return;
      case C_Token.EOF:
        return;
      default:
        parseError();
    }
  }
  
  // This function is incomplete
  void parse_E(C_Token nexttoken) {
    switch (nexttoken.kind) {
      case C_Token.NUMBER: 
        acceptToken(nexttoken);
        return;
      case C_Token.OPENBRACKET:
        acceptToken(nexttoken); 
        parse_S(nexttoken);
        acceptToken(")");
        return;
      default:
        parseError();
    }
  }
  
  // This function is incomplete
  void parseError() {}    
}