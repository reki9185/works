`define CYCLE_TIME 20
`define INSTRUCTION_NUMBERS 50
`timescale 1ns/1ps
`include "CPU.v"

module testbench;
reg Clk, Rst;
reg [31:0] cycles, i;

// Instruction DM initialilation
initial
begin
	/*=================================================     write down your program     =================================================*/
		cpu.IF.instruction[ 0] = 32'b000000_00001_00010_00011_00000_100000;	//add $3, $1, $2       $3 = 1 + 2 = 3
		cpu.IF.instruction[ 1] = 32'b000000_00000_00000_00000_00000_100000;	//NOP(add $0, $0, $0)
		cpu.IF.instruction[ 2] = 32'b000000_00000_00000_00000_00000_100000;	//NOP(add $0, $0, $0)
		cpu.IF.instruction[ 3] = 32'b000000_00000_00000_00000_00000_100000;	//NOP(add $0, $0, $0)
		cpu.IF.instruction[ 4] = 32'b000000_00011_00011_00100_00000_100000;	//add $4, $3, $3       $4 = 3 + 3 = 6
		cpu.IF.instruction[ 5] = 32'b000000_00000_00000_00000_00000_100000;	//NOP(add $0, $0, $0)
		cpu.IF.instruction[ 6] = 32'b000000_00000_00000_00000_00000_100000;	//NOP(add $0, $0, $0)
		cpu.IF.instruction[ 7] = 32'b000000_00000_00000_00000_00000_100000;	//NOP(add $0, $0, $0)
		cpu.IF.instruction[ 8] = 32'b000000_00100_00011_00100_00000_100000;	//add $4, $4, $3       $4 = 6 + 3 = 9
		cpu.IF.instruction[ 9] = 32'b000000_00000_00000_00000_00000_100000;	//NOP(add $0, $0, $0)
		cpu.IF.instruction[ 10] = 32'b000000_00000_00000_00000_00000_100000;	//NOP(add $0, $0, $0)
		cpu.IF.instruction[ 11] = 32'b000000_00000_00000_00000_00000_100000;	//NOP(add $0, $0, $0)
		for (i=11; i<352; i=i+1)  cpu.IF.instruction[ i] = 32'b000000_00000_00000_00000_00000_100000;	//NOP(add $0, $0, $0)
		cpu.IF.PC = 0;
end

//clock cycle time is 20ns, inverse Clk value per 10ns
initial Clk = 1'b1;
always #(`CYCLE_TIME/2) Clk = ~Clk;

//Rst signal
initial begin
	cycles = 32'b0;
	Rst = 1'b1;
	#12 Rst = 1'b0;
end

CPU cpu(
	.clk(Clk),
	.rst(Rst)
);

//display all Register value and Data memory content
always @(posedge Clk) begin
	cycles <= cycles + 1;
	if (cycles == `INSTRUCTION_NUMBERS) $finish; // Finish when excute the 24-th instruction (End label).
	$display("PC: %d cycles: %d", cpu.FD_PC>>2 , cycles);
	$display("  R00-R07: %08x %08x %08x %08x %08x %08x %08x %08x", cpu.ID.REG[0], cpu.ID.REG[1], cpu.ID.REG[2], cpu.ID.REG[3],cpu.ID.REG[4], cpu.ID.REG[5], cpu.ID.REG[6], cpu.ID.REG[7]);
	$display("  R08-R15: %08x %08x %08x %08x %08x %08x %08x %08x", cpu.ID.REG[8], cpu.ID.REG[9], cpu.ID.REG[10], cpu.ID.REG[11],cpu.ID.REG[12], cpu.ID.REG[13], cpu.ID.REG[14], cpu.ID.REG[15]);
	$display("  R16-R23: %08x %08x %08x %08x %08x %08x %08x %08x", cpu.ID.REG[16], cpu.ID.REG[17], cpu.ID.REG[18], cpu.ID.REG[19],cpu.ID.REG[20], cpu.ID.REG[21], cpu.ID.REG[22], cpu.ID.REG[23]);
	$display("  R24-R31: %08x %08x %08x %08x %08x %08x %08x %08x", cpu.ID.REG[24], cpu.ID.REG[25], cpu.ID.REG[26], cpu.ID.REG[27],cpu.ID.REG[28], cpu.ID.REG[29], cpu.ID.REG[30], cpu.ID.REG[31]);
	$display("  0x00   : %08x %08x %08x %08x %08x %08x %08x %08x", cpu.MEM.DM[0],cpu.MEM.DM[1],cpu.MEM.DM[2],cpu.MEM.DM[3],cpu.MEM.DM[4],cpu.MEM.DM[5],cpu.MEM.DM[6],cpu.MEM.DM[7]);
	$display("  0x08   : %08x %08x %08x %08x %08x %08x %08x %08x", cpu.MEM.DM[8],cpu.MEM.DM[9],cpu.MEM.DM[10],cpu.MEM.DM[11],cpu.MEM.DM[12],cpu.MEM.DM[13],cpu.MEM.DM[14],cpu.MEM.DM[15]);
end

//generate wave file, it can use gtkwave to display
initial begin
	$dumpfile("cpu_hw.vcd");
	$dumpvars;
end
endmodule

