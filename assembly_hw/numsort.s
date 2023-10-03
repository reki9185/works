/*text section*/
	.section .text
	.global numsort
	.type numsort,%function
numsort:
	mov ip,sp
	stmfd sp!,{r4-r10,fp,ip,lr}
	sub fp,ip,#4
	mov r9,r0
	mov r10,r1
	/*malloc(sizeof(array)*4)*/
	mov r0,r0,lsl#2
	bl malloc
	mov r3,r0
	mov r1,r9
	/*load the array to the new array:result*/
	loop:
		cmp r1,#0
		ldrgt r2,[r10],#4
		strgt r2,[r3],#4
		subgt r1,r1,#1
		bgt loop
	/*initial*/
	mov r3,r0
	mov r1,r9
	mov r2,r9
	/*bubble sort*/
	loop1:
		bl loop2
		sub r1,r1,#1
		/*initialize*/
		mov r2,r9
		mov r3,r0
		/*r1--*/
		cmp r1,#1
		bgt loop1
		/*if finish loop1,goto branch break*/
		b break
	loop2:
		/*if a[i]>a[i+1],swap a[i] and a[i+1]*/
		ldr r4,[r3]
		ldr r5,[r3,#4]
		cmp r4,r5
		strgt r4,[r3,#4]
		strgt r5,[r3]
		/*r2--*/
		sub r2,r2,#1
		cmp r2,#1
		/*r3+=4,let r3 point to the next value of a*/
		addgt r3,r3,#4
		bgt loop2
		/*go back to loop1*/
		mov pc,r14
	break:	
	ldmfd sp!,{r4-r10,fp,ip,pc}
	.end
