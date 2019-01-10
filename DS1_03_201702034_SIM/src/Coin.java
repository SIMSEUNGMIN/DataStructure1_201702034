
public class Coin {
	private int _value; //�ݾ�.
	
	public Coin(){ //������.
		this._value = 0;
	}
	
	public Coin(int givenValue){ //�־��� �ݾ����� �ʱ�ȭ�ϴ� ������.
		this._value = givenValue;
	}
	
	public void setValue(int newValue){ //setter.
		this._value = newValue;
	}
	
	public int value(){ //getter
		return this._value;
	}
	
	@Override //�������̵�
	public boolean equals(Object aCoin){ //(Object aCoin) this._value�� �־��� aCoin._value�� ������ ��.
		if(aCoin.getClass() != Coin.class){ //CoinŬ������ aCoinŬ������ ������ ��.
			return false;
		}
		else{
			return (this._value == ((Coin)aCoin)._value); //aCoin�� Ŭ������ �����ϰ� CoinŬ������ ��ȯ ����.
		}
		
		
	}
}
