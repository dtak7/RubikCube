
public class Model {
	
	/*
	 * 0 = front blue
	 * 1 = right red
	 * 2 = back  green
	 * 3 = left  orange
	 * 4 = up    yellow
	 * 5 = down  white
	 */
	
	private int[][] cube = new int[6][9];
	
	public Model() {
		for (int r=0; r<6; r++) {
			for (int c = 0; c<9; c++) {
				this.cube[r][c] = r;
			}
		}
		
		for (int row=0; row < cube.length; row++)
		{
		    for (int col=0; col < cube[row].length; col++)
		    {
		        int value = cube[row][col];
		    }
		}
	}
	
	public int[][] getMat() {
		return this.cube;
	}

}
