//The grammar for Catus language
grammar Cactus;

//Parser rules
token : (ELSE | ID | IF | FI | INT | MAIN | RETURN | WHILE | READ | WRITE | CONST | ADD | SUB | MUL | DIV | MOD | EQ | NE | GT | GE | LT | LE | AND | OR | NOT | ASSIGN | LPARENTHESE | RPARENTHESE | LCURLYBRACKET | RCURLYBRACKET | SEMICOLON | WHITESPACE | COMMENT)*;

//Lexer rules
ELSE : 'else';
ID : LETTER(LETTER | '0'..'9')*;
fragment LETTER : [a-z_A-Z];
FI : 'fi';
IF : 'if';
INT : 'int';
MAIN : 'main';
RETURN : 'return';
WHILE : 'while';
READ : 'read';
WRITE : 'write';
CONST : [0-9]+; 
ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';
MOD : '%';
EQ : '==';
NE : '!=';
GT : '>';
GE : '>=';
LT : '<';
LE : '<=';
AND : '&&';
OR : '||';
NOT : '!';
ASSIGN : '=';
LPARENTHESE : '(';
RPARENTHESE : ')';
LCURLYBRACKET : '{';
RCURLYBRACKET : '}';
SEMICOLON : ';';
WHITESPACE : [ \t\n\r]+ -> skip;
COMMENT : '/*' .*? '*/' -> skip;