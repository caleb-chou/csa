/*
 * Name    : Chou, Caleb
 * User ID : cyc3086
 * Lab #   : 0
 */
package arithmetic_expressions;
/**
 *
 * @author cyc3086
 */
public class Pi {
    public static void main(String[]args) {
        double hits =0;
        int numThrows = 1000;
        for(int i =0; i<numThrows;i++) {
            double x1 = random(),y1 = random();
            System.out.printf("x1: %s x2: %s y1: %s y2: %s \n",x1,0,y1,0);
            if(getDistance(x1,y1,0,0)<=1) {
                hits++;
            }
        }
        System.out.printf("Hits: %s\n",hits);
        System.out.printf("Pi (approx.): %s", (hits/numThrows) *4 );
    }
    public static double getDistance(double x1,double y1,double x2,double y2) {
        return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }
    public static double random() {
        return Math.random() * 2 - 1;
    }
}
