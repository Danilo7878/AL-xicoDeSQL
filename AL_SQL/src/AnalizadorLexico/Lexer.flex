package lexCode;
import static lexCode.Tokens.*;

%%

%class Lexer
%type Tokens

Letra=[a-zA-Z_]+
Digito=[0-9]+
espacio=[ ,\t,\r,\n]+


%{
public String lexeme;
%}

%%
{espacio} {/*Ignore*/}
ADD |
EXTERNAL |
PROC {lexeme=yytext(); return RESERVADAS;}

{Letra} ({Letra} | {Digito})* {lexeme=yytext(); return IDENTIFICADORES;}
 . {return ERROR;}
