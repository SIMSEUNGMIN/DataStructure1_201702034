
public class Coin {
	private int _value; //금액.
	
	public Coin(){ //생성자.
		this._value = 0;
	}
	
	public Coin(int givenValue){ //주어진 금액으로 초기화하는 생성자.
		this._value = givenValue;
	}
	
	public void setValue(int newValue){ //setter.
		this._value = newValue;
	}
	
	public int value(){ //getter
		return this._value;
	}
	
	@Override //오버라이드
	public boolean equals(Object aCoin){ //(Object aCoin) this._value와 주어진 aCoin._value와 같은지 비교.
		if(aCoin.getClass() != Coin.class){ //Coin클래스와 aCoin클래스가 같은지 비교.
			return false;
		}
		else{
			return (this._value == ((Coin)aCoin)._value); //aCoin의 클래스를 안전하게 Coin클래스로 변환 가능.
		}
		
		
	}
}
