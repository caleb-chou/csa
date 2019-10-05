public class Dice {
	public static void main(String[] abc) {
		int counter = 0;
		while(counter++ < 10) {
			int numDice = (int) (Math.random() * 10 + 1) * 2;
			int median = 7 * numDice / 2;
			double numMedian = 0;
			for( int i = 0 ; i < 1000000; i ++ ) {
				int sum = 0;
				for( int j = 0; j < numDice; j ++ ) 
					sum += (int) (Math.random() * 6 + 1);
				if( sum == median ) numMedian ++;
			}
			double probability = 100 * numMedian/1000000;
			//System.out.println("Number of dice: " + numDice + "\tMedian: " + median + "\tProbability: " + probability + "%");
			System.out.printf("Number of dice: %02d\tMedian: %02d\tProbability: %07.4f%%\n",numDice,median,probability);
		}
	}
}
