import java.util.ArrayList;
import java.util.Random;
class Runner {
	public static void main(String[] args) {
		new Cyc3086KittenBox();
	}
}
public class Cyc3086KittenBox {
	ArrayList<Kitten> kitten;
	private int rows = 30;
	private int cols = 30;
	private int start = 31;
	private int exit = 868;
	private int numKittens = 20000;
	public Cyc3086KittenBox() { // KittenBox constructor
		kitten = new ArrayList<Kitten>();
		for (int i = 0; i < numKittens; i++)
			kitten.add(new Kitten(rows, cols, start));
		play();
	}
	private void play() {
		long startTime = System.nanoTime();
		while (!kitten.isEmpty()) {
			for(int i=0;i<kitten.size();i++) {
				Kitten k = kitten.get(i);
				if (k.getCurrentSquare() == exit)
					kitten.remove(k);
				else
					k.fastMove();
			}
		}
		long endtime = System.nanoTime();
		System.out.printf("It took %s seconds to complete.\n", 
				(endtime - startTime) / 1000000000.0);
	}
}
class Kitten {
	private int rows, cols, currentSquare;
	private int[] moves;
	private Random r;
	public Kitten(int r, int c, int startingSquare) { // Kitten constructor
		rows = r;
		cols = c;
		currentSquare = startingSquare;
		moves = new int[]{1,-1,cols,-cols};
		this.r = new Random();
	}
	public int getCurrentSquare() {
		return currentSquare;
	}
	public void fastMove() {
		int newMove;
		do {
			newMove = currentSquare + moves[r.nextInt(4)];
		} while(newMove < 0 || newMove >= rows*cols 
			|| (newMove / cols == currentSquare / cols 
			&& newMove % cols == currentSquare % cols));
		currentSquare = newMove;
	}
	
}