package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int rows;
	private static int cols;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int r, int c) {
		rows = r;
		cols = c;
		maze = new Maze(rows, cols);
		Random ran = new Random();
		// 1. Pick a random cell along the border and remove its exterior wall.
		// This will be the starting point. Then select a random cell along
		// the opposite wall and remove its exterior wall. This will be the
		// finish line.
		int side = ran.nextInt(2);
		int a = ran.nextInt(2) * (maze.getRows() - 1);
		int b = ran.nextInt(2) * (maze.getCols() - 1);
		if (side == 0) {
			b = ran.nextInt(maze.getCols() - 1);
			if (a == 0) {
				maze.cells[a][b].setNorthWall(false);
				a = maze.getRows() - 1;
				b = ran.nextInt(maze.getCols() - 1);
				maze.cells[a][b].setSouthWall(false);
			}
		} else {
			a = ran.nextInt(maze.getRows() - 1);
			if (b == 0) {
				maze.cells[a][b].setWestWall(false);
				b = maze.getCols() - 1;
				a = ran.nextInt(maze.getRows() - 1);
				maze.cells[a][b].setEastWall(false);
			}
		}

		// 2. select a random cell in the maze to start

		// 3. call the selectNextPath method with the randomly selected cell
		selectNextPath(maze.cells[a][b]);
		return maze;
	}

	// 4. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		// A. SET currentCell as visited
		currentCell.setBeenVisited(true);
		// B. check for unvisited neighbors using the cell
		int x = currentCell.getRow();
		int y = currentCell.getCol();
		ArrayList<Cell> neighbors = getUnvisitedNeighbors(currentCell);
		Random ran = new Random();
		int randomNeighbor;

		if (neighbors.isEmpty() == false) {
			randomNeighbor = ran.nextInt(neighbors.size());
			removeWalls(currentCell, neighbors.get(randomNeighbor));
			currentCell = neighbors.get(randomNeighbor);
			currentCell.setBeenVisited(true);
			uncheckedCells.push(currentCell);
			neighbors.remove(randomNeighbor);
			selectNextPath(currentCell);
		}

		// C. if has unvisited neighbors,

		// C1. select one at random.

		// C2. push it to the stack

		// C3. remove the wall between the two cells

		// C4. make the new cell the current cell and SET it as visited

		// C5. call the selectNextPath method with the current cell

		// D. if all neighbors are visited
		if (neighbors.isEmpty() == false) {
			if (uncheckedCells.isEmpty() == false) {
				currentCell = uncheckedCells.pop();
				selectNextPath(currentCell);
			}
		}
		// D1. if the stack is not empty

		// D1a. pop a cell from the stack

		// D1b. make that the current cell

		// D1c. call the selectNextPath method with the current cell

	}

	// This method will check if c1 and c2 are adjacent.
	// If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if (c1.getRow() == c2.getRow()) {
			if (c1.getCol() > c2.getCol()) {
				c1.setWestWall(false);
				c2.setEastWall(false);
			} else {
				c1.setEastWall(false);
				c2.setWestWall(false);
			}
		} else {
			if (c1.getRow() > c2.getRow()) {
				c1.setNorthWall(false);
				c2.setSouthWall(false);
			} else {
				c1.setSouthWall(false);
				c2.setNorthWall(false);
			}
		}
	}

	// This method returns a list of all the neighbors around the specified
	// cell that have not been visited. There are up to 4 neighbors per cell.
	// 1
	// 2 cell 3
	// 4
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		int row = c.getRow();
		int col = c.getCol();

		ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();

		if (row > 0 && !maze.getCell(row - 1, col).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(row - 1, col));
		}

		if (col > 0 && !maze.getCell(row, col - 1).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(row, col - 1));
		}

		if (row < rows - 1 && !maze.getCell(row + 1, col).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(row + 1, col));
		}

		if (col < cols - 1 && !maze.getCell(row, col + 1).hasBeenVisited()) {
			unvisitedNeighbors.add(maze.getCell(row, col + 1));
		}

		return unvisitedNeighbors;
	}
}
