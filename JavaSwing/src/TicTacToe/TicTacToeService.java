package TicTacToe;

public class TicTacToeService {

    public static final int EMPTY = 0;
    public static final int CIRCLE = 1;
    public static final int CROSS = 2;

    private Game game = new Game();

    public void toCircle(Coordinates coordinate){
        int x = coordinate.getX();
        int y = coordinate.getY();
        int[][] board = game.getBoard();
        if(board[x][y] == EMPTY) {
            board[x][y] = CIRCLE;
        }
    }

    public void toCross(Coordinates coordinate){
        int x = coordinate.getX();
        int y = coordinate.getY();
        int[][] board = game.getBoard();
        if(board[x][y] == EMPTY) {
            board[x][y] = CROSS;
        }
    }

    public void clear(){
        game.setBoard(new int[3][3]);
    }

    public int[][] get(){
        return game.getBoard();
    }

    public int getResult(){
        if(circleLine())
            return 1;
        if(crossLine())
            return 2;
        return 0;
    }

    private boolean circleLine(){
        int[][] currentBoard = game.getBoard();
        if(currentBoard[0][0]==1 && currentBoard[0][1]==1 && currentBoard[0][2]==1
                || currentBoard[1][0]==1 && currentBoard[1][1]==1 && currentBoard[1][2]==1
                || currentBoard[2][0]==1 && currentBoard[2][1]==1 && currentBoard[2][2]==1)
            return true;
        if(currentBoard[0][0]==1 && currentBoard[1][0]==1 && currentBoard[2][0]==1
                || currentBoard[0][1]==1 && currentBoard[1][1]==1 && currentBoard[2][1]==1
                || currentBoard[0][2]==1 && currentBoard[1][2]==1 && currentBoard[2][2]==1)
            return true;
        if(currentBoard[0][0]==1 && currentBoard[1][1]==1 && currentBoard[2][2]==1
                || currentBoard[0][2]==1 && currentBoard[1][1]==1 && currentBoard[2][0]==1)
            return true;
        return false;
    }

    private boolean crossLine(){
        int[][] currentBoard = game.getBoard();
        if(currentBoard[0][0]==2 && currentBoard[0][1]==2 && currentBoard[0][2]==2
                || currentBoard[1][0]==2 && currentBoard[1][1]==2 && currentBoard[1][2]==2
                || currentBoard[2][0]==2 && currentBoard[2][1]==2 && currentBoard[2][2]==2)
            return true;
        if(currentBoard[0][0]==2 && currentBoard[1][0]==2 && currentBoard[2][0]==2
                || currentBoard[0][1]==2 && currentBoard[1][1]==2 && currentBoard[2][1]==2
                || currentBoard[0][2]==2 && currentBoard[1][2]==2 && currentBoard[2][2]==2)
            return true;
        if(currentBoard[0][0]==2 && currentBoard[1][1]==2 && currentBoard[2][2]==2
                || currentBoard[0][2]==2 && currentBoard[1][1]==2 && currentBoard[2][0]==2)
            return true;
        return false;
    }


}
