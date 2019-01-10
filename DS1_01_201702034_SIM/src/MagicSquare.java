
public class MagicSquare { //마방진에서 입력 받을 수 있는 최대 차수 지정, anOrder에 따른 OrderValidity 값 출력, anOrder에 따른 cell에 들어갈 숫자 위치 선정.
	private static final int DEFAULT_MAN_ORDER = 99;
	
	private int _maxOrder;
	
	public int maxOrder(){ //getter 
		return this._maxOrder;
	}
	
	public MagicSquare(){ //생성자
		this._maxOrder = MagicSquare.DEFAULT_MAN_ORDER;
	}
	
	public MagicSquare (int givenMaxOrder){ //최대 차수를 사용자가 지정하는 생성자.
		this._maxOrder = givenMaxOrder;
	}
	
	public OrderValidity checkOrderValidity (int anOrder){ //anOrder가 조건에 부합하는 경우.
		if(anOrder < 3){
			return OrderValidity.TooSmall;
		}
		else if (anOrder > 99){
			return OrderValidity.TooLarge;
		}
		else if (anOrder%2 == 0){
			return OrderValidity.NotOddNumber;
		}
		else return OrderValidity.Vaild;
	}
	
	public Board solve(int anOrder){ //마방진을 푸는 방법. (숫자를 배열하는 방법)
		if (this.checkOrderValidity(anOrder) != OrderValidity.Vaild){
			return null;
		}
		else{
			Board board = new Board(anOrder); // 차수와 함께 Board 객체 생성자를 call 하여, Board 객체를 생성한다. (Board 초기화)
			
			CellLocation currentLoc = new CellLocation(0, anOrder/2); // 출발 위치를 현재 위치로 설정.
			CellLocation nextLoc = new CellLocation(); 
			
			board.setCell(currentLoc, 1); //보드의 출발 위치에 1을 채운다.
			
			int lastValue = anOrder * anOrder;
			
			for(int cellValue = 2; cellValue <= lastValue; cellValue ++){ // 2부터 보드의 위치를 결정.
				if(currentLoc.row()-1 < 0){ // 다음 위치의 row가 없을 경우.
					nextLoc.setRow(anOrder-1);
				}
				else nextLoc.setRow(currentLoc.row()-1);
				
				if(currentLoc.col()+1 > anOrder-1){ //다음 위치의 col이 없을 경우.
					nextLoc.setCol(0);
				}
				else nextLoc.setCol(currentLoc.col()+1);
				
				if(!board.cellsEmpty(nextLoc)){ //다음 위치가 채워져 있으면 다음 위치를 현재위치의 바로 한 줄 아래 칸으로 수정한다.
					nextLoc.setRow(currentLoc.row()+1);
					nextLoc.setCol(currentLoc.col());
				}
				
				currentLoc.setRow(nextLoc.row()); //다음 위치를 새로운 현재 위치로 바꾼다.
				currentLoc.setCol(nextLoc.col());
				
				board.setCell(currentLoc, cellValue); //새로운 현재 위치에 cellValue값을 넣는다.
				
				}
				return board;
			}
			
			
		}
	}


