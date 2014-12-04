$include(system_includes.asm)

;	@author Jos Ahrens
;	@date	09/10/2014

start:  MOV     A,P0
    MOV     B,#2
    MUL     AB
    SUBB    A,#10
    MOV     P1,A
    JMP     start

    END
