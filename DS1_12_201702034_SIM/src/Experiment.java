
public class Experiment {
	//���� ���� ���� ������ �����Ѵ�.
	//���迡 �̸� �־����� �͵�: 
	//�Ű����� ���� / ������ ������ / ���Ĺ��.
	
	private final ParameterSet _parameterSet;
	//class�� �Լ����� �� ���� ������ �� ����.
	//������ ������ �ȿ����� ���� ������ �� �ִ�.
	//��, ��ü�� ������ �� ������ ���� �״�� �����Ѵ�.
	
	public Experiment(ParameterSet givenParameterSet){
		this._parameterSet = givenParameterSet;
	}
	
	private Integer[] copyListOfGivenSize(Integer[] aList, int copiedSize){ //list����.
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
		//�־��� aList[]�� ����Ͽ� ����(aSort)�� ����, ���� �ð� ����.
		Timer timer = new Timer();
		timer.start();
		{
			aSort.sort(aList, aList.length);
		}
		timer.stop();
		return timer.duratin();
	}
	
	public long[] durationOfSort(Sort<Integer> aSort, Integer[] experimentList){
		//���Ĺ��(aSort)�� ������ ������������ ����� ����Ʈ experimentList[]�� �־�����.
		//�Ű����� ���� ����ؼ� ������ ũ�� ���� ���� �ð��� �����Ͽ�, �� ����� �迭�� ��´�.
		//���Ĺ���� �Ű������� �־����ִٴ� �Ϳ� ����.
		
		int numberOfSteps = this._parameterSet.numberOfSizeIncreasingStep(); //ũ�� ���� ������ ���� Ƚ��.
		
		long[] durations = new long[numberOfSteps]; //���� ����� ������ ��.
		
		int sortingSize = this._parameterSet.startingSize(); //���� �������� ���� ũ��.
		int incrementSize = this._parameterSet.incrementSize(); //���� �������� ���� ũ��.
		
		for(int step = 0; step < numberOfSteps; step++){
			Integer[] listForSorting = this.copyListOfGivenSize(experimentList, sortingSize);
			//������ ����� ������ ����Ʈ ����.
			durations[step] = this.durationOfSingleSort(aSort, listForSorting);
			//�����Ͽ�, �� ����� ����.
			sortingSize += incrementSize; //�����ܰ��� ���ĵ����� ũ�⸦ ��´�.
		}
		return durations;
	}
	
}
