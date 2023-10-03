import java.util.EnumSet;
import java.util.Scanner;
public class Tic_Tac_Toe{ 
    public enum Status{
        O(),
        X(),
        EMPTY();
    }
    private Status[][]board=new Status[3][3];
    //constructor
    public Tic_Tac_Toe(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=Status.EMPTY;
            }
        }
    }
    public boolean isEmpty(int i,int j){
        if(board[i][j]==Status.EMPTY){
            return true;
        }
        return false;
    }
    //first player(0):X second player(1):O
    public void move(int i,int j,int player){
        if(player==0){
            board[i][j]=Status.X;
        }else{
            board[i][j]=Status.O;
        }
    }
    public boolean win(){
        //8 possible
        for(int i=0;i<3;i++){
            if(!isEmpty(i,0)&&board[i][0]==board[i][1]&&board[i][0]==board[i][2]){
                if(board[i][0]==Status.X){
                    System.out.println("First player wins");
                }else{
                    System.out.println("Second player wins");
                }
                return true;
            }
            if(!isEmpty(0,i)&&board[0][i]==board[1][i]&&board[0][i]==board[2][i]){
                if(board[0][i]==Status.X){
                    System.out.println("First player wins");
                }else{
                    System.out.println("Second player wins");
                }
                return true;
            }
        }
        if(!isEmpty(0,0)&&board[0][0]==board[1][1]&&board[0][0]==board[2][2]){
            if(board[0][0]==Status.X){
                System.out.println("First player wins");
            }else{
                System.out.println("Second player wins");
            }
            return true;
        }
        if(!isEmpty(0,2)&&board[0][2]==board[1][1]&&board[0][2]==board[2][0]){
            if(board[0][2]==Status.X){
                System.out.println("First player wins");
            }else{
                System.out.println("Second player wins");
            }
            return true;
        }
        return false;
    }
    public boolean game(){
        //if someone win,end the game
        if(this.win()){
            return false;
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==Status.EMPTY){
                    return true;
                }
            }
        }
        System.out.println("Draw");
        return false;
    }
    public void print(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.printf("%5s  ",board[i][j]);
            }
            System.out.print("\n");
        }
    }
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        Tic_Tac_Toe round=new Tic_Tac_Toe();
        int i,j;
        int state=0;
        while(round.game()){
            i=input.nextInt();
            j=input.nextInt();
            if(state==0){
                if(round.isEmpty(i,j)){
                    round.move(i,j,0);
                    round.print();
                    state=1;
                }else{
                    System.out.println("The move is invalid,enter again:");
                    continue;
                }
            }else{
                if(round.isEmpty(i,j)){
                    round.move(i,j,1);
                    round.print();
                    state=0;
                }else{
                    System.out.println("The move is invalid,enter again:");
                    continue;
                }
            }
        }
    }
}