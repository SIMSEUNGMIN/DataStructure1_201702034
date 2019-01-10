
public class CellLocation { //row�� col�� ���� �ϳ��� ��ü�� ǥ��.

	private int _row;
	private int _col;
	
	public CellLocation(){ //row�� col�� ��(cell�� ��ǥ)�� �־����� �ʾ����Ƿ� -1�� ����. (�ʱ�ȭ)
		this._row = -1;
		this._col = -1;
	}
	
	public CellLocation(int givenRow, int givenCol){ //cell��ǥ�� �־����� ������.
		this._row = givenRow;
		this._col = givenCol;
	}
	
	public void setRow(int newRow){ //setter
		this._row = newRow;
	}
	
	public int row(){ //getter
		return this._row;
	}
	
	public void setCol(int newCol){ //setter
		this._col = newCol;
	}
	
	public int col(){ //getter
		return this._col;
	}
}

