//The grammar for Catus language
grammar Cactus;

//Parser rules
program : MAIN LP RP LB declarations statements RB
    ;

declarations : INT ID SEMICOLON declarations
    |
    ;

statements : statement statements
    |
    ;

statement : ID ASSIGN arith_expression SEMICOLON
    | IF LP bool_expression RP LB statements RB else_statement
    | WHILE LP bool_expression RP LB statements RB
    | READ ID SEMICOLON
    | WRITE arith_expression SEMICOLON
    | RETURN SEMICOLON
    ;
else_statement : ELSE LB statements RB FI
    | FI;

bool_expression : bool_term bool_expression1
    ;
bool_expression1 : OR bool_term bool_expression1
    |
    ;

bool_term : bool_factor bool_term1
    ;
bool_term1 : AND bool_factor bool_term1
    |
    ;

bool_factor : NOT bool_factor
    | rel_expression
    ;

rel_expression : arith_expression relation_op arith_expression
    ;

relation_op : EQ
    | NE
    | GT
    | GE
    | LT
    | LE
    ;

arith_expression : arith_term arith_expression1
    ;
arith_expression1 : ADD arith_term arith_expression1
    | SUB arith_term arith_expression1
    |
    ;

arith_term : arith_factor arith_term1
    ;
arith_term1 : MUL arith_factor arith_term1
    | DIV arith_factor arith_term1
    | MOD arith_factor arith_term1
    |
    ;

arith_factor : SUB arith_factor
    | primary_expression
    ;

primary_expression : CONST 
    | ID
    | LP arith_expression RP
    ;

//Lexer rules
MAIN : 'main';
ELSE : 'else';
FI : 'fi';
IF : 'if';
INT : 'int';
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
LP : '(';
RP : ')';
LB : '{';
RB : '}';
SEMICOLON : ';';
ID : LETTER(LETTER | '0'..'9')*;
fragment LETTER : [a-z_A-Z];
WHITESPACE : [ \t\n\r]+ -> skip;
COMMENT : '/*' .*? '*/' -> skip;