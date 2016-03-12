import java.util.Scanner;

public class Life {

	private Cell[][] grid;
	
	/** Allocates a new grid of cells of the requested dimensions and 
	 * sets each cell in the grid to a random living/dead state.
	 * The desired percentage of living cells is passed as a
	 * parameter.
	 * 
	 * @double percent roughly, the percentage of cells that should
	 *   be initialized as alive
	 */
	public void initializeGrid(int rows, int cols, double percent) {
		// TODO Auto-generated method stub	
		  this.grid = new Cell[rows][cols];
		  for (Cell[] cellRow: grid) {
			  for (Cell c : cellRow) {
				  c = new Cell();
				  if (Math.random()<percent) c.setLiving(true);
			  }
		  }
	}

	/** Displays the contents of the grid to the standard output.
	 */
	public void displayGrid() {
		for (Cell[] cellRow : grid) {
			for (Cell c : cellRow) {
				if (c.isLiving()) System.out.print("0");
				else System.out.print("1");
			}
			System.out.println();
		}
	}

	/** Updates the value of each cell in the array according to
	 * the rules of life: 
	 * If the cell is currently living --
	 *   if fewer than two neighboring cells are alive, die (loneliness)
	 *   if three or four neighboring cells are alive, live
	 *   if five or more neighboring cells are alive, die (overcrowding)
	 * If the cell is currently dead -- 
	 *   if precisely three neighboring cells are alive, become alive
	 */
	public void updateGrid() {
		// TODO Auto-generated method stub	
	}
	
	/** Convenience method for setting the grid values.
	 * 
	 * @param grid a two dimensional table of Cells
	 */
	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}

	public static void main(String[] args) {
		Life life = new Life();
		life.initializeGrid(5, 5, 0.10);
		Scanner sc = new Scanner(System.in);
		while (true){
			System.out.println("Enter Q to quit, anything else to continue");
			String input = sc.nextLine();
			if (input.equals("Q")||input.equals("q")) break;
			life.updateGrid();
			life.displayGrid();
		}
		sc.close();
	}
	
	class Cell {
		private boolean isLiving;
		
		public void setLiving(boolean isLiving) {
			this.isLiving = isLiving;
		}
		public boolean isLiving() {
			return isLiving;
		}
	}
}
