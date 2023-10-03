module lab06(clk, rst, A, B, HEX0, HEX1, HEX2, HEX3, HEX4, HEX5);
	input clk;
	input rst;
	input [3:0] A;
	input [3:0] B;
	output [7:0] HEX0;
	output [7:0] HEX1;
	output [7:0] HEX2;
	output [7:0] HEX3;
	output [7:0] HEX4;
	output [7:0] HEX5;
	
	wire clk_1hz;

	//		declaration 		//dont touch
	wire [4:0] CLAout;
	wire [4:0] RCAout;
	wire [7:0] multiout;
	wire [4:0] num0;
	wire [4:0] num1;	
	wire [4:0] num2;
	wire [4:0] num3;
	wire [4:0] num4;
	wire [4:0] num5;
	//		end of declaration
	
	
	//		sample code RCA			//	dont touch
	RCA xl0(.clk(clk_1hz), .rst(rst), .A(A), .B(B), .carry(1'b0), .Y(RCAout));
	
	//		lab 6-1 CLA
	CLA xl1(.clk(clk_1hz), .rst(rst), .A(A), .B(B), .carry(1'b0), .Y(CLAout));
	
	//		lab 6-2 multiplier
	//multiplier	xl2(.clk(clk), .rst(rst), .A(A), .B(B[2:0]), .Y(multiout));
	
	//		clock divider				//	dont touch
	div_clk	xc0(.clk(clk), .rst(rst), .clk_1hz(clk_1hz));
	
	//		binary to decimal			//	dont touch
	bin2dec	xb0(.A(RCAout  ), .D1(num1), .D0(num0));
	bin2dec	xb1(.A(CLAout  ), .D1(num3), .D0(num2));
	bin2dec	xb2(.A(multiout), .D1(num5), .D0(num4));
	
	//		seven segment decoder	//	dont touch
	seven_seg xs0(.clk(clk), .seg_number(num0), .seg_data(HEX0));
	seven_seg xs1(.clk(clk), .seg_number(num1), .seg_data(HEX1));
	seven_seg xs2(.clk(clk), .seg_number(num2), .seg_data(HEX2));
	seven_seg xs3(.clk(clk), .seg_number(num3), .seg_data(HEX3));
	seven_seg xs4(.clk(clk), .seg_number(num4), .seg_data(HEX4));
	seven_seg xs5(.clk(clk), .seg_number(num5), .seg_data(HEX5));
endmodule

module RCA(clk, rst, A, B, carry, Y);
	input clk;
	input rst;
	input [3:0] A;
	input [3:0] B;
	input carry;
	output [4:0] Y;

	reg	[3:0] P;
	reg	[3:0] G;
	reg	[4:0] S;
	reg	[3:0] C;

	assign Y = S;

	always @(posedge clk or negedge rst) begin
		if (!rst) begin
			P <= 4'd0;
			G <= 4'd0;
			S <= 5'd0;
			C <= 5'd0;
		end else begin
			P[0] <= A[0] ^ B[0];
			G[0] <= A[0] & B[0];
			
			P[1] <= A[1] ^ B[1];
			G[1] <= A[1] & B[1];
			
			P[2] <= A[2] ^ B[2];
			G[2] <= A[2] & B[2];
			
			P[3] <= A[3] ^ B[3];
			G[3] <= A[3] & B[3];
			
			S[0] <= carry ^ P[0];
			S[1] <= C[1] ^ P[1];
			S[2] <= C[2] ^ P[2];
			S[3] <= C[3] ^ P[3];
			S[4] <= G[3] | (P[3] & C[3]);
			
			C[0] <= carry;
			C[1] <= G[0] | (P[0] & C[0]);
			C[2] <= G[1] | (P[1] & C[1]);
			C[3] <= G[2] | (P[2] & C[2]);
		end
	end
endmodule

module CLA(clk, rst, A, B, carry, Y);
	input clk;
	input rst;
	input [3:0] A;
	input [3:0] B;
	input carry;
	output [4:0] Y;

	reg	[3:0] P;
	reg	[3:0] G;
	reg	[4:0] S;
	reg	[4:0] C;

	assign Y = S;

	always @(posedge clk or negedge rst) begin
		if (!rst) begin
			P <= 4'd0;
			G <= 4'd0;
			S <= 5'd0;
			C <= 5'd0;
		end else begin
			P[0] <= A[0] ^ B[0];
			G[0] <= A[0] & B[0];
			
			P[1] <= A[1] ^ B[1];
			G[1] <= A[1] & B[1];
			
			P[2] <= A[2] ^ B[2];
			G[2] <= A[2] & B[2];
			
			P[3] <= A[3] ^ B[3];
			G[3] <= A[3] & B[3];
			
			C[0] <= carry;
			C[1] <= G[0] | (P[0] & C[0]);
			C[2] <= G[1] | (P[1] & G[0]) | (P[1] & P[0] & C[0]);
			C[3] <= G[2] | (P[2] & G[1]) | (P[2] & P[1] & G[0]) | (P[2] & P[1] & P[0] & C[0]);
			
			S[0] <= carry ^ P[0];
			S[1] <= C[1] ^ P[1];
			S[2] <= C[2] ^ P[2];
			S[3] <= C[3] ^ P[3];
			S[4] <= G[3] | (P[3] & C[3]);
		
		end
	end
endmodule

module bin2dec(A, D2, D1, D0);
    input [7:0] A;
    output [3:0] D2;
    output [3:0] D1;
    output [3:0] D0;

    wire [6:0] remaind;

    assign D2 = A / 100;
    assign remaind = A % 100;
    assign D1 = remaind / 10;
    assign D0 = remaind % 10;
endmodule

module div_clk(clk, rst, clk_1hz);
	input rst;
	input clk;
	output reg clk_1hz;
	integer counter;

	always @(posedge clk or negedge rst) begin  
		if (!rst)
			clk_1hz <= 0;
		else if (counter >= 25000000)
			clk_1hz <= ~clk_1hz;
	end

	always@(posedge clk or negedge rst) begin  
		if(!rst)
			counter <= 0;
		else if(counter >= 25000000)
			counter <= 0;
		else
			counter <= counter + 1;
	end
endmodule

module seven_seg(clk, seg_number, seg_data);
	input clk;
	input [3:0] seg_number;
	output reg [7:0] seg_data;

	always @(posedge clk) begin
		case (seg_number)
			4'd0:seg_data <= 8'b1100_0000;
			4'd1:seg_data <= 8'b1111_1001;
			4'd2:seg_data <= 8'b1010_0100;
			4'd3:seg_data <= 8'b1011_0000;
			4'd4:seg_data <= 8'b1001_1001;
			4'd5:seg_data <= 8'b1001_0010;
			4'd6:seg_data <= 8'b1000_0010;
			4'd7:seg_data <= 8'b1101_1000;
			4'd8:seg_data <= 8'b1000_0000;
			4'd9:seg_data <= 8'b1001_0000;
			default: seg_data <= seg_data;
		endcase
	end
endmodule
