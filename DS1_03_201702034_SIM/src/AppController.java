
public class AppController {
	private AppView _appView;
	private PerformanceMeasurement _pm;
	
	public AppController(){
		this._appView = new AppView();
	}

	public void run(){
		this._pm = new PerformanceMeasurement(); //��ü ����.
		this.showMessage(MessageID.Notice_StartProgram); //���α׷� ���� �޼��� ���.
		this._pm.generateData(); //_pm ��ü�� _data �迭�� ������ �����Ͽ� ����.
		this.showMessage(MessageID.Notice_UnsortedArrayStart); //�ڷᱸ�� ���� ���.
		this._pm.testUnsortedArrayBag(); //�������� ����.
		this.showTestResults(); //������ ����� ���.
		this.showMessage(MessageID.Notice_EndProgram); //���� �޼��� ���.
		
	}
	
	private void showMessage(MessageID aMessageID){
		switch(aMessageID){
			case Notice_StartProgram:
				this._appView.outMessge("<<List�� ������ ���� ���� ���� ���� �˾ƺ���>>\n");
				break;
			case Notice_EndProgram:
				this._appView.outMessge("<<���� ������ �����մϴ�>>\n");
				break;
			case Notice_UnsortedArrayStart:
				this._appView.outMessge("[Unsorted Array List]\n");
				break;
			case Error_WrongMenu:
				this._appView.outMessge("<<ERROR: �߸��� �޴��Դϴ�.>>\n");
				break;
			default:
				break;
		}
	}
	
	private void showTestResults(){
		TestResult testResult[] = this._pm.testResults();
		
		for(int index = 0; index < this._pm.numberOfTests(); index++){
			this._appView.outputResult(
					testResult[index].testSize(), 
					testResult[index].testInsertTime(),
					testResult[index].testFindMaxTime());
		}
	}

}
