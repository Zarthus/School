$include(system_includes.asm)

;	@author Jos Ahrens
;	@date	04/06/2014

start:	MOV	A,P0	; Read the switch
	JMP	case0	; Run the program
	
case0:	; Invert A

	CPL	A 		; Invert A
	JMP	exit		; Clean up
	
case1:	; Add 1111b to A.
	
	ADD	A,00001111b	; Add 1111b to A
	JMP 	exit		; Clean up
	
case2:
		
	
	
exit:
	MOV P1,A	; Set the value to output switch
	
	END