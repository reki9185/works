(1)執行環境:
CPU型號-intel(R) Sore(TM) i5-1035G1 CPU @ 1.00GHz
記憶體-4096MB
作業系統-Linux(Ubuntu)
(2)程式內容:
hw7.c:
	利用fopen+fgets從data.txt中讀入資料並分別存入a,b矩陣，將b矩陣每一列的值相加之後利用簡單的迴圈運算將答案存入c矩陣。結束之後使用fprintf把結果輸出到ouput.txt。
hw7simd.c:
	與上面使用同樣的方法輸入和輸出，之後將a,b矩陣四個數字一組存成共50個vector陣列(__m128*)，不足四個的地方則補0。利用*b[0][j]=_mm_add_ps(*b[0][j],*b[i][j])將b矩陣每一列的值相加，之後再用_mm_mul_ps()將a的每一行與此總和相乘，每算一次後就用*c[i]=_mm_add_ps(*c[i],*tmp)將這次的結果與前回相加，就可以得到我們想要的結果存在每個c vector裡面(例如:a[0]*b的結果存在c[0] vector裡)。最後再將c[i][0],c[i][1],c[i][2],c[i][3]利用兩次_mm_hadd_ps()相加，就可以得到結果。
(3)執行時間:
---------------------------------------------------------------
	 |	read	  |	compute   |	write
---------------------------------------------------------------
hw7.c    |   0.017659160  |  0.000215773  |  0.000067545
---------------------------------------------------------------
hw7simd.c|   0.031020873  |  0.000087676  |  0.000068425
(4)編譯程式:
	(make)
	gcc -g hw7.c -o hw7.out
	gcc -msse3 -msse -g hw7simd.c -o hw7simd.out
(5)執行程式:
	(make run)
	./hw7.out
	./hw7simd.out
	/*the result of hw7.c -> output.txt
	the result of hw7simd.c -> output_simd.txt*/
(6)使用的指令:
	SSE:_mm_add_ps() _mm_mul_ps()
	SSE3:_mm_hadd_ps()
