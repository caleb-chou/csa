/**
 * Student Name: Caleb Chou
 * Student ID  : cyc3086, 53086
 * Lab         : 03
 */
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
public class Cyc3086Dice {
	public static Scanner s;
	public static void main(String[] args) {
		s = new Scanner(System.in);
		int numDice=0;
		do {
			System.out.print("How many dice are you simulating? (2-6) ");
			try {
				numDice = s.nextInt();
			} catch(Exception e) {
				numDice = s.nextInt();
			}
			if(numDice > 6 || numDice < 2) {
				System.out.println("Invalid input.");
			}
		} while(numDice > 6 || numDice < 2);
		int[] diceSides = new int[numDice];
		@SuppressWarnings({ "unchecked", "rawtypes" })
		HashMap<Integer,Integer> h = new HashMap();
		for(int i = 0;i<numDice;i++) {
			System.out.printf("Sides for dice%d: ",i+1);
			int tempSides= s.nextInt();
			if(tempSides<4||tempSides>20) {
				System.out.println("Invalid Amount. Please try again.");
				i--;
				continue;
			}
			diceSides[i] = tempSides;
		}
		int numSum=0;
		for(int i :diceSides) {
			numSum += i;
		}
		for(int i = numDice;i<=numSum;i++) {
			h.put(i, 1);
		}
		for(int i = 0;i<1000;i++) {
			int sum =0;
			for(int k = 0;k<numDice;k++) {
				sum += (int)Math.floor(Math.random() * diceSides[k])+1;
			}
			h.put(sum, h.get(sum)+1);
		}
		System.out.print("Value:\t");
		for(int key:h.keySet()) {
			System.out.printf("%s\t",key);
		}
		System.out.print("\nResult:\t");
		for(int key:h.keySet()) {
			System.out.printf("%s\t",h.get(key));
		}
		System.out.print("\nChance:\t");
		for(int key:h.keySet()) {
			System.out.printf("%,.2f\t",h.get(key)/1000.0);
		}
		System.out.println();
		for(int i = Collections.max(h.values());i>=0;i--) {
			for(int key:h.keySet()) {
				if(h.get(key)>i) {
					System.out.print("* ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}