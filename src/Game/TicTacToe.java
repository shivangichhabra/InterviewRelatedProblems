package Game;

import java.util.Random;

public class TicTacToe {
    int[][] board ;
    int n;
    int player;
    int[] rows;
    int[] cols;
    int dc1, dc2;

    public TicTacToe(int n){
        this.n = n;
        board = new int[n][n];
        player = 1;
        rows = new int[n];
        cols = new int[n];
    }

    public void initializeBoard(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = -1;
            }
        }
    }

    public boolean isBoardFull(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == -1)
                    return false;
            }
        }
        return true;
    }

    public void printBoard(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins.

     Time O(n)
     */
    public int moveON(int row, int col, int player){
        boolean win = true;
        //place mark
        board[row][col] = player;

        //check row
        for(int i=0; i<board.length; i++){
            if(board[row][i] != player) {
                win = false;
                break;
            }
        }

        if(win) return player;

        //check column
        for(int i=0; i<board[0].length; i++){
            if(board[i][col] != player) {
                win = false;
                break;
            }
        }

        if(win) return player;

        //check back diagonal
        for(int i=0; i<board.length; i++){
            if(board[i][i] != player) {
                win = false;
                break;
            }
        }

        if(win) return player;

        //check forward diagonal
        for(int i=0; i<board.length; i++){
            if(board[i][board.length-1-i] != player) {
                win = false;
                break;
            }
        }

        if(win) return player;

        return 0;
    }

    /*
    A better way to do the same thing
     */
    //O(N)
    public int moveN(int row, int col, int player){
        int numOfMatches = player == 1 ? 1 : -1;

        rows[row] += numOfMatches;
        cols[col] += numOfMatches;

        if(col == row)
            dc1 += numOfMatches;

        if(col == n-1-row)
            dc2 += numOfMatches;

        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || dc1 == n || dc2 == n)
            return player;

        return 0; // draw
    }

    public void play(){
        Random rand = new Random();
        while(!isBoardFull()) {
            int randX = rand.nextInt(n);
            int randY = rand.nextInt(n);
            if (moveON(randX, randY, player) != 0) {
                System.out.println(player + " won!");
                return;
            }
            player = switchPlayers();
        }
    }

    public int switchPlayers(){
        return player == 1 ? 2 : 1;
    }

    public static void main(String args[]){
        TicTacToe ttt = new TicTacToe(3);
        ttt.initializeBoard();
        ttt.printBoard();
        ttt.play();
        ttt.printBoard();
    }
}
