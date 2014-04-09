$include(system_includes.asm)

;	@author Jos Ahrens
;	@date	09/04/2014

start:	MOV	A,P0	; Read the switch
	MUL	A	; multiply A
	MOV	P1,A	; A on the exit port.
	JMP	start	; 
	
	END		; end of program