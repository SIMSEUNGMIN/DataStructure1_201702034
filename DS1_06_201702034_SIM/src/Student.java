
public class Student { // �л��� ������ ��ü�� ���� ��.
	
	private int _score; //����.
	
	public Student(){ //�ʱ�ȭ.
		this._score = 0;
	}
	
	public Student(int givenScore){ //������ �Է¹޾��� �� �ʱ�ȭ.
		this._score = givenScore;
	}
	
	public void SetScore(int newScore){ //setter.
		this._score = newScore;
	}
	
	public int score(){ //getter.
		return this._score;
	}

}
