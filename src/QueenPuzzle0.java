import java.util.Arrays;
import java.util.Scanner;

public class QueenPuzzle0{
    private static String[][] board;
    private static boolean[][] availableBoard;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.print("Size of board: ");
        int size = s.nextInt();
        board = new String[size][size];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = "-";
            }
        }
        queenPlacement();
        for(String[]row : board){
            for(String position : row){
                System.out.print(position + " ");
            }
            System.out.println();
        }
        System.out.println(queenSafe(board));
    }

    public static void queenPlacement(){
        int queensPlaced = 0;
        board[0][0] = "Q";
        while(!queenSafe(board) && queensPlaced == board.length){

        }
    }
    public static boolean queenSafe(String[][]board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j].equals("Q")){
                    for(int k = 0; k < board[0].length; k++){
                        board[i][k] = "x"; //testing
                        if(board[i][k].equals("Q") && k!=j){

                            return false;
                        }
                    }
                    for(int l = 0; l < board.length; l++){
                        board[l][j] = "x"; //testing 
                        if(board[l][j].equals("Q") && l!=i){

                            return false;
                        }
                    }
                    int k = i;
                    int l = j;
                    while(k > 0 && l > 0){
                        k--;
                        l--;

                        if(board[k][l].equals("Q")){
                            return false;
                        }
                    }
                    k=0;
                    l=0;
                    while(k < board.length-1 && l < board.length-1){
                        k++;
                        l++;
                        if(board[k][l].equals("Q")){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
