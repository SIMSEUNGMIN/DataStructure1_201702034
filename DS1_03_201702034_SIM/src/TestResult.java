
public class TestResult { //test�� �����(ũ��,�ð�,�ִ밪)�� ��ü�� ǥ��.
	private int _testSize;
	private long _testInsertTime;
	private long _testFindMaxTime;
	
	public TestResult(){ //������.
		this._testSize = 0;
		this._testInsertTime = 0;
		this._testFindMaxTime = 0;
	}
	
	public TestResult(int aTestSize, long aTestInsertTime, long aTestFindMaxTime){ //�־��� ������ �ʱ�ȭ�ϴ� ������
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
