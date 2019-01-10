
public final class Timer {
	//실행 시간을 측정할 수 있는 타이머를 정의한다.
	//System.nanoTime()를 사용.
	//상속될 필요 x. > final로 선언. 
	//final을 쓰면 생성자를 사용할 필요가 없다.
	
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
