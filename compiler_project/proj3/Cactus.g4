//The grammar for Catus language
grammar Cactus;

//Parser rules
program : MAIN LP RP LB{System.out.println("\t"+".data");} 
    declarations{System.out.println("\t"+".text");System.out.println("main:");int reg = 0; int label=1;} 
    statements[reg,label] RB
    ;

declarations : INT ID SEMICOLON{System.out.println($ID.text + ":\t" + ".word\t" + "0");} declarations
    |  
    ;

statements[int reg,int label] returns[int nreg,int nlabel]: s=statement[$reg,$label] statements[$s.nreg,$s.nlabel]
    {$nreg = $statements.nreg; $nlabel = $statements.nlabel;}
    | {$nreg = $reg; $nlabel = $label;}
    ;

statement[int reg,int label] returns[int nreg,int nlabel]: 
    ID ASSIGN arith_expression[$reg]{System.out.println("\tla\t" + "\$t" + $arith_expression.nreg + ", " + $ID.text);
                                     System.out.println("\tsw\t" + "\$t" + $arith_expression.place + ", " + "0(" + "\$t" + $arith_expression.nreg + ")");
                                     $nreg = $arith_expression.nreg-1;
                                     $nlabel = $label;} SEMICOLON
    | IF{int b_true = $label;int b_false = $label+1; int b_next = $label+2;} LP b=bool_expression[$reg,$label+3,b_true,b_false]
    RP LB{System.out.println("L" + b_true + ":"); $nreg = $b.nreg; $nlabel = $b.nlabel;} 
    s1=statements[$nreg,$nlabel]{System.out.println("\tb\t" + "L" + b_next);
                                    System.out.println("L" + b_false + ":");
                                    $nreg = $s1.nreg; $nlabel = $s1.nlabel;}
    RB else_statement[$nreg,$nlabel,b_false,b_next]{System.out.println("L" + b_next + ":");
                                                    $nreg = $else_statement.nreg; $nlabel = $else_statement.nlabel;}
    | WHILE{int b_true = $label;int b_false = $label+1; int b_next = $label+2;} LP{System.out.println("L" + b_true + ":");} 
    b=bool_expression[$reg,$label+3,b_false,b_next]
    RP LB{System.out.println("L" + b_false + ":");} 
    statements[$b.nreg,$b.nlabel]{System.out.println("\tb\t" + "L" + b_true);
                                  System.out.println("L" + b_next + ":");
                                  $nreg = $b.nreg; $nlabel = $b.nlabel;} RB
    | READ ID{System.out.println("\tli\t" + "\$v0, 5"); System.out.println("\tsyscall");
              System.out.println("\tla\t" + "\$t" + $reg + ", " + $ID.text);
              System.out.println("\tsw\t" + "\$v0, 0(" + "\$t" + $reg + ")");
              $nreg = $reg;
              $nlabel = $label;} SEMICOLON
    | WRITE arith_expression[$reg]{System.out.println("\tmove\t" + "\$a0, " + "\$t" + $arith_expression.place);
                                   System.out.println("\tli\t" + "\$v0, 1");
                                   System.out.println("\tsyscall");
                                   $nreg = $reg;
                                   $nlabel = $label;} SEMICOLON
    | RETURN SEMICOLON{System.out.println("\tli\t" + "\$v0, 10");
                       System.out.println("\tsyscall");
                       $nreg = $reg;
                       $nlabel = $label;}
    ;
else_statement[int s1_nreg,int s1_nlabel,int b_false,int b_next] returns[int nreg,int nlabel]: 
    ELSE LB s2=statements[$s1_nreg,$s1_nlabel] RB FI{$nreg = $s2.nreg; $nlabel = $s2.nlabel;}
    | FI{$nreg = $s1_nreg; $nlabel = $s1_nlabel;}
    ;

bool_expression[int reg,int label,int b_true,int b_false] returns[int nreg,int nlabel]:
    bool_term[$reg,$label+1,$b_true,$label]
    b1=bool_expression1[$bool_term.nreg,$bool_term.nlabel,$b_true,$b_false,$label]
    {$nreg = $b1.nreg;
     $nlabel = $b1.nlabel;}
    ;
bool_expression1[int reg,int label,int b_true,int b_false,int next] returns[int nreg,int nlabel]:
    OR{System.out.println("L" + $next + ":");}
    bool_term[$reg,$label+1,$b_true,$label]
    b2=bool_expression1[$bool_term.nreg,$bool_term.nlabel,$b_true,$b_false,$label]{$nreg = $b2.nreg; $nlabel = $b2.nlabel;}
    | {System.out.println("L" + $next + ":");
       System.out.println("\tb\t" + "L" + $b_false); 
       $nreg = $reg; $nlabel = $label;}
    ;

//int b1_true = $label++; int b1_false = $b_false;
bool_term[int reg,int label,int b_true,int b_false] returns[int nreg,int nlabel]:
    bool_factor[$reg,$label+1,$label,$b_false]
    b1=bool_term1[$bool_factor.nreg,$bool_factor.nlabel,$b_true,$b_false,$label]{$nreg = $b1.nreg; $nlabel = $b1.nlabel;}
    ;
