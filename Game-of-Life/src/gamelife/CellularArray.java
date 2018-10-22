package gamelife;
/**
 * œ∏∞˚’Û¡–
 */
public class CellularArray {
    int[][] cells=new int[18][28];
    private int row;
    private int col;
    
    public CellularArray() {
    }
    public CellularArray(int row, int col) {
        this.row = row;
        this.col = col;
    }
  
    public boolean getCell(int x, int y) {
        if (cells[x][y] == 1) {
            return true;
        }
        return false;
    }
    public void setCellAlive(int x, int y) {       //¥ÊªÓ∏≥÷µ	
        cells[x][y] = 1;
    }
    public void setCellDead(int x, int y) {        //À¿Õˆ∏≥÷µ
    	cells[x][y] = 0;
    }
    
	private int getCol() {
		return col;
	}
	private int getRow() {
		return row;
	}
}

