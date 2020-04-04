grammar G;

program : main <EOF>
	| main functions <EOF>
	| functions main <EOF>
	;

function_definition : 'func' name '(' vars ')' '->' typeSpecification block 
	| 'func' name '()' '->' typeSpecification block
	;

block : '{' interiorStatement '}' ;

instruction : retFunc ';'
	| expr ';'
	| io
	| conditional
	| variableDeclaration
	| callFunction
	| ret
	| assignment
	;

expr : expr '++'
    | expr '--'
    | expr operator expr
    | basic | name | retFunc
    | name '[' name ']' | name '[' INT ']'
    | expr compOp expr
    | expr simpleOp expr
    | expr boolOp expr
    | '!' expr
    ;

main : 'func' 'main' '(' vars ')' '->' typeSpecification block 
	| 'func' 'main' '()' '->' typeSpecification block 
	;

functions : function_definition | functions function_definition ;

conditional : 'if' '(' expr ')' 'then' block
      	|  'if' '(' expr ')' 'then' block 'else' block
  	|  'while' '(' expr ')' block
      	|  'do' block 'while' '(' expr ')'
      	| 'for' '(' loopVar ';' expr ';' expr ';' ')' block
	;

callFunction : 'var' typeSpecification name '=' name '(' vars ')' ';'
	| name '=' name '(' vars ')' ';'
	;

ret : '->' expr ;

retFunc : name '(' vars ')' | name '(' ')' ;

interiorStatement : instruction | interiorStatement instruction ;

io : 'print' '(' typeSpecification ',' name ')' ';'
	| 'print' '(' 'array' '<' typeSpecification '>' ',' name ')' ';'
	| 'print' '(' expr ')' ';'
	| 'read' '(' typeSpecification ',' name ')' ';'
	;

vars : typeSpecification name 
	| typeSpecification name ',' vars 
	| 'array' '<' typeSpecification '>' name
	| 'array' '<' typeSpecification '>' name ',' vars
	| name | name ',' vars
	| expr | expr ',' vars
	| basic | basic ',' vars
	;

loopVar : 'var' typeSpecification name '=' basic ;

assignment : name '=' expr ';'
	| name '=' basic ';'
	| name '[' name ']' '=' basic ';'
	| name '[' INT ']' '=' basic ';'
	| name '[' name ']' '=' expr ';'
	| name '[' INT ']' '=' expr ';'
	;

name : IDENTIFIER | IDENTIFIER '_' IDENTIFIER ;

IDENTIFIER : [a-zA-Z]+ ;

variableDeclaration : 'var' typeSpecification name ';'
	| 'var' typeSpecification name '='  basic ';'
	| 'var' typeSpecification name '=' name ';'
	| arrayDeclaration ';'
	;

arrayDeclaration : 'var' 'array' '<' typeSpecification '>' name '=' '{' arrayVars '}'
	| 'var' 'array' '<' typeSpecification '>' name '=' 'new' '(' typeSpecification ',' INT ')'
	| 'var' 'array' '<' typeSpecification '>' name '=' 'new' '(' typeSpecification ',' name ')'
	;

arrayVars : basic | basic ',' arrayVars ;

typeSpecification : 'int' | 'char' | 'byte' | 'bool' | 'float' | 'void' ;

operator : | '+'
	| '-'
	| '*'
	| '/'
	| 'mod'
	| '**'
	;

compOp : '=='
	| '<='
	| '>='
	| '>'
	| '<'
	| '!='
	;

simpleOp : '+='
	| '-='
	| '*='
	| '/='
	;

boolOp : '||'
	| '&&'
	| '!'
	;

basic : INT
	| BOOL
	| FLOAT
	| BYTE
	| CHAR
	;

INT : [0-9]+ ;

CHAR : [a-z]+ | [A-Z]+ | [a-z]+CHAR | [A-Z]+CHAR ;

BYTE : '-' [1-9] | '-' [1-9][0-9] | '-' '1' [0-2][0-7] 
	| [0-9] | [1-9][0-9] | '1' [0-2][0-8]  ;

BOOL : 'T' | 'F' ;

FLOAT : INT '.' INT ;

WS : [ \t\r\n]+ -> skip;