bool_term1[int reg,int label,int b_true,int b_false,int next] returns[int nreg,int nlabel]:
    AND{System.out.println("L" + $next + ":");}
    bool_factor[$reg,$label+1,$label,$b_false]
    b2=bool_term1[$bool_factor.nreg,$bool_factor.nlabel,$b_true,$b_false,$label]{$nreg = $b2.nreg; $nlabel = $b2.nlabel;}
    | {System.out.println("L" + $next + ":");
       System.out.println("\tb\t" + "L" + $b_true);
       $nreg = $reg; $nlabel = $label;}
    ;

bool_factor[int reg,int label,int b_true,int b_false] returns[int nreg,int nlabel]: NOT{int e1_true = $b_false; int e1_false = $b_true;} 
    bool_factor[$reg,$label,e1_true,e1_false]{$nreg = $bool_factor.nreg; $nlabel = $bool_factor.nlabel;}
    | rel_expression[$reg,$label,$b_true,$b_false]{System.out.println(", L" + $b_true);
                                                   System.out.println("\tb\tL" + $b_false);
                                                   $nreg = $rel_expression.nreg; $nlabel = $label;}
    ;

rel_expression[int reg,int label,int b_true,int b_false] returns[int nreg]: e1=arith_expression[$reg] relation_op
    e2=arith_expression[$e1.nreg]{System.out.print("\t" + $relation_op.op + "\t" + "\$t" + $e1.place + ", " + "\$t" + $e2.place);
                                  $nreg = $e2.nreg-2;}
    ;

relation_op returns[String op] : EQ{$op = "beq";}
    | NE{$op = "bne";}
    | GT{$op = "bgt";}
    | GE{$op = "bge";}
    | LT{$op = "blt";}
    | LE{$op = "ble";}
    ;

arith_expression[int reg] returns[int nreg,int place]: arith_term[$reg] arith_expression1[$arith_term.nreg,$arith_term.place]{$nreg = $arith_expression1.nreg; $place = $arith_expression1.place;}
    ;
arith_expression1[int e1_nreg,int e1_place] returns[int nreg,int place]: 
    ADD{int e2_reg = $e1_nreg;} e2=arith_term[e2_reg]{System.out.println("\tadd\t" + "\$t" + $e1_place + ", " +  "\$t" + $e1_place + ", " + "\$t" + $e2.place);} 
    arith_expression1[$e2.nreg,$e1_place]{$nreg = $arith_expression1.nreg-1; $place = $arith_expression1.place;}
    | SUB{int e2_reg = $e1_nreg;} e2=arith_term[e2_reg]{System.out.println("\tsub\t" + "\$t" + $e1_place + ", " + "\$t" + $e1_place + ", " + "\$t" + $e2.place);}
    arith_expression1[$e2.nreg,$e1_place]{$nreg = $arith_expression1.nreg-1; $place = $arith_expression1.place;}
    | {$nreg = $e1_nreg; $place = $e1_place;}
    ;

arith_term[int reg] returns[int nreg,int place]: arith_factor[$reg] arith_term1[$arith_factor.nreg,$arith_factor.place]{$nreg = $arith_term1.nreg; $place = $arith_term1.place;}
    ;
arith_term1[int e1_nreg,int e1_place] returns[int nreg,int place]:
    MUL{int e2_reg = $e1_nreg;} e2=arith_factor[e2_reg]{System.out.println("\tmul\t" + "\$t" + $e1_place + ", " +  "\$t" + $e1_place + ", " + "\$t" + $e2.place);}
    arith_term1[$e2.nreg,$e1_place]{$nreg = $arith_term1.nreg-1; $place = $arith_term1.place;}
    | DIV{int e2_reg = $e1_nreg;} e2=arith_factor[e2_reg]{System.out.println("\tdiv\t" + "\$t" + $e1_place + ", " +  "\$t" + $e1_place + ", " + "\$t" + $e2.place);}
    arith_term1[$e2.nreg,$e1_place]{$nreg = $arith_term1.nreg-1; $place = $arith_term1.place;}
    | MOD{int e2_reg = $e1_nreg;} e2=arith_factor[e2_reg]{System.out.println("\tmod\t" + "\$t" + $e1_place + ", " +  "\$t" + $e1_place + ", " + "\$t" + $e2.place);}
    arith_term1[$e2.nreg,$e1_place]{$nreg = $arith_term1.nreg-1; $place = $arith_term1.place;}
    | {$nreg = $e1_nreg; $place = $e1_place;}
    ;

arith_factor[int reg] returns[int nreg,int place]: SUB{int e1_reg = $reg;} e1=arith_factor[e1_reg]{System.out.println("\tneg\t" + "\$t" + $e1.place + ", " + "\$t" + $e1.place);
                                                                                                   $nreg = $e1.nreg;
                                                                                                   $place = $e1.place;}
    | primary_expression[$reg]{$nreg = $primary_expression.nreg; $place = $primary_expression.place;}
    ;

// = 1 / = n / = LP + RP
primary_expression[int reg] returns[int nreg,int place]: CONST{System.out.println("\tli\t" + "\$t" + $reg + ", " + Integer.parseInt($CONST.text));
                                                                $place = $reg;
                                                                $nreg = $reg+1;}                        
    | ID{System.out.println("\tla\t" + "\$t" + $reg + ", " + $ID.text);
        System.out.println("\tlw\t" + "\$t" + $reg + ", " + "0(" + "\$t" + $reg + ")");
        $place = $reg;
        $nreg = $reg+1;}
    | LP arith_expression[$reg] RP{$nreg = $arith_expression.nreg; $place = $arith_expression.place;}
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