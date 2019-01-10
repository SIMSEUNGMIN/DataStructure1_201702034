
public class ExperimentManager {
	//constants for the parameters:
	private static final int DEFAULT_NUMBER_OF_SIZE_INCREASING_STEPS = 10;
	private static final int DEFAULT_INCREMENT_SIZE = 1000;
	private static final int DEFAULT_STARTING_SIZE = DEFAULT_INCREMENT_SIZE;
	
	//constants : ���迡�� ����� ���ĵ��� ��� ��ü�� ����
	private static final InsertionSort<Integer>
		INSERTION_SORT = new InsertionSort<Integer>();
	private static final QuickSort<Integer>
		QUICK_SORT = new QuickSort<Integer>();
	
	//private instance variables
	private Experiment _experiment; //���� ������ �ǽ��� ��ü.
	private ParameterSet _parameterSet; //���� ���迡 ����� �Ű����� ����.
	private Integer[] _ascendingList; //�������� ���Ŀ� ����� �������� ������ ����Ʈ.
	private Integer[] _desendingList; //�������� ���Ŀ� ����� �������� ������ ����Ʈ.
	private Integer[] _randomList; //�������� ���Ŀ� ����� ������ ������ ����Ʈ.
	private long[] _measuredResultForInsertionSort; //���� ������ ���� ��� ������ ��.
	private long[] _measuredResultForQuickSort; //�������� ���� ��� ������ ��.
	
	//constructor
	public ExperimentManager(){
		this.setParameterSetWithDefaults(); //�⺻ ������ �Ű����� ������ �ʱ�ȭ ��Ŵ.
	}
	
	//public Getter
	public ParameterSet parameterSet(){
		return this._parameterSet;
	}
	
	//private methods
	private void prepareExperimentList(){ //����Ʈ �ʱ�ȭ.(�غ�)
		int maxDataSize = this._parameterSet.maxSize();
		
		this._ascendingList = DataGenerator.ascendingOrderList(maxDataSize);
		this._desendingList = DataGenerator.descendingOrderList(maxDataSize);
		this._randomList = DataGenerator.randomOrderList(maxDataSize);
	}
	
	private void setParameterSetWithDefaults(){
		this._parameterSet = new ParameterSet(
				DEFAULT_STARTING_SIZE,
				DEFAULT_NUMBER_OF_SIZE_INCREASING_STEPS,
				DEFAULT_INCREMENT_SIZE);
	}
	
	private Integer[] experimentListOfOrder(ListOrder anOrder){
		//�־��� anOrder�� �ش��ϴ� ����Ʈ�� �����ش�.
		switch(anOrder){
		case Ascending:
			return this._ascendingList;
		case Descending:
			return this._desendingList;
		default:
			return this._randomList;
		}
	}
	
	public void prepareExperiment(ParameterSet aParameterSet){
		//������ �غ��Ѵ�.
		
		if(aParameterSet != null){
			//��ü ������ ��, �Ű����� ������ �⺻������ �����Ǿ� �ִ�.
			//���� �غ� �ܰ迡��, �̷��� ���ο� �Ű����� ������ �־� ������ �� �ִ�.
			this._parameterSet = aParameterSet;
		}
		
		this._experiment = new Experiment(this._parameterSet);
		//���� ������ �Ű����� ������ ����Ͽ� Experiment��ü�� �����Ѵ�.
		
		this.prepareExperimentList();
		//���� ���迡�� ���Ŀ� ����� ������ ����Ʈ�� �����Ͽ� �����Ѵ�.
		
		//������ ������ ���� ������, ���������δ� �ǹ̰� ���� �����̴�.
		//���� ���� ���� ����� ����ȭ��Ű�� ���� ������ ���̴�.
		this.performExperiment(ListOrder.Random);
		this.performExperiment(ListOrder.Random);
	}
	
	public long measuredResultForInsertionSortAt(int sizeStep){
		return this._measuredResultForInsertionSort[sizeStep];
	}
	
	public long measuredResultForQuickSortAt(int sizeStep){
		return this._measuredResultForQuickSort[sizeStep];
	}
	
	public void performExperiment(ListOrder anOrder){
		//���� ������ �����Ѵ�.
		
		//�־��� anOrder�� ���� ����Ʈ�� ��´�.
		Integer[] experimentList = this.experimentListOfOrder(anOrder);
		
		//�� ���� ����Ʈ�� ���԰� �� ������ ������ ������ �����ؼ�, �� ����� ��´�.
		this._measuredResultForInsertionSort = 
				this._experiment.durationOfSort(INSERTION_SORT, experimentList);
		this._measuredResultForQuickSort = 
				this._experiment.durationOfSort(QUICK_SORT, experimentList);
	}
}
