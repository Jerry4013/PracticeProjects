import java.awt.*;

public class TicTacToeService {

    public static final int EMPTY = 0;
    public static final int CIRCLE = 1;
    public static final int CROSS = 2;
    public static final int ROWS = 3;
    public static final int COLS = 3;
    public static final int DIAGONAL = 3;

    private Game game = new Game();

    public void toCircle(Point point){
        int x = (int) point.getX();
        int y = (int) point.getY();
        int[][] board = game.getBoard();
        if(board[x][y] == EMPTY) {
            board[x][y] = CIRCLE;
        }
    }

    public void toCross(Point point){
        int x = (int) point.getX();
        int y = (int) point.getY();
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
        if(judgeWhoWins(1))
            return 1;
        if(judgeWhoWins(2))
            return 2;
        return 0;
    }

    private boolean judgeWhoWins(int circleOrCross){
        boolean result = false;
        boolean[] line = new boolean[8];
        for (int i = 0; i < line.length; i++) {
            line[i] = true;
        }
        int[][] board = game.getBoard();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] != circleOrCross){
                    line[i] = false;
                    break;
                }
            }
        }
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                if (board[j][i] != circleOrCross){
                    line[i+3] = false;
                    break;
                }
            }
        }
        for (int i = 0; i < DIAGONAL; i++) {
            if (board[i][i] != circleOrCross)
                line[6] = false;
        }
        for (int i = 0; i < DIAGONAL; i++) {
            if (board[i][DIAGONAL-i-1] != circleOrCross)
                line[7] = false;
        }
        for (int i = 0; i < line.length; i++) {
            if (line[i] == true){
                result = true;
                break;
            }
        }
        return result;
    }
}
