
public class UnitExperimentResult { //개별 실험에 대한 시간을 객체로 만든 것.
	private int _experimentSize;
	private long _timeForAdd;
	private long _timeForSearch;
	private long _timeForRemove;
	
	public UnitExperimentResult(){};
	
	public UnitExperimentResult(int givenExperimentSize,
								long givenTimeForAdd,
								long givenTimeForSearch,
								long givenTimeForRemove){
		this._experimentSize = givenExperimentSize;
		this._timeForAdd = givenTimeForAdd;
		this._timeForSearch = givenTimeForSearch;
		this._timeForRemove = givenTimeForRemove;
	}

	public void setExperimentSize(int newSetExperimentSize){
		this._experimentSize = newSetExperimentSize;
	}
	
	public int experimentSize(){
		return this._experimentSize;
	}
	
	public void setTimeForAdd(long newTimeForAdd){
		this._timeForAdd = newTimeForAdd;
	}
	
	public long timeForAdd(){
		return this._timeForAdd;
	}
	
	public void setTimeForSearch(long newTimeForSearch){
		this._timeForSearch = newTimeForSearch;
	}
	
	public long timeForSearch(){
		return this._timeForSearch;
	}
	
	public void setTimeForRemove(long newTimeForRemove){
		this._timeForRemove = newTimeForRemove;
	}
	
	public long timeForRemove(){
		return this._timeForRemove;
	}
}
