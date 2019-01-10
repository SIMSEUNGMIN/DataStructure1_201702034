
public class TestResult { //test의 결과값(크기,시간,최대값)을 객체로 표현.
	private int _testSize;
	private long _testInsertTime;
	private long _testFindMaxTime;
	
	public TestResult(){ //생성자.
		this._testSize = 0;
		this._testInsertTime = 0;
		this._testFindMaxTime = 0;
	}
	
	public TestResult(int aTestSize, long aTestInsertTime, long aTestFindMaxTime){ //주어진 값으로 초기화하는 생성자
		this._testSize = aTestSize;
		this._testInsertTime = aTestInsertTime;
		this._testFindMaxTime = aTestFindMaxTime;
	}
	
	public int testSize(){ //testSize getter.
		return this._testSize;
	}
	
	public void setTestSize(int aTestSize){ //testSize setter.
		this._testSize = aTestSize;
	}
	
	public long testInsertTime(){ //testInsertTime getter.
		return this._testInsertTime;
	}
	
	public void setTestInSertTime(int aTestInsertTime){ //testInsertTime setter.
		this._testInsertTime = aTestInsertTime;
	}
	
	public long testFindMaxTime(){ //testFindMaxTime getter.
		return this._testFindMaxTime;
	}
	
	public void setTestFindMaxTime(int aTestFindMaxTime){ //testFindMaxTime setter.
		this._testFindMaxTime = aTestFindMaxTime;
	}
}
