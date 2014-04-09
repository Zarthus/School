;*********************************************************************
; DESCRIPTION :	Include bestand voor embedded systems
;		bevat standaard-routines 
; FILE NAME   : INCLUDE.ASM
; COMPILER    : M-IDE Studio
; SUPPORT     : AT89C5131
; DATE        : 28 oktober 2010
; AUTEUR      : E.R. van den Berg
;*********************************************************************

;***********************************
;	Definieer Standaard Function Registers
;***********************************
AUXR		EQU	08EH
CKCON0		EQU	08FH
BRL		EQU	09AH
BDRCON		EQU	09BH
KBLS		EQU	09CH
KBE		EQU	09DH
KBF		EQU	09EH

;***********************************
;	Definieer gebruikte variabelen
;***********************************
ER_buffer	EQU	070H		; ontvangst-buffer
;***********************************

	ORG	0000H			; Reset vector
	LJMP	ER_init
;***********************************
;	Definieer Interrupt vectoren
;***********************************
;***********************************

	ORG	0100H			; start user routines en initialisatie
ER_init:
	ANL	CKCON0,#11111110B	; SYSTEM CLOCK = 12CLK/MACHINE
	ORL	CKCON0,#00000001B	; SYSTEM CLOCK = 6CLK/MACHINE
	ORL	PCON,#11000000B		;
	ORL	BDRCON,#00001110B	; init baudrate generator
	MOV	SCON,#01010000B		; mode=1 (8 bits data)
;	MOV	BRL,#243		; baudrate = 115200
	MOV	BRL,#100		; baudrate = 9600
	ORL	BDRCON,#00010000B	; start baudrate generator
	SETB	REN			; zet de ontvanger aan
	MOV	P0,#0FFH		; zet Port 0 als input
	MOV	P1,#0			; zet Port 1 output op 0
	;*******************************
	; verzend reset-melding via serial Port
	;*******************************
	MOV	DPTR,#ER_welkom
	ACALL	ER_transmit_string
	CLR	P2.7			; zet buzzer aan
	ACALL	ER_delay05		; wacht 0,5 sec
	SETB	P2.7			; zet buzzer uit	
	LJMP	ER_start
;**************************************
;   ---- GEBRUIKTE SUBROUTINES ----
;**************************************
; transmit rs232 string:
;	string start-adres in DPTR
;	einde string markering = 0FF
;	gebruikt: DPTR, A
;**************************************	
ER_transmit_string:
	CLR	TI			; reset de transmit-vlag
ER_loop1:
	CLR	A
	MOVC	A,@A+DPTR		; haal string-char op in A
	INC	DPTR
	CJNE	A,#0FFH,ER_verder	; einde string bereikt?
	RET				; ja --> return
ER_verder:
	CALL	ER_transmit_char
	JMP	ER_loop1
;*************************************
; transmit rs232 character:
;	char (ascii) in A
;*************************************
					
ER_transmit_char:
	MOV	SBUF,A			; zet char in verzendbuffer
	JNB	TI,$			; wacht tot TI geset is --> char verzonden
	CLR	TI			; maak TI weer 0
	RET
	
;*************************************
; receive RS232 character:
;	char (ascii) in A
;*************************************
ER_receive_char:
	JNB	RI,$			; wacht tot char ontvangen is
	CLR	RI			; clear onvangen-vlag status
	MOV	A,SCON			; haal frame-error bit in A
	CLR	SCON.7			; clear Frame-error
	JB	ACC.7, ER_receive_char	; als frame-error: haal opnieuw char op
	MOV	A,SBUF			; anders: haal ontvangen char in A
	RET
	
;*************************************
; get rs232 character
;	char (ascii) in A als ontvangen
;	anders A=0
;*************************************
ER_get_char:
	JNB	RI,ER_verder2		; geen char binnengekomen
	CLR	RI			; clear onvangen-vlag status
	MOV	A,SBUF			; haal char op in A
	RET
ER_verder2:
	CLR	A			; status A op 0 (= geen char binnen)
	RET
	
;*************************************
; receive 8 bits van uitbreiding
;	A bevat de 8 ingelezen bits
;*************************************
ER_input:
	MOV	A,P0
	RET
;*************************************
; transmit 8 bits naar uitbreiding
;	A bevat de 8 te versturen bits
;*************************************
ER_output:
	MOV	P1,A
	RET		
;*************************************
; delay 0,5 seconden
;*************************************
ER_delay05:
	MOV	R4,#5
ER_del2:
	MOV	R2,#0FFH
ER_del1:
	MOV	R3,#0FFH
	DJNZ	R3,$
	DJNZ	R2,ER_del1
	DJNZ	R4,ER_del2
	RET
