$include(system_includes.asm)

;	@author Jos Ahrens
;	@date	23/10/2014

start:  MOV     A,P0
    SWAP    A
    MOV     P1,A
    JMP     start

    END
