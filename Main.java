import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row, column;
        System.out.println("Welcome your game !");
        System.out.println("Please enter game range");
        System.out.print("Row numbers: ");
        row = scan.nextInt();
        System.out.print("Column numbers: ");
        column = scan.nextInt();
        MineSweep mine = new MineSweep(row, column);
        mine.run();
    }
}