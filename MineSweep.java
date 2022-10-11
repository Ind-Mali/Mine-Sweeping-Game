import java.util.Random;
import java.util.Scanner;

public class MineSweep {
    int rowNumber, colNumber, size;
    int[][] map;
    int[][] board;
    boolean isGame = true;

    Random rand = new Random();
    Scanner scan = new Scanner(System.in);

    MineSweep(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
        this.size = rowNumber * colNumber;

    }

    public void prepareGame() {
        int randRow, randCol, count = 0;
        while (count != size / 4) {
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(colNumber);
            if (map[randRow][randCol] != -1) {
                map[randRow][randCol] = -1;
                count++;
            }
        }
    }

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] >= 0)
                    System.out.print(" ");
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void check(int r, int c) {
        if (map[r][c] == 0) {
            if ((c < colNumber - 1) && (map[r][c + 1] == -1)) {
                board[r][c]++;
            }
            if ((r < rowNumber - 1) && (map[r + 1][c] == -1)) {
                board[r][c]++;
            }
            if ((r > 0) && (map[r - 1][c] == -1)) {
                board[r][c]++;
            }
            if ((c > 0) && (map[r][c - 1] == -1)) {
                board[r][c]++;
            }

            /*
             * If I add this below code block, the app throw the error of
             * ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 2
             * I did not make a good solution.
             * I utilized lots of if statement, If I write a clean code I will do this at
             * the future.
             */

            // if ((map[r - 1][c + 1] == -1) && ((r > 0) && ( c < colNumber -1))) {
            // board[r][c]++;
            // }
            // if ((map[r + 1][c - 1] == -1) && ((r < rowNumber -1) && ( c > 0))) {
            // board[r][c]++;
            // }
            // if ((map[r + 1][c + 1] == -1) && ((r < rowNumber - 1) && ( c < colNumber
            // -1))) {
            // board[r][c]++;
            // }
            // if ((map[r - 1][c - 1] == -1) && (( r > 0)&&( c > 0))) {
            // board[r][c]++;
            // }

            if (board[r][c] == 0) {
                board[r][c] = -2;

            }

        }

    }

    public void run() {
        int row, col, counter = 0;
        prepareGame();
        print(map);
        System.out.println("The game start");
        while (isGame) {
            print(board);
            System.out.print("Enter row number: ");
            row = scan.nextInt();
            System.out.print("Enter column number: ");
            col = scan.nextInt();
            if ((row < 0) || (row >= rowNumber)) {
                System.out.println("You should not enter out of range number!!");
                continue;
            }
            if ((col < 0) || (col >= colNumber)) {
                System.out.println("You should not enter out of range number!!");
                continue;
            }
            if (map[row][col] != -1) {
                check(row, col);
                counter++;
                if (counter == (size - (size / 4))) {
                    System.out.println("You WON :) ");
                    break;

                }
            } else {
                isGame = false;
                System.out.println("Game OVER!");
            }
        }
    }
}
