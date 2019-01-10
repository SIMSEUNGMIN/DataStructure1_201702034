import java.util.Arrays;

public class AppController {
	
	//���
	private static final int DEFAULT_TEST_SIZE = 10000;
	private static final int DEFAULT_FIRST_PART_SIZE = 5;
	private static final InsertionSort<Integer> INSERTION_SORT = new InsertionSort<Integer>();
	private static final QuickSort<Integer> QUICK_SORT = new QuickSort<Integer>();
	
	//����� ������
	private AppView _appView;
	private Integer[] _list;
	private ListOrder _listOrder;

	public AppController(){
		this._appView = new AppView();
	}
	
	public void run(){
		this._appView.outputLine("<<< ���� �˰����� ���� ����� �����ϴ� ���α׷��� �����մϴ�. >>>\n");
		
		this._appView.outputLine("> ���� ����� ���� : \n");
		
		this.validateWithAscendingOrderList();
		this.vaildateWithDescendingOrderList();
		this.vaildateWithRandomOrderList();
		
		this._appView.outputLine("\n<<< ���� �˰����� ���� ����� �����ϴ� ���α׷��� �����մϴ�. >>>");
	}
	
	private void validateWithAscendingOrderList(){
		this._listOrder= ListOrder.Ascending;
		this._list = DataGenerator.ascendingOrderList(DEFAULT_TEST_SIZE);
		this.showFirstPartOfDataList();
		//System.out.println(Arrays.toString(_list));
		this.validateSortAndShowResult();
		
	}
	
	private void vaildateWithDescendingOrderList(){
		this._listOrder = ListOrder.Descending;
		this._list = DataGenerator.descendingOrderList(DEFAULT_TEST_SIZE);
		this.showFirstPartOfDataList();
		this.validateSortAndShowResult();
		
	}
	
	private void vaildateWithRandomOrderList(){
		this._listOrder = ListOrder.Random;
		this._list = DataGenerator.randomOrderList(DEFAULT_TEST_SIZE);
		this.showFirstPartOfDataList();
		this.validateSortAndShowResult();
	}
	
	private void showFirstPartOfDataList(){
		this._appView.output("[" + this._listOrder.orderName() + "����Ʈ]�� �� �κ� : ");
		for(int i = 0; i < DEFAULT_FIRST_PART_SIZE; i++){
			this._appView.output(this._list[i] + " ");
		}
		this._appView.outputLine("");
	}
	
	private void validateSortAndShowResult(){
		this.validateSort(INSERTION_SORT);
		this.validateSort(QUICK_SORT);
		this._appView.outputLine("");
		
	}
	
	private void validateSort(Sort<Integer> aSort){
		Integer[] list = this.copyList(this._list);
		//������ ����Ʈ�� ���� ��(�����δ� 2��)�����ϰ� �ȴ�.
		//�Ź� ���� ����Ʈ�� �����Ͽ� �����Ѵ�.
		aSort.sort(list, list.length);
		this.showValidationMessage(aSort, list);
	}
	
	private Integer[] copyList(Integer[] aList){
		//�־��� �迭 ��ü aList[]�� ���纻�� ����� �����ش�.
		//aList[]��ü�� ����������,
		//�迭�� ���� ��ü ��ü�� �������� �ʰ� �����Ѵ�.
		Integer[] copiedList = new Integer[aList.length];
		
		for(int i = 0; i < aList.length; i++) {
			copiedList[i] = aList[i];
		}
		
		return copiedList;
	}
	
	private boolean sortedListIsValid(Integer[] aList){
		//�־��� aList�� ���ҵ��� ������������ �Ǿ������� true�� �����ش�.
		for(int i = 0; i < (aList.length-1); i++){
			if(aList[i].compareTo(aList[i+1]) > 0){
				return false; //���������� �ƴϴ�.
			}
		}
		return true; //���������̴�.
	}
	
	private void showValidationMessage(Sort<Integer> aSort, Integer[] aList){
		this._appView.output("[" + this._listOrder.orderName() + "����Ʈ]�� [" + aSort.getClass().getSimpleName() + "] �� ����� ");
		
		if(this.sortedListIsValid(aList)){
			this._appView.output("�ùٸ��ϴ�.\n");
		}
		else{
			this._appView.output("�ùٸ��� �ʽ��ϴ�.\n");
		}
	}
	
}
