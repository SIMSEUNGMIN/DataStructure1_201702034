
public class Board { //���� ���, cellLocationŬ������ �̿��ؼ� ��ǥ ����.(2���� �迭)
	private static int EMPTY_CELL = -1; 

	private int _order;
	private int[][] _cell; //2���� �迭.
	
	public Board(int givenOrder){ //���� ��� ������.
		this._order = givenOrder;
		this._cell = new int[givenOrder][givenOrder];
		for(int row = 0; row < givenOrder; row ++){
			for(int col = 0; col < givenOrder; col ++){
				this._cell[row][col] = Board.EMPTY_CELL; //���� �ȿ� ���ڸ� ���� -1�� �ʱ�ȭ.
			}
		}
		
	}
	
	public int order(){ //������ ���� ������ ��´�.
		return this._order;
	}
	
	public int cell(CellLocation aLocation){ //�־��� ��ġ aLocation�� cell���� ��´�.
		return this._cell[aLocation.row()][aLocation.col()];
	}
	
	public int cell(int aRow, int aCol){ //�־��� ��ġ (aRow, aCol)�� cell���� ��´�.
		return this.cell(aRow, aCol);
	}
	
	public void setCell(CellLocation aLocation, int aCellValue){ //�־��� �� aCellValue�� �־��� ��ġ aLocation�� cell �� �ִ´�. 
		this._cell[aLocation.row()][aLocation.col()] = aCellValue;
	}
	
	public void setCell(int aRow, int aCol, int aCellValue){ // �־��� �� aCellValue�� �־��� ��ġ (aRow, aCol)�� cell �� �ִ´�.
		this._cell[aRow][aCol] = aCellValue;
	}
	
	public boolean cellsEmpty (CellLocation aLocation){ // �־��� ��ġ�� cell�� ��� �ִ��� ���θ� �˷��ش�.
		if (this._cell[aLocation.row()][aLocation.col()] == -1){
			return true;
		}
		else return false;
	}
}
