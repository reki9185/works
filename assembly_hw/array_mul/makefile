all:	hw7.c hw7simd.c
	gcc -g hw7.c -o hw7.out
	gcc -msse3 -msse -g hw7simd.c -o hw7simd.out
run:
	./hw7.out
	./hw7simd.out
clean:
	-rm hw7.out
	-rm hw7simd.out
	-rm output.txt
	-rm output_simd.txt
