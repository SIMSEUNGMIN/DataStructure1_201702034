
public final class Timer {
	//���� �ð��� ������ �� �ִ� Ÿ�̸Ӹ� �����Ѵ�.
	//System.nanoTime()�� ���.
	//��ӵ� �ʿ� x. > final�� ����. 
	//final�� ���� �����ڸ� ����� �ʿ䰡 ����.
	
	private long _startTime;
	private long _stopTime;
	
	public Timer(){};
	
	public void start(){
		this._startTime = System.nanoTime();
	}
	
	public void stop(){
		this._stopTime = System.nanoTime();
	}
	
	public long duratin(){
		return (this._stopTime - this._startTime);
	}

}
