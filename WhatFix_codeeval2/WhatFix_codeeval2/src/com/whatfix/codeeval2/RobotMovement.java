package com.whatfix.codeeval2;

public class RobotMovement {

	static int numPaths = 0;

	public static void moveRobot(int row, int col, int[][] grid) {
		grid[row][col] = 1;
		moveUp(row, col, grid);
		moveDown(row, col, grid);
		moveLeft(row, col, grid);
		moveRight(row, col, grid);
	}

	public static void moveUp(int row, int col, int[][] grid) {
		// TODO Auto-generated method stub
		if (row == 3 && col == 3) {
			numPaths++;
			grid[row][col] = 1;
			return;
		} else if (row == 3)
			return;
		else {
			if (grid[row + 1][col] == 1)
				return;
			grid[row + 1][col] = 1;
			moveRobot(row + 1, col, grid);
			grid[row + 1][col] = 0;
		}

	}

	public static void moveDown(int row, int col, int[][] grid) {
		// TODO Auto-generated method stub
		if (row == 0)
			return;
		if (grid[row - 1][col] == 1)
			return;
		grid[row - 1][col] = 1;
		moveRobot(row - 1, col, grid);
		grid[row - 1][col] = 0;

	}

	public static void moveRight(int row, int col, int[][] grid) {
		// TODO Auto-generated method stub
		if (row == 3 && col == 3) {
			numPaths++;
			grid[row][col] = 1;
			return;
		} else if (col == 3)
			return;
		else {
			if (grid[row][col + 1] == 1)
				return;
			grid[row][col + 1] = 1;
			moveRobot(row, col + 1, grid);
			grid[row][col + 1] = 0;
		}
	}

	public static void moveLeft(int row, int col, int[][] grid) {
		// TODO Auto-generated method stub
		if (col == 0)
			return;
		if (grid[row][col - 1] == 1)
			return;
		grid[row][col - 1] = 1;
		moveRobot(row, col - 1, grid);
		grid[row][col - 1] = 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = new int[4][4];
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++) {
				grid[i][j] = 0;
			}
		grid[0][0] = 1;
		moveRobot(0, 1, grid);
		System.out.println(numPaths);

	}

}
