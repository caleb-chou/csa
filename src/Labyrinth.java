/**
 * Author: Caleb Chou
 * Period 3
 * Labyrinth Lab
 */

import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.*;
import javax.swing.*;

public class Labyrinth {
    
    JFrame frame;
    JButton[] button;
    int numRows, numCols;
    private final int delay = 50;
    
    private char[][] grid;      // 2D char array
    private int[] start;        // starting square {row, col}
    private int[] exit;         // exiting square {row, col}
    private char wall = 'x';    // character that represents a wall
    private char crumb = '*';   // breadcrumb used to mark the path

    public Labyrinth() {
        start = new int[] {-1,-1};     //start[0] = row, start[1] = col
        exit  = new int[] {-1,-1};     //exit[0]  = row, exit[1]  = col  
    }

    public void findPath() {
        int cRow = start[0];
        int cCol = start[1];
        grid[cRow][cCol] = crumb;
        updateGUI(grid);
        for(;!(cCol == exit[0] && cRow == exit[1]);) {
        	if(cCol > 0 && grid[cRow][cCol-1] == ' ') // left
        		cCol -= 1;
        	else if(cCol < grid[0].length -1 && grid[cRow][cCol+1] == ' ') // right
        		cCol += 1;
        	else if(cRow > 0 && grid[cRow-1][cCol] == ' ') // up
        		cRow -= 1;
        	else if(cRow < grid.length - 1 && grid[cRow+1][cCol] == ' ') // down
        		cRow += 1;
        	grid[cRow][cCol] = crumb;
            updateGUI(grid);
        }
    }
    public int[] assign(int x, int y) {
    	return new int[] {x,y};
    }
    public void findOpenings() {
    	int random = (int) (Math.random()*100);
    	if(random % 2 != 0) {
    		setStart();
    		setExit();
    	} else {
    		setExit();
    		setStart();
    	}
    	System.out.println();
    }
    public void setStart() {
    	for(int i = 0; i < grid[0].length; i++) {
        	if(grid[0][i]==' ' && start[0]==-1)
                start = (Arrays.equals(assign(0,i),exit)) ?  new int[]{-1,-1} : assign(0,i);
            else if(grid[grid.length-1][i]==' ' && start[0]==-1)
            	start = (Arrays.equals(assign(grid.length-1,i),exit)) ?  new int[]{-1,-1} : assign(grid.length-1,i);
        }
        for(int i = 0; i < grid.length; i++) {
        	if(grid[i][0] == ' '&& start[0]==-1)
        		start = (Arrays.equals(assign(i,0),exit)) ?  new int[]{-1,-1} : assign(i,0);
        	else if(grid[i][grid[0].length-1] == ' '&& start[0]==-1)
        		start = (Arrays.equals(assign(i,grid[0].length-1),exit)) ?  new int[]{-1,-1} : assign(i,grid[0].length-1);
        }
    }
    public void setExit() {
    	for(int i = 0; i < grid[0].length; i++) {
        	if(grid[0][i]==' ' && exit[0]==-1)
                exit = (Arrays.equals(assign(0,i),start)) ?  new int[]{-1,-1} : assign(0,i);
            else if(grid[grid.length-1][i]==' ' && exit[0]==-1)
            	exit = (Arrays.equals(assign(grid.length-1,i),start)) ?  new int[]{-1,-1} : assign(grid.length-1,i);
        }
        for(int i = 0; i < grid.length; i++) {
        	if(grid[i][0] == ' '&& exit[0]==-1)
        		exit = (Arrays.equals(assign(i,0),start)) ?  new int[]{-1,-1} : assign(i,0);
        	else if(grid[i][grid[0].length-1] == ' '&& exit[0]==-1)
        		exit = (Arrays.equals(assign(i,grid[0].length-1),start)) ?  new int[]{-1,-1} : assign(i,grid[0].length-1);
        }
    }
    public void readLabyrinth(String file) {
        try {
            Scanner read = new Scanner(new File(file));
            int rows = read.nextInt();
            grid = new char[rows][];
            read.nextLine();
            for (int i = 0; i < rows; i++) {
                grid[i] = read.nextLine().toCharArray();
            }
            findOpenings();
            createGUI(grid, start, exit, wall);
            read.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Labyrinth.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createGUI(char[][] grid, int[] start, int[] exit, char c) {
        numRows = grid.length;
        numCols = grid[0].length;
        frame = new JFrame("Labyrinth");
        button = new JButton[numRows * numCols];
        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton("");
            button[i].setFont(new Font("Arial", Font.PLAIN, 30));
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
        frame.setSize(numRows * 60 + 15, numCols * 40 + 15);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void updateGUI(char[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 'x')
                    button[row * numCols + col].setText("");
                else
                    button[row * numCols + col].setText("" + grid[row][col]);
            }
        }
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
        }
    }
}