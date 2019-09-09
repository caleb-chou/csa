
/*
 * Name    : Chou, Caleb
 * User ID : cyc3086
 * Lab #   : 10
 */
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

public class Maze {
	public static void main(String[] args) {
		MazeGUI maze = new MazeGUI();
		maze.initialize();
	}
}

class MazeGUI {

	JFrame frame;
	JButton[] button;
	int numRows, numCols;
	private int delay;
	private String mazeFile = "maze.txt";
	private char[][] grid; // 2D char array
	private int[] start; // starting square {row, col}
	private int[] exit; // exiting square {row, col}
	private char wall = 'X'; // character that represents a wall
	private char crumb = 'o'; // breadcrumb used to mark the path

	public void setSpeed(int delay) {
		this.delay = delay;
	}
	// private boolean pathFound;

	public void initialize() {
		// pathFound = false;
		try {
			setSpeed(Integer.parseInt(JOptionPane.showInputDialog("Enter the delay (ms):")));
		} catch (Exception e) {
			setSpeed(120);
		}
		start = new int[] { -1, -1 }; // start[0] = row, start[1] = col
		exit = new int[] { -1, -1 }; // exit[0] = row, exit[1] = col
		readMaze(mazeFile); // load maze file
		createGUI(grid, start, exit, wall);
		System.out.println((findPath(start[0], start[1], false)) ? "Maze successfully completed.":"No path found.");
	}

	/**
	 * The findPath method will recursively find a path through the maze. You should
	 * mark your path with a crumb as you go. You need to remove crumbs and replace
	 * them with spaces as you back out from dead ends. Call updateGUI(grid) anytime
	 * you place or remove a crumb. The base condition will be reached when you hit
	 * a dead end or when row==exit[0] and col==exit[1]. You can use pathFound as
	 * one of your base conditions.
	 */
	public final boolean findPath(int row, int col, boolean pathFound) {
		grid[row][col] = crumb;
		updateGUI(grid);

		if (row == exit[0] && col == exit[1])
			pathFound = true;

		if (!pathFound && row < numRows - 1 && grid[row + 1][col] == ' ')
			pathFound = findPath(row + 1, col, pathFound);

		if (!pathFound && row > 0 && grid[row - 1][col] == ' ')
			pathFound = findPath(row - 1, col, pathFound);

		if (!pathFound && col < numCols - 1 && grid[row][col + 1] == ' ')
			pathFound = findPath(row, col + 1, pathFound);

		if (!pathFound && col > 0 && grid[row][col - 1] == ' ')
			pathFound = findPath(row, col - 1, pathFound);
		
		if (!pathFound) {
			grid[row][col] = ' ';
			updateGUI(grid);
		}
		return pathFound;
	}

	/**
	 * The findOpenings method finds the two openings (start & exit) in the maze.
	 * The start and exit are int arrays with a size of 2. Your algorithm should
	 * randomly choose which of the two openings is the start and which is the exit.
	 * There will be only two openings and they can be on any of the four sides.
	 * There will NOT be an opening in a corner.
	 */
	public int[] assign(int x, int y) {
		return new int[] { x, y };
	}

	public void findOpenings() {
		int random = (int) (Math.random() * 100);
		if (random % 2 != 0) {
			setStart();
			setExit();
		} else {
			setExit();
			setStart();
		}
		System.out.println();
	}

	// Yes I know these are inefficient
	
	public void setStart() {
		for (int i = 0; i < grid[0].length; i++) {
			if (grid[0][i] == ' ' && start[0] == -1)
				start = (Arrays.equals(assign(0, i), exit)) ? new int[] { -1, -1 } : assign(0, i);
			else if (grid[grid.length - 1][i] == ' ' && start[0] == -1)
				start = (Arrays.equals(assign(grid.length - 1, i), exit)) ? new int[] { -1, -1 }
						: assign(grid.length - 1, i);
		}
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][0] == ' ' && start[0] == -1)
				start = (Arrays.equals(assign(i, 0), exit)) ? new int[] { -1, -1 } : assign(i, 0);
			else if (grid[i][grid[0].length - 1] == ' ' && start[0] == -1)
				start = (Arrays.equals(assign(i, grid[0].length - 1), exit)) ? new int[] { -1, -1 }
						: assign(i, grid[0].length - 1);
		}
	}

	public void setExit() {
		for (int i = 0; i < grid[0].length; i++) {
			if (grid[0][i] == ' ' && exit[0] == -1)
				exit = (Arrays.equals(assign(0, i), start)) ? new int[] { -1, -1 } : assign(0, i);
			else if (grid[grid.length - 1][i] == ' ' && exit[0] == -1)
				exit = (Arrays.equals(assign(grid.length - 1, i), start)) ? new int[] { -1, -1 }
						: assign(grid.length - 1, i);
		}
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][0] == ' ' && exit[0] == -1)
				exit = (Arrays.equals(assign(i, 0), start)) ? new int[] { -1, -1 } : assign(i, 0);
			else if (grid[i][grid[0].length - 1] == ' ' && exit[0] == -1)
				exit = (Arrays.equals(assign(i, grid[0].length - 1), start)) ? new int[] { -1, -1 }
						: assign(i, grid[0].length - 1);
		}
	}

	public final void readMaze(String file) {
		try {
			Scanner read = new Scanner(new File(file));
			int rows = read.nextInt();
			grid = new char[rows][];
			read.nextLine();
			for (int i = 0; i < rows; i++) {
				grid[i] = read.nextLine().toCharArray();
			}
			numRows = grid.length;
			numCols = grid[0].length;
			findOpenings();
		} catch (FileNotFoundException ex) {
			System.out.println("Error reading file: " + file);
		}
	}

	public final void createGUI(char[][] grid, int[] start, int[] exit, char c) {
		frame = new JFrame("Maze");
		button = new JButton[numRows * numCols];
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton("");
			button[i].setFont(new Font("Arial", Font.BOLD, 20));
			button[i].setBackground(new Color(255, 200, 150));
			if (grid[i / numCols][i % numCols] == wall) {
				button[i].setBackground(new Color(0, 25, 0));
			}
			frame.add(button[i]);
		}
		button[start[0] * numCols + start[1]].setOpaque(true);
		button[start[0] * numCols + start[1]].setBackground(new Color(0, 255, 0));
		button[exit[0] * numCols + exit[1]].setOpaque(true);
		button[exit[0] * numCols + exit[1]].setBackground(new Color(255, 0, 0));
		frame.setLayout(new GridLayout(numRows, numCols));
		frame.setSize(numCols * 45 + 15, numRows * 45 + 15);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public final void updateGUI(char[][] grid) {
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				/*
				 * if (grid[row][col] == 'x') button[row * numCols + col].setText(""); else
				 */
				button[row * numCols + col].setText("" + grid[row][col]);
			}
		}
		try {
			Thread.sleep(delay);
		} catch (InterruptedException ex) {
		}
	}
}
