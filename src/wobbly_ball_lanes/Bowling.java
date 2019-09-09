/* Author: Chou, Caleb
 * ID: cyc3086
 * Lab: 2
 */

import java.io.*;
import java.util.*;

public class Bowling {
	
	public static Scanner in;
	public static File file;
	
	public static void main(String[] args) throws FileNotFoundException {
		file = new File("E:/eclipse/eclipse-workspace/School/src/game.txt");
		in = new Scanner(file);
		String[] scores = in.nextLine().split(" ");
		int i =0;
		String printScore = "";
		String printScore2= "";
		int score = 0;
		
		if(scores[i].equals("10")) {
			score += 10 + Integer.parseInt(scores[i+1]) + Integer.parseInt(scores[i+2]);
			printScore += "X\t";
			printScore2+= "" + score + "\t";
			i++;
		} else {
			if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) == 10) {
				score += 10 + Integer.parseInt(scores[i+2]);
				printScore += scores[i] + " /\t";
				printScore2+= "" + score+"\t";
			} else if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) != 10){
				score += Integer.parseInt(scores[i]) + Integer.parseInt(scores[i+1]);
				printScore2 += "" + score + "\t";
				printScore += scores[i] + " " + scores[i+1] + "\t";
			}
			i+=2;
		}
		if(scores[i].equals("10")) {
			score += 10 + Integer.parseInt(scores[i+1]) + Integer.parseInt(scores[i+2]);
			printScore += "X\t";
			printScore2+= "" + score + "\t";
			i++;
		} else {
			if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) == 10) {
				score += 10 + Integer.parseInt(scores[i+2]);
				printScore += scores[i] + " /\t";
				printScore2+= "" + score+"\t";
			} else if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) != 10){
				score += Integer.parseInt(scores[i]) + Integer.parseInt(scores[i+1]);
				printScore2 += "" + score + "\t";
				printScore += scores[i] + " " + scores[i+1] + "\t";
			}
			i+=2;
		}
		if(scores[i].equals("10")) {
			score += 10 + Integer.parseInt(scores[i+1]) + Integer.parseInt(scores[i+2]);
			printScore += "X\t";
			printScore2+= "" + score + "\t";
			i++;
		} else {
			if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) == 10) {
				score += 10 + Integer.parseInt(scores[i+2]);
				printScore += scores[i] + " /\t";
				printScore2+= "" + score+"\t";
			} else if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) != 10){
				score += Integer.parseInt(scores[i]) + Integer.parseInt(scores[i+1]);
				printScore2 += "" + score + "\t";
				printScore += scores[i] + " " + scores[i+1] + "\t";
			}
			i+=2;
		}
		if(scores[i].equals("10")) {
			score += 10 + Integer.parseInt(scores[i+1]) + Integer.parseInt(scores[i+2]);
			printScore += "X\t";
			printScore2+= "" + score + "\t";
			i++;
		} else {
			if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) == 10) {
				score += 10 + Integer.parseInt(scores[i+2]);
				printScore += scores[i] + " /\t";
				printScore2+= "" + score+"\t";
			} else if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) != 10){
				score += Integer.parseInt(scores[i]) + Integer.parseInt(scores[i+1]);
				printScore2 += "" + score + "\t";
				printScore += scores[i] + " " + scores[i+1] + "\t";
			}
			i+=2;
		}
		if(scores[i].equals("10")) {
			score += 10 + Integer.parseInt(scores[i+1]) + Integer.parseInt(scores[i+2]);
			printScore += "X\t";
			printScore2+= "" + score + "\t";
			i++;
		} else {
			if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) == 10) {
				score += 10 + Integer.parseInt(scores[i+2]);
				printScore += scores[i] + " /\t";
				printScore2+= "" + score+"\t";
			} else if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) != 10){
				score += Integer.parseInt(scores[i]) + Integer.parseInt(scores[i+1]);
				printScore2 += "" + score + "\t";
				printScore += scores[i] + " " + scores[i+1] + "\t";
			}
			i+=2;
		}
		if(scores[i].equals("10")) {
			score += 10 + Integer.parseInt(scores[i+1]) + Integer.parseInt(scores[i+2]);
			printScore += "X\t";
			printScore2+= "" + score + "\t";
			i++;
		} else {
			if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) == 10) {
				score += 10 + Integer.parseInt(scores[i+2]);
				printScore += scores[i] + " /\t";
				printScore2+= "" + score+"\t";
			} else if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) != 10){
				score += Integer.parseInt(scores[i]) + Integer.parseInt(scores[i+1]);
				printScore2 += "" + score + "\t";
				printScore += scores[i] + " " + scores[i+1] + "\t";
			}
			i+=2;
		}
		if(scores[i].equals("10")) {
			score += 10 + Integer.parseInt(scores[i+1]) + Integer.parseInt(scores[i+2]);
			printScore += "X\t";
			printScore2+= "" + score + "\t";
			i++;
		} else {
			if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) == 10) {
				score += 10 + Integer.parseInt(scores[i+2]);
				printScore += scores[i] + " /\t";
				printScore2+= "" + score+"\t";
			} else if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) != 10){
				score += Integer.parseInt(scores[i]) + Integer.parseInt(scores[i+1]);
				printScore2 += "" + score + "\t";
				printScore += scores[i] + " " + scores[i+1] + "\t";
			}
			i+=2;
		}
		if(scores[i].equals("10")) {
			score += 10 + Integer.parseInt(scores[i+1]) + Integer.parseInt(scores[i+2]);
			printScore += "X\t";
			printScore2+= "" + score + "\t";
			i++;
		} else {
			if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) == 10) {
				score += 10 + Integer.parseInt(scores[i+2]);
				printScore += scores[i] + " /\t";
				printScore2+= "" + score+"\t";
			} else if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) != 10){
				score += Integer.parseInt(scores[i]) + Integer.parseInt(scores[i+1]);
				printScore2 += "" + score + "\t";
				printScore += scores[i] + " " + scores[i+1] + "\t";
			}
			i+=2;
		}
		if(scores[i].equals("10")) {
			score += 10 + Integer.parseInt(scores[i+1]) + Integer.parseInt(scores[i+2]);
			printScore += "X\t";
			printScore2+= "" + score + "\t";
			i++;
		} else {
			if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) == 10) {
				score += 10 + Integer.parseInt(scores[i+2]);
				printScore += scores[i] + " /\t";
				printScore2+= "" + score+"\t";
			} else if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) != 10){
				score += Integer.parseInt(scores[i]) + Integer.parseInt(scores[i+1]);
				printScore2 += "" + score + "\t";
				printScore += scores[i] + " " + scores[i+1] + "\t";
			}
			i+=2;
		}
		if(scores[i].equals("10")) {
			score += 10 + Integer.parseInt(scores[i+1]) + Integer.parseInt(scores[i+2]);
			printScore += "X\t";
			printScore2+= "" + score + "\t";
			i++;
		} else {
			if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) == 10) {
				score += 10 + Integer.parseInt(scores[i+2]);
				printScore += scores[i] + " /\t";
				printScore2+= "" + score+"\t";
			} else if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) != 10){
				score += Integer.parseInt(scores[i]) + Integer.parseInt(scores[i+1]);
				printScore2 += "" + score + "\t";
				printScore += scores[i] + " " + scores[i+1] + "\t";
			}
			i+=2;
		}
		if(scores[scores.length-1].equals("10")) {
			if(scores[i].equals("10")) {
				score += 10 + Integer.parseInt(scores[i+1]) + Integer.parseInt(scores[i+2]);
				printScore += "X\t";
				printScore2+= "" + score + "\t";
				i++;
			} else {
				if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) == 10) {
					score += 10 + Integer.parseInt(scores[i+2]);
					printScore += scores[i] + " /\t";
					printScore2+= "" + score+"\t";
				} else if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) != 10){
					score += Integer.parseInt(scores[i]) + Integer.parseInt(scores[i+1]);
					printScore2 += "" + score + "\t";
					printScore += scores[i] + " " + scores[i+1] + "\t";
				}
				i+=2;
			}
			if(scores[i].equals("10")) {
				score += 10 + Integer.parseInt(scores[i+1]) + Integer.parseInt(scores[i+2]);
				printScore += "X\t";
				printScore2+= "" + score + "\t";
				i++;
			} else {
				if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) == 10) {
					score += 10 + Integer.parseInt(scores[i+2]);
					printScore += scores[i] + " /\t";
					printScore2+= "" + score+"\t";
				} else if(Integer.parseInt(scores[i])+Integer.parseInt(scores[i+1]) != 10){
					score += Integer.parseInt(scores[i]) + Integer.parseInt(scores[i+1]);
					printScore2 += "" + score + "\t";
					printScore += scores[i] + " " + scores[i+1] + "\t";
				}
				i+=2;
			}
		}
		System.out.println("1\t2\t3\t4\t5\t6\t7\t8\t9\t10\tBonus");
		System.out.println(printScore);
		System.out.println(printScore2);
	}

}
