
public class CellLocation { //row와 col의 값을 하나의 객체로 표현.

	private int _row;
	private int _col;
	
	public CellLocation(){ //row와 col의 값(cell의 좌표)이 주어지지 않았으므로 -1로 설정. (초기화)
		this._row = -1;
		this._col = -1;
	}
	
	public CellLocation(int givenRow, int givenCol){ //cell좌표가 주어지는 생성자.
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

