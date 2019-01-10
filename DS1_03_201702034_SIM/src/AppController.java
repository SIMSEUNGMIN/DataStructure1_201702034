
public class AppController {
	private AppView _appView;
	private PerformanceMeasurement _pm;
	
	public AppController(){
		this._appView = new AppView();
	}

	public void run(){
		this._pm = new PerformanceMeasurement(); //객체 생성.
		this.showMessage(MessageID.Notice_StartProgram); //프로그램 시작 메세지 출력.
		this._pm.generateData(); //_pm 객체의 _data 배열에 난수를 생성하여 삽입.
		this.showMessage(MessageID.Notice_UnsortedArrayStart); //자료구조 종류 출력.
		this._pm.testUnsortedArrayBag(); //성능측정 수행.
		this.showTestResults(); //측정한 결과를 출력.
		this.showMessage(MessageID.Notice_EndProgram); //종료 메세지 출력.
		
	}
	
	private void showMessage(MessageID aMessageID){
		switch(aMessageID){
			case Notice_StartProgram:
				this._appView.outMessge("<<List의 구현에 따른 실행 성능 차이 알아보기>>\n");
				break;
			case Notice_EndProgram:
				this._appView.outMessge("<<성능 측정을 종료합니다>>\n");
				break;
			case Notice_UnsortedArrayStart:
				this._appView.outMessge("[Unsorted Array List]\n");
				break;
			case Error_WrongMenu:
				this._appView.outMessge("<<ERROR: 잘못된 메뉴입니다.>>\n");
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
