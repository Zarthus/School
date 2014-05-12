$include(system_includes.asm)

;	@author Jos Ahrens
;	@date	09/04/2014

start:	MOV	A,P0	; Read the switch

	ADD	A,#18	; Add 18 to A
	MOV 	P1,A	; Move A to P1
	
	;... todo (page 21)
	

	MOV	P1,A	; A on the exit port.
	JMP	start	; 
	
	END		; end of program