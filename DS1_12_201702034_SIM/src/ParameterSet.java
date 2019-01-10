
public class ParameterSet {
	//�ܼ��� ���迡�� �ʿ��� �Ű��������� ��Ƴ��� ������ �Ѵ�.
	
	private int _startingSize; //������ ���� ������.
	private int _numberOfSizeIncreasingSteps; //����̳� �����͸� ������Ű���� �˷��ִ� ��.
	private int _incrementSize; //������ ���� ������.
	
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
