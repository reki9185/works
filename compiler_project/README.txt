(2023/3)
Project1 Implementation of a Lexer
-----------------------------------------------------
In this assignment you are requested to use the tool ANTLR to write a lexer for a small language Cactus. 
The language Cactus contains the following categories of token types:
1. An identifier is a sequence of letters and digits; the first character must be a letter. 
   The underscore ‘_’ counts as a letter.
   All identifiers are returned as the same token type.
2. The following identifiers are reserved for use as keywords, and may not be used otherwise:
   else fi if int main return while read write
   Each keyword is returned as a distinct token type.
3. An integer constant consists of a sequence of digits. All integerconstants are returned as the same token type.
4. Operators include
   + - * / % == != > >= < <= && || ! = ( ) { } ;
   Each operator is returned as a distinct token type.
5. Blanks, tabs, and newlines are ignored except as they serve to separate tokens.
6. Comments are ignored except as they serve to separate tokens.
   The characters /* introduces a comment, which terminates with the characters */. 
   Comments do not nest.

Project2 Implementation of a Recursive Descent Parser
-----------------------------------------------------
In this assignment you are required to use the tool ANTLR to generate a recursive descent parser for the small language Cactus. 
The context-free grammar for Cactus consists of the following productions:
program → main ‘(’ ‘)’ ‘{’ declarations statements ‘}’
declarations → int identifier ‘;’ declarations
declarations → ε
statements → statement statements
statements → ε
statement → identifier ‘=’ arith_expression ‘;’
statement → if ‘(’ bool_expression ‘)’ ‘{’ statements ‘}’ else ‘{’ statements ‘}’ fi
statement → if ‘(’ bool_expression ‘)’ ‘{’ statements ‘}’ fi
statement → while ‘(’ bool_expression ‘)’ ‘{’ statements ‘}’
statement → read identifier ‘;’
statement → write arith_expression ‘;’
statement → return ‘;’
bool_expression → bool_expression ‘||’ bool_term
bool_expression →bool_term
bool_term → bool_term ‘&&’ bool_factor
bool_term → bool_factor
bool_factor → ‘!’ bool_factor
bool_factor → rel_expression
rel_expression → arith_expression relation_op arith_expression
relation_op → ‘==’ | ‘!=’ | ‘>’ | ‘>=’ | ‘<’ | ‘<=’
arith_expression → arith_expression ‘+’ arith_term
| arith_expression ‘-’ arith_term
| arith_term
arith_term → arith_term ‘*’ arith_factor
| arith_term ‘/’ arith_factor
| arith_term ‘%’ arith_factor
| arith_factor
arith_factor → ‘-’ arith_factor
| primary_expression
primary_expression → integer_constant
primary_expression → identifier
primary_expression → ‘(’ arith_expression ‘) ’

Project3 Implementation of a Code Generator
-----------------------------------------------------
In this assignment you are requested to use ANTLR to implement a code generator for MIPS processors using the techniques introduced for intermediate code generation.