
public class Star { //���� x��ǥ�� y��ǥ �̸��� �ϳ��� ��ü�� ���� ��.
	
	private int _xCoordinate; //x�� ��ǥ.
	private int _yCoordinate; //y�� ��ǥ.
	private String _starName; //���� �̸�.
	
	public Star(){
		this._starName = null;
		this._xCoordinate = 0;
		this._yCoordinate = 0;
	}
	
	public Star(int givenX, int givenY){ //x�� y ���� ���� ��.
		this._xCoordinate = givenX;
		this._yCoordinate = givenY;
	}
	
	public Star(String givenStarName){ //���� �̸��� ���� ��.
		this._starName = givenStarName;
	}
	
	public Star(int givenX, int givenY, String givenStarName){ //x�� y�� �̸��� ���� ��.
		this._xCoordinate = givenX;
		this._yCoordinate = givenY;
		this._starName = givenStarName;
	}
	
	public int xCoordinate(){ //x�� getter.
		return this._xCoordinate;
	}
	
	public int yCoordinate(){ //y�� getter.
		return this._yCoordinate;
	}
	
	public String starName(){ //�̸��� getter.
		return this._starName;
	}
	
	public void setXCoordinate(int newX){ //x�� setter.
		this._xCoordinate = newX;
	}
	
	public void setYCoordinate(int newY){ //y�� setter.
		this._yCoordinate = newY;
	}
	
	public void setStarName(String newStarName){ //�̸��� setter.
		this._starName = newStarName;
	}
	
	@Override
	public boolean equals(Object aStar){//�־��� aStar�� ��ü�� ������ ��ü���� Ȯ���Ѵ�.
		if(this._xCoordinate == ((Star)aStar)._xCoordinate){
			if(this._yCoordinate == ((Star)aStar)._yCoordinate){
				return true;
			}
		}
		else{
			if(((Star)aStar)._starName != null){
				if(this._starName.compareTo(((Star)aStar)._starName) == 0){ //compareTo�� ���� �� ������ 0�� ��ȯ�Ѵ�.
					return true;
				}
			}
		}
		return false;
	}
}
