package Minesweeper;
import java.util.Random;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Row : ");
		int row = scan.nextInt();
		System.out.println("Col : ");
		int col = scan.nextInt();
		
		Minesweeper game1 = new Minesweeper(row, col);
		game1.run();
	}
}
