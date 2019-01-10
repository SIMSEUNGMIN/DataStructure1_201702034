
public class AppController {
	private static final int APP_NUMBER_OF_EXPERIMENTS = 5;
	private static final int APP_FIRST_DATA_SIZE = 10000;
	private static final int APP_SIZE_INCREMENT = 10000;
	
	private AppView _appView;
	private PerformanceMeasurement _measurement;
	
	public AppController(){
		this._appView = new AppView();
	}
	
	public void run(){
		this._appView.outputLine("<<<\"Dictionary\" �� ���� ������ �����մϴ�. >>>\n");
		this._measurement = 
				new PerformanceMeasurement(
						APP_NUMBER_OF_EXPERIMENTS,
						APP_FIRST_DATA_SIZE,
						APP_SIZE_INCREMENT);
		
		this.showExperimentByListOrderType(ListOrder.Ascending);
		this.showExperimentByListOrderType(ListOrder.Descending);
		this.showExperimentByListOrderType(ListOrder.Random);
		
		this._appView.outputLine("<<<\"Dictionary\" �� ���� ������ �����մϴ�. >>>\n");
	}
	
	private void showExperimentByListOrderType(ListOrder anOrder){
		this._appView.outputLine("<" + anOrder.toStringInKorean() + 
				" �����͸� ����� ���� (���� : micro second) >");
		
		this.showExperimentByDictionaryAndListOrderType(new DictionaryBySortedArray<Integer, String>(
				this._measurement.parameterSet().maxDataSize()), anOrder);
		
		this._appView.outputLine("");
		
		this.showExperimentByDictionaryAndListOrderType(new DictionaryBySortedLinkedList<Integer, String>(),anOrder);
		
		this._appView.outputLine("");
		
		this.showExperimentByDictionaryAndListOrderType(new DictionaryByBinarySearchTree<Integer, String>(), anOrder);
		
		this._appView.outputLine("");
	}
	
	private void showExperimentByDictionaryAndListOrderType(
			Dictionary<Integer, String> aDictionary, ListOrder anOrder){
		
		this._appView.output("\"" + aDictionary.getClass().getName() + "\"�� ������ ������ ���� : \n");
		this._appView.output(String.format("%6s", "ũ��"));
		this._appView.output(String.format("%11s", "����"));
		this._appView.output(String.format("%11s", "�˻�"));
		this._appView.outputLine(String.format("%11s", "����"));
		
		UnitExperimentResult[] results = 
				this._measurement.experimentByDictionaryAndListOrderType(aDictionary, anOrder);
		
		for(int iteration = 0;
				iteration < this._measurement.parameterSet().numberOfExperiment();
				iteration++){
			this.showUnitExperimentResult(results[iteration]);
		}
	}
	
	private void showUnitExperimentResult(UnitExperimentResult aResult){
		this._appView.output(String.format("[%5d]", aResult.experimentSize()));
		this._appView.output(String.format("%12d", aResult.timeForAdd()/1000));
		this._appView.output(String.format("%12d", aResult.timeForSearch()/1000));
		this._appView.output(String.format("%12d", aResult.timeForRemove()/1000));
		this._appView.outputLine("");
	}
}
