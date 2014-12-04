$include(system_includes.asm)

;	@author Jos Ahrens
;	@date	04/06/2014

start:	MOV	A,P0	; Read the switch
    JMP	case0	; Run the program
    CPL	A 		; Invert A
    JMP	exit		; Clean up

    END