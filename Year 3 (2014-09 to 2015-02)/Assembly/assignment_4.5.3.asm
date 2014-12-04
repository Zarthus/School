$include(system_includes.asm)

;	@author Jos Ahrens
;	@date	09/10/2014

start:  MOV     A,P0
    ADDC    A,#5
    MOV     B,#3
    MUL     AB
    MOV     P1,A
    JMP     start

    END
