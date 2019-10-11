public class DiceFRQ {
    public static void main(String[] a) {
        
        // Starter Code --
        int numSims = 20; // Get numSims
        int num6 = 2; // Get num6
        int num8 = 4; // Get num8
        int num10= 6; // Get num10
        // -- End Starter Code

        // Calculatable Variables --
        int lower = num6 + num8 + num10;
        int upper = num6 * 6 + num8 * 8 + num10 * 10;
        int median = (lower+upper)/2;
        // -- End Calculatable Variables

        // Simulation Specific Variables --
        int total = 0;
        int min = upper;
        int max = lower;
        // -- End Simulation Specific Variables

        // Initial Print Statments
        System.out.printf("%d Simulations of %d six-sided dice, %d eight-sided dice, %d ten-sided dice.\n",numSims,num6,num8,num10);
        System.out.printf("Range, Median:\t[%d,%d], %d\n", lower, upper, median);

        // Loop number of simulations
        for(int i = 0 ; i < numSims; i++) {
            
            // Temporary sum for current simulation
            int sum = 0;

            // Roll all 6, 8, and 10 sided dice
            for(int j = 0; j < num6; j++)
                sum += (int) (Math.random() * 6 + 1);
            for(int j = 0; j < num8; j++)
                sum += (int) (Math.random() * 8 + 1);
            for(int j = 0; j < num10; j++)
                sum += (int) (Math.random() * 10 + 1);
            
            // Checking min/max
            if(sum < min) min = sum;
            if(sum > max) max = sum;

            // Adding to global total
            total += sum;
        }
        
        // Final print statement
        System.out.printf("Average Roll:\t%d\tMinimum Roll:\t%d\tMaximum Roll:\t%d\n", total/numSims,min,max);
    }
}