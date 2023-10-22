import java.util.Arrays;
import java.util.Scanner;

public class Connect4Game {
    public static void main(String[] args) {
        int rows = 6;
        int cols = 7;
        char[][] board = new char[rows][cols];
        boolean gameWon = false;
        char currentPlayer = 'X';

        initializeBoard(board);

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        while (!gameWon) {
            displayBoard(board);

            int col = getPlayerMove(scanner, currentPlayer);
            int row = dropPiece(board, col, currentPlayer);

            gameWon = checkWin(board, row, col, currentPlayer);

            if (!gameWon) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        displayBoard(board);
        System.out.println("Player " + currentPlayer + " wins!");

        // Close the scanner
        scanner.close();
    }

    public static void initializeBoard(char[][] board) {
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
    }

    public static void displayBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print("| " + board[row][col] + " ");
            }
            System.out.println("|");
        }
        for (int col = 0; col < board[0].length; col++) {
            System.out.print(" " + (col + 1) + "  ");
        }
        System.out.println();
    }

    public static int getPlayerMove(Scanner scanner, char currentPlayer) {
        int col;
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (1-7):");
            col = scanner.nextInt();
            if (col >= 1 && col <= 7) {
                return col - 1;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public static int dropPiece(char[][] board, int col, char currentPlayer) {
        for (int row = board.length - 1; row >= 0; row--) {
            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                return row;
            }
        }
        return -1; // Column is full
    }

    public static boolean checkWin(char[][] board, int row, int col, char player) {
        // Check for a win horizontally, vertically, or diagonally
        return checkHorizontal(board, row, col, player) || checkVertical(board, row, col, player)
                || checkDiagonal1(board, row, col, player) || checkDiagonal2(board, row, col, player);
    }

    public static boolean checkHorizontal(char[][] board, int row, int col, char player) {
        int count = 0;
        for (int c = Math.max(0, col - 3); c <= Math.min(board[0].length - 1, col + 3); c++) {
            if (board[row][c] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public static boolean checkVertical(char[][] board, int row, int col, char player) {
        int count = 0;
        for (int r = Math.max(0, row - 3); r <= Math.min(board.length - 1, row + 3); r++) {
            if (board[r][col] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public static boolean checkDiagonal1(char[][] board, int row, int col, char player) {
        int count = 0;
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        for (int r = row + 1, c = col + 1; r < board.length && c < board[0].length; r++, c++) {
            if (board[r][c] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public static boolean checkDiagonal2(char[][] board, int row, int col, char player) {
        int count = 0;
        for (int r = row, c = col; r >= 0 && c < board[0].length; r--, c++) {
            if (board[r][c] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        for (int r = row + 1, c = col - 1; r < board.length && c >= 0; r++, c--) {
            if (board[r][c] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}
