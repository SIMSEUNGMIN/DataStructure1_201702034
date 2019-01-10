import java.util.Arrays;

public class AppController {
	
	//상수
	private static final int DEFAULT_TEST_SIZE = 10000;
	private static final int DEFAULT_FIRST_PART_SIZE = 5;
	private static final InsertionSort<Integer> INSERTION_SORT = new InsertionSort<Integer>();
	private static final QuickSort<Integer> QUICK_SORT = new QuickSort<Integer>();
	
	//비공개 변수들
	private AppView _appView;
	private Integer[] _list;
	private ListOrder _listOrder;

	public AppController(){
		this._appView = new AppView();
	}
	
	public void run(){
		this._appView.outputLine("<<< 정렬 알고리즘의 정렬 결과를 검증하는 프로그램을 시작합니다. >>>\n");
		
		this._appView.outputLine("> 정렬 결과의 검증 : \n");
		
		this.validateWithAscendingOrderList();
		this.vaildateWithDescendingOrderList();
		this.vaildateWithRandomOrderList();
		
		this._appView.outputLine("\n<<< 정렬 알고리즘의 정렬 결과를 검증하는 프로그램을 종료합니다. >>>");
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
		this._appView.output("[" + this._listOrder.orderName() + "리스트]의 앞 부분 : ");
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
		//동일한 리스트로 여러 번(실제로는 2번)정렬하게 된다.
		//매번 원본 리스트를 복사하여 정렬한다.
		aSort.sort(list, list.length);
		this.showValidationMessage(aSort, list);
	}
	
	private Integer[] copyList(Integer[] aList){
		//주어진 배열 객체 aList[]의 복사본을 만들어 돌려준다.
		//aList[]자체는 복사하지만,
		//배열의 원소 객체 자체는 복사하지 않고 공유한다.
		Integer[] copiedList = new Integer[aList.length];
		
		for(int i = 0; i < aList.length; i++) {
			copiedList[i] = aList[i];
		}
		
		return copiedList;
	}
	
	private boolean sortedListIsValid(Integer[] aList){
		//주어진 aList의 원소들이 오름차순으로 되어있으면 true를 돌려준다.
		for(int i = 0; i < (aList.length-1); i++){
			if(aList[i].compareTo(aList[i+1]) > 0){
				return false; //오름차순이 아니다.
			}
		}
		return true; //오름차순이다.
	}
	
	private void showValidationMessage(Sort<Integer> aSort, Integer[] aList){
		this._appView.output("[" + this._listOrder.orderName() + "리스트]를 [" + aSort.getClass().getSimpleName() + "] 한 결과는 ");
		
		if(this.sortedListIsValid(aList)){
			this._appView.output("올바릅니다.\n");
		}
		else{
			this._appView.output("올바르지 않습니다.\n");
		}
	}
	
}
