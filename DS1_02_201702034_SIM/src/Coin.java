
public class Coin {
	private int _value; //�ݾ�.
	
	public Coin(){ //������.
		this._value = 0;
	}
	
	public Coin(int givenValue){ //�־��� ������ �ϴ� ������.
		this._value = givenValue;
	}
	
	public int value(){ //getter.
		return this._value;
	}
	
	public void setValue(int newValue){ //newValue�� this._Value������ ����.
		this._value = newValue;
	}
	
	@Override
	public boolean equals(Object aCoin){ //this._value�� ���� �־��� aCoin._value�� ���� ������ ��.  (object aCoin)
		if(aCoin.getClass() != Coin.class){
			return false;
		}
		else{//aCoin�� class�� �����ϰ� Coinclass�� ����ȯ ����.
			return (this._value == ((Coin)aCoin)._value);
			}
	}
	
}
