/**
 *
 * @author : 409410082
 * @latest changed : 2022/5/15 07:11
 */

`define length 6

module lab8(input clk,
            input reset,
            input give_valid,
            input [7:0]dataX,
            input [7:0]dataY,
            output reg [7:0]ansX,
            output reg [7:0]ansY,
            output reg out_valid);

integer i;
integer j;
reg signed [12:0]inX[0:`length-1];
reg signed [12:0]inY[0:`length-1];
reg signed [7:0]tempX[0:`length-1];
reg signed [7:0]tempY[0:`length-1];
reg signed [7:0]count[0:`length-1];

//reg signed [7:0]cross[0:`length-1];

reg [7:0]ix;
reg [7:0]iy;
reg [7:0]cnt_i;
reg [7:0]cnt_j;
reg [7:0]number;
reg tmp;
reg finish;

initial begin
    $dumpfile("Lab.vcd");
    $dumpvars(0, lab8tb);
    for(i = 0; i < `length; i = i+1)
        $dumpvars(1, inX[i], inY[i], tempX[i], tempY[i], count[i]);
end

always@(posedge clk or posedge reset)
begin
    if(reset)
    begin
		  tmp<=0;
		  cnt_i<=`length-1;
		  cnt_j<=1;
		  ix<=0;
        for (i = 0; i < `length; i = i + 1)
        begin
            inX[i] <= 0;
            inY[i] <= 0;
        end
    end
    else if(give_valid)
    begin
        inX[ix] <= dataX;
        inY[ix] <= dataY;
        ix <= ix + 1;
	end
	else if(ix==6)
	begin
		//give_valid<=0;
		//4 round
		if(cnt_i==0)
		begin
			tmp<=1;
			ix<=0;
		end
		else if(cnt_j==cnt_i)
		begin
			cnt_i<=cnt_i-1;
			cnt_j<=1;
		end
		else
		begin
			//check<=j;
			//check<=(inX[cnt_j]-inX[0])*(inY[cnt_j+1]-inY[0])-(inY[cnt_j]-inY[0])*(inX[cnt_j+1]-inX[0]);
			if(((inX[cnt_j]-inX[0])*(inY[cnt_j+1]-inY[0])-(inY[cnt_j]-inY[0])*(inX[cnt_j+1]-inX[0]))<0)
			begin
				inX[cnt_j]<=inX[cnt_j+1];
				inX[cnt_j+1]<=inX[cnt_j];
				inY[cnt_j]<=inY[cnt_j+1];
				inY[cnt_j+1]<=inY[cnt_j];
			end
			cnt_j<=cnt_j+1;
		end
	end
	else if(iy==6)
	begin
		tmp<=0;
		cnt_i<=`length-1;
		cnt_j<=1;
	end
end

always@(posedge clk or posedge reset)
begin
    if(reset)
    begin
        out_valid <= 0;
		  finish <= 0;
    end
	 else if(out_valid)
	 begin
		ansX<=inX[iy];
		ansY<=inY[iy];
		iy<=iy+1;
		//tmp <= 0;
		//give_valid<=1;
		if(iy==6)
		begin
			out_valid <= 0;
			iy <= 0;
			ansX <= 0;
			ansY <= 0;
			//ix<=0;
		end
	 end
	 else if(!out_valid && tmp==1)
	 begin
		ansX<=inX[0];
		ansY<=inY[0];
		iy<=1;
		out_valid <= 1;
		//give_valid<=1;
	 end
end

endmodule

/*==================================*/
