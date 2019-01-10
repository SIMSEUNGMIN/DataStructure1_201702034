
public class Star { //별의 x좌표와 y좌표 이름을 하나의 객체로 만든 것.
	
	private int _xCoordinate; //x의 좌표.
	private int _yCoordinate; //y의 좌표.
	private String _starName; //별의 이름.
	
	public Star(){
		this._starName = null;
		this._xCoordinate = 0;
		this._yCoordinate = 0;
	}
	
	public Star(int givenX, int givenY){ //x와 y 값을 받을 때.
		this._xCoordinate = givenX;
		this._yCoordinate = givenY;
	}
	
	public Star(String givenStarName){ //별의 이름을 받을 때.
		this._starName = givenStarName;
	}
	
	public Star(int givenX, int givenY, String givenStarName){ //x와 y와 이름을 받을 때.
		this._xCoordinate = givenX;
		this._yCoordinate = givenY;
		this._starName = givenStarName;
	}
	
	public int xCoordinate(){ //x의 getter.
		return this._xCoordinate;
	}
	
	public int yCoordinate(){ //y의 getter.
		return this._yCoordinate;
	}
	
	public String starName(){ //이름의 getter.
		return this._starName;
	}
	
	public void setXCoordinate(int newX){ //x의 setter.
		this._xCoordinate = newX;
	}
	
	public void setYCoordinate(int newY){ //y의 setter.
		this._yCoordinate = newY;
	}
	
	public void setStarName(String newStarName){ //이름의 setter.
		this._starName = newStarName;
	}
	
	@Override
	public boolean equals(Object aStar){//주어진 aStar의 객체가 동일한 객체인지 확인한다.
		if(this._xCoordinate == ((Star)aStar)._xCoordinate){
			if(this._yCoordinate == ((Star)aStar)._yCoordinate){
				return true;
			}
		}
		else{
			if(((Star)aStar)._starName != null){
				if(this._starName.compareTo(((Star)aStar)._starName) == 0){ //compareTo를 썼을 떄 같으면 0을 반환한다.
					return true;
				}
			}
		}
		return false;
	}
}
