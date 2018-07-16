package Game;

public class ValidateTicTacToe {
    public boolean validTicTacToe(String[] board) {
        int countX = getCount('X', board);
        int countO = getCount('O', board);

        if(countX == countO || countX == countO+1){
            if(wonBy('O' , board)){
                if(wonBy('X', board))
                    return false;

                if(countX != countO)
                    return false;
            }

            if(wonBy('X', board)){
                return countX > countO;
            }

            return true;
        }
        return false;
    }

    private int getCount(char ch, String[] board){
        int count = 0;
        for(String row : board){
            for(int i=0; i<row.length(); i++){
                if(row.charAt(i) == ch)
                    count++;
            }
        }
        return count;
    }

    private boolean wonBy(char ch, String[] board){
        //check row
        for(String row : board) {
            if (row.charAt(0) == ch && row.charAt(1) == ch && row.charAt(2) == ch)
                return true;
        }

        //check column
        for(int col=0; col<3; col++) {
            if (board[0].charAt(col) == ch && board[1].charAt(col) == ch && board[2].charAt(col) == ch)
                return true;
        }

        //check diagonal
        for(int col=0; col<3; col++) {
            if (board[0].charAt(0) == ch && board[1].charAt(1) == ch  && board[2].charAt(2) == ch)
                return true;

            if (board[0].charAt(2) == ch && board[1].charAt(1) == ch  && board[2].charAt(0) == ch)
                return true;
        }
        return false;
    }

    public static void main(String args[]){
        ValidateTicTacToe vttt = new ValidateTicTacToe();
        String[] board = {"XOX", "O O", "XOX"};
        System.out.println(vttt.validTicTacToe(board));
    }
}
