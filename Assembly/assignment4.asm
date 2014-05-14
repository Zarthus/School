$include(system_includes.asm)

;	@author Jos Ahrens
;	@date	14/05/2014

start:	MOV	A,P0	; Read the switch

	; CASE 0 -- add 18 to P0 and put it in P1. Compiles & works
	ADD	A,#18	; Add 18 to A
	MOV 	P1,A	; Move A to P1
	
	; CASE 1 -- multiply P0 by 2, and minus 10, put it in P1. Compiles & works
	MOV	B,P0	; Move P0 into B
	MUL 	AB	; Multiply A by A
	SUBB 	A,#10	; Subtract 10 from A
	MOV 	P1,A	; Move A to P1
	
	; CASE 2 -- Multiply P0+5 by 3. Doesn't compile therefore doesn't work.
	MOV	A,P0	; Move P0 into B
	ADD	B,#3	; Add 3 to A
	ADD	A,#5	; Add 5 to B
	MUL	AB	; Multiply B by 3
	MOV 	P1,B	; Move B into P1

	; CASE 3 -- P0 to the power of 2. Doesn't compile
	MOV 	A,P0	; Move P0 into A
	MUL 	AA	; A to the power of 2 is simply A * A
	MOV	P1,A	; Move the end value into P1
	
	; CASE 4 -- P0 + 256
	MOV	A,P0	; Move P0 into A. No compile
	ADD	A,#256	; Add 256 to A
	MOV 	P1,A	; Move the end value into P1
	
	;... todo (page 21)
	

	MOV	P1,A	; A on the exit port.
	JMP	start	; 
	
	END		; end of program