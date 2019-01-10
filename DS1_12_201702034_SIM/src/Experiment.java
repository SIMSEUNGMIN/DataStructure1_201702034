
public class Experiment {
	//정렬 성능 측정 실험을 실행한다.
	//실험에 미리 주어지는 것들: 
	//매개변수 집합 / 정렬할 데이터 / 정렬방법.
	
	private final ParameterSet _parameterSet;
	//class의 함수에서 이 값을 변경할 수 없다.
	//오로지 생성자 안에서만 값을 설정할 수 있다.
	//즉, 객체를 생성할 때 정해진 값을 그대로 유지한다.
	
	public Experiment(ParameterSet givenParameterSet){
		this._parameterSet = givenParameterSet;
	}
	
	private Integer[] copyListOfGivenSize(Integer[] aList, int copiedSize){ //list복사.
		Integer[] copiedList = null;
		if(copiedSize <= aList.length){
			copiedList = new Integer[copiedSize];
			for(int i = 0; i < copiedSize; i++){
				copiedList[i] = aList[i];
			}
		}
		return copiedList;
	}
	
	private long durationOfSingleSort(Sort<Integer> aSort, Integer[] aList){
		//주어진 aList[]를 사용하여 정렬(aSort)을 실행, 실행 시간 측정.
		Timer timer = new Timer();
		timer.start();
		{
			aSort.sort(aList, aList.length);
		}
		timer.stop();
		return timer.duratin();
	}
	
	public long[] durationOfSort(Sort<Integer> aSort, Integer[] experimentList){
		//정렬방법(aSort)과 정렬의 성능측정에서 사용할 리스트 experimentList[]가 주어진다.
		//매개변수 값을 사용해서 데이터 크기 별로 정렬 시간을 측정하여, 그 결과를 배열로 얻는다.
		//정렬방법이 매개변수로 주어져있다는 것에 유의.
		
		int numberOfSteps = this._parameterSet.numberOfSizeIncreasingStep(); //크기 별로 실행할 측정 횟수.
		
		long[] durations = new long[numberOfSteps]; //측정 결과를 저장할 곳.
		
		int sortingSize = this._parameterSet.startingSize(); //정렬 데이터의 시작 크기.
		int incrementSize = this._parameterSet.incrementSize(); //정렬 데이터의 증가 크기.
		
		for(int step = 0; step < numberOfSteps; step++){
			Integer[] listForSorting = this.copyListOfGivenSize(experimentList, sortingSize);
			//측정에 사용할 데이터 리스트 복사.
			durations[step] = this.durationOfSingleSort(aSort, listForSorting);
			//측정하여, 그 결과를 저장.
			sortingSize += incrementSize; //다음단계의 정렬데이터 크기를 얻는다.
		}
		return durations;
	}
	
}
