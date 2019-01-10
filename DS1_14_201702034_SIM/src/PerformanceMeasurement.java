
public class PerformanceMeasurement {
	private static final int DEFAULT_NUMBER_OF_EXPERIMENTS = 5;
	private static final int DEFAULT_FIRST_DATA_SIZE = 10000;
	private static final int DEFAULT_SIZE_INCREMENT = 10000;
	
	private ParameterSet _parameterSet;
	
	private int[] _ascendingList;
	private int[] _descendingList;
	private int[] _randomList;
	
	public PerformanceMeasurement(){
		this.setParameterSet(new ParameterSet(
				PerformanceMeasurement.DEFAULT_NUMBER_OF_EXPERIMENTS,
				PerformanceMeasurement.DEFAULT_FIRST_DATA_SIZE,
				PerformanceMeasurement.DEFAULT_SIZE_INCREMENT));
		this.generateData();
	}
	
	public PerformanceMeasurement(int givenNumberOfExperiments, int givenFirstDataSize, int givenSizeIncrement){
		this.setParameterSet(new ParameterSet(
				givenNumberOfExperiments,
				givenFirstDataSize,
				givenSizeIncrement));
		this.generateData();
	}
	
	public void setParameterSet(ParameterSet newParameterSet){
		this._parameterSet = newParameterSet;
	}
	
	public ParameterSet parameterSet(){
		return this._parameterSet;
	}
	
	public int[] ascendinList(){
		return this._ascendingList;
	}
	
	public int[] descendingList(){
		return this._descendingList;
	}
	
	public int[] randomList(){
		return this._randomList;
	}
	
	public void generateData(){
		this._ascendingList = DataGenerator.ascendingList(this.parameterSet().maxDataSize());
		this._descendingList = DataGenerator.descendingList(this.parameterSet().maxDataSize());
		this._randomList = DataGenerator.randomList(this.parameterSet().maxDataSize());
	}
	
	public int[] experimentList(ListOrder anOrder){
		if(anOrder == ListOrder.Ascending){
			return this._ascendingList;
		}
		else if(anOrder == ListOrder.Descending){
			return this._descendingList;
		}
		else if(anOrder == ListOrder.Random){
			return this._randomList;
		}
		else{
			return null;
		}
	}
	
	//단위 측정 실험을 실행한다. 그 측정 결과를 돌려준다.
	private UnitExperimentResult unitExperiment(Dictionary<Integer, String> aDictionary, ListOrder anOrder, int dataSize){
		long startTime;
		long stopTime;
		int[] experimentList = this.experimentList(anOrder);
		
		long timeForAdd = 0;
		for(int i = 0; i < dataSize; i++){
			startTime = System.nanoTime();
			aDictionary.addKeyAndObject(experimentList[i], null);
			stopTime = System.nanoTime();
			timeForAdd += (stopTime - startTime);
		}
		
		long timeForSearch = 0;
		for(int i = 0; i < dataSize; i++){
			startTime = System.nanoTime();
			aDictionary.objectForKey(experimentList[i]);
			stopTime = System.nanoTime();
			timeForSearch += (stopTime - startTime);
		}
		
		long timeForRemove = 0;
		for(int i = 0; i < dataSize; i++){
			startTime = System.nanoTime();
			aDictionary.removeObjectForKey(experimentList[i]);
			stopTime = System.nanoTime();
			timeForRemove += (stopTime - startTime);
		}
		
		return (new UnitExperimentResult(dataSize, timeForAdd, timeForSearch, timeForRemove));
	}
	
	//주어진 사전과 리스트 타입의 데이터 리스트를 사용하여 크기 별로 단위 측정 실험을 실행한다.
	//그 측정 결과를 돌려준다.
	public UnitExperimentResult[] experimentByDictionaryAndListOrderType(
			Dictionary<Integer, String> aDictionary, ListOrder anOrder){
		UnitExperimentResult[] experimentResults = 
				new UnitExperimentResult[this.parameterSet().numberOfExperiment()];
		
		//측정 결과를 안정시키기 위해서 측정과 무관하게 미리 실행한다.
		this.unitExperiment(aDictionary, anOrder, this.parameterSet().maxDataSize());
		System.gc();
		//측정 전에 미리 garbage collection을 강제로 실행.
		
		int dataSize = this.parameterSet().firstDataSize();
		for(int iteration = 0; iteration < this.parameterSet().numberOfExperiment(); iteration ++){
			aDictionary.clear();
			experimentResults[iteration] = this.unitExperiment(aDictionary, anOrder, dataSize);
			dataSize += this.parameterSet().sizeIncrement();
		}
		return experimentResults;
	}
}
