package Minesweeper;
import java.util.Scanner;

public class Minesweeper {
	int row;
	int col;
	String[][] map;
	String[][] mapWithBomb;

	public Minesweeper(int row, int col) {
		this.row = row;
		this.col = col;
		
		this.map = new String[row][col];
		
		for(int i = 0; i<this.row; i++) {
			for(int j = 0; j<this.col; j++) {
				this.map[i][j] = "-";
			}
		}
		
		this.mapWithBomb = new String[row][col];
		
		for(int i = 0; i<this.row; i++) {
			for(int j = 0; j<this.col; j++) {
				this.mapWithBomb[i][j] = "-";
			}
		}
		
		placeTheBombs(mapWithBomb);
		
	}
	
	void placeTheBombs(String array[][]) {
		for(int k = 0; k<(mapWithBomb.length * mapWithBomb[0].length)/4; k++) {
			int randomi = (int) (Math.random() * mapWithBomb.length);
			int randomj = (int) (Math.random() * mapWithBomb[0].length);
			
			if(!mapWithBomb[randomi][randomj].equals("*")) {
				this.mapWithBomb[randomi][randomj] = "*";
			}else {
				k--;
			}
		}
	}
	
	
	public void run () {
		
		System.out.println("Mayinlarin Konumu");
		printMap(mapWithBomb);
		
		System.out.println("\nMayin Tarlasi Oyununa Hosgeldiniz!");
		printMap(map);
		
		while(isContinuing()) {
			System.out.println("==========");
			printMap(map);
		}
	}
	  boolean isContinuing(){

	        Scanner input = new Scanner(System.in);

	        if (isWin(map)){
	            System.out.println("Tebrikler kazandýnýz! ");
	            return false;
	        }
	        System.out.print("\nSatýr Giriniz: ");
	        int i = input.nextInt();
	        System.out.print("Sütun Giriniz: ");
	        int j = input.nextInt();

	        if ((map.length > i &&  i >= 0) && (map[0].length > j && j >= 0)){
	            if (mapWithBomb[i][j].equals("*")){
	                System.out.println("Kaybettiniz!");
	                return false;
	            }
	            else {
	                int sayac = 0;

	                if (i==0 && j==0){
	                    if (mapWithBomb[i][j+1].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i+1][j+1].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i+1][j].equals("*")) {
	                        sayac++;
	                    }
	                    map[i][j]=String.valueOf(sayac);
	                }
	                else if(i == 0  &&  j == map[0].length-1){
	                    if (mapWithBomb[i][j-1].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i+1][j-1].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i+1][j].equals("*")) {
	                        sayac++;
	                    }
	                    map[i][j]=String.valueOf(sayac);
	                }
	                else if(i == map.length-1  &&  j == map[0].length-1){
	                    if (mapWithBomb[i][j-1].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i-1][j-1].equals("*")){
	                        sayac++;
	                    }
	                   if(mapWithBomb[i-1][j].equals("*")) {
	                        sayac++;
	                    }
	                    map[i][j]=String.valueOf(sayac);
	                }
	                else if(i == map.length-1  &&  j == 0){
	                    if (mapWithBomb[i-1][j].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i-1][j+1].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i][j+1].equals("*")) {
	                        sayac++;
	                    }
	                    map[i][j]=String.valueOf(sayac);
	                }
	                else if(i == 0){
	                    if (mapWithBomb[i][j-1].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i+1][j-1].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i+1][j].equals("*")) {
	                        sayac++;
	                    }
	                    if(mapWithBomb[i+1][j+1].equals("*")) {
	                        sayac++;
	                    }
	                    if(mapWithBomb[i][j+1].equals("*")) {
	                        sayac++;
	                    }
	                    map[i][j]=String.valueOf(sayac);
	                }
	                else if(j == map[0].length-1){
	                    if (mapWithBomb[i-1][j].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i-1][j-1].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i][j-1].equals("*")) {
	                        sayac++;
	                    }
	                    if(mapWithBomb[i+1][j-1].equals("*")) {
	                        sayac++;
	                    }
	                    if(mapWithBomb[i+1][j].equals("*")) {
	                        sayac++;
	                    }
	                    map[i][j]=String.valueOf(sayac);
	                }
	                else if(i == map.length-1){
	                    if (mapWithBomb[i][j+1].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i-1][j+1].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i-1][j].equals("*")) {
	                        sayac++;
	                    }
	                    if(mapWithBomb[i-1][j-1].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i][j-1].equals("*")) {
	                        sayac++;
	                    }

	                    map[i][j]=String.valueOf(sayac);
	                }
	                else if(j == 0){
	                    if (mapWithBomb[i-1][j].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i-1][j+1].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i][j+1].equals("*")) {
	                        sayac++;
	                    }
	                    if(mapWithBomb[i+1][j+1].equals("*")) {
	                        sayac++;
	                    }
	                    if(mapWithBomb[i+1][j].equals("*")) {
	                        sayac++;
	                    }
	                    map[i][j]=String.valueOf(sayac);
	                }
	                else if(j != map[0].length-1 &&  i != map.length-1){
	                    if (mapWithBomb[i-1][j-1].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i-1][j].equals("*")){
	                        sayac++;
	                    }
	                    if(mapWithBomb[i-1][j+1].equals("*")) {
	                        sayac++;
	                    }
	                    if(mapWithBomb[i][j+1].equals("*")) {
	                        sayac++;
	                    }
	                    if(mapWithBomb[i+1][j+1].equals("*")) {
	                        sayac++;
	                    }
	                    if(mapWithBomb[i+1][j].equals("*")) {
	                        sayac++;
	                    }
	                    if(mapWithBomb[i+1][j-1].equals("*")) {
	                        sayac++;
	                    }
	                    if(mapWithBomb[i][j-1].equals("*")) {
	                        sayac++;
	                    }
	                    map[i][j] = String.valueOf(sayac);
	                }
	            }
	        }

	        else {
	            System.out.println("Sýnýrlarýn dýþýna çýktýnýz! ");
	            return true;
	        }
	        return true;
	    }

	
	boolean isWin(String arr[][]) {
		int sayac = 0;
		for(int i=0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j].equals("-")) {
					sayac++;
				}
			}
		}
		if(sayac == mapWithBomb.length * mapWithBomb[0].length / 4) {
			return true;
		}
		return false;
	}
		
	public void printMap(String[][] map) {
		for(int i = 0; i<map.length; i++) {
			for(int j = 0; j<map[0].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
}
