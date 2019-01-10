
public class ParameterSet {
	private int _numberOfExperiments;
	private int _firstDataSize;
	private int _sizeIncrement;
	
	public ParameterSet(){};
	
	public ParameterSet(int givenNumberOfExperiments, int givenFirstDataSize, int givenSizeIncrement){
		this.setNumberOfExperiments(givenNumberOfExperiments);
		this.setFirstDataSize(givenFirstDataSize);
		this.setSizeIncrement(givenSizeIncrement);
	}
	
	public void setNumberOfExperiments(int newNumberOfExperiment){
		this._numberOfExperiments = newNumberOfExperiment;
	}
	
	public int numberOfExperiment(){
		return this._numberOfExperiments;
	}
	
	public void setFirstDataSize(int newFirstDataSize){
		this._firstDataSize = newFirstDataSize;
	}
	
	public int firstDataSize(){
		return this._firstDataSize;
	}
	
	public void setSizeIncrement(int newSizeIncrement){
		this._sizeIncrement = newSizeIncrement;
	}
	
	public int sizeIncrement(){
		return this._sizeIncrement;
	}
	
	public int maxDataSize(){
		return (this.firstDataSize() + (this.sizeIncrement() * (this.numberOfExperiment()-1)));
	}
}
