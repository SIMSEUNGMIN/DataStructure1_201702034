
public class Board { //보드 모양, cellLocation클래스를 이용해서 좌표 구성.(2차원 배열)
	private static int EMPTY_CELL = -1; 

	private int _order;
	private int[][] _cell; //2차원 배열.
	
	public Board(int givenOrder){ //보드 모양 생성자.
		this._order = givenOrder;
		this._cell = new int[givenOrder][givenOrder];
		for(int row = 0; row < givenOrder; row ++){
			for(int col = 0; col < givenOrder; col ++){
				this._cell[row][col] = Board.EMPTY_CELL; //보드 안에 숫자를 전부 -1로 초기화.
			}
		}
		
	}
	
	public int order(){ //마방진 판의 차수를 얻는다.
		return this._order;
	}
	
	public int cell(CellLocation aLocation){ //주어진 위치 aLocation의 cell값을 얻는다.
		return this._cell[aLocation.row()][aLocation.col()];
	}
	
	public int cell(int aRow, int aCol){ //주어진 위치 (aRow, aCol)의 cell값을 얻는다.
		return this.cell(aRow, aCol);
	}
	
	public void setCell(CellLocation aLocation, int aCellValue){ //주어진 값 aCellValue를 주어진 위치 aLocation의 cell 에 넣는다. 
		this._cell[aLocation.row()][aLocation.col()] = aCellValue;
	}
	
	public void setCell(int aRow, int aCol, int aCellValue){ // 주어진 값 aCellValue를 주어진 위치 (aRow, aCol)의 cell 에 넣는다.
		this._cell[aRow][aCol] = aCellValue;
	}
	
	public boolean cellsEmpty (CellLocation aLocation){ // 주어진 위치의 cell이 비어 있는지 여부를 알려준다.
		if (this._cell[aLocation.row()][aLocation.col()] == -1){
			return true;
		}
		else return false;
	}
}
