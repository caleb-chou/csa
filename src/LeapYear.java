/*
 * Name    : Chou, Caleb
 * User ID : cyc3086
 * Lab #   : 0
 */
package arithmetic_expressions;
import java.util.*;
/**
 *
 * @author cyc3086
 */
public class LeapYear {
    public static Scanner in;
    public static void main(String[]args) {
        in = new Scanner(System.in);
        System.out.print("Enter a year: ");
        try {
            int year = in.nextInt();
            if(year%4==0) {
                if(year%100==0) {
                    if(year%400==0) {
                        System.out.println(year + " is a Leap year.");
                    } else {
                        System.out.println(year + " is not a Leap year.");
                    }
                } else {
                    System.out.println(year + " is a Leap year.");
                }
            } else {
                System.out.println(year + " is not a Leap year.");
            }
        } catch(Exception e) {
            System.out.println("You have an error.");
            e.printStackTrace();
        }
    }
}
