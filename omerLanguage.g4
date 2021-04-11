grammar omerLanguage;
//PARSER RULES

@header {
package parseTree;
}

variable: (LOCAL|GLOBAL)? CONSTANT? datatype WORD+ ENDLINE;

variableAssignment: STRINGTYPE WORD+ ASSIGNMENT anySpeech
                  | BOOLTYPE WORD+ ASSIGNMENT BOOLEANOPERAND
                  | FLOATTYPE WORD+ ASSIGNMENT FLOAT
                  ENDLINE;

ifBlock: ('IF' expression 'DO' CLAUSE)+
    ('IF NOT' CLAUSE)?;

expression: LBRACKET operation+ RBRACKET;

operation: operand operator operand;

print: 'print' '"' anySpeech+ '"' ENDLINE;

countLoop: 'DO THIS' CLAUSE LBRACKET INTEGER 'TIMES' RBRACKET;//loop - DO THIS{ }(3TIMES) - do this 3 times

loopCondition: 'LOOP IF' expression CLAUSE;
//                          INPUT ARGUMENT          RETURN
function: WORD LBRACKET (datatype variableUse)* (COMMA datatype variableUse)? RBRACKET CLAUSE;

functionCall: WORD LBRACKET (datatype variableUse)* RBRACKET ENDLINE;

array: datatype (variableUse) ASSIGNMENT '[' INTEGER ']' ENDLINE;

operator: (IS
          |MORETHAN
          |LESSTHAN
          |MORETHANOREQUALTO
          |LESSTHANOREQUALTO
          |booleanOperators);

booleanOperators: (AND|OR|NOT);

operand: (variableUse
         |expression
         |NUMBER
         |BOOLEANOPERAND);

anySpeech:(DIGIT+|WORD+|NUMBER+);
variableUse: (WORD|multiWordVariable);//NEEDS TO BE WORD, (WORD/S)
multiWordVariable:LBRACKET WORD+ RBRACKET;//WORDS IN BRACKETS
stringInSpeech: SPEECH WORD+ SPEECH;//WORDS IN SPEECH
digitString: SPEECH DIGIT+ SPEECH;//ANYTHING IN SPEECH
datatype: (STRINGTYPE | BOOLTYPE | FLOATTYPE);


arithmeticoperator: (MULTIPLY
                     |DIVIDE
                     |MINUS
                     |ADD
                     |POWER);

//LEXER RULES
CLAUSE: SCLAUSE .*? ECLAUSE;

STRINGTYPE: 'str';
BOOLTYPE: 'bool';
FLOATTYPE: 'float';

WS: [ \r\n\t]+ -> skip ;

BOOLEANOPERAND: (BOOLTRUE|BOOLFALSE);


AND: '&&';
OR: '||';
NOT: '!';
BOOLTRUE: 'True';
BOOLFALSE: 'False';
LBRACKET: '(';
RBRACKET: ')';
SCLAUSE: '{';
ECLAUSE: '}';
MORETHAN: '>';
LESSTHAN: '<';
MORETHANOREQUALTO: '<=';
LESSTHANOREQUALTO: '>=';
IS: 'IS';
DOT: '.';
COMMA: ',';
SPEECH: '"';
ASSIGNMENT: '=';
MULTIPLY: '*';
DIVIDE: '/';
MINUS: '-';
ADD: '+';
POWER: '^';
ENDLINE: ';';
LOCAL: '--';
GLOBAL: '++';
CONSTANT: 'const';
COMMENT: '##' .*? -> skip;
fragment LETTER: [a-z] | [A-Z];
WORD: LETTER+ ;//includes single letter words - just normal alphabet, no symbols or NUMBERs
NUMBER: (INTEGER | FLOAT);
INTEGER: [0-9]+;
FLOAT: INTEGER* DOT INTEGER+;
DIGIT: [\u0020-\u0021\u0024-\u007f];