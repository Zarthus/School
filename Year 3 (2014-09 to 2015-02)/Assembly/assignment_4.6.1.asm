$include(system_includes.asm)

;	@author Jos Ahrens
;	@date	16/10/2014

start:  MOV     A,P0
    CPL     A
    MOV     P1,A
    JMP     start

    END
