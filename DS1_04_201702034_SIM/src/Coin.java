
public class Coin { // 금액을 객채로 만든다.
	private int _value; // 금액.
	
	public Coin(){ //생성자.
		
		this._value = 0;
	}
	
	public Coin(int givenValue){ //주어진 값으로 하는 생성자.
		this._value = givenValue;
	}
	
	public int value(){ //getter.
		return this._value;
	}
	
	public void setValue(int newValue){ //newValue를 this._Value값으로 설정. setter.
		this._value = newValue;
	}
	
	@Override
	public boolean equals(Object aCoin){ //this._value의 값과 주어진 aCoin._value의 값과 같은지 비교.  (object aCoin)
		if(aCoin.getClass() != Coin.class){
			return false;
		}
		else{//aCoin의 class를 안전하게 Coin class로 형변환 가능.
			return (this._value == ((Coin)aCoin)._value);
			}
	}
		

}
