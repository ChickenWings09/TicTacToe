import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static char player = 'X';

    public static void main(String[] args) {    
        while (!gameIsOver()){
            displayBoard();
            makeMove();
            switchCurrentPlayer();
        }
    
        displayBoard();

    }

    private static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-----");
            }
        }
        System.out.println();
    }

    private static void makeMove() {
        Scanner inputMove = new Scanner(System.in);
        int row = -1;  // Initialize row and column with invalid values
        int column = -1;
    
        while(!isValidMove(row, column)) {
            System.out.println(player + " enter the row and column you want to place your piece(row column): ");
            row = inputMove.nextInt();
            column = inputMove.nextInt();
        }
    
        board[row][column] = player;
    }
        

    private static void switchCurrentPlayer() {
        if (player == 'X') {
            player = 'O';
        } else {
            player = 'X';
        }  
    }

    private static boolean gameIsOver() {
        return isWin() || isBoardFull();
    }

    private static boolean isWin() {
        return checkTripleRows() || checkTripleColumns() || checkTripleDiagonals();
    }

    private static boolean checkTripleRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean checkTripleColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean checkTripleDiagonals() {
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) || (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
                return true;
        } else {
            return false;
        }
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isValidMove(int row, int column) {
        if (row < 0 || row > 2 || column < 0 || column > 2 || board[row][column] != ' ') {
            System.out.println("Invalid move. Try again.");
            return false;
        }
        return true;
    }
}
