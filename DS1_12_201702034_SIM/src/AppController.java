
public class AppController {
	private AppView _appView;
	private ExperimentManager _manager;
	
	public AppController(){
		this._appView = new AppView();
		this._manager = new ExperimentManager();
	}
	
	private void showTableTitle(ListOrder anOrder){
		this._appView.outputLine("> " + anOrder.orderName() + "데이터를 사용하여 실행한 측정 : ");
	}
	
	private void showTableHead(){
		this._appView.outputLine(
				String.format("%8s", " ") + 
				String.format("%16s", "<Insertion Sort>") + 
				String.format("%16s", "<Quick Sort>")
				);
	}
	
	private void showMeasuredResult(){
		int startingSize = this._manager.parameterSet().startingSize();
		int incrementSize = this._manager.parameterSet().incrementSize();
		int numberOfSteps = this._manager.parameterSet().numberOfSizeIncreasingStep();
		
		
		for(int step = 0; step < numberOfSteps; step++){
			int sortingSize = startingSize + (incrementSize * step);
			this._appView.outputLine(
					"[" + String.format("%5d", sortingSize) + "]" +
					String.format("%16d", this._manager.measuredResultForInsertionSortAt(step)) +
					String.format("%16d", this._manager.measuredResultForQuickSortAt(step)));
		}
	}
	
	private void measureAndShowResultFor(ListOrder anOrder){
		//주어진 order에 대하여, 성능을 측정 > 결과를 보여준다.
		this.showTableTitle(anOrder);
		this.showTableHead();
		this._manager.performExperiment(anOrder);
		this.showMeasuredResult();
		this._appView.outputLine("");
	}
	
	public void run(){
		this._appView.outputLine("<<< 정렬 성능 비교 프로그램을 시작합니다. >>>");
		this._appView.outputLine("");
		{
			this._appView.outputLine(">> 2가지 정렬의 성능 비교 : 삽입, 퀵 <<");
			this._manager.prepareExperiment(null);
			//ExperimentManager 객체에게 실험을 준비시킨다.
			//이번 실험에서는 매개변수 값으로 기본 설정 값을 사용한다.
			//기본 설정 값은 class "ExperimentManager"에 설정되어 있다.
			
			this.measureAndShowResultFor(ListOrder.Ascending);
			this.measureAndShowResultFor(ListOrder.Descending);
			this.measureAndShowResultFor(ListOrder.Random);
		}
		this._appView.outputLine("<<< 정렬 성능 비교 프로그램을 종료합니다. >>>");
	}
}
