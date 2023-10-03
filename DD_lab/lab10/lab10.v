/**
 *
 * @author : 409410082
 * @latest changed : 2022/5/27 12:00
 */

module lab10(input clk,
			input reset,
			input [3:0]code_pos,
			input [2:0]code_len,
			input [7:0]chardata,
			output reg finish,
			output reg [7:0]char_nxt);

initial begin
    $dumpfile("Lab.vcd");
    $dumpvars(0, lab10tb);
end

reg [2:0]state;
reg [7:0]search_buffer[0:8];

reg [2:0]ix;
reg decode_done;
integer i;

always@(posedge clk or posedge reset) // output & state control
begin
	if(reset)
	begin
		state<=0;
		finish<=0;
		decode_done<=0;
		for(i=0;i<9;i=i+1)
		begin
			search_buffer[i]<=0;
		end
	end
	else
	begin
		case(state)
			3'd0:begin
				ix<=0;
				if(decode_done)
				begin
					finish<=1;
				end
				else if(code_len==0)
				begin
					char_nxt<=chardata;
					search_buffer[8]<=search_buffer[7];
					search_buffer[7]<=search_buffer[6];
					search_buffer[6]<=search_buffer[5];
					search_buffer[5]<=search_buffer[4];
					search_buffer[4]<=search_buffer[3];
					search_buffer[3]<=search_buffer[2];
					search_buffer[2]<=search_buffer[1];
					search_buffer[1]<=search_buffer[0];
					search_buffer[0]<=chardata;
					if(chardata=="$")
					begin
						//finish<=1;
						decode_done<=1;
					end
				end
				else 
				begin
					char_nxt<=search_buffer[code_pos];
					search_buffer[8]<=search_buffer[7];
					search_buffer[7]<=search_buffer[6];
					search_buffer[6]<=search_buffer[5];
					search_buffer[5]<=search_buffer[4];
					search_buffer[4]<=search_buffer[3];
					search_buffer[3]<=search_buffer[2];
					search_buffer[2]<=search_buffer[1];
					search_buffer[1]<=search_buffer[0];
					search_buffer[0]<=search_buffer[code_pos];
					state<=1;
				end
			end
			3'd1:begin
				if(ix==code_len-1)
				begin
					char_nxt<=chardata;
					search_buffer[8]<=search_buffer[7];
					search_buffer[7]<=search_buffer[6];
					search_buffer[6]<=search_buffer[5];
					search_buffer[5]<=search_buffer[4];
					search_buffer[4]<=search_buffer[3];
					search_buffer[3]<=search_buffer[2];
					search_buffer[2]<=search_buffer[1];
					search_buffer[1]<=search_buffer[0];
					search_buffer[0]<=chardata;
					state<=0;
					if(chardata=="$")
					begin
						//finish<=1;
						decode_done<=1;
					end
				end
				else 
				begin
					char_nxt<=search_buffer[code_pos];
					search_buffer[8]<=search_buffer[7];
					search_buffer[7]<=search_buffer[6];
					search_buffer[6]<=search_buffer[5];
					search_buffer[5]<=search_buffer[4];
					search_buffer[4]<=search_buffer[3];
					search_buffer[3]<=search_buffer[2];
					search_buffer[2]<=search_buffer[1];
					search_buffer[1]<=search_buffer[0];
					search_buffer[0]<=search_buffer[code_pos];
					ix<=ix+1;
				end
			end
		endcase
	end
end

endmodule
