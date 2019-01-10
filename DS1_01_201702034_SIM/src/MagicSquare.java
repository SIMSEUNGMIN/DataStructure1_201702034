
public class MagicSquare { //���������� �Է� ���� �� �ִ� �ִ� ���� ����, anOrder�� ���� OrderValidity �� ���, anOrder�� ���� cell�� �� ���� ��ġ ����.
	private static final int DEFAULT_MAN_ORDER = 99;
	
	private int _maxOrder;
	
	public int maxOrder(){ //getter 
		return this._maxOrder;
	}
	
	public MagicSquare(){ //������
		this._maxOrder = MagicSquare.DEFAULT_MAN_ORDER;
	}
	
	public MagicSquare (int givenMaxOrder){ //�ִ� ������ ����ڰ� �����ϴ� ������.
		this._maxOrder = givenMaxOrder;
	}
	
	public OrderValidity checkOrderValidity (int anOrder){ //anOrder�� ���ǿ� �����ϴ� ���.
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
	
	public Board solve(int anOrder){ //�������� Ǫ�� ���. (���ڸ� �迭�ϴ� ���)
		if (this.checkOrderValidity(anOrder) != OrderValidity.Vaild){
			return null;
		}
		else{
			Board board = new Board(anOrder); // ������ �Բ� Board ��ü �����ڸ� call �Ͽ�, Board ��ü�� �����Ѵ�. (Board �ʱ�ȭ)
			
			CellLocation currentLoc = new CellLocation(0, anOrder/2); // ��� ��ġ�� ���� ��ġ�� ����.
			CellLocation nextLoc = new CellLocation(); 
			
			board.setCell(currentLoc, 1); //������ ��� ��ġ�� 1�� ä���.
			
			int lastValue = anOrder * anOrder;
			
			for(int cellValue = 2; cellValue <= lastValue; cellValue ++){ // 2���� ������ ��ġ�� ����.
				if(currentLoc.row()-1 < 0){ // ���� ��ġ�� row�� ���� ���.
					nextLoc.setRow(anOrder-1);
				}
				else nextLoc.setRow(currentLoc.row()-1);
				
				if(currentLoc.col()+1 > anOrder-1){ //���� ��ġ�� col�� ���� ���.
					nextLoc.setCol(0);
				}
				else nextLoc.setCol(currentLoc.col()+1);
				
				if(!board.cellsEmpty(nextLoc)){ //���� ��ġ�� ä���� ������ ���� ��ġ�� ������ġ�� �ٷ� �� �� �Ʒ� ĭ���� �����Ѵ�.
					nextLoc.setRow(currentLoc.row()+1);
					nextLoc.setCol(currentLoc.col());
				}
				
				currentLoc.setRow(nextLoc.row()); //���� ��ġ�� ���ο� ���� ��ġ�� �ٲ۴�.
				currentLoc.setCol(nextLoc.col());
				
				board.setCell(currentLoc, cellValue); //���ο� ���� ��ġ�� cellValue���� �ִ´�.
				
				}
				return board;
			}
			
			
		}
	}


