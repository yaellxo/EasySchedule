import java_cup.runtime.Symbol;
%%
%public
%class Lexer
%unicode
%cup
%{
    // Método auxiliar para devolver tokens
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

%%


[ \t\r\n]+                      { /* Ignorar espacios en blanco */ }
[0-9]+                          { return new Symbol(sym.NUMBER, yytext()); }
[a-zA-Z_][a-zA-Z0-9_]*          { return new Symbol(sym.ID, yytext()); }
\"([^\"]|\\\")*\"               { return new Symbol(sym.STRING, yytext().substring(1, yytext().length()-1)); }

. {
          System.err.println("Error léxico: Carácter no reconocido '" + yytext() + "' en línea " + yyline + ", columna " + yycolumn);
          return symbol(sym.error);
      }