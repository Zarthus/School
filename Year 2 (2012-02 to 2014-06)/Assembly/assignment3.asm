$include(system_includes.asm)

;	@author Jos Ahrens
;	@date	09/04/2014

start:	MOV	A,P0	; Read the switch
	MOV	B,#2	; Read switch again.
	
	MUL	AB	; multiply A
	
	MOV	P1,A	; A on the exit port.
	JMP	start	; 
	
	END		; end of program