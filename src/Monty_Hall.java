/*
 * Name    : Chou, Caleb
 * User ID : cyc3086
 * Lab #   : 0
 */
/**
 *
 * @author cyc3086
 */
public class Monty_Hall {
    private static int prize = 0;
    private static int guess = 0;
    private static int view = 0;
    private static int newguess;
    private static int[] wins = {0,0};

    public static void main(String[]args) {
        int times = 1000000;
        for (int i =0 ; i < times; i ++ ) {
            prize = (int) (Math.random() * 3 + 1);
            guess = (int) (Math.random() * 3 + 1);
            while (view == guess || view == prize || view == 0)
                view = (int) (Math.random() * 3 + 1);
            //System.out.printf("p:%s\tg:%s\tv:%s\n", prize, guess, view);
            newguess = 0;
            while (newguess == guess || newguess == view || newguess == 0)
                newguess = (int) (Math.random() * 3 + 1);
            //System.out.printf("p:%s\tg:%s\tv:%s\tng:\t%s\n",prize, guess, view, newguess);
            wins[0] += (guess == prize) ? 1 : 0;
            wins[1] += (newguess == prize)?1: 0;
        }
        System.out.printf("Wins if you stayed:\t%s\nWins if you changed:\t%s",(double)wins[0]/(double)times,(double)wins[1]/(double)times);
    }
    
}