;*************************************
; delay 1 milliseconden
;*************************************
ER_delay001:
	MOV	R2,#0FFH
	DJNZ	R2,$
	RET
;*************************************
;	Gebruikte Teksten
;*************************************
ER_welkom:	DB	0DH,0AH,0DH,0AH
		DB	"Embedded systems Ontwikkelboard v1.0",0DH,0AH
		DB	"(c) 2010 E.R. van den Berg",0DH,0AH,0DH,0AH,0FFH
ER_error:	DB	0DH, 0AH
		DB	"No, syntax error!!",0DH,0AH,0DH,0AH,0FFH
ER_prompt:	DB	0DH, 0AH,"Command>",0FFH
ER_help:	DB	0DH,0AH
		DB	"*******************************************",0DH,0AH
		DB	"* Beschikbare commando's:                 *",0DH,0AH
		DB	"* -----------------------                 *",0DH,0AH
		DB	"* OUT w      : schrijft w naar port P1    *",0DH,0AH
		DB	"*              w in 8 bits binair formaat *",0DH,0AH
		DB	"* IN         : leest port P0 en geeft     *",0DH,0AH
		DB	"*              waarde binair weer         *",0DH,0AH
		DB	"* SBn        : set output-bit n           *",0DH,0AH
		DB	"* CBn        : clear output-bit n         *",0DH,0AH
		DB	"* PBn        : pulse output-bit n         *",0DH,0AH
		DB	"* RUN        : start user programma       *",0DH,0AH
		DB	"* ?          : deze help-tekst            *",0DH,0AH
		DB	"* [NB: keer terug naar command-mode       *",0DH,0AH
		DB	"*      door de reset in te drukken.]      *",0DH,0AH
		DB	"*******************************************",0DH,0AH,0DH,0AH,0FFH
ER_in_tekst:	DB	0DH,0AH,"Waarde Port0: ",0FFH
ER_set_tekst:	DB	0DH,0AH,"Waarde Port1: ",0FFH
ER_run_tekst:	DB	0DH,0AH,"[keer terug naar command-mode door reset in te drukken]",0DH,0AH,0DH,0AH,"running......",0FFH
ER_toggle_tekst1: DB	0DH,0AH,"Pulse 0-1-0 op Port1 Bit",0FFH
ER_toggle_tekst2: DB	0DH,0AH,"Pulse 1-0-1 op Port1 Bit",0FFH

;***********************************
; EINDE SUBROUTINES
;***********************************	
ER_start:
;***********************************
; command mode hoofdprogramma
; - handelt  BS, BELL en CR af
; - converteert ontvangen 
;   karakters naar uppercase
;***********************************
	MOV	DPTR,#ER_prompt
	ACALL	ER_transmit_string	; toon prompt aan gebruiker
	MOV	R0,#ER_buffer		; clear buffer-pointer

ER_loop2:
	ACALL	ER_receive_char		; wacht op invoer
	MOV	R1,A
	CLR	C
	SUBB	A, #97
	JC	ER_v5			; is het een lowercase karakter?
	SUBB	A, #26
	JNC	ER_v5
	MOV	A,R1
	ADD	A, #224			; convert naar uppercase
	MOV	R1,A
ER_v5:
	MOV	A,R1
	ACALL	ER_transmit_char	; echo de invoer
	CJNE	A,#08,ER_v6		; backspace?
	DEC	R0			; ja: verlaag bufferpointer
	CLR	C			; en echo BS+spatie+BS
	MOV	A,R0
	SUBB	A,#ER_buffer
	JC	ER_start		; begin commando --> start opnieuw
	MOV	A,#' '
	ACALL	ER_transmit_char	; wis beeld met spatie
	MOV	A,#08
	ACALL	ER_transmit_char	; zet cursor 1 terug
	JMP	ER_loop2
ER_v6:
	CJNE	A,#07,ER_d1		; beep?
	SETB	P2.7			; zet buzzer aan
	ACALL	ER_delay05		; wacht 0,5 sec
	CLR	P2.7			; zet buzzer uit
	JMP	ER_start
ER_d1:
	MOV	@R0,A			; plaats karakter in buffer
	CJNE	A,#0DH,ER_v1		; karakter = return?			
	JMP	ER_check1		; return ontvangen --> check syntax
ER_v1:	INC	R0			; verhoog pointer
	CJNE	R0,#ER_buffer + 018,ER_loop2	; pointer op einde buffer?
	MOV	DPTR,#ER_error
	ACALL	ER_transmit_string	; ja --> geef error
	JMP	ER_start
;******************************************
ER_check1:
	MOV	R0,#ER_buffer		; begin bij 1e karakter
					; lees karakter in....
