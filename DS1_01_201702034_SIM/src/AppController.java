
public class AppController { //전체적인 흐름.
	
	private AppView _appView; //AppView를 연결시킴.
	private MagicSquare _magicSquare;
	
	
	public AppController(){
		
		_appView = new AppView(); //생성자에서 클래스 AppController을 실행할 때 AppView클래스도 같이 실행, AppView 초기화.
		_magicSquare = new MagicSquare(); // MagicSquare클래스도 같이 실행, MagicSquare 초기화.
	}
	
	public void run(){ //마방진 전체를 출력하기 위한 함수. 전체적인 흐름을 전담한다.
		this._appView.outputLine("<<< 마방진 출력을 시작하겠습니다. >>>"); //AppView를 통해서 출력.
		
		int order = this._appView.inputOrder(); //AppView를 통해서 차수를 입력받아 order에 저장.
		
		while(order >= 0){ //차수의 타당성 판단. 음수면 프로그램 종료.
			OrderValidity currentOrderValidity = this._magicSquare.checkOrderValidity(order); //현재 차수의 상태를 알려줌.
			
			if(currentOrderValidity == OrderValidity.Vaild){ //현재 차수가 타당하면 마방진 시작.
				this._appView.outputTitleWithOrder(order); //title 출력하는 함수 호출.
				Board solvedBoard = this._magicSquare.solve(order); //MagicSquare객체에게 마방진을 풀이해서 만들라고 명령.
				this.showBoard(solvedBoard); //마방진을 화면에 출력.
			}
			else { 
				this.showOrderValidityErrorMessage(currentOrderValidity); //타당하지 않을 경우 현재차수에 맞춰 오류문 출력.
			}
			
			order = this._appView.inputOrder(); // 다시 차수를 입력 받음. (반복)
			
		}
		
		this._appView.outputLine("\n<<< 마방진 풀이를 종료합니다. >>>");

		
	}
	
	
	private void showOrderValidityErrorMessage (OrderValidity anOrderValidity){ //받아들인 anOrderValidity가 타당하지 않을 경우.
		switch(anOrderValidity){
			case TooSmall:
				this._appView.outputLine("오류 : 차수가 너무 작습니다. 3보다 크거나 같아야 합니다.");
				break;
			case TooLarge:
				this._appView.outputLine("오류 : 차수가 너무 큽니다. 99보다 작거나 같아야 합니다.");
				break;
			case NotOddNumber:
				this._appView.outputLine("오류 : 차수가 짝수입니다. 홀수이어야 합니다.");
				break;
			default:
				break;
				
		}
	}
	
	private void showBoard (Board aBoard){ // Board클래스를 이용하여 order에 맞게 cellLocation의 row,col에 해당하는 값을 보드에 출력.
		CellLocation currentLoc = new CellLocation();
		this.showTitleOfrColumnIndexes(aBoard.order());
		
		for(int row = 0; row < aBoard.order(); row++){
			this._appView.outputRowNumber(row);
			
			for(int col = 0; col < aBoard.order(); col++){
				currentLoc.setRow(row); //row의 값을 currentLoc의 setRow에 넣는다.
				currentLoc.setCol(col);	//col의 값을 currentLoc의 setCol에 넣는다.
				this._appView.outputCell(aBoard.cell(currentLoc)); // currentLoc의 cell안에 들어있는 값을 출력한다.
			}
			
			this._appView.outputLine("");
		}
		
		
	}
	
	private void showTitleOfrColumnIndexes(int anOrder){ //세로 [] 표시.
		this._appView.outputLine("      "); //빈칸 6개.
		
		for(int col = 0; col < anOrder; col++){
			if(col == 0){
				this._appView.output(String.format("     [%3d]", col));
			}
			else this._appView.output(String.format("[%3d]", col));
		}
		this._appView.outputLine("");
	}
	
	
	
	}
