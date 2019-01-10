
public class ParameterSet {
	//단순히 실험에서 필요한 매개변수들을 모아놓는 역할을 한다.
	
	private int _startingSize; //데이터 시작 사이즈.
	private int _numberOfSizeIncreasingSteps; //몇번이나 데이터를 증가시키는지 알려주는 수.
	private int _incrementSize; //데이터 증가 사이즈.
	
	public ParameterSet(int givenStartingSize,
						 int givenNumberOfSizeIncreasingSteps,
						 int givenIncrementSize){
		this._startingSize = givenStartingSize;
		this._numberOfSizeIncreasingSteps = givenNumberOfSizeIncreasingSteps;
		this._incrementSize = givenIncrementSize;
		
	}
	
	public void setStartingSize(int newStartingSize){
		this._startingSize = newStartingSize;
	}
	
	public int startingSize(){
		return this._startingSize;
	}
	
	public void setNumberOfSizeIncreasingStep(int newIncreasingStep){
		this._numberOfSizeIncreasingSteps = newIncreasingStep;
	}
	
	public int numberOfSizeIncreasingStep(){
		return this._numberOfSizeIncreasingSteps;
	}
	
	public void setIncrementSize(int newIncrementSize){
		this._incrementSize = newIncrementSize;
	}
	
	public int incrementSize(){
		return this._incrementSize;
	}
	
	public int maxSize(){
		return (this._startingSize + ((this._numberOfSizeIncreasingSteps-1) * this._incrementSize));
	}
	
}
