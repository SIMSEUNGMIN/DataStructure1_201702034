
public class AppController {
	private AppView _appView;
	private ExperimentManager _manager;
	
	public AppController(){
		this._appView = new AppView();
		this._manager = new ExperimentManager();
	}
	
	private void showTableTitle(ListOrder anOrder){
		this._appView.outputLine("> " + anOrder.orderName() + "�����͸� ����Ͽ� ������ ���� : ");
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
		//�־��� order�� ���Ͽ�, ������ ���� > ����� �����ش�.
		this.showTableTitle(anOrder);
		this.showTableHead();
		this._manager.performExperiment(anOrder);
		this.showMeasuredResult();
		this._appView.outputLine("");
	}
	
	public void run(){
		this._appView.outputLine("<<< ���� ���� �� ���α׷��� �����մϴ�. >>>");
		this._appView.outputLine("");
		{
			this._appView.outputLine(">> 2���� ������ ���� �� : ����, �� <<");
			this._manager.prepareExperiment(null);
			//ExperimentManager ��ü���� ������ �غ��Ų��.
			//�̹� ���迡���� �Ű����� ������ �⺻ ���� ���� ����Ѵ�.
			//�⺻ ���� ���� class "ExperimentManager"�� �����Ǿ� �ִ�.
			
			this.measureAndShowResultFor(ListOrder.Ascending);
			this.measureAndShowResultFor(ListOrder.Descending);
			this.measureAndShowResultFor(ListOrder.Random);
		}
		this._appView.outputLine("<<< ���� ���� �� ���α׷��� �����մϴ�. >>>");
	}
}
