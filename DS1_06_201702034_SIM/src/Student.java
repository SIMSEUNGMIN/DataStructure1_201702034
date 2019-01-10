
public class Student { // 학생의 점수를 객체로 만든 것.
	
	private int _score; //점수.
	
	public Student(){ //초기화.
		this._score = 0;
	}
	
	public Student(int givenScore){ //점수를 입력받았을 때 초기화.
		this._score = givenScore;
	}
	
	public void SetScore(int newScore){ //setter.
		this._score = newScore;
	}
	
	public int score(){ //getter.
		return this._score;
	}

}
