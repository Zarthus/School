$include(system_includes.asm)

;	@author Jos Ahrens
;	@date	16/10/2014

start:  MOV     A,P0
    CJNE    A,#255, start
    JMP     0

    END