ER_check_?:
	CJNE	@R0,#'?',ER_check_out	; '?' getypt?
	MOV	DPTR,#ER_help		; ja --> toon help
	ACALL	ER_Transmit_string
	JMP	ER_start		; restart
ER_check_out:
	CJNE	@R0,#'O',ER_check_in
	INC	R0
					; haal volgende karakter op
	CJNE	@R0,#'U',ER_check_in
	INC	R0
					; haal volgende karakter op
	CJNE	@R0,#'T',ER_check_in
	INC	R0			
					; haal volgende karakter op
	CJNE	@R0,#' ',ER_check_in
					; commando = 'OUT ', haal nu 8 bits op....
	MOV	R1,#8			; lus-teller
	MOV	R7,#0			; komt waarde in
ER_loop4:
	INC	R0
					; haal waarde op
	CJNE	@R0,#'1',ER_v4
	SETB	C			; carry -> 1
ER_t1:
	MOV	A,R7
	RLC	A			; schuif carry in A
	MOV	R7,A			; bewaar in R7
	DJNZ	R1, ER_loop4
	MOV	P1,R7			; output -> port 1
	JMP	ER_start
ER_v4:	CLR	C			; carry -> 0
	JMP	ER_t1
	
ER_check_in:
	MOV	R0,#ER_buffer		; begin opnieuw bij 1e karakter
					; lees karakter in....
	CJNE	@R0,#'I',ER_check_run
	INC	R0
					; lees karakter in....
	CJNE	@R0,#'N',ER_check_run
	MOV	A,P0			; commando = IN, lees P0 in
	MOV	R7,A			; sla 8 bits op in R7
	MOV	R1,#8			; lus-teller
	CLR	C
	MOV	DPTR,#ER_in_tekst
	ACALL	ER_transmit_string
ER_loop3:
	MOV	A,R7
	RLC	A			; haal bit uit R7 op
	MOV	R7,A
	JC	ER_display_1
	MOV	A,#'0'
	ACALL	ER_transmit_char
	JMP	ER_v3
ER_display_1:
	MOV	A,#'1'
	ACALL	ER_transmit_char
ER_v3:
	DJNZ	R1,ER_loop3
	LJMP	ER_start
ER_check_run:
	MOV	R0,#ER_buffer		; begin opnieuw bij 1e karakter
	CJNE	@R0,#'R',ER_check_set; lees karakter in....
	INC	R0			; lees karakter in....
	CJNE	@R0,#'U',ER_check_set
	INC	R0			; lees karakter in....
	CJNE	@R0,#'N',ER_check_set
	MOV	DPTR,#ER_run_tekst
	ACALL	ER_transmit_string
	LJMP	ER_start_user		; RUN --> start user programma
;*****************************************
ER_check_set:
	MOV	R0,#ER_buffer		; begin opnieuw	
	CJNE	@R0,#'S',ER_check_clr
	INC	R0
	CJNE	@R0,#'B',ER_check_clr
	INC	R0
	CJNE	@R0,#'0',ER_check_set1
	SETB	P1.0			; set bit 0
	LJMP	ER_set_end
ER_check_set1:
	CJNE	@R0,#'1',ER_check_set2
	SETB	P1.1			; set bit 1
	LJMP	ER_set_end
ER_check_set2:
	CJNE	@R0,#'2',ER_check_set3
	SETB	P1.2			; set bit 2
	LJMP	ER_set_end
ER_check_set3:
	CJNE	@R0,#'3',ER_check_set4
	SETB	P1.3			; set bit 3
	LJMP	ER_set_end
ER_check_set4:
	CJNE	@R0,#'4',ER_check_set5
	SETB	P1.4			; set bit 4
	LJMP	ER_set_end
ER_check_set5:
	CJNE	@R0,#'5',ER_check_set6
	SETB	P1.5			; set bit 5
	LJMP	ER_set_end
ER_check_set6:
	CJNE	@R0,#'6',ER_check_set7
	SETB	P1.6			; set bit 6
	LJMP	ER_set_end
ER_check_set7:
	CJNE	@R0,#'7',ER_check_clr
	SETB	P1.7			; set bit 7
ER_set_end:
	MOV	DPTR,#ER_set_tekst
	ACALL	ER_transmit_string
	CLR	C
	MOV	R1,#8
	MOV	R7,P1
	LJMP	ER_loop3
;***************************************
ER_check_clr:
	MOV	R0,#ER_buffer		; begin opnieuw	
	CJNE	@R0,#'C',ER_check_toggle
	INC	R0
	CJNE	@R0,#'B',ER_check_toggle
	INC	R0
	CJNE	@R0,#'0',ER_check_clr1
	CLR	P1.0			; set bit 0
	LJMP	ER_set_end
