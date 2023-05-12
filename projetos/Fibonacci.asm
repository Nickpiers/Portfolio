extern  _getchar,_printf
section .data
contador:            dd 15

format1:             db "%d",10,0
     aux:	     dd 0
     temp:           dd 0
     cont:           dd 0
     num:	     dd 1
     anterior:       dd 0
     aux2:	     dd 0
     cont2:          dd 0
     cont3:          dd 0
     array: 	     dd 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0  ;14 posições disponíveis
 
section .text
global  _main
_main:
    push eax
    push ebx
    push ecx
    push edx
    push edi
    mov  eax,[contador]	            ; contador de ciclos
    mov  edi,1                      ; contador de posições no array
    mov  edx,[anterior]	            ; valor anterior

    for:
        mov  ebx,[num]	            ; Movemos o valor de num para ebx
	mov  [aux2],ebx             ; Movemos ebx para aux2
	add  ebx,edx                ; somamos numero atual com anterior
	mov  edx,[aux2]             ; movemos aux2 para edx como novo anterior
	mov  [num],ebx              ; movemos ebx como novo atual
        mov  ebx,[num]             
        mov  dword[array+edi*4],ebx ; guardamos o valor de ebx em posição[edi] do array
        inc  edi                    ; incrementamos edi(contador de posições)
        dec  eax                    ; decrementamos eax(contador de ciclos)
        jnz  for                    ; verifica se não é zero
        
        mov   [cont3],edi           ; movemos edi como contador de posições para imprimir
        mov   edi,0                 ; colocamos edi com posição 0
      
    print:      
        push dword[array+edi*4]     ; array [edi]
        push format1
	call _printf
	add  esp,8
        inc  edi                    ; incrementamos edi
	cmp  edi,[cont3]            ;  comparamos se a posição do vetor é menor que o contador de posição
	jl   print
  
fin:
    pop     edi
    pop     edx
    pop     ecx
    pop     ebx
    pop     eax           
ret

