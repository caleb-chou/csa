/*
 * Name    : Chou, Caleb
 * User ID : cyc3086
 * Lab #   : 0
 */
/**
 *
 * @author cyc3086
 */
import java.util.*;
public class Monty_Hall {
    private static int prize;
    private static int guess;
    private static int view;
    public static Scanner in;
    public static void main(String[]args) {
        in = new Scanner(System.in);
        
        double probability1,probablility2;
        double switchNum=0,stayNum=0;
        
        System.out.print("How many times: ");
        
        int times = in.nextInt();
        System.out.println("Prize\tGuess\tView\tNew Guess\t");
        for(int i=0; i<times;i++) {
        	String output  = "";
            prize = (int)Math.floor(Math.random() * 3 + 1);
            guess = (int)Math.floor(Math.random() * 3 + 1);
            view  = 1;
            while(view==prize||view==guess) {
                view++;
            }
            if(guess==prize) {
                stayNum++;
            }
            int new_guess =(int)Math.floor(Math.random() * 3 + 1);
            while(new_guess==view||new_guess==guess) {
                new_guess =(int)Math.floor(Math.random() * 3 + 1);
            }
            if(new_guess==prize) {
                switchNum++;
            }
            System.out.printf("%s\t%s\t%s\t%s\n",prize,guess,view,new_guess);
        }
        System.out.println("Chance to win if switch: " + (switchNum/times));
        System.out.println("Chance to win if stayed: " + (stayNum/times));
       

    }
    
}