ER_check_clr1:
	CJNE	@R0,#'1',ER_check_clr2
	CLR	P1.1			; set bit 1
	LJMP	ER_set_end
ER_check_clr2:
	CJNE	@R0,#'2',ER_check_clr3
	CLR	P1.2			; set bit 2
	LJMP	ER_set_end
ER_check_clr3:
	CJNE	@R0,#'3',ER_check_clr4
	CLR	P1.3			; set bit 3
	LJMP	ER_set_end
ER_check_clr4:
	CJNE	@R0,#'4',ER_check_clr5
	CLR	P1.4			; set bit 4
	LJMP	ER_set_end
ER_check_clr5:
	CJNE	@R0,#'5',ER_check_clr6
	CLR	P1.5			; set bit 5
	LJMP	ER_set_end
ER_check_clr6:
	CJNE	@R0,#'6',ER_check_clr7
	CLR	P1.6			; set bit 6
	LJMP	ER_set_end
ER_check_clr7:
	CJNE	@R0,#'7',ER_check_toggle
	CLR	P1.7			; set bit 7
	LJMP	ER_set_end
ER_go_return:
	LJMP	ER_check_return
ER_check_toggle:
	MOV	R0,#ER_buffer		; begin opnieuw
	CJNE	@R0,#'P',ER_go_return
	INC	R0
	CJNE	@R0,#'B',ER_go_return
	INC	R0
	CJNE	@R0,#'0',ER_check_toggle1
	CPL	P1.0			; toggle bit 0
	ACALL	ER_delay001		; wacht 1 msec.
	CPL	P1.0			; toggle bit 0
	JB	P1.0,ER_toggle1_1
	JMP	ER_toggle1_0
ER_check_toggle1:
	CJNE	@R0,#'1',ER_check_toggle2
	CPL	P1.1			; toggle bit 1
	ACALL	ER_delay001		; wacht 1 msec.
	CPL	P1.1			; toggle bit 1
	JB	P1.1,ER_toggle1_1
	JMP	ER_toggle1_0
ER_check_toggle2:
	CJNE	@R0,#'2',ER_check_toggle3
	CPL	P1.2			; toggle bit 2
	ACALL	ER_delay001		; wacht 1 msec.
	CPL	P1.2			; toggle bit 2
	JB	P1.2,ER_toggle1_1
	JMP	ER_toggle1_0
ER_check_toggle3:
	CJNE	@R0,#'3',ER_check_toggle4
	CPL	P1.3			; toggle bit 3
	ACALL	ER_delay001		; wacht 1 msec.
	CPL	P1.3			; toggle bit 3
	JB	P1.3,ER_toggle1_1
	JMP	ER_toggle1_0
ER_check_toggle4:
	CJNE	@R0,#'4',ER_check_toggle5
	CPL	P1.4			; toggle bit 4
	ACALL	ER_delay001		; wacht 1 msec.
	CPL	P1.4			; toggle bit 4
	JB	P1.4,ER_toggle1_1
	JMP	ER_toggle1_0
ER_check_toggle5:
	CJNE	@R0,#'5',ER_check_toggle6
	CPL	P1.5			; toggle bit 5
	ACALL	ER_delay001		; wacht 1 msec.
	CPL	P1.5			; toggle bit 5
	JB	P1.5,ER_toggle1_1
	JMP	ER_toggle1_0
ER_check_toggle6:
	CJNE	@R0,#'6',ER_check_toggle7
	CPL	P1.6			; toggle bit 6
	ACALL	ER_delay001		; wacht 1 msec.
	CPL	P1.6			; toggle bit 6
	JB	P1.6,ER_toggle1_1
	JMP	ER_toggle1_0
ER_check_toggle7:
	CJNE	@R0,#'7',ER_check_return
	CPL	P1.7			; toggle bit 7
	ACALL	ER_delay001		; wacht 1 msec.
	CPL	P1.7			; toggle bit 7
	JB	P1.7,ER_toggle1_1
	JMP	ER_toggle1_0
;********************************************
ER_toggle1_0:
	MOV	DPTR,#ER_toggle_tekst1
	JMP	ER_toggle_v1
ER_toggle1_1:
	MOV	DPTR,#ER_toggle_tekst2
ER_toggle_v1:
	ACALL	ER_transmit_string
	MOV	A,@R0
	ACALL	ER_transmit_char
	LJMP	ER_start
;********************************************
ER_check_return:
	MOV	R0,#ER_buffer		; start buffer
	CJNE	@R0,#0DH,ER_cr_error
	LJMP	ER_start
ER_cr_error:
	MOV	DPTR,#ER_error
	ACALL	ER_transmit_string
	LJMP	ER_start
ER_start_user:

