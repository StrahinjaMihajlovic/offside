package offsideAssigment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static boolean offsidePosition(Integer[][] teams, Integer value) {
		Integer[] maxTeam1 = {100, 100}; // team on the left side of the field, defence and a goalkeeper
		Integer[] maxTeam2 = {0, 0}; // team on the right side of the field, defence and a goalkeeper
		
		for(int i = 0; i<11; i++) {
			if((maxTeam1[0] > teams[0][i]) || (maxTeam1[1] > teams[0][i])) 
				maxTeam1[maxTeam1[0] > teams[0][i] ? 0:1] = teams[0][i];
			
			if((maxTeam2[0] < teams[1][i]) || (maxTeam2[1] < teams[1][i])) 
				maxTeam2[maxTeam2[0] < teams[1][i] ? 0:1] = teams[1][i];
		}
		
		for(int i = 0; i < 11; i++) {
			if(maxTeam1[1] > teams[1][i]) {
				System.out.println("Player at position " + teams[1][i] + " is at offside!");
				return true;
			}
			
			if(maxTeam2[1] < teams[0][i]) {
				value = teams[0][i];
				System.out.println("Player at the position "+ teams[0][i] + " is at offside!");
				return true;
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		Integer[][] teams = new Integer[2][11]; // comment too if using example instead of the input
		Integer vrednost = null;
		Scanner input = new Scanner(System.in);
		
		for(int j = 0; j<2; j++)
			for(int i = 0; i < 11; i++) {
				try {
					System.out.println("Insert position of the player number "+ (i + 1) + ((j == 0) ? " in the left team":" in the right team"));
					teams[j][i] = input.nextInt();
					
					if(teams[j][i] < 1 || teams[j][i] > 99) {
						throw new NumberFormatException();
					}
					
				} catch (InputMismatchException e) {
					System.out.println("The input must a number!");
					input.nextLine();
					i--;
				} catch (NumberFormatException k) {
					System.out.println("The input must be >0 and <100");
					i--;
				} 
		}
		input.close();
	
		// test example bellow, comment upper for loop if it is easier to use like that.
		//Integer[][] teams = {{5, 25, 30, 40, 30, 50, 30, 50, 50, 70, 50}, {96, 25, 30, 25, 25, 40, 60, 70, 80, 70, 40}};
		System.out.println(offsidePosition(teams, vrednost) ? "":"No on is at the offside!");
		
	}

}
