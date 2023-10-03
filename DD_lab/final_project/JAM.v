module JAM (
input CLK,
input RST,
output reg [2:0] W,
output reg [2:0] J,
input [6:0] Cost,
output reg [3:0] MatchCount,
output reg [9:0] MinCost,
output reg Valid );

integer i;

initial begin
    $dumpfile("JAM.vcd");
    $dumpvars(0, testfixture);
    for(i = 0; i < 8; i = i+1)
        $dumpvars(1, num[i]);
end

reg first;
reg [5:0]state;
reg [2:0]num[0:7];
reg [2:0]num_tmp[0:7];
reg [9:0]tmp_cost;
reg [3:0]ix;
reg [9:0]min_cost;
reg [3:0]match_count;
//J-M output cost
always @(posedge CLK or posedge RST) 
begin
	if(RST)
	begin
		state<=9;
		first<=1;
		num[0]<=0;
		num[1]<=1;
		num[2]<=2;
		num[3]<=3;
		num[4]<=4;
		num[5]<=5;
		num[6]<=6;
		num[7]<=7;
		Valid<=0;
    	end
	else if(Valid)
	begin
		//MinCost<=min_cost;
		//MatchCount<=match_count;
		Valid<=0;
	end
    	else 
    	begin
		//$display("%d %d %d %d %d %d %d %d",num_tmp[0],num_tmp[1],num_tmp[2],num_tmp[3],num_tmp[4],num_tmp[5],num_tmp[6],num_tmp[7]);
		case(state)
			5'd9:begin
				if(first)
				begin
					num_tmp[0]<=num[0];
					num_tmp[1]<=num[1];
					num_tmp[2]<=num[2];
					num_tmp[3]<=num[3];
					num_tmp[4]<=num[4];
					num_tmp[5]<=num[5];
					num_tmp[6]<=num[6];
					num_tmp[7]<=num[7];
					first<=0;
				end
				else if(ix==8)
				begin
					num_tmp[0]<=num[0];
					num_tmp[1]<=num[1];
					num_tmp[2]<=num[2];
					num_tmp[3]<=num[3];
					num_tmp[4]<=num[4];
					num_tmp[5]<=num[5];
					num_tmp[6]<=num[6];
					num_tmp[7]<=num[7];
					state<=8;
				end
			end
			5'd8:begin
				if(num[7]>num[6])
				begin
					num[6]<=num[7];
					num[7]<=num[6];
					state<=9;
				end
				else if(num[6]>num[5])
				begin
					if(num[7]>num[5])
					begin
						num[5]<=num[7];
						num[7]<=num[5];
						state<=5;
					end
					else
					begin
						num[5]<=num[6];
						num[6]<=num[5];
						state<=5;
					end
				end
				else if(num[5]>num[4])
				begin
					if(num[7]>num[4])
					begin
						num[4]<=num[7];
						num[7]<=num[4];
						state<=4;
					end
					else if(num[6]>num[4])
					begin
						num[4]<=num[6];
						num[6]<=num[4];
						state<=4;
					end
					else
					begin
						num[4]<=num[5];
						num[5]<=num[4];
						state<=4;
					end
				end
				else if(num[4]>num[3])
				begin
					if(num[7]>num[3])
					begin
						num[3]<=num[7];
						num[7]<=num[3];
						state<=3;
					end
					else if(num[6]>num[3])
					begin
						num[3]<=num[6];
						num[6]<=num[3];
						state<=3;
					end
					else if(num[5]>num[3])
					begin
						num[3]<=num[5];
						num[5]<=num[3];
						state<=3;
					end
					else
					begin
						num[3]<=num[4];
						num[4]<=num[3];
						state<=3;
					end
				end
				else if(num[3]>num[2])
				begin
					if(num[7]>num[2])
					begin
						num[2]<=num[7];
						num[7]<=num[2];
						state<=2;
					end
					else if(num[6]>num[2])
					begin
						num[2]<=num[6];
						num[6]<=num[2];
						state<=2;
					end
					else if(num[5]>=num[2])
					begin
						num[2]<=num[5];
						num[5]<=num[2];
						state<=2;
					end
					else if(num[4]>=num[2])
					begin
						num[2]<=num[4];
						num[4]<=num[2];
						state<=2;
					end
					else
					begin
						num[2]<=num[3];
						num[3]<=num[2];
						state<=2;
					end
				end
				else if(num[2]>num[1])
				begin
					//$display("hi");
					//$display("%d %d %d %d %d %d %d %d",num[0],num[1],num[2],num[3],num[4],num[5],num[6],num[7]);
					if(num[7]>num[1])
					begin
						num[1]<=num[7];
						num[7]<=num[1];
						state<=1;
					end
					else if(num[6]>num[1])
					begin
						num[1]<=num[6];
						num[6]<=num[1];
						state<=1;
					end
					else if(num[5]>num[1])
					begin
						num[1]<=num[5];
						num[5]<=num[1];
						state<=1;
					end
					else if(num[4]>num[1])
					begin
						num[1]<=num[4];
						num[4]<=num[1];
						state<=1;
					end
					else if(num[3]>num[1])
					begin
						num[1]<=num[3];
						num[3]<=num[1];
						state<=1;
					end
					else
					begin
						num[1]<=num[2];
						num[2]<=num[1];
						state<=1;
					end
				end
				else if(num[1]>num[0])
				begin
					if(num[7]>num[0])
					begin
						num[0]<=num[7];
						num[7]<=num[0];
						state<=0;
					end
					else if(num[6]>num[0])
					begin
						num[0]<=num[6];
						num[6]<=num[0];
						state<=0;
					end
					else if(num[5]>num[0])
					begin
						num[0]<=num[5];
						num[5]<=num[0];
						state<=0;
					end
					else if(num[4]>num[0])
					begin
						num[0]<=num[4];
						num[4]<=num[0];
						state<=0;
					end
					else if(num[3]>num[0])
					begin
						num[0]<=num[3];
						num[3]<=num[0];
						state<=0;
					end
					else if(num[2]>num[0])
					begin
						num[0]<=num[2];
						num[2]<=num[0];
						state<=0;
					end
					else
					begin
						num[0]<=num[1];
						num[1]<=num[0];
						state<=0;
					end
				end
				else
				begin
					Valid<=1;
					MinCost<=min_cost;
					MatchCount<=match_count;
				end
			end
			5'd5:begin
				num[6]<=num[7];
				num[7]<=num[6];
				state<=9;
			end
			5'd4:begin
				num[5]<=num[7];
				//num[6]<=num[6];
				num[7]<=num[5];
				state<=9;
			end
			5'd3:begin
				num[4]<=num[7];
				num[5]<=num[6];
				num[6]<=num[5];
				num[7]<=num[4];
				state<=9;
			end
			5'd2:begin
				num[3]<=num[7];
				num[4]<=num[6];
				//num[5]<=num[5];
				num[6]<=num[4];
				num[7]<=num[3];
				state<=9;
			end
			5'd1:begin
				num[2]<=num[7];
				num[3]<=num[6];
				num[4]<=num[5];
				num[5]<=num[4];
				num[6]<=num[3];
				num[7]<=num[2];
				state<=9;
			end
			5'd0:begin
				num[1]<=num[7];
				num[2]<=num[6];
				num[3]<=num[5];
				//num[4]<=num[4];
				num[5]<=num[3];
				num[6]<=num[2];
				num[7]<=num[1];
				state<=9;
			end
		endcase
    	end
end

always @(posedge CLK or posedge RST)
begin
	if(RST)
	begin
		ix<=0;
	end
	else
	begin
		if(ix==8)
		begin
			ix<=ix+1;
		end
		else if(ix==9)
		begin
			ix<=0;
		end
		else
		begin
			J<=num_tmp[ix];
			W<=ix;
			ix<=ix+1;
		end
	end	
end

//find minimum cost
always @(posedge CLK or posedge RST)
begin
	if(RST)
	begin
		min_cost<=1023;
		match_count<=0;
		tmp_cost<=0;
	end
	else
	begin
		if(ix==9 && Valid==0)
		begin
			if(tmp_cost<min_cost)
			begin
				min_cost<=tmp_cost;
				match_count<=1;
				tmp_cost<=0;
			end
			else if(tmp_cost==min_cost)
			begin
				match_count<=match_count+1;
				tmp_cost<=0;
			end
			else
			begin
				tmp_cost<=0;
			end
		end
		else if(ix>0 && Valid==0)
		begin
			tmp_cost<=tmp_cost+Cost;
		end
	end
end

endmodule


