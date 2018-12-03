grammar Lambda;

expression  :   LPAR expression RPAR                                                                                                        #parenExpression
            |   VAR                                                                                                                         #variable
            |   INT                                                                                                                         #integer
            |   expression op=(MULT|DIV) expression                                                                                         #multiplication
            |   expression op=(PLUS|MINUS) expression                                                                                       #addition
            |   IF LPAR expression op=(EQ|NEQ|GT|LT|GTEQ|LTEQ) expression RPAR THEN LCURL expression RCURL ELSE LCURL expression RCURL      #ifStatement
            |   expression ' ' expression                                                                                                   #application
            |   LAMBDA VAR DOT expression                                                                                                   #abstraction
            |   REC ' ' VAR ' ' VAR DOT expression                                                                                          #recursion
            ;

RPAR    :   ')';
LPAR    :   '(';
RCURL   :   '}';
LCURL   :   '{';

PLUS    :   '+';
MINUS   :   '-';
MULT    :   '*';
DIV     :   '/';
DOT     :   '.';

EQ      :   '=';
NEQ     :   '!=';
GT      :   '>';
LT      :   '<';
GTEQ    :   '>=';
LTEQ    :   '<=';

IF      :   'if';
THEN    :   'then';
ELSE    :   'else';
REC     :   'rec';

INT     :   [0-9]+;
VAR     :   [a-zA-Z][a-zA-Z0-9]*;

LAMBDA  :   'λ' | '\\';
WS      :   [ \t\n]+ -> skip;