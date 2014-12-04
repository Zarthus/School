$include(system_includes.asm)

;	@author Jos Ahrens
;	@date	16/10/2014

start:  MOV     A,P0
    CJNE    A,#16, shutdown
    MOV     P1,#255
    JMP     start

shutdown:    MOV     P1,#0
    JMP     start

    END
