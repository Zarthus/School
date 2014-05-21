$include(system_includes.asm)

;	@author Jos Ahrens
;	@date	14/05/2014

start:	MOV	A,P0	; Read the switch
	JMP 	case3	; Select which case to run.

case0:	; CASE 0 -- add 18 to P0 and put it in P1. Compiles & works

	ADD	A,#18	; Add 18 to A
	
	JMP	eop	; Go to end of program
	
case1:	; CASE 1 -- multiply P0 by 2, and minus 10, put it in P1. Compiles & works

	MOV	B,P0	; Move P0 into B
	ADD 	A,B	; Multiply A by A (B == A)
	SUBB 	A,#10	; Subtract 10 from A
	
	JMP	eop	; Go to end of program
	
case2:	; CASE 2 -- Multiply P0+5 by 3. Doesn't compile therefore doesn't work.
	ADD	A,#5	; Add 3 to A
	MOV	B,A	; B = A
	ADD	A,B	; Multiply B by 3
	ADD	A,B	; Straightforward. We add B to A twice (therefore: * 3)
	
	JMP	eop	; Go to end of program
	
case3:	; CASE 3 -- P0 to the power of 2. Doesn't compile
	MOV	A,B	; B = A
	MUL 	AA	; A to the power of 2 is simply A * A 

	JMP	eop	; Go to end of program
	
case4:	; CASE 4 -- P0 + 256
	;MOV	A,P0	; Move P0 into A. No compile
	;ADD	A,#256	; Add 256 to A
	
	JMP	eop	; Go to end of program
	;... todo (page 21)
	
eop:
	MOV	P1,A	; A on the exit port. - Avoid duplicate code by doing it at the end of the program
	JMP	start	; restart the loop
	
	END		; end the program